package com.OopsFundamental;
class Employee{
    int r;
    String dr;
    Employee(int r, String dr){
        this.r = r;
        this.dr = dr;
        System.out.println(r+" "+dr);
    }
}

public class Constructor {
    int a = 10;
    String b = "Aryan";
    private Constructor (int a, String b){
        this.a = a;
        this.b= b;
        System.out.println(a +" " + b);

    }

    public static void main(String[] args) {
        Constructor c = new Constructor(15, "Anil");
        Employee ec = new Employee(9, "bhavana");
    }

}
