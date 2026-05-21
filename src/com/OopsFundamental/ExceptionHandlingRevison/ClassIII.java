package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

public class ClassIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Connection start");
            System.out.println("Enter numerator");
            int n = in.nextInt();
            System.out.println("enter denominator");
            int d = in.nextInt();
            int res = n / d;
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index out of bound");
        }
        try{
            System.out.println("Enter the array size");
            int size = in.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elemnt to be inserted");
            int elemt = in.nextInt();
            System.out.println("Enter the index at the element should be inserted");
            int index = in.nextInt();
            arr[index] = elemt;
            System.out.println("the element you inserted in the index " + index + arr[index]);
        }
        catch (ArithmeticException e){
            System.out.println("denominator is zero");
        }catch (NegativeArraySizeException e){
            System.out.printf("array size is negative");
        }
        catch (Exception e){
            System.out.println("an exception occured . someproblem");
        }
        System.out.println("Connection terminated");
    }
}
//here do need to worry the generic catch block will work for all the try blocks.