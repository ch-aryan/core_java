package com.javabasics;
class An{
     public  static int x = 10;
     public int b = 20;
    public static void meth(){//private member of the class will not get inherited.
        An.x = 111;
        System.out.println(x);


    }
    public  void methSt(int x){

        System.out.println(x);
        System.out.println(An.x);

    }
}
class Bn extends An {


    public static void meth(){
        System.out.println("this gives diff");

    }
    public void methSt(int x){

        System.out.println("Hello world");
        System.out.println("this is aryan");
    }

    public void methSpecial(){
        System.out.println("how will you call the specialized methods");
    }
}
public class InheritanceRevision {
    public static void main(String[] args) {
        An obj = new Bn();//up casting
//        obj.meth();
//        obj.x = 122;
//        obj.meth();
//        Bn.methSt(133);
//        Bn.meth();
//        An.meth();
        obj.methSt(1);
        obj.meth();//not recommended to call the static methods like this.
        ( (Bn) obj).methSpecial();// downcasting

    }
}
/*
}  we cannot initialize the value for the static data
member in the static method right..
why i can't call the static variable in the static method using the this keyword to diff the calling for
parameter and the instance static var.

🔹 1. Your assumption: “we cannot initialize static variable in static method”

That’s not correct. You absolutely can.

static int x;

static void methSt() {
    x = 50;  // ✅ perfectly valid
}

Static methods can access static variables directly because both belong to the class, not to any object.

🔹 2. The real issue in your code

This line is the problem:

System.out.println(this.x);  // ❌ ERROR
❗ Why this fails:
this refers to the current object (instance)
But a static method does not belong to any object
So there is no this available

👉 That’s why Java gives an error:

"non-static variable this cannot be referenced from a static context"

🔹 3. How to access static variable inside static method

You should use:

System.out.println(x);        // ✅ direct access
System.out.println(An.x);    // ✅ class name (best practice)

So your fixed method:

public static void methSt(int x){
    System.out.println(An.x); // static variable
    System.out.println(x);    // parameter
}
🔹 4. Your doubt: “How to differentiate parameter x and class x?”

Great thinking—that’s exactly why you're trying this.

But since this won’t work, use class name:

public static void methSt(int x){
    System.out.println(An.x); // class variable
    System.out.println(x);    // method parameter
}
🔹 5. Why this.x works in non-static method?

In your non-static method:

public int meth(){
    this.x = 25;  // ✅ works (but not recommended)
}

Why it works:

meth() is called using an object → so this exists
Java allows accessing static variables via object (though not recommended)

👉 Better way:

x = 25;       // or An.x = 25;
🔹 6. Key Rule (Very Important 🔥)
Context	Can use this?	Can access static variable?
Static method	❌ No	✅ Yes
Non-static	✅ Yes	✅ Yes
🔥 Final intuition (remember this)
static → belongs to class
this → belongs to object
No object → no this
 */