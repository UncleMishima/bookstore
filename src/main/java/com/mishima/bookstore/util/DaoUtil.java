package com.mishima.bookstore.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class DaoUtil {
    public static boolean isObjectPersist(SessionFactory sessionFactory, Object object) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isObjectUpdate(SessionFactory sessionFactory, Object object) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
