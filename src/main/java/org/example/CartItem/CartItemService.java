package org.example.CartItem;


import org.example.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartitemRepository;

    public Optional<CartItem> findCart_ByCartIdAndProduct_ProductId(String cartId, String productId){
        return cartitemRepository.findByCart_CartIdAndProduct_ProductId(cartId,productId);
    }

    public void saveCartItem(CartItem cartItem){
        cartitemRepository.save(cartItem);
    }
    
}