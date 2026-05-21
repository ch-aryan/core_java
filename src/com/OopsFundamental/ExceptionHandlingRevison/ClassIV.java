package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

class Alpha{
    public void meth1(){
        System.out.println("Alpha connection Established");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numerator");
        int n = in.nextInt();
        System.out.println("enter denominator");
        int d = in.nextInt();
        int res = n / d;
        System.out.println(res);
        System.out.println("Alpha connection Terminated");
    }
}
class Beta{
    public void dispBeta(){
        System.out.println("Beta connection estabhished");
        Alpha a = new Alpha();
        a.meth1();
        System.out.println("Beta connection terminated");
    }

}
public class ClassIV {
    public static void main(String[] args) {
        System.out.println("Main connection established");
        Beta obj = new Beta();
        obj.dispBeta();
        System.out.println("Main connection terminated");
    }

}
