package com.mishima.bookstore.controller;

import com.mishima.bookstore.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    BookDao bookDao;

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
