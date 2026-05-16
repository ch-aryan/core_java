package SystemDesignLLD.SOLID;
/*
Your sir’s notes summarize ISP as:
Many client-specific interfaces are better than one general-purpose interface.
🎯 Interface Segregation Principle (ISP)
Definition
Clients should not be forced to depend on methods they do not use.

🧠 Simple Meaning

If a class only needs one capability, it should not be forced to implement unrelated methods.

🍽️ Real-Life Analogy

Imagine a restaurant employee.

Chef → cooks food
Waiter → serves food
Cleaner → cleans tables

If you force every employee to implement all three jobs, that makes no sense.

Employee Interface
├── cook()
├── serve()
└── clean()

A chef should not be forced to implement serve() or clean().
 */
interface Worker {
    void cook();
    void serve();
    void clean();
}
class Chef implements Worker {
    @Override
    public void cook() {
        System.out.println("Cooking food");
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException(
                "Chef does not serve");
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException(
                "Chef does not clean");
    }
}
class Waiter implements Worker {
    @Override
    public void cook() {
        throw new UnsupportedOperationException(
                "Waiter does not cook");
    }

    @Override
    public void serve() {
        System.out.println("Serving food");
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException(
                "Waiter does not clean");
    }
}

public class InterfaceSegregationPUnfollow {
    public static void main(String[] args) {

    }
}
/*
❌ Why This Is Bad

Classes are forced to implement methods they do not need.

Chef
├── cook()   ✅
├── serve()  ❌
└── clean()  ❌

This leads to:

Empty methods
UnsupportedOperationException
Confusing code
LSP violations
 */