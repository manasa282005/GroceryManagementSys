package com.grocery.service;

import com.grocery.model.Product;
public interface GroceryService {
    void addProduct(Product product);
    void viewProducts();
    void searchProduct(int id);
}
