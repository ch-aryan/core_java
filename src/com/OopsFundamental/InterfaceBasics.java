package com.OopsFundamental;
interface WorldWar{
    void method1();

}
class America implements WorldWar{
    public void method1(){
        System.out.println("world war will not happen");
    }
}
class One{
    void show(){
        System.out.println("hello world");
        System.out.println("this is will not make any error happen");
    }
    public static void nothingShow(){
        System.out.println("this is nothing to do with it.");
    }
}
class Two extends One{
    void noShow(){
        System.out.println("hello world");
    }
}
public class InterfaceBasics {
    public static void main(String[] args) {
        WorldWar o = new America();
        o.method1();

    }
}
