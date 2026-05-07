package com.OopsFundamental;
abstract class Art1{
     int a = 1;
    public abstract void methA ();
    public abstract void methAB();
//     public Art1(){
//         System.out.println("this is main parent constructor");
//         System.out.println("abstract class constructor are involved in inheritance");
//         System.out.println("we cannot make abstract class   as abstract constructor compile te");
//     }
     public Art1(int a, int b){
         System.out.println(a +" "+ b);
     }
    public void methAC(){
        System.out.println("ABSTRACT METHOD MUST BE OVERRIEDDEN");
        System.out.println("abstraction class can abstract methods as well as methods with body/impmentation");
    }
}
class Drawing1 extends Art1{


    public Drawing1(int i){
        super(1,2);
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
 public Music1(){
        super(1,4);
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
/*
✅ Solution: Downcasting

You already hinted it correctly: downcasting.

You need to:

Check the actual object type
Cast it to Drawing1
Then call the method
🔥 Correct way (safe downcasting)

Modify your available() method like this:

void available(Art1 art) {
    art.methA();
    art.methAB();
    art.methAC();

    if (art instanceof Drawing1) {
        Drawing1 d = (Drawing1) art; // downcasting
        d.thisIsSpecialized();
    }
}
💡 What happens now?
When you pass:
Drawing1 obj = new Drawing1(8);
obj1.available(obj);

Output will include:

how should i access you: easy downcast
When you pass:
Music1 obj2 = new Music1();
obj1.available(obj2);

It will NOT call thisIsSpecialized() (correct behavior).

⚠️ Important rule (very important for interviews)

👉 Always use instanceof before downcasting
Otherwise you may get:

ClassCastException ❌
🧠 Clean Design Insight (Advanced Thinking)

If you find yourself doing this often, it means:

👉 Your design might need improvement

Instead of downcasting, you could:

Declare a method in abstract class (if applicable)
Or use interfaces / polymorphism better

But in your case, since thisIsSpecialized() is only for Drawing, downcasting is valid.
 */