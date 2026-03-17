package com.OopsFundamental.MultiThreading;

import java.util.Scanner;

class Alpaa extends Thread{
    Scanner in = new Scanner(System.in);
    @Override
    public void run(){
        add();
    }
    public void add(){
        System.out.println("Enter numbers");
        int a = in.nextInt();
        int b = in.nextInt();
        int result = a/b;
        System.out.println(result);
    }

}
class Betta extends Thread{
    public void add(){
        try {
            printStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printStars() throws InterruptedException {
        for(int i =0;i<5;i++) {
            for (int j = 0; j < i; j++) {

                System.out.println("* ");
            }
            System.out.println();
        }
    }
}
class Gamma extends Thread{
    public void run(){
        printArr();
    }
    int[] arr = {42,33,12,45};
    public void printArr(){
        for(int i:arr){
            System.out.println(i);
        }
    }

}
public class M2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("this is frist statement");
    Alpaa obj1 = new Alpaa();
    Betta obj2 = new Betta();
    Gamma obj3 = new Gamma();

    obj1.start();
        try {
            obj2.printStars();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj3.printArr();
        obj1.join();
        obj2.join();
        obj3.join();
        System.out.println("this is end statement");

    }
}
