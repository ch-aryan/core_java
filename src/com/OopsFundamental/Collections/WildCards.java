package com.OopsFundamental.Collections;

import java.util.ArrayList;
import java.util.List;

class Human1<T>{
    public  int a =1;
    public String s = "Aryan";


    public void disp(){
        System.out.println("Humans are awesome");
    }
}
class Students1<T> extends Human1<String>{

}
class Employee1{

}
public class WildCards {
    public static void main(String[] args) {
//     Object obj = new Object();
//     String str = new String("Aryan");
        //  obj =str;//allowed
        //   str = obj//not allowed

        Human1<Integer> h = new Human1<>();
        Students1<String> s = new Students1<>();
        //   h = s;//not allowed
        //  s  = h; not allowed

        ArrayList<Human1> obj = new ArrayList<>();
        obj.add(new Human1());
        obj.add(new Human1());
        obj.add(new Human1());
        invokeDisp(obj);

        Human1<?> hw = new Human1<>();
        Students1<String> ss = new Students1<>();
        hw = ss; //allowed wild card..
        //  ss = hw //not allowed

        Human1<? extends Human1> hh1 = new Human1<>();
        Students1<Character> ss2 = new Students1<>();
        //  hh1 = ss2; not allowed.
    }
public static void invokeDisp(List<? extends Human1> list){

        for(Human1 h : list){

            System.out.println(h);
        }
        }


    }

