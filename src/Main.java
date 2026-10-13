import com.grocery.model.Product;
import com.grocery.service.GroceryServiceImpl;
import com.grocery.service.GroceryService;
import java.util.Scanner;
import com.grocery.service.CartService;


public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GroceryService service=new GroceryServiceImpl();
        CartService cartService = new CartService();
        System.out.println("\n ------GROCERY MANAGEMENT SYSTEM---------");
        while(true){
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Search Product");
            System.out.println("4. Add to cart");
            System.out.println("5. View Cart");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    String ans="yes";
                    while(ans.equalsIgnoreCase("yes")){
                    System.out.println("Product Id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    Product product =
                            new Product(id, name, price, quantity);

                    service.addProduct(product);
                        System.out.print("Add another product? (yes/no): ");
                        ans= sc.next();
                    }
                    break;
                case 2:
                    service.viewProducts();
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    int searchId = sc.nextInt();
                    service.searchProduct(searchId);
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    cartService.addProductById(id, quantity);
                    break;

                case 5:
                    cartService.viewCart();
                    break;
                case 6:
                    System.out.println("----CLOSE-----");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}