package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

class Car1 implements Runnable {
    @Override
     public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "has entered into parkin lot");
          synchronized (this)  {//block level
                Thread.sleep(3000);
                System.out.println(name + " has starting car");
                Thread.sleep(3000);
                System.out.println(name + " has went out ");
                Thread.sleep(3000);
                System.out.println(name + " has came and parked the car");
            }
        }catch(InterruptedException e){
                e.printStackTrace();
            }


    }
}
public class UsingSynchro2  {
    public static void main(String[] args) {

        Car1 car = new Car1();

        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);

        t1.setName("Ramesh");
        t2.setName("Suresh");
        t3.setName("Mahesh");

        t1.start();
        t2.start();
        t3.start();

    }
}


