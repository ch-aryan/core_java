package SystemDesignLLD.SOLID;

import java.util.ArrayList;
import java.util.List;

class Product1{
    String name;
    int price;
    Product1(String name, int price){
        this.name = name;
        this.price = price;
    }
}
class ShoppingCart1{
    private List<Product1> product1List = new ArrayList<>();
    public void addProduct(Product1 product1){
       product1List.add(product1);
    }
    public int calculatePrice(){
        int total = 0;
        for(Product1 p : product1List){
            total = total+ p.price;
        }
        return total;
    }

    public List<Product1> getProduct(){
        return product1List;
    }
}
class InvoicePrint{
    public void invoicePrinter(ShoppingCart1 cart){
        System.out.println("______INVOICE___________");
        for(Product1 p : cart.getProduct()){
            System.out.println(p.name + "___RS" + p.price);
        }

        System.out.println("Total "+ cart.calculatePrice());
    }
}
class DatabaseStorage{
    public void saveToDB(ShoppingCart1 cart){
        System.out.println("Saving cart with total . database");
    }
}

public class SRFollow {
    public static void main(String[] args) {
    ShoppingCart1 cart1  = new ShoppingCart1();

    cart1.addProduct(new Product1("laptop", 50000));
    cart1.addProduct(new Product1("Camera :", 100000));

    InvoicePrint print = new InvoicePrint();
    print.invoicePrinter(cart1);

    DatabaseStorage save = new DatabaseStorage();
    save.saveToDB(cart1);

    }
}
/*
                +----------------+
                    |    Product     |
                    +----------------+
                           ▲
                           |
                           |
                    +----------------+
                    | ShoppingCart   |
                    | calculateTotal |
                    +----------------+
                      ▲           ▲
                      |           |
                      |           |
          +----------------+   +----------------+
          | InvoicePrinter |   | DatabaseStorage|
          | printInvoice() |   | save()         |
          +----------------+   +----------------+
🧠 Responsibilities
Class	Responsibility
Product	Holds product data
ShoppingCart	Manages products and calculates total
InvoicePrinter	Prints invoice
DatabaseStorage	Saves to database
🔥 Real-Life Analogy

Think of a restaurant:

👨‍🍳 Chef cooks food
🧾 Cashier prints bill
📦 Delivery person delivers order

Each person has one responsibility.

🎯 Key Rule to Remember

If you can describe a class using the word “and”, it probably violates SRP.

Bad
ShoppingCart calculates total and prints invoice and saves to database.
Good
ShoppingCart calculates total.
InvoicePrinter prints invoice.
DatabaseStorage saves data.
🏆 Interview Answer

The Single Responsibility Principle states that a class should have only one reason to change.
Each class should
 focus on one specific responsibility, improving maintainability, readability, and testability.

 📌 Where SRP Helps in Your Matrimony Project

For MunnurKappu Matrimony:

ProfileService → manages profiles
PhotoService → uploads photos
NotificationService → sends notifications
PaymentService → records payments
MatchService → computes matches

Each service does one job.
 */