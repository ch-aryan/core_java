package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

import java.util.Scanner;

class Alpha1 implements Runnable{

    public void banking() {
        System.out.println("con start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Etner your account");
        int n = in.nextInt();
        System.out.println("enter amount");
        int m = in.nextInt();
        System.out.println("collect your cash.");

        System.out.println("con ter");

    }

    @Override
    public void run() {
        banking();
    }
}
class Beta1 implements Runnable{
    public void printStart(){
        for(int i =0;i<5;i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("*********");
        }
    }

    @Override
    public void run() {

        printStart();
    }
}
class Gamma1 implements Runnable{
    public void printRange() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter range you want to ");
        int n= in.nextInt();
        Thread.sleep(3000);
        for(int i =0;i<n ; i++){
            System.out.println(i+1);
        }
    }

    @Override
    public void run() {

        try {
            printRange();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class  AnotherAppraochRunnable {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main started");
        Alpha1 obj = new Alpha1();
        Beta1 beta = new Beta1();
        Gamma1 gamma = new Gamma1();

    Thread thread1 = new Thread(obj);
    Thread thread2 = new Thread(beta);
    Thread thread3 = new Thread(gamma);

    thread1.start();;
    thread2.start();
    thread3.start();
    thread1.join();
    thread2.join();
    thread3.join();

        System.out.println("main trermiatenad");

    }
}