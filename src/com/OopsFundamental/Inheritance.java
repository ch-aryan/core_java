package com.OopsFundamental;
class Parent{
    int i = 8;
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
    int a  ;
//    i = 7; we cannot assign the here in the class body we can assign in the methods. class right
    int i;
    {
        i = 10; //valid
    }

    public Child(){
    this(8);
    super.i = 9;//valid
        i =10;//valid

        System.out.println("this is child");
    }
    public Child(int c){
//        super(7);
//     this();
        a = c;
        System.out.println(a+"from child parameter");
    }
    public void meth(){
        i = 122;//valid
        super.i = 12;//valid
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Parent obj = new Child();

    }
}
