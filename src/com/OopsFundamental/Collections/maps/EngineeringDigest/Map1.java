package com.OopsFundamental.Collections.maps.EngineeringDigest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Aryan");
        map.put(2,"Vani");
        map.put(3, "Bhavana");
        map.put(4, "Anil kumar");

        System.out.println(  map.get(3));
        System.out.println(map.containsValue("Aryan"));//true //ARYAN -> false.

        for(int i : map.keySet()){
            System.out.println(i);
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
    for(Map.Entry<Integer, String> i : entries){
        System.out.println(i.getValue() + " " + i .getKey());
    }

        for (Map.Entry<Integer, String> iter : map.entrySet()) {
            System.out.println(iter.setValue("Chilkeshwaram").toUpperCase());
        }

        for(Map.Entry<Integer, String> i : entries){
            System.out.println(i.getValue() + " " + i .getKey());
        }

    }
}
