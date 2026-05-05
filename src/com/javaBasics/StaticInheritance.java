package com.javabasics;
class Parent{
    public static void disp(){
        System.out.println("parent static");
    }

    public void meth1(){
        System.out.println("parent meth");
    }
}
class Child extends Parent{
    public static void disp(){//it is specialized

        System.out.println("child static");
    }

    public void meth1(){
        System.out.println("child meth");
    }
}

public class StaticInheritance {
    public static void main(String[] args) {
        Parent obj = new Child();
//        obj.disp();//it is
//        Parent.disp();

        obj.meth1();
    }
}
