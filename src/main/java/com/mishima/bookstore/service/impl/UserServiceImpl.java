package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.User;
import com.mishima.bookstore.model.UserModel;
import com.mishima.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    HttpSession session;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getCurrentUser() {
        UserModel userModel = (UserModel) session.getAttribute("userModel");
        return userDao.getUserById(userModel.getId());
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
