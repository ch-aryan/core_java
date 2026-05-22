package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

public class IXTryCatTryCat {
    public static void main(String[] args) {

        try{
            System.out.println("Main method Started");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a range of num");
            int n = in.nextInt();
            String s = null;
            System.out.println(s.length());
            System.out.println("Enter deno ");
                int d = in.nextInt();
                int res = n/d;
                System.out.println("res");
                try{
                    System.out.println("Enter an array size");
                    int len = in.nextInt();
                    int [] arr = new int[len];
                    System.out.println("Enter an element to inserted");
                    int elm = in.nextInt();
                    System.out.println("Enter an index to insert at");
                    int ind = in.nextInt();
                    arr[ind] = elm;
                }catch (IndexOutOfBoundsException e){
                    System.out.println("inner catch is working");
                }catch (NegativeArraySizeException e){
                    System.out.println("this is also in inner catch");
                }

        }catch (ArithmeticException e){
            System.out.println("outer catch exception");
        } finally {
            System.out.println("this will exectue no problme what may be the exception is");
        }
        System.out.println("main method is terminated successfully");
    }
}
