package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;

import java.util.List;

public interface UserDao {
    boolean addUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
