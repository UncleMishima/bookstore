package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Cart;

public interface CartDao {
    boolean addCart(Cart cart);
    boolean updateCart(Cart cart);
}
