package com.mishima.bookstore.controller;

import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.User;
import com.mishima.bookstore.service.BookService;
import com.mishima.bookstore.service.CartLineService;
import com.mishima.bookstore.service.CartService;
import com.mishima.bookstore.service.UserService;
import com.mishima.bookstore.util.CartHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    CartLineService cartLineService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = {"/", "/booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "booklist";
    }

    @RequestMapping("/booklist/{bookGenre}")
    public String bookGenreList(@PathVariable String bookGenre, Model model) {
        model.addAttribute("bookGenre", bookGenre);
        model.addAttribute("books", bookService.getAllBooksByGenre(bookGenre));
        return "bookgenre";
    }

    @RequestMapping("/booklist/bookdetails/{bookArticle}")
    public String bookDetails(@PathVariable int bookArticle, Model model) {
        model.addAttribute("book", bookService.getBookByArticle(bookArticle));
        return "bookdetails";
    }

    @RequestMapping({"/buyBook"})
    public String buyBook(@RequestParam(value = "code") int bookArticle) {
        Book book = bookService.getBookByArticle(bookArticle);
        User user = userService.getCurrentUser();

        if (cartLineService.isBookAlreadyInCart(book)) {
            CartLine cartLine = cartLineService.getCartLineByBookArticle(bookArticle);
            cartLine.setBookCount(cartLine.getBookCount() + 1);
            cartLineService.update(cartLine);
        } else {
            CartLine cartLine = CartHandler.createNewCartLine(book, user);
            cartLineService.add(cartLine);
        }

        Cart cart = user.getCart();
        double newTotalPrice = CartHandler.updateCartTotalPrice(cartLineService.listOfAvailable());
        cart.setTotalPrice(newTotalPrice);
        cartService.updateCart(user.getCart());

        return "redirect:/booklist";
    }

    @RequestMapping({"/orderBooks"})
    public String orderBooks() {
        User user = userService.getCurrentUser();
        List<CartLine> cartLineList = cartLineService.listOfAvailable();

        for (CartLine cartLine : cartLineList) {
            Book book = cartLine.getBook();
            book.setAmountInStore(book.getAmountInStore() - cartLine.getBookCount());
            bookService.updateBook(book);
            cartLineService.delete(cartLine);
        }

        Cart cart = user.getCart();
        cart.setTotalPrice(0.0);
        cartService.updateCart(cart);

        return "redirect:/booklist";
    }
}
