package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.CartLine;

import java.util.List;

public interface CartLineDao {
    boolean add(CartLine cartLine);
    boolean update(CartLine cartLine);
    boolean delete(CartLine cartLine);
    List<CartLine> listOfAvailable(int cartId);
}
