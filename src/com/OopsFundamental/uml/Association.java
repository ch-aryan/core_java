package com.OopsFundamental.uml;
class Car{
    private String model;
    private int speed;

    public Car(String model){
        this.model = model;
        speed = 0;
    }

    public void StartCar(){
        System.out.println(model + "car has been started");

    }
    public void accerate(int value){
        this.speed += value;
        System.out.println(model +"has been running in the speed of "+ speed);
    }
    public void stop() {
        speed = 0;
        System.out.println(model + " car stopped.");
    }
    public String getModel(){
        return model;
    }
}

class Driver{
    private String name;
    public Driver(String name){
        this.name = name;
    }
    public void driveCar(Car car){
        System.out.println(name + "is driving the "+ car.getModel());
        car.StartCar();
        car.accerate(100);
        car.stop();
        System.out.println(name +" reached destination  perfectly");
    }
}
public class Association {
    public static void main(String[] args) {

        Driver d1 = new Driver("ARyan");
        Car car1 = new Car("fortuner");

        Driver d2 = new Driver("shubham");
        Car car2 = new Car("bmw");

        d1.driveCar(car1);
        System.out.println("*************");
        d2.driveCar(car2);
    }
}
/*Association means relationship between two classes.

When one object uses or communicates with another object, it is called association.

✔️ Simple meaning:

“Two independent objects are connected to perform some work.”

✅ Real Life Example

Teacher ↔ Student

Driver ↔ Car

Customer ↔ Bank

Both can exist independently.

👉 Teacher can exist without student
👉 Student can exist without teacher

So this is Association

✅ Java Example of Association
class Student {
    String name;
}

class College {
    String collegeName;
    Student student;   // association
}

Here:

👉 College has a reference to Student
👉 Both are separate entities

This is called:

⭐ HAS-A relationship (general relationship)

✅ Types of Association (Interview point)

Association can be:

⭐ One-to-One
⭐ One-to-Many
⭐ Many-to-Many

Example:

One teacher → many students

Many customers → many products*/