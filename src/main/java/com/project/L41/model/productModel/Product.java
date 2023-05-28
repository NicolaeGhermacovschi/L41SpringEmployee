package com.project.L41.model.productModel;

public class Product {
    private long id;
    private String name;
    private ProductType productType;
    private double price;
    private String barCode;

    public Product() {
    }

    public Product(long id, String name, ProductType productType, double price, String barCode) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.barCode = barCode;
    }

    public Product(String name, ProductType productType, double price, String barCode) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.barCode = barCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                ", barCode='" + barCode + '\'' +
                '}';
    }
}
