package SystemDesignLLD.SOLID;
interface SaveToDB{
    void save();
}
class sqlStorage implements SaveToDB{
    @Override
    public void save() {
        System.out.println("saving to sql");
    }
}
class mongoStorage implements SaveToDB{
    @Override
    public void save() {
        System.out.println("saving to mongoDb");
    }
}
class FileStorage implements SaveToDB{
    public void save(){
        System.out.println("saving to the file");
    }
}
class DriverManager{
    public void save(SaveToDB stb){
        stb.save();
    }
}
public class OSPFollow {
    public static void main(String[] args) {
    DriverManager dm = new DriverManager();
    FileStorage fs = new FileStorage();
    dm.save(new sqlStorage());
    dm.save(fs);
    }
}
/*
📊 Design Diagram
                Storage (interface)
                        |
        ---------------------------------
        |               |               |
   SQLStorage      MongoStorage      FileStorage

   ✅ GOOD DESIGN (OCP Followed)

Use:

Interface
Polymorphism
Separate implementations

File
🚀 Adding New Feature: Redis Storage
New Class Only
class RedisStorage implements Storage {
    @Override
    public void save() {
        System.out.println("Saving to Redis");
    }
}
Usage
manager.saveData(new RedisStorage());

No existing code changes required.

🎯 Why This Follows OCP
Existing classes:
✔ No modification

New behavior:
✔ Add new implementation
🧠 Core Idea

Replace if-else and switch statements with polymorphism.

📊 Before vs After
❌ Before
DatabaseStorage
 ├── if sql
 ├── else if mongo
 └── else if file
✅ After
Storage (interface)
 ├── SQLStorage
 ├── MongoStorage
 ├── FileStorage
 └── RedisStorage
🏢 Real-World Example from Your Matrimony Project
Notification System
NotificationSender
 ├── EmailSender
 ├── SmsSender
 └── WhatsAppSender

If tomorrow you add push notifications, just create:

PushNotificationSender

No modification to existing code.

🏆 Interview Explanation

The Open/Closed Principle states that software entities should be open for extension but
closed for modification. We achieve this using abstractions such as
interfaces and leverage polymorphism to add new behavior without changing existing, tested code.

🔥 Framework Examples

Used heavily in:

Spring Framework
Spring Boot
Hibernate

For example, in Spring you can create multiple implementations of the same interface and inject whichever one you need.

🧠 Memory Trick
OCP = Add New Class, Don't Edit Old Class
📌 Golden Rule

When you see:

Large if-else
Large switch

ask yourself:

“Can I replace this with an interface and multiple implementations?”

If yes, OCP is likely the right design approach.
 */