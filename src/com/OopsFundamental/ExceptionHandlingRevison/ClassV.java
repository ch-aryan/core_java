package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

class Alpha1 {
    public void meth1() throws Exception {

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

class Beta1 {
    public void dispBeta() throws Exception {
        System.out.println("Beta connection estabhished");
        Alpha1 a = new Alpha1();
        a.meth1();
        System.out.println("Beta connection terminated");
    }

}

public class ClassV {
    public static void main(String[] args) {
        System.out.println("Main connection established");
        Beta1 obj = new Beta1();
        try {
            obj.dispBeta();
        } catch (Exception e) {
            System.out.println("exception occured.");
        }
        System.out.println("Main connection terminated");
    }

}