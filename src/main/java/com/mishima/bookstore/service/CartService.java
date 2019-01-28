package com.mishima.bookstore.service;

import com.mishima.bookstore.model.Cart;

public interface CartService {
    boolean addCart(Cart cart);
    boolean updateCart(Cart cart);
}
