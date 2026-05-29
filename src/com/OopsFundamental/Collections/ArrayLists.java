package com.OopsFundamental.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        System.out.println(al1.getClass().getName());

        al1.add(2);
        al1.add(3.5);
        al1.add("bhavana");
        al.add(al1);//this will add the element in the rare end means back.
        System.out.println(al1);
        System.out.println(al);

//        al.indexOf(al.size() != );

        List<String> list = Arrays.asList("friday", "saturday", "sunday");
//        list.add("hello");
//        System.out.println(list);run time error.
      //  list.remove(1);
        list.set(1,"monday");
        System.out.println(list);//can do modification but no add, and removal.
        System.out.println(list.getClass().getName());

        String [] arr = new String[] {"apple", "banana", "mango"};
        List<String> list1 = Arrays.asList(arr); //here also we can set but can't add, remove. to do so with array
        //create the orignal arraylist.
        System.out.println(list1);

        ArrayList<String > listArr = new ArrayList<>(list1);//we can give capacity or a collection diretly.
        listArr.add("pomogrante");
        System.out.println(listArr);


        List<Integer> integers = List.of(1, 2, 3, 4);//constant means no set will work , add and remove. unmodifaicaiton.
        System.out.println(integers);
        System.out.println(integers.getClass().getName());

        //to access the elements in the arraylist we use. get.
        String string = listArr.get(3);
        System.out.println(string);

        //to remove we use. remove.


        //see one thing here. very awesome one.
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        //if we do remove a.remove(1) it will remove the index right.
        System.out.println(a);
//        a.remove(1); it will remove the index.
        System.out.println(a);
        //to remove the element of 1 is stored we use wrapper classes/
        a.remove(Integer.valueOf(1));
        System.out.println(a);

        ArrayList fruits = new ArrayList();
        fruits.add("pple");
        fruits.add("ban");
        fruits.add("drageon");
        fruits.add("gauva");

        Iterator iterator = fruits.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        System.out.println(fruits);
        fruits.remove("ban");
        System.out.println(fruits);

        // to convert list to array.
        Object[] array = fruits.toArray();

        for(Object aryan : array){
            System.out.println(aryan);
        }

    }
}
