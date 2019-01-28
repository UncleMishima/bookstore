package com.mishima.bookstore.util;

import com.mishima.bookstore.model.CartLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class DaoUtil {
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

    public static double updateCartTotalPrice(List<CartLine> cartLineList) {
        double cartTotalPrice = 0.0;
        for (CartLine cartLine : cartLineList) {
            cartTotalPrice += cartLine.getTotal();
        }
        return cartTotalPrice;
    }
}
