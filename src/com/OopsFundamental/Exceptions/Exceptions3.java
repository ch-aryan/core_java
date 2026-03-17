package com.OopsFundamental.Exceptions;

import java.util.Scanner;

class Alpha{
    public void calC() {
        try {
            System.out.println("alpha connection established");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the number for numerator ");
            int n = in.nextInt();
            System.out.println("enter the number for denominator");
            int d = in.nextInt();
            int result = n / d;
            System.out.println(result);

        } catch (Exception e) { //we can make ArithemeticException e also
            System.out.println("kindly enter non-zero number");
        }
        System.out.println("connection terminated");
    }
}
class Beta {
    public void disp(){
        System.out.println("Beta conneciton established");
        Alpha obj = new Alpha();
        obj.calC();
        System.out.println("Beta connection terminated");
    }
}
public class Exceptions3 {
    public static void main(String[] args) {
        System.out.println("Main connection started");
        Beta obj = new Beta();
        obj.disp();
        System.out.println("main connection terminated");
    }
}
//handling the exception using try catch