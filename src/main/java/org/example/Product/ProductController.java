package org.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productServiceObj;

    @GetMapping("/api/v1/products")
    public List<Product> getAllProducts() { //automatically spring MVC converts this list to JSON
        return productServiceObj.getAllProducts();
    }

    @GetMapping("/api/v1/products/{productId}")
    public Optional<Product> getProduct(@PathVariable String productId) {
        return productServiceObj.getProduct(productId);
    }

    @PostMapping("/api/v1/products")
    public void addProduct(@RequestBody Product product){
        productServiceObj.addProduct(product);
    }

    @PutMapping("/api/v1/products/{productId}")
    public void updateProduct(@PathVariable String productId,@RequestBody Product product){
        productServiceObj.updateProduct(productId,product);
    }

    @DeleteMapping("/api/v1/products/{productId}")
    public void deleteProduct(@PathVariable String productId){
        productServiceObj.deleteProduct(productId);
    }


}
