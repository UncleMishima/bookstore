package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Book;
import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    List<Book> getAllBooksByGenre(String genre);
    Book getBookByArticle(int article);
    //void updateBooks();
}
