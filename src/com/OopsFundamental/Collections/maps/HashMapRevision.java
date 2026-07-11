package com.OopsFundamental.Collections.maps;

import java.util.*;
//the relation of the entry and map is something like this.
interface  k{
    interface b{
        public static void disp(){
            System.out.println("entry is the child interface of map interface like this.");
            System.out.println("so to access the entry data we need to do map.entry right.");
        }
    }
}

class Tel{
    private String name;
    private Integer id;

    public Tel(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class HashMapRevision {
    public static void main(String[] args) {
        HashMap hs = new HashMap();
        Tel obj = new Tel("Aryan", 1);
        hs.put(1,10);
        hs.put(2,10);
        hs.put(obj, "value coudl be anythig right");
        hs.put("String", 1);
        System.out.println(hs);
        System.out.println("**************** hashMap stage 2 starts.");

        HashMap<Integer, String > map = new HashMap<>();
        map.put(1,"arayan");
        map.put(2,"hello");
        map.put(3,"ithas");
        map.put(4, "hello");
        System.out.println(map);
        String string = map.get(3);//accessing only elements
        System.out.println(string);

        Collection<String> values = map.values();
        Iterator<String> iterator = values.iterator();
        System.out.println("this are all the values okay.");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("******");
        System.out.println("and this are the keys");
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator1 = integers.iterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
        System.out.println("************");
        System.out.println("and this are the both key and maps");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next()+" ");
        }



    }
}
/*
One odd Occuring
Difficulty: BasicAccuracy: 50.53%Submissions: 97K+Points: 1
Given an array of arr[] positive integers where all numbers occur even number
 of times except one number which occurs odd number of times. Return that number.
Examples:
Input:arr[] = [1, 2, 3, 2, 3, 1, 3]
Output: 3
Explaination: 3 occurs three times.
Input:arr[] = [5, 7, 2, 7, 5, 2, 5]
Output: 5
Explaination: 5 occurs three times.
class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0){
                return entry.getKey();
            }
        }
        return -1;

    }
    sout
}
 */