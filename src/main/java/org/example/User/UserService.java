package org.example.User;

import org.example.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    private User user;

    public User createUser(String userName, String userEmail, String userPassword, String userAddress, String userPhone) {
        // Create a new user object
        user = new User(userName, userEmail, userPassword, userAddress, userPhone);
        userRepository.save(user);

        // initialize the cart for this user using CartService-not needed created during login
        //cartService.createCart(user);
        return user;
    }


    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }
    public User getUserByEmail(String email){
        return userRepository.findByUserEmail(email);
    }

    //getters and setters
    public User getUser() {
        return user;
    }

}