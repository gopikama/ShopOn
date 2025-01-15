package org.example.CartItem;

import org.example.Cart.Cart;
import org.example.Product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CartItemController {
    @Autowired
    CartItemService cartItemServiceObj;

    //@Autowired
    //Cart cart;



}
