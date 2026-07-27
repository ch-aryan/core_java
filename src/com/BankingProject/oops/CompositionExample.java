package com.BankingProject.oops;
class Car1{
    protected String name;
    protected transmission tms;
    protected powerSource psc;

    public Car1(String name, transmission tms, powerSource psc) {
        this.name = name;
        this.tms = tms;
        this.psc = psc;
    }

    public void start(){
        System.out.println("car started"+ name);
    }

    public void drive(){


        tms.changeGair();
        psc.powerSupply();
        System.out.println(name + "car is driving with speed");

    }
    public void stop(){
//        this.speed = 0;
        System.out.println(name + "car stopped");
    }

}
interface transmission{
    void changeGair();

}
interface powerSource{
    void powerSupply();
}

class GearBoxManual implements transmission{
    @Override
    public void changeGair() {
        System.out.println("Mnaula gear shifted");
    }
    public void usingSpecial(){
        System.out.println("some special");
    }
}
class battery implements powerSource{

    private int battery = 100;

    @Override
  public void  powerSupply(){
        battery -= 10;
        System.out.println("battery is giving the accelaeration to car remaining battery is"+ battery);
    }

    public void batteryCharge() {
        battery = 100;
        System.out.println("battery is fully charged"+battery);
    }

}

public class CompositionExample {
    public static void main(String[] args) {
        powerSource obj = new battery();
        transmission obj1 = new GearBoxManual();

        Car1 electricManualCar = new Car1("tesla", obj1 , obj);
        electricManualCar.start();
        electricManualCar.drive();
        electricManualCar.stop();
        ((battery) obj).batteryCharge();
        obj.powerSupply();
        obj1.changeGair();
        ((GearBoxManual) obj1).usingSpecial();

    }
}
