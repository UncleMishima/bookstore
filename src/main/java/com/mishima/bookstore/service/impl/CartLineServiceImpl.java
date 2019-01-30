package com.mishima.bookstore.service.impl;

import com.mishima.bookstore.dao.CartLineDao;
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
    CartLineDao cartLineDao;

    @Autowired
    HttpSession session;

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
    public List<CartLine> listOfAvailable() {
        Cart cart = this.getCart();
        return cartLineDao.listOfAvailable(cart.getId());
    }

    private Cart getCart() {
        UserModel userModel = (UserModel)session.getAttribute("userModel");
        return userModel.getCart();
    }
}
