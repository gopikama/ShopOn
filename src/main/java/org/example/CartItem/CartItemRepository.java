package org.example.CartItem;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItem,String> {
    Optional<CartItem> findByCart_CartIdAndProduct_ProductId(String cartId, String productId);

}
