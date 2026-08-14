package com.javabasics;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringMethods {
    public static void main(String[] args) {
        String s = "aryan";
        char [] arr = s.toCharArray();
        for(char i : arr){
            System.out.println(i);
        }
        String a = new String(arr);
        System.out.println(a);
        StringBuilder he = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.clear();
    }
}
