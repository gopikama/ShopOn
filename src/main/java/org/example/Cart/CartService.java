package org.example.Cart;

import org.example.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void createCart(User user){
        Cart cart;
        Optional<Cart> checkCart = getCartByUser_UserId(user.getUserId());
        if (checkCart.isEmpty()) {
            cart = new Cart(user);
            cartRepository.save(cart);
        }
    }



    public Optional<Cart> getCartByUser_UserId(String userId){
        return cartRepository.getCartByUser_UserId(userId);
    }
}