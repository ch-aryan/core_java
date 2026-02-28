package com.OopsFundamental;
class Z{
    void maa(){
        System.out.println("this is parent");
    }

    void paa(){
        System.out.println("this is parent paa");
    }

}
class Y extends Z{
    void paa(){
        super.paa();
        System.out.println("this is child paa");
    }
    void raa(){
        System.out.println("this is child raa");
    }

}
public class InheritanceBasics {
    public static void main(String[] args) {
        Z obj = new Y();
        obj.maa();
        obj.paa();
        ((Y)obj).raa();
    }
}
