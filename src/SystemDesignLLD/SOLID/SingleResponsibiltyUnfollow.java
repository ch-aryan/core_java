package SystemDesignLLD.SOLID;

import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    int price;
    int itemID;

    Product(String name, int price, int itemID){
        this.name = name;
        this.price = price;
        this.itemID = itemID;
    }
}
class ShoppingCart{
    private List<Product> productListO = new ArrayList<>();
    public void addProduct(Product product){
        productListO.add(product);
    }
    //Responsibility 1: calculate totalPrice
    public int calculatePrice(){
        int total = 0;
        for(Product p : productListO){
            total = total + p.price;
        }
        return total;
    }
    //Responsibilty 2: printInvoice
    public void printInvoice(){
        System.out.println("Total amount :" + calculatePrice());
    }
    //Responsibility 3: saveToDB
    public void saveToDB(){
        System.out.println("saved successfully");
    }
}
public class SingleResponsibiltyUnfollow {
    public static void main(String[] args) {
        Product obj = new Product("oil", 1000, 1);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(obj);
        shoppingCart.calculatePrice();
        shoppingCart.printInvoice();
        shoppingCart.saveToDB();
    }
}
/*
❌ Why This Is Bad

ShoppingCart has three responsibilities:

ShoppingCart
├── Calculate Total
├── Print Invoice
└── Save to Database
Reasons to Change
Calculation logic changes
Invoice format changes
Database changes

So this class has three reasons to change.
 */