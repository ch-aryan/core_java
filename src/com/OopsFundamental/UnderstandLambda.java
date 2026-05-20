package com.OopsFundamental;
class A1{
    public void meth1(){
        System.out.println("this is a class");
    }
    public void meth2(){
        System.out.println("this is meth2 a class");
    }
}
class B1 extends A1{
    public void meth1(){
        System.out.println("tis a b class");
    }
}

public class UnderstandLambda {
    public static void main(String[] args) {
        A1 obj = new A1();
        obj.meth1();

        A1 obj1 = new B1();
        obj1.meth1();

        A1 obj2 = new A1(){//annonoumous inner class
            @Override
            public void meth1() {
                System.out.println("this is inner class implementation in the main method");
            }

            @Override
            public void meth2() {
                System.out.println("this is also fine to change it here.");
            }

            public void meth3(){
                System.out.println("this is not accepeted we cannot call it .");
            }
        };
        obj2.meth1();
        obj2.meth2();
       // obj2.meth3(); it is not avaialbe.

        new B1(){//annonoums object used only once.
            public void meth1(){
                System.out.println("this is B annonoums inner class");
            }

            @Override
            public void meth2() {
                System.out.println("this is B annonoums inner class");
            }

            public void meth3(){
                System.out.println("this is perfectly fine");
            }

        }.meth3();//annonoums object used only once. and methods are also called only once.





    }
}
