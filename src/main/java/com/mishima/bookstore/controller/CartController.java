package com.mishima.bookstore.controller;

import com.mishima.bookstore.service.CartLineService;
import com.mishima.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartLineService cartLineService;

    @Autowired
    UserService userService;

    @RequestMapping("/show")
    public String showCart(Model model) {
        model.addAttribute("cartLines", cartLineService.listOfAvailable());
        return "cart";
    }
}
