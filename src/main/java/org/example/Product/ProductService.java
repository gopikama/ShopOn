package org.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
    public Optional<Product> getProduct(String productId){
        Optional<Product> p;
        p=productRepository.findById(productId);
        return p;
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(String productId,Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}