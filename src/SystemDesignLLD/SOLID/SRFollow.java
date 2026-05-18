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
/*
Exactly, Aryan — that is a very insightful observation.

Short Answer

Yes, the SRP example primarily uses Association, and more specifically a “uses-a” relationship.

In the design:

InvoicePrinter uses ShoppingCart
DatabaseStorage uses ShoppingCart

So the relationship is mainly Association.

📊 SRP Design Recap
ShoppingCart
    ↑
    │ uses
    │
InvoicePrinter

ShoppingCart
    ↑
    │ uses
    │
DatabaseStorage
☕ Java Code Reminder
class InvoicePrinter {
    public void printInvoice(ShoppingCart cart) {
        System.out.println(cart.calculateTotal());
    }
}

class DatabaseStorage {
    public void save(ShoppingCart cart) {
        System.out.println("Saving...");
    }
}

Here:

ShoppingCart is passed as a method parameter.
Neither class owns the cart permanently.
They simply use it temporarily.

That is classic Association.

🧠 Why It Is Not Composition

Composition means one object creates and owns another.

Example:

class Car {
    private Engine engine = new Engine();
}

In our SRP example:

InvoicePrinter printer = new InvoicePrinter();
printer.printInvoice(cart);
InvoicePrinter does not create ShoppingCart.
It does not store it as a mandatory internal part.
It only uses it.

So this is not composition.

🧩 Why Your Sir Mentioned “Has-A”

Sometimes instructors say “has-a relationship” in a broader, conceptual sense. In UML terminology:

If a class merely receives another object and uses it → Association
If it stores references but does not own lifecycle → often Aggregation
If it creates and owns lifecycle → Composition

In the SRP example as implemented, the strongest and most accurate classification is Association.

🏗️ If We Stored the Cart as a Field
class InvoicePrinter {
    private ShoppingCart cart;

    public InvoicePrinter(ShoppingCart cart) {
        this.cart = cart;
    }
}

This becomes a stronger “has-a” relationship. Depending on lifecycle ownership, it may be viewed as:

Aggregation (if cart is created elsewhere), or
Composition (if created internally).

But in our original version, we simply passed the cart to methods.

📌 Relationship Summary in SRP Example
Class	Relationship to ShoppingCart	Why
InvoicePrinter	Association	Uses cart as method parameter
DatabaseStorage	Association	Uses cart as method parameter
Product inside ShoppingCart	Aggregation/Composition (design choice)	Cart contains products
🎯 Best Interview Answer

In the SRP example, InvoicePrinter and DatabaseStorage have an association relationship with ShoppingCart because they use the cart to perform their responsibilities. They do not own its lifecycle.

🧠 Memory Trick
Method parameter only  → Association
Stored reference       → Aggregation
Created and owned      → Composition
🏆 Final Conclusion

Yes, the SRP design mainly demonstrates Association, because helper classes use ShoppingCart to perform their responsibilities without owning it.
 */