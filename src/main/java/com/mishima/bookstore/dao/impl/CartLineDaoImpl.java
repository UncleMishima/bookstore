package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.util.DaoHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CartLineDaoImpl implements CartLineDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(CartLine cartLine) {

        return DaoHandler.isObjectPersisted(sessionFactory, cartLine);
    }

    @Override
    public boolean update(CartLine cartLine) {
        return DaoHandler.isObjectUpdated(sessionFactory, cartLine);
    }

    @Override
    public boolean delete(CartLine cartLine) {
        return DaoHandler.isObjectDeleted(sessionFactory, cartLine);
    }

    @Override
    public CartLine getCartLineByBookArticle(int bookArticle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartLine where book.article = :bookArticle", CartLine.class);
        return (CartLine) query
                .setParameter("bookArticle", bookArticle)
                .getSingleResult();
    }

    @Override
    public List<CartLine> listOfAvailable(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from CartLine where cartId = :cartId and isAvailable = :isAvailable", CartLine.class);
        return query
                .setParameter("cartId", cartId)
                .setParameter("isAvailable", true)
                .getResultList();
    }
}
