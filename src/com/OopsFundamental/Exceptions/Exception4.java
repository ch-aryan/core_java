package com.OopsFundamental.Exceptions;

import java.util.Scanner;


class Alpha1{
    public void calC() throws ArithmeticException {
//        try {
            System.out.println("alpha connection established");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the number for numerator ");
            int n = in.nextInt();
            System.out.println("enter the number for denominator");
            int d = in.nextInt();
            int result = n / d;
            System.out.println(result);

//        } catch (Exception e) { //we can make ArithemeticException e also
//            System.out.println("kindly enter non-zero number");
//            calC();//once again call the calc method so that user can enter once again.
//        }
        System.out.println("connection terminated");
    }
}
//class Beta1 {
//    public void disp(){
//        System.out.println("Beta conneciton established");
//        Alpha obj = new Alpha();
//        obj.calC();
//        System.out.println("Beta connection terminated");
//    }
//}
public class Exception4 {
    public static void main(String[] args) {
        Alpha1 obj = new Alpha1();
        try {
            System.out.println("Main connection started");
//        Beta1 obj = new Beta1();
//        obj.disp();

            obj.calC();
        } catch (ArithmeticException e) {
            System.out.println("kindly enter the non zero ");
            obj.calC();
        }
        System.out.println("main connection terminated");
    }
}
//Ducking the exception using the throws keyword.

