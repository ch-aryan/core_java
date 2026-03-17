package com.OopsFundamental;
class Parent1{
    public void meth(){
        System.out.println("this is parent");
    }
    public int methPC(int a){
        System.out.println("acting like parent method fine");
        return 0;

    }
}
class Child1 extends Parent1{
    //overriding parent class method to suite child requirement
    public void meth(){
        super.meth();
        System.out.println("this is child");
    }
    public void specialized(){
        System.out.println("can you access this with parent refference");
    }
    public int methPC(){
        System.out.println("this is acting as a specialized method");
        return 1;
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Child1 obj = new Child1();
        obj.meth();
        obj.specialized();
        System.out.println("*****************");
        Parent1 obj1 = new Child1();// this is upcasting. parent type ref child object.
        obj1.meth();
        obj1.methPC(8);//this is overridden method.
        ((Child1)obj1).methPC();//this is a specialized method that's why i need to downcast.
       ((Child1)obj1).specialized();
        System.out.println("yes with the help of downcasting.");

        System.out.println("********************");


    }
}
