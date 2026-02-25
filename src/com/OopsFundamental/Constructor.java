package com.OopsFundamental;

public class Constructor {
    int a = 10;
    String b = "Aryan";
    public Constructor (int a, String b){
        this.a = a;
        this.b= b;
        System.out.println(a +" " + b);

    }

    public static void main(String[] args) {
        Constructor c = new Constructor(15, "Anil");
    }

}
