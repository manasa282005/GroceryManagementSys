package com.grocery.dao;

import com.grocery.util.DBConnection;

import com.grocery.model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProductDAO {
    public void testConnection(){
        try(Connection con= DBConnection.getConnection()){
            System.out.println("Database connected!!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void addProduct(Product product){
        String sql="INSERT INTO PRODUCTS VALUES(?,?,?,?)";
        try(Connection con=DBConnection.getConnection();java.sql.PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,product.getProductId());
            ps.setString(2, product.getName());
            ps.setDouble(3,product.getPrice());
            ps.setInt(4,product.getQuantity());
            ps.executeUpdate();
            System.out.println("Product saved to Database!!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void viewProducts(){
        String sql="SELECT * FROM products";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){
            System.out.println("---Product Details---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("------------------");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void searchProduct(int id){
        String sql="SELECT * FROM products WHERE product_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("---Product Found---");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getBigDecimal("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
            } else {
                System.out.println("Product not found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateQuantity(int id, int quantity) {
        String sql = "UPDATE products SET quantity = ? WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Quantity updated!");
            } else {
                System.out.println("Product not found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product deleted!");
            } else {
                System.out.println("Product not found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}