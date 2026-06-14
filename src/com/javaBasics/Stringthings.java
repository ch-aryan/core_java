package com.javabasics;

public class Stringthings {
    public static void main(String[] args) {
        String s1 = "Aryan";
        System.out.println(s1);
        StringBuilder s2 = new StringBuilder(s1);
        s2.append('I');
        System.out.println(s2);
    }
}
