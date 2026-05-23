package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Revision {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
       for(int i = 0; i<5;i++){
           al.add(i,i+1);
       }
        System.out.println(al);
       for(int i = 0;i<al.size();i++){
           System.out.print(al.get(i)+" ");
       //    al.add(1);//this is dangerous concurrent modification
       }
        System.out.println(" ");
       for(Object ob : al){
           System.out.print(ob+" ");
       }

        Iterator<Integer> iterator = al.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }
       //what happens in case of iterator.
        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(al.get(3));
            System.out.println(itr.next()+" hello");
        //  al.add(12);
        }
        System.out.printf("********************");
        CopyOnWriteArrayList arrL = new CopyOnWriteArrayList();
        for(int i =5; i<=10;i++){
            arrL.add(i);
        }
        Iterator iterator1 = arrL.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
            arrL.add(111);//fail safe.
        }
        System.out.println("***********");
        ListIterator listIterator = arrL.listIterator(arrL.size());
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
