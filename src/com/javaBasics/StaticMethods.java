package com.javabasics;
class StaticMeth{
    static int a ;
    int b;
    public void meth( int c){
        this.a =a+ c;
       b++;
        System.out.println(a+"a");
        System.out.println(b);
    }

    public static void meth1(int d){

        System.out.println();
    }


}
public class StaticMethods {
    public static void main(String[] args) {
        StaticMeth obj = new StaticMeth();
        obj.meth(2);

        StaticMeth obj1 = new StaticMeth();
        obj1.meth(23);

        StaticMeth obj2 = new StaticMeth();
        obj2.meth(12);
    }
}
