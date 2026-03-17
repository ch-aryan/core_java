package com.OopsFundamental.MultiThreading;

import java.sql.SQLOutput;
import java.util.Scanner;

class Alpha23 implements Runnable{
    Scanner in = new Scanner(System.in);


    @Override
    public void run() {
        print();
    }

    public void print(){
        System.out.println("ENTER N ");
        int n  = in.nextInt();
        for(int i = 0;i<n;i++) {

            System.out.println("print this ok ");
        }
    }
}
class Beta23 implements Runnable{
    @Override
    public void run() {
        try {
            betaPrint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void betaPrint() throws InterruptedException {
        int n = 5;
        for(int i = 0; i< n ; i++) {
           Thread.sleep(2000);
            System.out.println("hello from 2nd class beta");

        }

    }
}
class Gamma23 implements Runnable{
    @Override
    public void run() {
        try {
            gammaPrint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void gammaPrint() throws InterruptedException{
//        Thread.sleep(3000);
        System.out.println("hello run");
    }
}
public class M3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("thread started");
        Alpha23 a = new Alpha23();
        Beta23 b = new Beta23();
        Gamma23 g = new Gamma23();

        Thread thread = new Thread(a);
        Thread thread1 = new Thread(b);
        Thread thread2 = new Thread(g);



        thread1.start();
        thread.start();
        thread2.start();
        thread1.join();
       thread2.join();
        thread.join();
        System.out.println("thread terminated");//comes first only if you don't invoke join method.

    }
}
