package com.OopsFundamental;
class Calculator{
    int a;
    int b;
    void add(){
        a=10;
        b=10;
        int res = a+b;
        System.out.println(res);
    }

}

public class Oops1 {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        obj.add();


    }
}
