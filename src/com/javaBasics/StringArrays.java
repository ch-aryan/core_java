package com.javabasics;

import java.util.Scanner;

public class StringArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the size of arr");
        int inp = in.nextInt();
        String[] so = new String[inp];
        for(int i = 0;i<so.length;i++){
            System.out.println("Enter the values to enter");
            so[i] = in.nextLine();

        }
        for(String s : so){
            System.out.println(s);
        }
    }
}
