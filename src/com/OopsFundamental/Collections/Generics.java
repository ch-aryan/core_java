package com.OopsFundamental.Collections;

import java.util.ArrayList;

class Human<T>{
   public  int a =1;
    public String s = "Aryan";
}
class Students<T> extends Human<String>{

}
class Employee{

}
public class Generics {
    public static void main(String[] args) {
//        Human<String> obj = new Human<>();
//        Students<Integer> obj1 = new Students<>();
//
//         Integer num = (Integer)obj1.a;
//        System.out.println(num);
//      String in = (String)obj1.s;
//        System.out.println(in);

        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
       // al.add(3.5);//error because of generics.
    }
}
