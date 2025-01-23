package org.example.CartItem;

import jakarta.persistence.*;

import org.example.Cart.Cart;
import org.example.Product.Product;


import java.util.UUID;


@Entity
@Table(name = "cartItem")
public class CartItem {

    @Id
    private String cartItemId;
    @ManyToOne
    @JoinColumn(name="cartId",referencedColumnName="cartId",nullable=false)
    private Cart cart;
    @OneToOne
    @JoinColumn(name="productId",referencedColumnName = "productId",nullable=false)
    private Product product;

    private int quantity;



    public CartItem(String cart_id,String product_id) {
        super();
        cartItemId=UUID.randomUUID().toString();
        cart_id=cart.getCartId();
        product_id=product.getProductId();
        quantity=1;

    }

    //Getters and Setters
    public String getCartItemId() {
        return cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
