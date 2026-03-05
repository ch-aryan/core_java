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
        System.out.println("That statement executes **only if the exception is handled**.\n" +
                "\n" +
                "If the exception is **not handled**, the program **terminates before reaching it**. ");
    }
}
