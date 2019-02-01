package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.service.BookService;
import com.mishima.bookstore.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "file:/home/msedov/my_projects/bookstore/src/main/webapp/WEB-INF/application-context.xml",
                "file:/home/msedov/my_projects/bookstore/src/main/webapp/WEB-INF/dispatcher-servlet.xml"
        }
)
public class BookDaoTest {
    private static final int TEST_BOOK_ARTICLE = 33;

    private BookService bookService;

    @Autowired
    ApplicationContext context;

    @Before
    public void testContext() {
        bookService = context.getBean(BookServiceImpl.class);
        assertNotNull(bookService);
    }

    @Test
    public void testAddBook() {
        Book testBook = new Book();
        testBook.setArticle(TEST_BOOK_ARTICLE);
        testBook.setName("Lord of the Rings : Two Towers");
        testBook.setAuthor("J. R. R. Tolkien");
        testBook.setGenre("Fantasy");
        testBook.setAmountInStore(14);
        testBook.setPrice(999.0);
        testBook.setDescription("Desc");

        assertEquals("Failed to add book to the BookstoreDB", true, bookService.addBook(testBook));
    }

    @Test
    public void deleteBookByArticle() {
        assertEquals("Failed to delete book by BOOK_ARTICLE from the BookstoreDB", true, bookService.deleteBookByArticle(TEST_BOOK_ARTICLE));
    }
}
