package com.flawden.ShopProject.controller;

import com.flawden.ShopProject.exception.CartException;
import com.flawden.ShopProject.model.Cart;
import com.flawden.ShopProject.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
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
    public List<Long> getCart() throws CartException {
        return shopService.getCart().getProductsId();
    }

    @ExceptionHandler
    private String cartException(CartException e) {
        return e.getMessage();
    }

}
