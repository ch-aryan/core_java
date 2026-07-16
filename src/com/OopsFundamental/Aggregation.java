package com.OopsFundamental;
class Engine1{
    public void start(){
        System.out.println("engine started");
    }
}
class Car1{
    public Engine1 engine1;
    public Car1(Engine1 engine1){
        this.engine1 = engine1;
    }
    public void startCar1(){
        engine1.start();
        System.out.println("car started");
    }
}
public class Aggregation {
    public static void main(String[] args) {
        Car1 car = new Car1(new Engine1());
        car.startCar1();
    }
}
