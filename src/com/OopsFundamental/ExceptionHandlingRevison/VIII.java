package com.OopsFundamental.ExceptionHandlingRevison;

public class VIII {
    public static void main(String[] args)  {
        System.out.println("main mthod started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main method terminated");

    }
}
