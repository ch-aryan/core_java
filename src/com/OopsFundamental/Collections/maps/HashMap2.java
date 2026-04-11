package com.OopsFundamental.Collections.maps;

import java.util.HashMap;

public class HashMap2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(1,1);// override
        map.put(2,1);//
        map.put(3,1);//
        map.put(4,1);
        map.put(1,5);
        map.put(2,6);
        map.put(3,3);
//        map.containsKey(arr[i]);
        System.out.println(map);
        boolean b = map.containsKey(3);
        boolean ab = !map.containsKey(2);
        System.out.println(ab);
        System.out.println(b);
    }
}
