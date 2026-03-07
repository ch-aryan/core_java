package com.OopsFundamental.Collections;

import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(12);
        ll.add("String");
        ll.addLast(100);
        ll.addFirst("art");
        System.out.println(ll.contains("art"));
        System.out.println(ll);
        System.out.println("****");
        ll.peek();
        System.out.println(ll);
        ll.poll();
        System.out.println(ll);
//follows double linked list.
    }
}
