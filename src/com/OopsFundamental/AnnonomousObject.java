package com.OopsFundamental;

class Annom{
    int m = 1;
    public  int meth(){
        return 1;
    }
}
public class AnnonomousObject {
    public static void main(String[] args) {
        int res = new Annom().meth(); // if you want to call the one method without refering to any class
        // it is useful to create this object but no readability it have.
        System.out.println(res);
    }
}
