package org.example.Cart;

import org.example.CartItem.CartItem;
import org.example.CartItem.CartItemService;
import org.example.Product.ProductService;
import org.example.User.User;
import org.example.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserService userServiceObj;

    @Autowired
    ProductService productServiceObj;

    @Autowired
    CartItemService cartItemServiceObj;

    @RequestMapping("/api/v1/cart/{productId}")
    public void updateCart(@PathVariable String productId) {
        //return cartServiceObj.getCartByUser_UserId(userService.getUser().getUserId());
        //for testing
        //return cartServiceObj.getCartByUser_UserId("SO0001");
        //userId to get cartId then from that cartId see if Cart item exists
        /*String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("current user Gopika comment:"+currentUserEmail);
        User currentUser = userServiceObj.getUserByEmail(currentUserEmail);

        System.out.println("current user Gopika comment 2:"+SecurityContextHolder.getContext().getAuthentication());
        */
        String currentUserEmail="";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        currentUserEmail = auth.getName(); // This gets the email (username) from the authentication
        System.out.println("Authenticated user email: " + currentUserEmail);
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            currentUserEmail = auth.getName(); // This gets the email (username) from the authentication
            System.out.println("Authenticated user email: " + currentUserEmail);
        }

        User currentUser = userServiceObj.getUserByEmail(currentUserEmail);

        if (currentUser == null) {
            throw new RuntimeException("User not found");
        }

        //Retrieve the user's cart
        Optional<Cart> userCart = cartServiceObj.getCartByUser_UserId(currentUser.getUserId());

        if (userCart.isEmpty()) {
            throw new RuntimeException("Cart not found for the user");
        }

        String cartId=userCart.get().getCartId();
        Optional<CartItem> cartItem=cartItemServiceObj.findCart_ByCartIdAndProduct_ProductId(cartId,productId);

        if (cartItem.isEmpty()) {
            //add new line to cart
            CartItem newCartItem=new CartItem(cartId,productId);
            cartItemServiceObj.saveCartItem(newCartItem);
        }
        else{
            //update existing cart lines's quantity by one
            CartItem updatedCartItem=cartItem.get();
            updatedCartItem.setQuantity(cartItem.get().getQuantity()+1);
            cartItemServiceObj.saveCartItem(updatedCartItem);
        }

    }


}
