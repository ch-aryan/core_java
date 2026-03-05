package com.OopsFundamental;
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
    }
}
