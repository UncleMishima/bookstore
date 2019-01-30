package com.mishima.bookstore.service;

import com.mishima.bookstore.model.CartLine;

import java.util.List;

public interface CartLineService {
    boolean add(CartLine cartLine);
    boolean update(CartLine cartLine);
    boolean delete(CartLine cartLine);
    List<CartLine> listOfAvailable();
}
