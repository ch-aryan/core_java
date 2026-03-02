package com.OopsFundamental;
class H{
    public void mee(){
        System.out.println("This is parent ");
    }
}
class N extends H{
    public void mee(){
       super.mee();
        System.out.println("This is child");
    }
}
public class InheritanceWithoutStatic {
    public static void main(String[] args) {
        H obj = new H();
        obj.mee();

        N obj1 = new N();
        obj1.mee();

        System.out.println("*********");

        H obj2 = new N();
        obj2.mee();
        ((H)obj2).mee();
    }
}
