package com.javabasics;

public class AddTwoFunctions {
    public static int add1(int n){
        return n;
    }

    public static int add2(int n){
        return n;
    }
    public static void main(String[] args) {
        int i = add1(3) + add2(3);
        System.out.println(i);
    }
}
