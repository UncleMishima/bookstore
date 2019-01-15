package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Book;
import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    Book getBookByArticle(int article);
}
