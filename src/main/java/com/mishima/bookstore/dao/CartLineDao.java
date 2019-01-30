package com.mishima.bookstore.dao;

import com.mishima.bookstore.model.CartLine;

import java.util.List;

public interface CartLineDao {
    boolean add(CartLine cartLine);
    boolean update(CartLine cartLine);
    boolean delete(CartLine cartLine);
    CartLine getCartLineByBookArticle(int bookArticle);
    List<CartLine> listOfAvailable(int cartId);
}
