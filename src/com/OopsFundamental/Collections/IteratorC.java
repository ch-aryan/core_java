package com.OopsFundamental.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorC {
    public static void main(String[] args) {

        ArrayList obj = new ArrayList();
        obj.add(234);
        obj.add(23);
        obj.add(1);
        obj.add(3);
        obj.add(33);
        System.out.println("**************");
//        Iterator itr = obj.iterator();
//         while(itr.hasNext()){
//            System.out.println(itr.next());
//            obj.add(35); //fail fast concurrent modification. // structural modification
//         }
//        ListIterator itr = obj.listIterator(obj.size());
//        while(itr.hasPrevious()){
//            System.out.println(itr.previous());
//        }
        CopyOnWriteArrayList obj1 = new CopyOnWriteArrayList();
        obj1.add(2);
        obj1.add(32);
        obj1.add(3);
        obj1.add(1);
        obj1.add(5);
        Iterator itr1=  obj1.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
            obj1.add(999);//fail safe.
        }


    }
}
