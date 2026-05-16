package SystemDesignLLD.SOLID;

public class DependencyInversionPrinciple {
}
/*
Your sir’s notes summarize DIP as:

High-level modules should not depend on low-level modules. Both should depend on abstractions.

This is one of the most powerful principles in modern software engineering and the foundation of frameworks like Spring Framework and Spring Boot.

🎯 Dependency Inversion Principle (DIP)
Definition

High-level modules should not depend on low-level modules. Both should depend on abstractions.

Abstractions should not depend on details. Details should depend on abstractions.
🧠 Simple Meaning

Business logic should not directly depend on specific implementations.

Instead:

Application
    ↓
Interface (Abstraction)
    ↑
SQLDatabase / MongoDatabase / FileStorage
🏢 Real-Life Analogy: CEO and Developers
CEO  →  Manager  →  Developers
CEO = High-level module
Developers = Low-level modules
Manager = Abstraction

The CEO communicates through the manager, not directly with individual developers.

If one developer is replaced, the CEO is unaffected.
📦 Example: Saving Data

We have:

Business logic (Application)
Database implementations (SQLDatabase, MongoDatabase)
❌ BAD DESIGN (DIP Violated)
Low-Level Module
class SQLDatabase {
    public void save() {
        System.out.println("Saving data to SQL Database");
    }
}
High-Level Module
class Application {
    private SQLDatabase database = new SQLDatabase();

    public void storeData() {
        database.save();
    }
}
❌ Problems

If you want to use:

MongoDB
File storage
Cloud storage

you must modify Application.

This causes:

Tight coupling
Difficult testing
OCP violation
 */