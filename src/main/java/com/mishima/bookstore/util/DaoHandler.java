package com.mishima.bookstore.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class DaoHandler {
    public static boolean isObjectPersisted(SessionFactory sessionFactory, Object object) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isObjectUpdated(SessionFactory sessionFactory, Object object) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isObjectDeleted(SessionFactory sessionFactory, Object object) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
