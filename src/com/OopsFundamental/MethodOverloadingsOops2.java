package com.OopsFundamental;
class Percent{
    int add(int x, int y){
        return x +y;
    }

    double mul(int x , double y){
        return x+y;
    }
    double mul(double x , int y){
        return x +y;
    }

    int add(int x, int y, int z){
        return x +y + z;
    }
    double add( int x, int y, double z){
        return x + y + z;
    }
    double add (int x, double y){
        return x + y;
    }
    double add (double x, double y, double z){
        return x + y + z;
    }

    double add ( double x, int y){
        return x + y;
    }





}

public class MethodOverloadingsOops2 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 30;

        double a = 100.0;
        double b = 200.0;
        double c = 300.0;

        int k = 9;
        double m = 10.0;

        Percent obj = new Percent();
        System.out.println(  obj.add(x,y));
        System.out.println(  obj.add(x,y,z));
        System.out.println(  obj.add(x,y,a));

        System.out.println(  obj.add(a,b,z));
        System.out.println(  obj.add(x,a));
        System.out.println(  obj.add(a,x));

        System.out.println("******");
//        System.out.println(obj.mul(m,m)); compiler time error due to machine cannot think


    }
}
