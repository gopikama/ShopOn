package org.example.Cart;

import org.example.User.User;
import org.example.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    @Autowired
    CartService cartServiceObj;

    @Autowired
    UserService userService;

    @RequestMapping("/api/v1/cart")
    public Optional<Cart> getCartByUser_UserId() {
        //return cartServiceObj.getCartByUser_UserId(userService.getUser().getUserId());
        //for testing
        return cartServiceObj.getCartByUser_UserId("SO0001");
    }


}
