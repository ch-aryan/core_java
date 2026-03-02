package com.OopsFundamental;
class Object1{
    public int meth(){
        System.out.println("parent meth");
        return 1;
    }
}
class Object2 extends Object1{
    public int meth(){
        System.out.println("child meth overrideen");
       return  2;
    }
//    int meth(){
//        System.out.println("without accessmodifier");cannot override due to decreasing visibilty
//    }
//    public int meth(){
//        System.out.println("cannot overrideen once overriden in the same class ");
//        return 1;
//    }

}
class obj9 extends Object1{
//    public String meth(){
//        System.out.println("cannot change the return type while override");
//    }

}
class Obj3{
    public  Object1 method(){
        Object1 obj = new Object1();
        return obj;
    }
}
class Object4 extends  Obj3{
    public Object2 method(){
        Object2 obj = new Object2();
        return obj;
    }
}
public class InheritanceParentReturnType {
    public static void main(String[] args) {
    Obj3 a = new Obj3();
        System.out.println(  a.method());
    }
}
