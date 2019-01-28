package com.mishima.bookstore.service;

import com.mishima.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getAllBooksByGenre(String genre);
    Book getBookByArticle(int article);
    boolean updateBook(Book book);
}
