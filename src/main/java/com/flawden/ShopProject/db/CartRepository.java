package com.flawden.ShopProject.db;

import com.flawden.ShopProject.exception.CartException;
import com.flawden.ShopProject.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

@Repository
@Scope(scopeName = "session")
public class CartRepository {

    @Autowired
    private Cart cart;

    public void addToCart (long ... products) throws CartException {
        for (Long product: products) {
            cart.getProductsId().add(product);
        }
    }

    public Cart getCart() {
        return cart;
    }
}
