package com.mishima.bookstore.dao.impl;

import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;
import com.mishima.bookstore.util.DaoUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.rmi.CORBA.Util;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
//        try {
//            Session session = sessionFactory.getCurrentSession();
//            session.persist(user);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return DaoUtil.isObjectPersist(sessionFactory, user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id = :id", User.class);
        return (User) query.setParameter("id", id).getSingleResult();
    }
}
