package org.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productServiceObj;

    @RequestMapping("/products")
    public List<Product> getAllProducts() { //automatically spring MVC converts this list to JSON
        return productServiceObj.getAllProducts();
    }

    @RequestMapping("/products/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return productServiceObj.getProduct(productId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Product product){
        productServiceObj.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}")
    public void updateProduct(@PathVariable String productId,@RequestBody Product product){
        productServiceObj.updateProduct(productId,product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}")
    public void deleteProduct(@PathVariable String productId){
        productServiceObj.deleteProduct(productId);
    }


}
