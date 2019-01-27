package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.util.DaoUtil;
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
    public CartLine get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CartLine.class, id);
    }

    @Override
    public boolean add(CartLine cartLine) {
        return DaoUtil.isObjectPersist(sessionFactory, cartLine);
    }

    @Override
    public boolean update(CartLine cartLine) {
        return DaoUtil.isObjectUpdate(sessionFactory, cartLine);
    }

    @Override
    public boolean delete(CartLine cartLine) {
        return false;
    }

    @Override
    public List<CartLine> list(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from CartLine where cartId = :cartId", CartLine.class);
        return query.setParameter("cartId", cartId).getResultList();
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from CartLine where cartId = :cartId and isAvailable = :isAvailable", CartLine.class);
        return query
                .setParameter("cartId", cartId)
                .setParameter("isAvailable", true)
                .getResultList();
    }

    @Override
    public CartLine getByCartAndBook(int cartId, int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from CartLine where cartId = :cartId and book.article = :bookId", CartLine.class);
        return (CartLine) query
                .setParameter("cartId", cartId)
                .setParameter("bookId", bookId)
                .getSingleResult();
    }

    @Override
    public boolean updateCart(Cart cart) {
        return DaoUtil.isObjectUpdate(sessionFactory, cart);
    }
}
