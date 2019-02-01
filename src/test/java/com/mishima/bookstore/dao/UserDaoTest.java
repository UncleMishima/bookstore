package com.mishima.bookstore.dao;

import com.mishima.bookstore.service.UserService;
import com.mishima.bookstore.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "file:/home/msedov/my_projects/bookstore/src/main/webapp/WEB-INF/application-context.xml",
                "file:/home/msedov/my_projects/bookstore/src/main/webapp/WEB-INF/dispatcher-servlet.xml"
        }
)
public class UserDaoTest {
    private static final String TEST_USER_EMAIL = "alexalisson@gmail.com";
    private static final String TEST_USER_FIRST_NAME = "Alex";

    private UserService userService;

    @Autowired
    private ApplicationContext context;

    @Before
    public void testContext() {
        userService = context.getBean(UserServiceImpl.class);
        assertNotNull(userService);
    }

    @Test
    public void testGetUserByEmail() {
        assertEquals("Failed to get user by email", TEST_USER_FIRST_NAME, userService.getUserByEmail(TEST_USER_EMAIL).getFirstName());
    }
}
