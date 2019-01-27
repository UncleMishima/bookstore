package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.model.Book;
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
        Query query = session.createQuery("from Book");
        List<Book> books = query.list();
        return books;
    }

    @Override
    public List<Book> getAllBooksByGenre(String genre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where genre = :genre", Book.class);
        return query.setParameter("genre", genre).getResultList();
    }

    @Override
    public Book getBookByArticle(int article) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, article);
    }
}
