package com.javaBasics;

public class TernaryOperator {
    public static void main(String[] args) {
        int a =10, b= 20;
//        System.out.println(a>b?a:b);
        int c = 40 , d = 50;

        int result = (a>b) ? (b < c ? a:b):(d>a ? c:b);
        System.out.println(result);
    }
}
