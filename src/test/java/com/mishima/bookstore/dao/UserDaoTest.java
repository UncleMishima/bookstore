package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.User;
import com.mishima.bookstore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = "file:/src/main/webapp/WEB-INF/application-context.xml"//,
        //classes = {UserServiceImpl.class, UserDao.class, User.class}
)
public class UserDaoTest {

    private UserService userService;

    @Autowired
    ApplicationContext context;

//    @BeforeClass
//    public static void init() {
//    }

    @Test
    public void testAddUser() {
        userService = (UserService) context.getBean("userService");

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
