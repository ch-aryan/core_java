package com.OopsFundamental.Collections;

import java.util.ArrayDeque;

public class ArrayDeques {
    public static void main(String[] args) {
        ArrayDeque obj = new ArrayDeque();
       // obj.add(1,4);//not possible in this
        obj.add(1);
    obj.addFirst(3);
    obj.addLast(4);
        System.out.println(obj);
        System.out.println("****************");

        ArrayDeque ad = new ArrayDeque();
        ad.addAll(obj);
        ad.addFirst(12);
        ad.add(55);
        System.out.println(ad);

    }
}
