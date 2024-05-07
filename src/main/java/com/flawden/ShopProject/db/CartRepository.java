package com.flawden.ShopProject.db;

import com.flawden.ShopProject.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

@Repository
@SessionScope
public class CartRepository {

    private Cart cart;

    public CartRepository(Cart cart) {
        this.cart = cart;
    }

    public void addToCart (long ... products) {
        for (Long product: products) {
            cart.getProductsId().add(product);
        }
    }

    public Cart getCart() {
        return cart;
    }
}
