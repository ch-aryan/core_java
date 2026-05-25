package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

import java.util.Scanner;

public class SampleOFMT {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("con start");

        //Thread.sleep(5000);
        Scanner in = new Scanner(System.in);
        System.out.println("Etner your account");
        int n = in.nextInt();
        System.out.println("enter amount");
        int m = in.nextInt();
        System.out.println("collect your cash.");

        System.out.println("con ter");

        System.out.println("Now this is different");
        for(int i =0;i<5;i++){
            System.out.println("*");
        }
        System.out.println("lets see the another program");
        System.out.println("Etner the range you want to print the numbers");
        int ran = in.nextInt();
        for(int i =0; i<ran ;i++){
            System.out.print(i+" ");
        }
    }
}
//other applicatinons are dependent on the user input right. so cpu time is getting wasted.
//this is achiving parallelsim right. if you create seperate class for this 3 and call there methods by creating
//3 seperate objects if you call there method it is also following the single threaded program.