package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.BookDao;
import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.model.UserModel;
import com.mishima.bookstore.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartLineServiceImpl implements CartLineService {
    @Autowired
    private CartLineDao cartLineDao;

    @Autowired
    private HttpSession session;

    @Override
    public boolean add(CartLine cartLine) {
        return cartLineDao.add(cartLine);
    }

    @Override
    public boolean update(CartLine cartLine) {
        return cartLineDao.update(cartLine);
    }

    @Override
    public boolean delete(CartLine cartLine) {
        return cartLineDao.delete(cartLine);
    }

    @Override
    public CartLine getCartLineByBookArticle(int bookArticle) {
        return cartLineDao.getCartLineByBookArticle(bookArticle);
    }

    @Override
    public List<CartLine> listOfAvailable() {
        Cart cart = this.getCart();
        return cartLineDao.listOfAvailable(cart.getId());
    }

    private Cart getCart() {
        UserModel userModel = (UserModel)session.getAttribute("userModel");
        return userModel.getCart();
    }

    @Override
    public boolean isBookAlreadyInCart(Book book) {
        for (CartLine cartLine : listOfAvailable()) {
            Book bookInList = cartLine.getBook();
            if (book.getArticle() == bookInList.getArticle()) {
                return true;
            }
        }
        return false;
    }
}
