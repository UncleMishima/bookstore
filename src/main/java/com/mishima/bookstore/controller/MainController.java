package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;
import com.mishima.bookstore.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class MainController {
    @Autowired
    HttpSession session;

    @Autowired
    UserDao userDao;

    @Autowired
    CartDao cartDao;

    UserModel userModel = null;

    @ModelAttribute("userModel")
    public UserModel getUserModel() {
        if (session.getAttribute("userModel") == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userDao.getUserByEmail(authentication.getName());

            if (user != null) {
                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setFullName(user.getFirstName() + " " + user.getLastName());
                userModel.setRole(user.getRole());

                if (user.getCart() == null) {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    userModel.setCart(cart);
                    cartDao.addCart(userModel.getCart());
                } else userModel.setCart(user.getCart());

                session.setAttribute("userMode", userModel);
                return userModel;
            }
        }

        return (UserModel) session.getAttribute("userModel");
    }

}
