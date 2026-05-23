package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;
import java.util.List;

class Human{
    public String name;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }

    Human(String name){
        this.name = name;
    }
    void getMeth(){
        System.out.println(name);
    }
}
class student extends Human{
    student(){
        super("Aryan");
    }
}
class Employee{

}
public class WildCardsGenerics {
    public static void main(String[] args) {
//       Object obj = new Object();
//       String str = new String("original");
//       obj = str;
//        System.out.println(obj);
////        str = (String) obj; downcasting is possible or ce .
//
//        Human h = new Human("Hello world");
//        h.getMeth();
//        student s  = new student();
//        s.getMeth();
//        System.out.println("**********");
//        Human hs = new student();
//        hs.getMeth();
//        System.out.println("**********");
//
//        Human h1 = new Human("HE");
//        student s1 = new student();
//        h1 = s1;//allowed.
//      //  s1 = (student) h1;///not allowed downcasting or ce.
//
//        ArrayList<Human> alH = new ArrayList<>();
//        ArrayList<student> alS = new ArrayList<>();
//      //  alH = alS;//even parent type relationship it is not allowed.
//      //  alS = alH if upper is not allowed then it will also not right.
//
//        ArrayList<?> alH1 = new ArrayList<>();//unknown or wildcard type. ?
//        ArrayList<student> alS1 = new ArrayList<>();
//        ArrayList<Employee> ale1 = new ArrayList<>();
//
//        alH1 = alS1;//now this is alllowed.
//        alH1 = ale1;//did know about it till now .
//
//
//        ArrayList<? extends Human> alH2 = new ArrayList<>();//unknown or wildcard type. ?either it should
//        //be of human type Humans or child of humans(examp9le students extending human). this is called
//        //UPPER BOUND.
//        ArrayList<student> alS2 = new ArrayList<>();
//        ArrayList<Employee> alE2 = new ArrayList<>();
//        ArrayList<Object> alO1 = new ArrayList<>();
//        alH2 = alS2;//now this is alllowed.
//        //alH2 = alE2;//not allowed
//       // alH2 = alO1; not allowed even though it is the parent of the of classes it is not allowed.
//
//        System.out.println("*********");
//        ArrayList<? super Human> alH3 = new ArrayList<>();
//        //now this is lower bound either human or parent of human .
//        ArrayList<student> alS3 = new ArrayList<>();
////        alH3 = alS3; not allowed.
//        alH3 = alO1; //..alloewd.
//       // alH3 = alE2//not alloed;

        ArrayList<Human > hlist = new ArrayList<>();
        hlist.add(new Human("hello"));
        hlist.add(new Human("world"));
        invokeDisP(hlist);//allowed

        ArrayList<student> slist = new ArrayList<>();
        slist.add(new student());
        slist.add(new student());
        invokeDisP(slist);//allowed.


    }
    public static void invokeDisP(List<? extends Human> list){//upperbound.
        for(Human h: list){
            System.out.println(h.toString());
        }
    }
    //public static void invokeDisP(List< Human> list){//it will be error for slist.
}
