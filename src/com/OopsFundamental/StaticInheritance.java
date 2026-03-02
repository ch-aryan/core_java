package com.OopsFundamental;
class Inherit1{
    static int a = 10;
    public static void inheritMeth(){
        System.out.println("this parend class");
    }
    public void nonStatic(){
        System.out.println("this is parent no static met");
    }

}
class Inherit2 extends Inherit1{
    public static void inheritMeth(){
//        super.nonStatic(); this is not allowed becuase it is static method.
        System.out.println("this is child class");
    }
    public  void nonStatic(){
        super.nonStatic();
        System.out.println("this is child no static meth");
    }
}

public class StaticInheritance {
    public static void main(String[] args) {

        Inherit1 obj = new Inherit1();
        Inherit1.inheritMeth();
        obj.nonStatic();
        System.out.println("************8");

        Inherit2 obj1 = new Inherit2();
        Inherit2.inheritMeth();
        obj1.inheritMeth();
        obj1.nonStatic();
        System.out.println("***************");

        Inherit1 obj2 = new Inherit2();
        Inherit2.inheritMeth();
        obj2.inheritMeth();
//        Inherit1.inheritMeth();
    }
}
