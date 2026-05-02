package com.javabasics;
//this will create the ambiguity.
public class MethodOverlaodingRevison {
//    double mult(int a, double b){
//        return a * b;
//    }
//    double mult(double a, int b){
//        return a*b;
//    }
//    public static void main(String[] args) {
//        MethodOverlaodingRevison methodOverlaodingRevison = new MethodOverlaodingRevison();
//        methodOverlaodingRevison.mult(1,2);
//    }
public static void main(String[] args) {
    System.out.println("hello world");
}

    public static double main(String[] args, double ad) {
        System.out.println("this is diff");
        return 22.0;
    }

    public static void main(String[] args, String ch , char c) {
        System.out.println("this is diff");
    }
}
