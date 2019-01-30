package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.UserModel;
import com.mishima.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;

    @Autowired
    HttpSession session;

    @Override
    public boolean addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public boolean updateCart(Cart cart) {
        UserModel userModel = (UserModel)session.getAttribute("userModel");
        userModel.setCart(cart);
        return cartDao.updateCart(userModel.getCart());
    }
}
