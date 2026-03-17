package com.javabasics;



public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println(result);

        }
//        catch(ArithmeticException e){
//            System.out.println("Exception handled by main ");
//            }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("is there any chance to print this exception");
        }
        finally {
            System.out.println(" finally block will be executed no matter what,");
        }
        System.out.println("Will it print yes it will");

    }
}
