package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.util.DaoHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where amountInStore > 0");
        List<Book> books = query.list();
        return books;
    }

    @Override
    public List<Book> getAllBooksByGenre(String genre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where genre = :genre and amountInStore > 0", Book.class);
        return query.setParameter("genre", genre).getResultList();
    }

    @Override
    public Book getBookByArticle(int article) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, article);
    }

    @Override
    public boolean updateBook(Book book) {
        return DaoHandler.isObjectUpdated(sessionFactory, book);
    }
}
