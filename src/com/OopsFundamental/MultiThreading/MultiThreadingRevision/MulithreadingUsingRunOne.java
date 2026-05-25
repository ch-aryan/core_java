package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

import java.util.Scanner;

class Alpha2 extends Thread{

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
    public void printRange()  {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter range you want to ");
        int n= in.nextInt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i =0;i<n ; i++){
            System.out.println(i+1);
        }
    }

    @Override
    public void run() {
        String aClass = Thread.currentThread().getName();
        if(aClass.equals("meth1")){
            banking();
        }else if(aClass.equals("meth2")){
            printRange();
        }else{
            printStart();
        }
    }
}
class Beta2 extends Thread {
    public void printStart() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("*********");
        }
    }
}


class Gamma2 extends Thread{
    public void printRange()  {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter range you want to ");
        int n= in.nextInt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i =0;i<n ; i++){
            System.out.println(i+1);
        }
    }


}
public class MulithreadingUsingRunOne {
    public static void main(String[] args) {
        Alpha2 alpha = new Alpha2();


        Thread thread = new Thread(alpha);
    Thread thread1    =new Thread(alpha);
        Thread thread2 = new Thread(alpha);

        thread.setName("meth1");
        thread1.setName("meth2");
        thread2.setName("meth3");

        thread.start();
        thread1.start();
        thread2.start();

    }
}
