package com.OopsFundamental;
class A{//extends Object class bydefault if no class extends then it is there.that why we have methods.
    int a =1;
    int b =2;
    public int methA(){
        return a + b;
    }
}
class B extends A{
    int c = 3;
    int d = 4;
    public int methB(){
        return c + d;
    }
}
class C extends  A{
    int e = 5;
    int f = 6;
    public int methC(){
        return e+f;
    }
}

class D extends B{
    int g = 7;
    int h = 8;
    public int methD(){
        return g + h + c + d;
    }
}
class E extends  D{ }
public class MultilevelInheritance {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.methA());
        System.out.println("************");
        B obj1 = new B();
        System.out.println(obj1.methB());
        System.out.println("************");
        C obj2 = new C();
        System.out.println(obj2.methC());
        System.out.println("************");
        D obj3 = new D();
        System.out.println(obj3.methD());
        System.out.println("************");
        E obj4 = new E();
        System.out.println(obj4.methA());
        System.out.println(obj4.methB());
        System.out.println(obj4.methD());
        System.out.println("************");
        A obj5 = new E();
        System.out.println(obj5.methA());
        System.out.println(((E)obj5).methB());//downcasting to e class we can also cast to b class aslo
        System.out.println(((D)obj5).methD());//downcasting to d class
        System.out.println("************");
    }
}
