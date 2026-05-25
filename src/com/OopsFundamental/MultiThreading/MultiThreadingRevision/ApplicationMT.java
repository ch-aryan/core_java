package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

import java.util.Scanner;
//1st appraoch just learning how threads can be created.
class Alpha extends Thread{

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
class Beta extends Thread{
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
        super.run();
        printStart();
    }
}
class Gamma extends Thread{
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
        super.run();
        try {
            printRange();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class ApplicationMT {
    public static void main(String[] args) {

        Alpha obj = new Alpha();
        Beta beta = new Beta();
        Gamma gamma = new Gamma();

        //if we call obj.banking it will behave normally so to do so
        //create multithreading progarmming .

        //now we can obj.run and beta.run it also behave same so give the thread a life.

        obj.start();
        beta.start();
        gamma.start();
    }
}
