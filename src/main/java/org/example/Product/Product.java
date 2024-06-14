package org.example.Product;


public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private Float productPrice;

    public Product(String productId, String productName, String productDescription, String productCategory, Float productPrice) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }
}
