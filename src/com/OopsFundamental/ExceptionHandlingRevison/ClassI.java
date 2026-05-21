package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

public class ClassI {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter numerator");
            int n = in.nextInt();
            System.out.println("enter denominator");
            int d = in.nextInt();
            int res = n / d;
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Exception got occured");
        }
        System.out.println("After catching the exception will it execute lets see");
        System.out.println("yes it will . lets check if no exception is occured will it execute");
        System.out.println("yes it will execute no matter if exception occured or not when handling " +
                "the exception by catch block it will execute great!~");
    }
}
