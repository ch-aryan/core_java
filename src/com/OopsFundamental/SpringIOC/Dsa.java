package com.OopsFundamental.SpringIOC;

public class Dsa implements AllCourses{
    @Override
    public Boolean course(int amount) {
        System.out.println("Dsa");
        return true;
    }
}
