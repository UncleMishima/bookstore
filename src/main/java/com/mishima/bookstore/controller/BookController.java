package com.mishima.bookstore.controller;

import com.mishima.bookstore.model.*;
import com.mishima.bookstore.service.BookService;
import com.mishima.bookstore.service.CartLineService;
import com.mishima.bookstore.service.CartService;
import com.mishima.bookstore.service.UserService;
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
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    CartLineService cartLineService;

    @Autowired
    CartService cartService;

    @Autowired
    HttpSession session;

    Authentication authentication = null;

    @RequestMapping(value = {"/", "/booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "booklist";
    }

    @RequestMapping("/booklist/{bookGenre}")
    public String bookGenre(@PathVariable String bookGenre, Model model) {
        model.addAttribute("bookGenre", bookGenre);
        model.addAttribute("books", bookService.getAllBooksByGenre(bookGenre));
        return "bookgenre";
    }

    @RequestMapping("/booklist/bookdetails/{bookArticle}")
    public String bookDetails(@PathVariable int bookArticle, Model model) {
        model.addAttribute("book", bookService.getBookByArticle(bookArticle));
        return "bookdetails";
    }

    @RequestMapping({"/buyBook"})
    public String buyBook(@RequestParam(value = "code") int bookArticle) {
        Book book = bookService.getBookByArticle(bookArticle);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(authentication.getName());

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
        cartLineService.add(cartLine);

        Cart cart = user.getCart();
        cart.setTotalPrice(DaoUtil.updateCartTotalPrice(cartLineService.list(cart.getId())));
        cartService.updateCart(user.getCart());

        return "redirect:/booklist";
    }

    @RequestMapping({"/orderBooks"})
    public String orderBooks() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(authentication.getName());
        List<CartLine> cartLineList = cartLineService.list(user.getCart().getId());

        for (CartLine cartLine : cartLineList) {
            Book book = cartLine.getBook();
            book.setAmountInStore(book.getAmountInStore() - cartLine.getBookCount());
            bookService.updateBook(book);
            cartLineService.delete(cartLine);
        }

        Cart cart = user.getCart();
        cart.setTotalPrice(0.0);
        cartService.updateCart(cart);

        return "redirect:/booklist";
    }
}
