package com.OopsFundamental;

public class StaticRevision101 {
    public  int number;
    public static void somethingAbout(int data){
        StaticRevision101 obj = new StaticRevision101();
       obj.number = data;
        System.out.println(obj.number);
    }
    public static void print(){
        StaticRevision101 obj = new StaticRevision101();
        System.out.println(obj.number);
    }

}
class Main{
    public static void main(String[] args) {
        StaticRevision101 obj = new StaticRevision101();
        StaticRevision101.somethingAbout(100);
        StaticRevision101.print();

        StaticRevision101 obj1 = new StaticRevision101();
        obj1.somethingAbout(200);
        obj1.print();

        obj.print();
    }
}
