package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public List<Book> getAllBooksByGenre(String genre) {
        return bookDao.getAllBooksByGenre(genre);
    }

    @Override
    public Book getBookByArticle(int article) {
        return bookDao.getBookByArticle(article);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
