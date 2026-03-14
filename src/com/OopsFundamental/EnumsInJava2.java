package com.OopsFundamental;

import java.sql.SQLOutput;

enum Demo{
        HELLO, HI, NAMASTE;
        Demo (){
            System.out.println("constructor of demo will be created 3 times because we have 3 constants");
        }
        public String name;
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return  name;
        }
}
enum Result{
    //byfeault what will happen is behind the scene is this
    //public static final Result PASS = new Result();
    //public static final Result FAIL = new Result();
    //public static final Result NR = new Result(); will be creating


    PASS, FAIL, NR;
    int marks;
    Result (){
        System.out.println("constructor of enum is created 3 times becuase we have 3 constants");
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }

//    enum Week{
//        //we can create a enum inside a enum totally fine
//    }
}

public class EnumsInJava2 {
    public static void main(String[] args) {
// a group of data which is specific type
        Result obj = Result.PASS;
        obj.setMarks(44);
        System.out.println( obj.getMarks());

        Result obj1 = Result.NR;
        obj1.setMarks(88);
        System.out.println(obj1.getMarks());

        Result obj2 = Result.FAIL;
        System.out.println(obj2.getMarks());

        System.out.println("******************");

        Demo obj3 = Demo.HELLO;
        obj3.setName("Aryan");
        System.out.println(obj3.getName());

        System.out.println(Demo.HI.ordinal());

        Demo obj4 = Demo.HI;
        obj4.setName("Bhavana");
        System.out.println(obj4.getName());

        Demo obj5 = Demo.NAMASTE;
        obj5.setName("Anil Vani");
        System.out.println(obj5.getName());

        Demo obj6 = Demo.HI;
        obj6.setName("Chilukeshwaram");
        System.out.println(obj6.getName());

        Demo obj7 = Demo.NAMASTE;
        obj5.setName("kammalamma Sattaiahya");
        System.out.println(obj7.getName());
    }
}
