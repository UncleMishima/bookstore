package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.*;
import com.mishima.bookstore.util.DaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @Autowired
    HttpSession session;

    @RequestMapping("/show")
    public String showCart(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.getUserByEmail(authentication.getName());
        Cart cart = user.getCart();
        List<CartLine> cartLineList = cartLineDao.list(user.getCart().getId());
        cart.setTotalPrice(DaoUtil.updateCartTotalPrice(cartLineList));
        model.addAttribute("cartLines", cartLineList);
        model.addAttribute("cart", user.getCart());

        return "cart";
    }
}
