package com.OopsFundamental.Strings;

import java.sql.SQLOutput;

public class S1 {
    public static void main(String[] args) {
        String a = "Aryan";
        String b = "Aryan";
        System.out.println(a == b);//true.
        String aa = a;
        System.out.println(aa);
        a = a.concat("raj");
        System.out.println(a);
        System.out.println(aa);
        System.out.println(a==b);

        String c = new String("ARYAN");
        String d = new String("ARYAN");
        System.out.println(c==d);//false
        System.out.println(c.equals(d));//true


    }
}
