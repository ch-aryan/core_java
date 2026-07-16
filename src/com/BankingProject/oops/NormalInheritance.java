package com.BankingProject.oops;
abstract class Car{
    protected String name;
    protected int speed;
    public Car(String name ){
        this.name = name;
        this.speed  = 0;
    }
    public void start(){
        System.out.println("car started"+ name);
    }

    public void drive(){
        this.speed = 60;
        System.out.println(name + "car is driving with speed"+ speed);
    }
    public void stop(){
        this.speed = 0;
        System.out.println(name + "car stopped");
    }

}
//👉 abstract because we never drive a generic car.
class ManualCar extends Car{

    public ManualCar(String name) {
        super(name);
    }
    public void shiftGear(int gear){
        System.out.println("manual car shifted gear"+ gear);
    }
}
class ElectricCar extends Car{
    private int batteryLevel;
public ElectricCar(String name){
    super(name);
    this.batteryLevel = 100;
}
public void chargeBattery(){
    batteryLevel = 100;

}
@Override
    public void drive(){
    batteryLevel -= 10;
    System.out.println( name + "car started in one jounery avialabe battery" + batteryLevel);
}
}
public class NormalInheritance {
    public static void main(String[] args) {
    Car car1 = new ElectricCar("TeslA");
    Car car2 = new ManualCar("TATA");

    car2.start();
    car2.drive();
    car2.stop();
        ((ManualCar) car2).shiftGear(2);

    car1.start();
    car1.drive();
    car1.stop();

    }
}
