package com.OopsFundamental.Collections.maps;

import java.util.HashMap;
class Tell{
    String o ;
    int c ;

    public void setO(String o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "Tell{" +
                "o='" + o + '\'' +
                ", c=" + c +
                '}';
    }

    public Tell(String o, int c) {
        this.o = o;
        this.c = c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public String getO() {
        return o;
    }
}

public class HashMaps1 {
    public static void main(String[] args) {
        HashMap obj = new HashMap();


        obj.put(0,"Namaste");
        obj.put(1,"Hello World!");
        obj.put(2, 1);
        obj.put(3,1);
        obj.put(4,'c');

        Tell obj1  = new Tell("Aryan", 14);
        HashMap HM2 = new HashMap();
        HM2.put("Aryan", "Raj");
        HM2.put(1 , obj1);
        System.out.println(HM2);


    }
}
