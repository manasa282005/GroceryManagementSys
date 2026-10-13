package com.grocery.model;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int productId, String name, double price, int quantity){
        this.productId=productId;
        this.name=name;
        if(price>0){
        this.price=price;}
        else throw new IllegalArgumentException("Invalid Price entry");
        if(quantity>0){
        this.quantity=quantity;}
        else throw new IllegalArgumentException("Invalid Quantity entry");
    }
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if(price>0){
            this.price=price;}
        else throw new IllegalArgumentException("Invalid Price entry");
    }

    public void setQuantity(int quantity) {
        if(quantity>0){
            this.quantity=quantity;}
        else throw new IllegalArgumentException("Invalid Quantity entry");
    }
}
