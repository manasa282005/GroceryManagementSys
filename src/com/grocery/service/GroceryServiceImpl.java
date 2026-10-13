package com.grocery.service;
import com.grocery.model.Product;
import com.grocery.dao.ProductDAO;

public class GroceryServiceImpl implements GroceryService {
    private ProductDAO productDAO=new ProductDAO();
    @Override
    public void addProduct(Product product){
        productDAO.addProduct(product);
        System.out.println("Product added Succcessfully!!");
    }
    @Override
    public void viewProducts(){
        productDAO.viewProducts();
    }
    @Override
    public void searchProduct(int id) {
        productDAO.searchProduct(id);
    }
}
