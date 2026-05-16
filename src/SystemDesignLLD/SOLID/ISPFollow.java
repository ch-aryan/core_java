package SystemDesignLLD.SOLID;
interface Cookable {
    void cook();
}

interface Serveable {
    void serve();
}

interface Cleanable {
    void clean();
}

class Chef1 implements Cookable {
    @Override
    public void cook() {
        System.out.println("Cooking food");
    }
}
class Waiter1 implements Serveable {
    @Override
    public void serve() {
        System.out.println("Serving food");
    }
}
class Cleaner implements Cleanable {
    @Override
    public void clean() {
        System.out.println("Cleaning tables");
    }
}
public class ISPFollow {
    public static void main(String[] args) {


                Cookable chef = new Chef1();
                Serveable waiter = new Waiter1();
                Cleanable cleaner = new Cleaner();

                chef.cook();
                waiter.serve();
                cleaner.clean();
            }
        }

/*
✅ GOOD DESIGN (ISP Followed)

Split the large interface into smaller, focused interfaces.

📊 Design Diagram
Cookable
Serveable
Cleanable

Chef   -> Cookable
Waiter -> Serveable
Cleaner-> Cleanable
✅ Output
Cooking food
Serving food
Cleaning tables
🧠 Why This Follows ISP

Each class depends only on methods it actually uses.

Class	Interface
Chef	Cookable
Waiter	Serveable
Cleaner	Cleanable
❌ Bad Interface
interface Shape {
    double area();
    double volume();
}

Problem:

2D shapes (Square, Rectangle) do not have volume.
✅ Good Design
interface TwoDShape {
    double area();
}

interface ThreeDShape {
    double area();
    double volume();
}
🏢 Matrimony Project Example

For MunnurKappu Matrimony:

ReadableProfile
EditableProfile
DeletableProfile
Notifiable

Different services implement only what they need.

🏆 Interview Explanation

The Interface Segregation Principle states that clients should not be forced to depend on methods they do not use. Instead of one large interface, we create smaller, focused interfaces so classes implement only relevant behavior.

🔥 Relationship with LSP

When classes throw UnsupportedOperationException, it often indicates:

ISP violation
Potential LSP violation

Splitting interfaces usually resolves both issues.
🧠 Memory Trick
ISP = Small Interfaces for Specific Clients
📌 Golden Rule

If a class is forced to implement methods it doesn’t need, split the interface.

📊 Before vs After
❌ Before
Worker
├── cook()
├── serve()
└── clean()
✅ After
Cookable
Serveable
Cleanable
 */