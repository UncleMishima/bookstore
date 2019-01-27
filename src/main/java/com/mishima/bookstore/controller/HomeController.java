package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("books", bookDao.getBooks());
        return "booklist";
    }

    @RequestMapping("/booklist/bookdetails/{bookArticle}")
    public String bookdetails(@PathVariable int bookArticle, Model model) {
        model.addAttribute("book", bookDao.getBookByArticle(bookArticle));
        return "bookdetails";
    }


}
