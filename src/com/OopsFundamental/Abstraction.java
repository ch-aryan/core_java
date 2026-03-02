package com.OopsFundamental;
abstract class Art1{
     int a = 1;
    public abstract void methA ();
    public abstract void methAB();
     public Art1(){
         System.out.println("this is main parent constructor");
         System.out.println("abstract class constructor are involved in inheritance");
         System.out.println("we cannot make abstract class   as abstract constructor compile te");
     }
    public void methAC(){
        System.out.println("ABSTRACT METHOD MUST BE OVERRIEDDEN");
        System.out.println("abstraction class can abstract methods as well as methods with body/impmentation");
    }
}
class Drawing1 extends Art1{


    public Drawing1(int i){
        System.out.println("this is child class construtor"+ i+ a);
    }

    public void methA(){
        System.out.println("4");
    }
    public void methAB(){
        System.out.println("5");
    }

    public void methAC(){
        super.methAC();
        System.out.println("6");
    }

    public void thisIsSpecialized(){
        System.out.println("how should i access you: easy downcast");
    }


}
class Music1 extends Art1{
    public void methA(){
        System.out.println("7");
    }
    public void methAB(){
        System.out.println("8");
    }

    public void methAC(){
        System.out.println("9");
    }
}

class Artist1{
    void available(Art1 art){//referrence type of abstract class we cannot create object .
        art.methA();
        art.methAB();
        art.methAC();

    }
}
public class Abstraction {
    public static void main(String[] args) {
        Drawing1 obj = new Drawing1(8);
        Artist1 obj1 = new Artist1();
        obj1.available(obj);
        

        System.out.println("************");

        Music1 obj2 = new Music1();
        obj1.available(obj2);
    }
}
