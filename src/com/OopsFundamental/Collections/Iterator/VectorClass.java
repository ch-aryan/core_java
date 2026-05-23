package com.OopsFundamental.Collections.Iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorClass {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(12);
        v.add(124);
        v.add(121);
        v.add(1);
        System.out.println(v);//order of insertion is allowed in this. it implements the list interface.

        Iterator iterator = v.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("*********");

        Enumeration elements = v.elements();
        while(elements.hasMoreElements()){
            System.out.print(elements.nextElement()+" ");
        }


    }
}
