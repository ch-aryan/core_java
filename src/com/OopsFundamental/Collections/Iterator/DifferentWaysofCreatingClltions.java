package com.OopsFundamental.Collections.Iterator;

import java.util.*;
;

public class DifferentWaysofCreatingClltions {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        List<Integer> ll = new LinkedList<>();//you know that ll is implements two interfaces.
        // list and deque if we give parent type of list then it is not possbile to access the methods
        //of deque interface right. remember.
        //by using the arrays class or uitlity class of rrays also we can creaet colloections.
       List<Integer> al2 =  Arrays.asList(1,2,45);// but it is only list type of collection.



    }
    public static Iterable<Integer> meth(){
        //return new ArrayList<Integer>();//anything can be the return type.
        //return new LinkedList<>();
        return new TreeSet<>();//allowed.
    }
    public static List<Integer> meth1(){
        return new ArrayList<>();//allowed
      //  return new TreeSet<Integer>();//not allowed right.
    }
}
