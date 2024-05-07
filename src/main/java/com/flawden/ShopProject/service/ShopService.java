package com.flawden.ShopProject.service;

import com.flawden.ShopProject.db.CartRepository;
import com.flawden.ShopProject.exception.CartException;
import com.flawden.ShopProject.model.Cart;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@Scope(scopeName = "session")
public class ShopService {

    private CartRepository cartRepository;

    public ShopService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void add(long... id) throws CartException {
        if (id.length < 0) {
            throw new CartException("Ошибка! Не передано ни одного значения");
        }
        cartRepository.addToCart(id);
    }

    public Cart getCart() throws CartException {
        return cartRepository.getCart();
    }
}
