package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;

public interface UserDao {
    boolean addUser(User user);
    boolean updateCart(Cart cart);
}
