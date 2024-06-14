package org.example.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @RequestMapping("/products")
    public List<Product> getAllProducts(){ //automatically spring MVC converts this list to JSON
        return Arrays.asList(
                new Product("0001","Reebok Shoes","Running shoes","Footwear",1500.00F),
                new Product("0002","Sketcher Shoes","Running shoes","Footwear",1300.00F)
        );
    }
}
