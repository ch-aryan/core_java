package com.javabasics;

import java.util.HashSet;

public class HashingSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.remove(1));
        System.out.println(set);
    }
}
