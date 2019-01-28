package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.CartLineDao;
import com.mishima.bookstore.model.Cart;
import com.mishima.bookstore.model.CartLine;
import com.mishima.bookstore.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartLineServiceImpl implements CartLineService {

    @Autowired
    CartLineDao cartLineDao;

    @Override
    public CartLine get(int id) {
        return cartLineDao.get(id);
    }

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
    public List<CartLine> list(int cartId) {
        return cartLineDao.list(cartId);
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        return cartLineDao.listAvailable(cartId);
    }

    @Override
    public CartLine getByCartAndBook(int cartId, int bookId) {
        return cartLineDao.getByCartAndBook(cartId, bookId);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartLineDao.updateCart(cart);
    }
}
