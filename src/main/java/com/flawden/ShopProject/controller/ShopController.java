package com.flawden.ShopProject.controller;

import com.flawden.ShopProject.exception.CartException;
import com.flawden.ShopProject.model.Cart;
import com.flawden.ShopProject.service.ShopService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
@Scope(scopeName = "session")
@RequestMapping("/store/order")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody long... id) throws CartException {
        shopService.add(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public Cart getCart() throws CartException {
        return shopService.getCart();
    }

    @ExceptionHandler
    private String cartException(CartException e) {
        return e.getMessage();
    }

}
