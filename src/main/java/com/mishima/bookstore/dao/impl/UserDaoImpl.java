package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
