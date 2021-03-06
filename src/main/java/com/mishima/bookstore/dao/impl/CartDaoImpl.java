package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.CartDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.util.DaoHandler;
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
        return DaoHandler.isObjectPersisted(sessionFactory, cart);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return DaoHandler.isObjectUpdated(sessionFactory, cart);
    }
}
