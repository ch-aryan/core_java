package com.OopsFundamental.Collections.Iterator;

import DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.Easy.Palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> obj = new ArrayList<>();
        obj.add(12);
        obj.add(33);
        obj.add(4);
        obj.add(56);
        System.out.println(obj);
        for(Integer o : obj) {
            int res = o;
            System.out.println(res * 2);
        }
        System.out.println("*****");
        Consumer<Integer> object  = new Consumer<>() {
            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        };

        obj.forEach(object);
        System.out.println("*************");
        Consumer<Integer> object1= (Integer o) -> {
            System.out.println(o+" lambda");
        };
        obj.forEach(object1);

        System.out.println("*************");

        obj.forEach((i)-> System.out.println(i+"forEach"));
        System.out.println("******why do we need this streams");
        ArrayList<Integer> obj2 = new ArrayList<>();
        obj2.add(12);
        obj2.add(33);
        obj2.add(4);
        obj2.add(56);
        obj2.add(1);
        System.out.println(obj2);
        System.out.println("before sort");
        Collections.sort(obj2);
        System.out.println(obj2);

        System.out.println("****************Stream api ***********");
        System.out.println("streams.");

        ArrayList<Integer> obj1 = new ArrayList<>();
        obj1.add(12);
        obj1.add(33);
        obj1.add(4);
        obj1.add(56);
        obj1.add(1);
        System.out.println(obj1);



        Stream<Integer> stream = obj1.stream();
        Stream<Integer> sorted = stream.sorted();
        sorted.forEach(i-> System.out.print(i+" "));
        System.out.println();
        System.out.println(obj1);

        //if you will use the used stream once again it will throw an exception
        //so it is not allowed to use the stream once it is done.

        Stream<Integer> stream1 = obj1.stream();
        Stream<Integer> sorted1 = stream1.sorted();
        //se now if i used the stream1 which is already used for sorting it will throw error.
//        Stream<Integer> mapO = stream1.map(n->2*n); it is already used.
        Stream<Integer> mapO = sorted1.map(n->2*n);//it is allowed because this are different stream right
        mapO.forEach(n-> System.out.print(n+" "));

        //for more shorter hand we can do like this.
        obj1.stream()
                .sorted()
                .map(n->2*n)
                .forEach(n-> System.out.print(n+" "+"shorter hand"));
        System.out.println("******");

        List<String> ls = new ArrayList<>();
        ls.add("aryan");
        ls.add("aaryan");
        ls.add("raj");
        System.out.println(ls);
        Stream<String> stream2 = ls.stream();
        Set<String> collect = stream2.collect(Collectors.toSet());
        collect.forEach(n-> System.out.print(n+" "));
        ls.forEach(i-> System.out.println(i));

    }
}
//we can do anything with the stream like we can convert the list type of collections into set.etc
//like anything there are lot of methods.
