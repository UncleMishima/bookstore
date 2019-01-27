package com.mishima.bookstore.test;

import com.mishima.bookstore.dao.UserDao;
import com.mishima.bookstore.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    //TODO: Always NPE, need to fix
    @Test
    public void testAddUser() {

        User user = new User();
        user.setRole("USER");
        user.setFirstName("Name");
        user.setLastName("Last name");
        user.setEnabled(true);
        user.setEmail("dgsdhd");
        user.setPassword("112243");

        assertEquals("User successfully added to DB", true, userDao.addUser(user));
    }
}
