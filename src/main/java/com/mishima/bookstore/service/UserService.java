package com.mishima.bookstore.service;

import com.mishima.bookstore.model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    User getCurrentUser();
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
