package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/userlist")
    public String userlist(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "userlist";
    }

    //TODO Create add user form and get data from it
    @RequestMapping("/new")
    public String addUser() {

        //worked
        User user = new User();
        user.setFirstName("Eugene");
        user.setLastName("Raise");
        user.setEnabled(true);
        user.setRole("USER");
        user.setPassword("paas");
        user.setEmail("e35354");
        userDao.addUser(user);

        return "redirect:/user/users";
    }
}
