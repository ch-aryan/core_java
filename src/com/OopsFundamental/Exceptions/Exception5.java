package com.OopsFundamental.Exceptions;

import java.util.Scanner;

class Alpha2{
    public void calC()  throws ArithmeticException {
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
            throw e;//rethrowing manually to jvm compiler.
        }
        finally {
            System.out.println("connected Terminated");
        }
//        System.out.println("connection terminated");//to execute this line write finally block
    }
}
//class Beta {
//    public void disp(){
//        System.out.println("Beta conneciton established");
//        Alpha obj = new Alpha();
//        obj.calC();
//        System.out.println("Beta connection terminated");
//    }
//}
public class Exception5 {
    public static void main(String[] args) {
        System.out.println("Main connection started");
       Alpha2 obj = new Alpha2();
       obj.calC();//it must handle the exception or else it will be lead to a abnormal termination
        System.out.println("main connection terminated");
    }
}

