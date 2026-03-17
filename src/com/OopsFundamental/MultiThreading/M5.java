package com.OopsFundamental.MultiThreading;
class CarTest implements Runnable{
    @Override
   synchronized public void run() {//see the diff
        try {
            runCar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void runCar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " has entered");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+ " is driving");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " has reached dest");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+ " got out from car");
    }
}
public class M5 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread started");
        CarTest a = new CarTest();

        Thread c1 = new Thread(a);
        Thread c2 = new Thread(a);
        Thread c3 = new Thread(a);

        c1.setName("Aryan");
        c2.setName("akhil");
        c3.setName("Banu");

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();
        System.out.println("Thread ended");



    }
}
