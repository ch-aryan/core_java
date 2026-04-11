package com.OopsFundamental.Collections;

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(1.2);
        al.add(1, 3);//this will be inserted but inefficeint right.
        al.add("Aryan");
        al.add(true);
        System.out.println(al);
        System.out.println("************");
        ArrayList al1 = new ArrayList();

        al1.add(2);
        al1.add(3.5);
        al1.add("bhavana");
        al.add(al1);//this will add the element in the rare end means back.
        System.out.println(al1);
        System.out.println(al);

//        al.indexOf(al.size() != );

    }
}
