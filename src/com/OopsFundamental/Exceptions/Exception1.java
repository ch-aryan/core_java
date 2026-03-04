package com.OopsFundamental.Exceptions;

public class Exception1 {
    public static void main(String[] args) {
        try {
            int a = 9, b = 0;
            System.out.println("running fine ok");
            int result = a / b;
            System.out.println(result);
            System.out.println("this will not execute because of exception");
        } catch (Exception e) {
            System.out.println("exception caught");
        }
        System.out.println("this is execute whether the exception occured or handled or not ");
    }
}
