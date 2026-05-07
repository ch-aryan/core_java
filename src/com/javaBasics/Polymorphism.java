package com.javabasics;
class AeroPlane{
    public void fly(){
        System.out.println("aeroplane is fly");
    }
    public void land(){
        System.out.println("landing is done");
    }

}
class FighterPlane extends AeroPlane{
    public void fly(){
        System.out.println(" fighter aeroplane is fly");
    }
    public void land(){
        System.out.println("fighter landing is done");
    }

}
class CargoPlane extends AeroPlane{
    public void fly(){
        System.out.println("cargo aeroplane is fly");
    }
    public void land(){
        System.out.println("cargo landing is done");
    }

}

class Airport{
    public void permitt(AeroPlane aeroPlane){
        aeroPlane.land();
        aeroPlane.fly();
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        AeroPlane aeroPlane = new AeroPlane();
//        aeroPlane.fly();
//        aeroPlane.land();
//        System.out.println("********11111");
//
//
//
//
//        System.out.println("********");

        FighterPlane fighterPlane = new FighterPlane();
        CargoPlane cargoPlane = new CargoPlane();

        Airport obj = new Airport();
        obj.permitt(fighterPlane);
        obj.permitt(cargoPlane);
        obj.permitt(aeroPlane);


        System.out.println("*******");

//        CargoPlane cargoPlane = new CargoPlane();
//        cargoPlane.fly();
//        cargoPlane.land();
//
//        System.out.println("*********");
//
//        AeroPlane fcPlane = new CargoPlane();//allowed
//        AeroPlane cfPlane = new FighterPlane();//allowed
//
//        fcPlane.land();
//        fcPlane.fly();
//
//        System.out.println("*********");
//        cfPlane.fly();
//        cfPlane.land();
//        int a = 10;
//        long b; same concept of polymorphism.
//        b= a;
    }
}
