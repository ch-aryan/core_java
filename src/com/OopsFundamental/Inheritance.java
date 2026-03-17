package com.OopsFundamental;
class Parent{
    int i = 8;
    public Parent(){
        System.out.println("Hello world from parent + default paremeter 1st statement to be executed");
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
//if there is a call b/w parent class constructor from child constructor and in child class we have
        //java initialization block then remember it will first execute the parent type constructor
        //then java initilization block and then child constructors.
        i = 10;
        System.out.println("When it will execute before constructor? after static ?" +
                "or when? let see");//valid java initilization block it is if you know.
    }

    public Child(){
        //always remember constructor don't participate in inheritance due to always having super()
        //method by default.
    this(8); //calling the constructor of same class .
    super.i = 9;//valid parent field or attributes or properties.
        i =10;//valid child only

        System.out.println("this is child");
    }
    public Child(int c){
      // super(7);//calling the parent class constructor with parameter right.
        //here we already have a super() method present if you remember.
//     this(); compile time error loop will run.
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
        System.out.println("**********");
        Child obj1 = new Child();

    }
}
/* Initialization block executes AFTER parent constructor
BUT BEFORE child constructor body

So flow when:

Parent obj = new Child();

Actual execution:

Parent default constructor
Child initialization block
Child(int) constructor
Child() constructor remaining body */