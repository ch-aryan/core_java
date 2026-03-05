package com.OopsFundamental.Exceptions;

import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {
        try {
            System.out.println("Connection Started");

            Scanner inp = new Scanner(System.in);
            System.out.println("Enter a number to divide 10  ");// for this we can write try and catch separately.
            int a = 10, b = inp.nextInt();
            int result = a/b;
            System.out.println(result);
            System.out.println("Enter size of the arryay");// and for this we can write try and catch seperately
            int size = inp.nextInt();
            int[] arr = new int[size];
            int pos;
            int elmt;
            for (int i = 0; i < size; i++) {
                System.out.println("Enter element to be inserted");
                elmt = inp.nextInt();
                System.out.println("Enter position you want to insert at");
                pos = inp.nextInt();


                arr[pos] = elmt;


            }

            for (int z : arr) {
                System.out.println(z);
            }
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception occured");
        } catch(NegativeArraySizeException e){
            System.out.println("array could be negative");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("array index out of bounds.");
        }
        catch (Exception e) {//to know what exception is actually occuring try to catch them all by writing right exceptions.
            System.out.println("some problem ");
        }
        System.out.println("Connection Terminated");
    }
}//single try block can have multiple catch blocks no doubt in that.
//and always try to write the generic exception at the end. means Exception e.
//generic means parent of the all exceptions.
//we can try catch try catch if there is a diff diff type methods.