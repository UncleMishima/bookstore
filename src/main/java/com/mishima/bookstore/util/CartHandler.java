package com.mishima.bookstore.util;

import com.mishima.bookstore.model.Book;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.model.User;

import java.util.List;

public final class CartHandler {
    public static double updateCartTotalPrice(List<CartLine> cartLineList) {
        double cartTotalPrice = 0.0;
        for (CartLine cartLine : cartLineList) {
            cartTotalPrice += cartLine.getTotal();
        }
        return cartTotalPrice;
    }

    public static CartLine createNewCartLine(Book book, User user) {
        CartLine newCartLine = new CartLine();
        newCartLine.setBook(book);
        newCartLine.setAvailable(true);
        newCartLine.setBuyingPrice(book.getPrice());
        newCartLine.setCartId(user.getCart().getId());
        newCartLine.setBookCount(newCartLine.getBookCount() + 1);
        newCartLine.setTotal(newCartLine.getBookCount() * newCartLine.getBuyingPrice());
        return newCartLine;
    }
}
