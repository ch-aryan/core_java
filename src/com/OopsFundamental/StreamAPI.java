package com.OopsFundamental;

import java.util.ArrayList;
import java.util.List;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        for(Integer i: a){
            System.out.print(i+" ");
        }
        System.out.println();

      a.forEach(i -> System.out.println(i));
    }
}
