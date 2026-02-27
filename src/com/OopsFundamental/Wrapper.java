package com.OopsFundamental;

import java.util.ArrayList;

public class Wrapper {
    public static void main(String[] args) {
        int a = 10;
      Integer b = Integer.valueOf(10);
        System.out.println(a+b);

        int c = 20;
        Integer d = Integer.valueOf(c);//boxing
        Integer e = c; //autoboxing.

        Integer f = Integer.valueOf(30);
        int g = f.intValue();//unboxing
        int h = f;// auto-Unboxing.

        //here the example of auto boxing.
        ArrayList<Integer> z = new ArrayList<>();
        z.add(10); //conveting primitve to object type.

    }
}
