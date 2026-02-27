package com.OopsFundamental;



class LaunchStatic2{
    static int count ;
    int name , roll ;
    {
        count++;
    }
    LaunchStatic2(){
        System.out.println("zero pram");
    }
    LaunchStatic2(int name , int roll){
        this.name = name;
        this.roll = roll;
        System.out.println(name + " parameter constr"+ roll);
    }

        }
class LaunchStatic1{
    public static int a = 1;
    int x,y,z =0;
    int b =2;
    static{
        System.out.println("hello world from the LaunchStatic");
        a=2;
        System.out.println(a);
    }
    {
        System.out.println("java init");
        x =1; y =2 ; z = 3;
        System.out.println(x+y+z+" ");
    }
    public LaunchStatic1(){
        System.out.println("This is param constructor");
    }
    public static int callStatic(int c, int d){
        a = 6;
        System.out.println(a);
        int e = c;
        int f = d;
        return e + f;
    }
    public int callNonStatic(int c, int d){
        int ee = c;
        int ff = d;
        return ee + ff;
    }
}


public class StaticKeyword {
    static {
        System.out.println("hello world");
    }
    public static void main(String[] args) {
//    LaunchStatic1 obj = new LaunchStatic1();
//
//        System.out.println("********************888");
////    int res = LaunchStatic1.callStatic(2,4);
////        System.out.println(res);
////        System.out.println(  obj.callNonStatic(3,5));
////
////        LaunchStatic1 obj2 = new LaunchStatic1();
////        obj2.callNonStatic(3,8);
////        obj2.callStatic(3,5);
//        LaunchStatic1.callStatic(3,5);

        LaunchStatic2 obj = new LaunchStatic2();
        System.out.println(LaunchStatic2.count);


        LaunchStatic2 obj2 = new LaunchStatic2();
        System.out.println(LaunchStatic2.count);

        LaunchStatic2 obj3 = new LaunchStatic2();
        System.out.println(LaunchStatic2.count);

        LaunchStatic2 obj4 = new LaunchStatic2();
        System.out.println(LaunchStatic2.count);

        LaunchStatic2 obj5 = new LaunchStatic2(3,9);
        System.out.println(LaunchStatic2.count);

    }
}
