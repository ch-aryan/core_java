package com.OopsFundamental.Collections;

import java.util.ArrayList;
import java.util.List;

class ZZZ{
    public int a =1;
    public void methZ(){
        System.out.println("java is an ocean");
    }

}
class YYY extends ZZZ{

}
class WWW{

}
public class GenericsImportant {
    public static void main(String[] args) {
        ArrayList<Object> objO = new ArrayList<>();
    ArrayList<ZZZ> objZ = new ArrayList<>();
    ArrayList<YYY> objY = new ArrayList<>();
        ArrayList<WWW> objW = new ArrayList<>();
    //obj = obj1; not allowed.

//        ZZZ obj2 = new ZZZ();this is completely different.
//        YYY obj3 = new YYY();
//        obj2 = obj3;

        ArrayList<?> objZ1 = new ArrayList<>();//wildcard.
   objZ1 = objY;// allowed.
        objZ1 = objW;//allowed.
        objZ1 = objO; // allowed.
        objZ1 = objZ;//allowed.

        ArrayList<? extends ZZZ> objZ2 = new ArrayList<>();//upperbound
        objZ2 = objY;//allowed child class.
       // objZ2 = objW; not allowed.
        objZ2 = objZ ;//allowed . same class
       // objZ2 = objO not allowed

        ArrayList<? super ZZZ> objZ3 = new ArrayList<>();//lowerbound
       // objZ3 = objY; not allowed.
        objZ3 = objZ; //allowed
        //objZ3 = objW; not allowed.
        objZ3 = objO; //allowed.

        ArrayList<ZZZ> obj1 = new ArrayList<>();
        obj1.add(new ZZZ());
        obj1.add(new ZZZ());
        obj1.add(new ZZZ());
//        methInvoke(obj1); allowed

        ArrayList<YYY> obj2 = new ArrayList<>();
        obj2.add(new YYY());
        obj2.add(new YYY());
        obj2.add(new YYY());
        methInvoke(obj2);//allowed.



    }
    public static void methInvoke(List<? extends ZZZ> list){
        for(ZZZ i : list){
            System.out.println(i);
        }
    }
}
