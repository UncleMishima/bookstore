package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.util.DaoDataHandler;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addCart(Cart cart) {
        return DaoDataHandler.isObjectPersisted(sessionFactory, cart);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return DaoDataHandler.isObjectUpdated(sessionFactory, cart);
    }
}
