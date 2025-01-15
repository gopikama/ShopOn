package org.example.User;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String loginUser(@RequestBody User loginUser) {
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


            /*Optional<User> user = userServiceObj.getUserByEmail(email);
            if (user.isPresent() && user.get().getUserPassword().equals(password)) {

                return "Login successful for user: " + email;
            } else {
                return "Invalid email or password";
            }*/
            return "Login successful for user: " + email;
        }catch(Exception e){
            return "Authentication failure";
        }
    }
}
