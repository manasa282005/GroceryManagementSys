
package com.grocery.service;
import com.grocery.dao.ProductDAO;
import com.grocery.model.CartItem;
import com.grocery.model.Product;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cart = new ArrayList<>();
    private ProductDAO productDAO = new ProductDAO();

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero!");
            return;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock!");
            return;
        }

        cart.add(new CartItem(product, quantity));
        System.out.println("Product added to cart!");
    }
    public void addProductById(int id, int quantity) {
        Product product = productDAO.getProductById(id);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        addToCart(product, quantity);
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        double grandTotal = 0;
        System.out.println("---CART items--");
        for (CartItem item : cart) {
            System.out.println("Product: " + item.getProduct().getName());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Total: " + item.getTotalPrice());
            System.out.println("-------------------");

            grandTotal += item.getTotalPrice();
        }

        System.out.println("Grand Total: " + grandTotal);
        System.out.println("--------------------------");
    }
}