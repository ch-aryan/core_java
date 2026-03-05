package com.OopsFundamental.Exceptions;

public class RunTimeError {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("print");
        Thread.sleep(5000);
        System.out.println("after thread print");
    }
}
