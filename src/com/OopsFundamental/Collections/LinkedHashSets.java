package com.OopsFundamental.Collections;

import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {
        LinkedHashSet obj = new LinkedHashSet();
        obj.add(1);
        obj.add(2);//follow order of insertion hashing algo is used behing the scene.
        obj.add(2);
        obj.add(3);
        System.out.println(obj);
    }
}
