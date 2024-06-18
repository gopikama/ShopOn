package org.example.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("0001","Reebok Shoes","Running shoes","Footwear",1500.00F),
                new Product("0002","Sketcher Shoes","Running shoes","Footwear",1300.00F)
        ));

    public List<Product> getAllProducts(){
        return products;
    }
    public Product getProduct(String productId){
        return products.stream().filter( t->t.getProductId().equals(productId)).findFirst().get();
    }
    public void addProduct(Product product){
        products.add(product);
    }
}