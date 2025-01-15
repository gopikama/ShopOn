package org.example.Cart;

import org.example.User.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,String> {
    Optional<Cart> getCartByUser_UserId(String userId);

}
