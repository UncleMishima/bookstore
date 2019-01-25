package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartLineDao cartLineDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;

    @RequestMapping("/show")
    public String showCart(Model model) {
        User user = userDao.getUserById(1);
        Book book1 = bookDao.getBookByArticle(1);
        CartLine cartLine1 = new CartLine();
        cartLine1.setBook(book1);
        cartLine1.setCartId(user.getCart().getId());

        CartLine cartLine2 = new CartLine();
        Book book2 = bookDao.getBookByArticle(2);
        cartLine2.setBook(book2);
        cartLine2.setCartId(user.getCart().getId());

        List<CartLine> cartLineList = cartLineDao.list(1);
        model.addAttribute("cartLines", cartLineList);
        return "cart";
    }
}
