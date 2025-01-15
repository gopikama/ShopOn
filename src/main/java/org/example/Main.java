package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example.UserAuthentication","org.example.User","org.example.Cart","org.example.Product","org.example.CartItem"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}