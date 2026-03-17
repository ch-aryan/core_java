package com.OopsFundamental.MultiThreading;
class ABC implements Runnable{
    public void  run(){
        String name = Thread.currentThread().getName();
        if(name.equals("First")){
            printStarts();
        }else if (name.equals("Second")){
            sencondMethod();
        }else{
            thirdMethod();
        }
    }
    public void printStarts(){
        for(int i =0;i<3;i++){
            System.out.println("**");
        }
    }
    public void sencondMethod(){
        for(int i = 0; i<4;i++){
            System.out.println("123");
        }
    }
    public void thirdMethod(){
        for(int i =0; i<5;i++){
            System.out.println("###");
        }
    }
}
public class M4 {
    public static void main(String[] args) throws InterruptedException {
        ABC a = new ABC();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);

        t1.setName("First");
        t2.setName("Second");
        t3.setName("third");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
