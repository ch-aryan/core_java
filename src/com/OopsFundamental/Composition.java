package com.OopsFundamental;
class Car{
    private Engine engine;
    private String name;
    public Car(String name){
        this.name = name;
        this.engine = new Engine();
    }
    public void carStart(){
        engine.stat();
    }
}
class Engine{
    public void stat(){
        System.out.println("Engined started");
    }
        }
public class Composition {
    public static void main(String[] args) {
        Car c = new Car("fortuner");
        c.carStart();
    }
}

