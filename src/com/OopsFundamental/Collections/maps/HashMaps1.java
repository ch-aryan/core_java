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

//key - value pairs.
        obj.put(0,"Namaste");
        obj.put(1,"Hello World!");
        obj.put(2, 1);
        obj.put(3,1);
        obj.put(3,1);//key must be unique it will not print no duplicates allowed in hashmap.
        obj.put(null, 0);//can be null key and same emplies to value also.
        obj.put(4,'c');
        System.out.println(obj);

        Tell obj1  = new Tell("Aryan", 14);
        HashMap HM2 = new HashMap();
        HM2.put("Aryan", "Raj");
        HM2.put(1 , obj1);
        System.out.println(HM2);

//linkedhashmap is same as hashmap. okay
        //in hashtable we cannot have value as null and key as null.
        //in treemap we can have value as null but key cannot be null.

        //remember we can have interface inside a interface (nested interfaces) & interfaces can
        //contain static method inside it althoug we know interfaces are public abstract by default.
        //& default keyword is diff used to implement the body for it.
    }
}
