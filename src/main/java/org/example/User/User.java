package org.example.User;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.UUID;

@Entity
public class User implements UserDetails {
    @Id
    private String userId;
    @Column(unique = true)
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userPhone;

    public User(){
    }
    public User(String userName, String userEmail, String userPassword, String userAddress, String userPhone ) {
        super();
        this.userId= UUID.randomUUID().toString();
        this.userName=userName;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.userAddress=userAddress;
        this.userPhone=userPhone;
    }
    // Implement UserDetails interface's methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return user roles or permissions (usually an empty list if not used)
        return null;
    }
    @Override
    public String getPassword() {
        return this.userPassword;
    }
    @Override
    public String getUsername() {
        return this.userEmail;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    //getters and setters to access from different class
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserEmail() { return userEmail; }
    public String getUserAddress() { return userAddress; }
    public String getUserPhone() { return userPhone; }
    public String getUserPassword() { return userPassword; }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserEmail(String userEmail) {this.userEmail = userEmail; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

}
