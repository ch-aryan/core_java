package com.javabasics;
class A{

    {
        System.out.println("this is init");
    }
    public A(){

        System.out.println("A constructor");
    }
    public A(int a){
      this(2,3);
        System.out.println(a+"a parametre constructor");
    }
    public A(int a, int b){
        this();
        System.out.println("A construcotor with 2 para");
    }
    public void meth(){
        System.out.println("A class");
    }
}
class B extends A{
    public B(){
        //automatically by default B constructor.
        System.out.println("B constructor");
    }
    public B(int b){
   super(b);

        System.out.println(b+"b parameter con");
    }
    public void meth(){
        //parent class.
        System.out.println("B class");
    }

    public void methBOnly(){
        System.out.println("B class specialized");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {

   new A(3,4);//annonomous object.

        A obj = new B();

    }
}
