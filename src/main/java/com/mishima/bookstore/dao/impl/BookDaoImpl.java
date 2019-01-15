package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBooks() {
        Book book1 = new Book();
        book1.setArticle(13412);
        book1.setName("The Shinning");
        book1.setAuthor("S. King");
        book1.setPrice(99.9);
        book1.setGenre("Horror");

        Book book2 = new Book();
        book2.setArticle(13332);
        book2.setName("Cradle for a cat");
        book2.setAuthor("K. Vonnegut");
        book2.setPrice(69.0);
        book2.setGenre("Deep thoughts");

        Book book3 = new Book();
        book3.setArticle(12132);
        book3.setName("Code Complete");
        book3.setAuthor("S. McConell");
        book3.setPrice(199.0);
        book3.setGenre("Non fiction");

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }

    @Override
    public Book getBookByArticle(int article) throws IOException {
        for (Book book : getBooks()) {
            if (book.getArticle() == article) {
                return book;
            }
        }
        throw new IOException("Book doesn't exist by article " + article);
    }
}
