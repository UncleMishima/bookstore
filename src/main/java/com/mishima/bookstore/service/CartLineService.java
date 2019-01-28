package com.mishima.bookstore.service;

import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.CartLine;

import java.util.List;

public interface CartLineService {
    CartLine get(int id);
    boolean add(CartLine cartLine);
    boolean update(CartLine cartLine);
    boolean delete(CartLine cartLine);
    List<CartLine> list(int cartId);

    List<CartLine> listAvailable(int cartId);
    CartLine getByCartAndBook(int cartId, int bookId);

    boolean updateCart(Cart cart);
}
