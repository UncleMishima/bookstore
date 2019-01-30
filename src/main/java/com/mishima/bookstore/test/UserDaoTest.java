package com.mishima.bookstore.test;

import com.mishima.bookstore.model.User;
import com.mishima.bookstore.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration({"file:/src/main/webapp/WEB-INF/application-context.xml"})
public class UserDaoTest {
    @Autowired
    private UserService userService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testAddUser() {

        User user = new User();
        user.setId(7);
        user.setRole("USER");
        user.setFirstName("Name");
        user.setLastName("Last name");
        user.setEnabled(true);
        user.setEmail("dgsdhd");
        user.setPassword("112243");

        assertEquals("User successfully added to DB", true, userService.addUser(user));
    }
}
