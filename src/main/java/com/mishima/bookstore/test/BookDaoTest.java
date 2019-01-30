package com.mishima.bookstore.test;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration(locations = "file:/src/main/webapp/WEB-INF/application-context.xml")
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetBookById() {
        Book book = bookDao.getBookByArticle(1);
        assertEquals("Successfully equaled", 499.0, book.getPrice());
    }
}
