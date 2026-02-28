package com.OopsFundamental;
class Parent{
    int i;
    public Parent(){
        System.out.println("Hello world from parent");
    }
    public Parent(int i){
        this.i = i;
        int h = i;
        System.out.println(h+" "+ i+ "this is parent para");
    }
}
class Child extends Parent{
    int a ;
    public Child(){
this(8);
        System.out.println("this is child");
    }
    public Child(int c){
//        super(7);
//     this();
        a = c;
        System.out.println(a+"from child parameter");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Parent obj = new Child();

    }
}
