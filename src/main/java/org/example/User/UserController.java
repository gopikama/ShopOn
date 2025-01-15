package org.example.User;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.Cart.Cart;
import org.example.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userServiceObj;

    @Autowired
    CartService cartServiceObj;

    @Autowired
    private AuthenticationManager authenticationManager;  // Spring Security authentication manager

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/api/v1/users")
    public List<User> getAllUsers() { //automatically spring MVC converts this list to JSON
        return userServiceObj.getAllUsers();
    }

    @ApiResponse(responseCode = "404",description="Page Not found")
    @PostMapping("/api/v1/registration")
    public User registerUser(@RequestBody User registerUser){
        return userServiceObj.createUser(
                registerUser.getUserName(),
                registerUser.getUserEmail(),
                passwordEncoder.encode(registerUser.getUserPassword()),
                registerUser.getUserAddress(),
                registerUser.getUserPhone());
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {

        String email = loginUser.getUserEmail();
        String password = loginUser.getUserPassword();
        try {
            // Authenticate user using Spring Security
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     email,password
                )
            );
            // Set the authentication context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Fetch the authenticated user
            User user = userServiceObj.getUserByEmail(email);
            if (user == null) {
                return ResponseEntity.status(404).body("User not found!");
            }

            //Assign cart to user if it doesn't exist
            cartServiceObj.createCart(user);

            return ResponseEntity.ok("Login successful for user: " + email);
        }catch(Exception e){
            return ResponseEntity.status(401).body("Authentication failure: " + e.getMessage());
        }
    }
}
