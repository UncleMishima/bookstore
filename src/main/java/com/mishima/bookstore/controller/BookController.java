package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.*;
import com.mishima.bookstore.util.DaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CartLineDao cartLineDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    HttpSession session;

    Authentication authentication = null;

    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookDao.getAllBooks());
        return "booklist";
    }

    @RequestMapping("/booklist/{bookGenre}")
    public String bookGenre(@PathVariable String bookGenre, Model model) {
        model.addAttribute("bookGenre", bookGenre);
        model.addAttribute("books", bookDao.getAllBooksByGenre(bookGenre));
        return "bookgenre";
    }

    @RequestMapping("/booklist/bookdetails/{bookArticle}")
    public String bookDetails(@PathVariable int bookArticle, Model model) {
        model.addAttribute("book", bookDao.getBookByArticle(bookArticle));
        return "bookdetails";
    }

    @RequestMapping({"/buyBook"})
    public String buyBook(@RequestParam(value = "code") int bookArticle) {
        Book book = bookDao.getBookByArticle(bookArticle);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(authentication.getName());

        CartLine cartLine = new CartLine();
        cartLine.setBook(book);

        if (user.getCart() ==null) {
            Cart cart = new Cart();
            user.setCart(cart);
        } else {
            cartLine.setCartId(user.getCart().getId());
        }

        cartLine.setAvailable(true);
        cartLine.setBuyingPrice(book.getPrice());
        cartLine.setBookCount(1);
        cartLine.setTotal(cartLine.getBookCount() * cartLine.getBuyingPrice());
        cartLineDao.add(cartLine);

        Cart cart = user.getCart();
        cart.setTotalPrice(DaoUtil.updateCartTotalPrice(cartLineDao.list(cart.getId())));
        cartDao.updateCart(user.getCart());

        return "redirect:/booklist";
    }

    @RequestMapping({"/orderBooks"})
    public String orderBooks(@RequestParam(value = "code") int cartId) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(authentication.getName());
        List<CartLine> cartLineList = cartLineDao.list(user.getCart().getId());

        for (CartLine cartLine : cartLineList) {
            Book book = cartLine.getBook();
            book.setAmountInStore(book.getAmountInStore() - cartLine.getBookCount());
            bookDao.updateBook(book);
            cartLineDao.delete(cartLine);
        }

        Cart cart = user.getCart();
        cart.setTotalPrice(0.0);
        cartDao.updateCart(cart);

        return "redirect:/booklist";
    }
}
