package com.OopsFundamental;
class Parent1{
    public void meth(){
        System.out.println("this is parent");
    }
}
class Child1 extends Parent1{
    //overriding parent class method to suite child requirement
    public void meth(){
        System.out.println("this is child");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Child1 obj = new Child1();
        obj.meth();
    }
}
