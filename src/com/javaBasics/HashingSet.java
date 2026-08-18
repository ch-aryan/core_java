package com.javabasics;

import java.util.*;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println( map.get(1)+ " hello");
        ArrayList<Integer> lis = new ArrayList<>();
        System.out.println("hello world");

    }
    public List<Integer> hello(){
        return Arrays.asList(1, 2);
    }
}
