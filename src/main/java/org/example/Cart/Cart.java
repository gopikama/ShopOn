package org.example.Cart;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.UUID;

import org.example.User.User;


@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private String cartId;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;
    @Column(nullable = false)
    private LocalDateTime createdDate;

    //default constructor
    public Cart() {
        this.cartId = UUID.randomUUID().toString();  // Generate cartId
        this.createdDate = LocalDateTime.now();  // Set createdDate
    }


    public Cart(User user) {
        super();
        this.user=user;
        this.cartId=UUID.randomUUID().toString();
        this.createdDate=LocalDateTime.now();
    }

    //Getters and Setters
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
