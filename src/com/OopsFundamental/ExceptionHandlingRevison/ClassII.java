package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;

public class ClassII {
    public static void main(String[] args) {
        try {
            System.out.println("Connection start");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter numerator");
            int n = in.nextInt();
            System.out.println("enter denominator");
            int d = in.nextInt();
            int res = n / d;
            System.out.println(res);

            System.out.println("Enter the array size");
            int size = in.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elemnt to be inserted");
            int elemt = in.nextInt();
            System.out.println("Enter the index at the element should be inserted");
            int index = in.nextInt();
            arr[index] = elemt;
            System.out.println("the element you inserted in the index " + index + arr[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index out of bound");
        }catch (ArithmeticException e){
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
/*
see the problem is we having two different logics or two differnet methods right. one is additional and
another is array elements so if one is getting exception second one should be executed how> write in diff
diff try and catch blocks. let see how in class III.
 */