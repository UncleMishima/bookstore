package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public boolean addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }
}
