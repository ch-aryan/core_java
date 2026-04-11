package com.OopsFundamental.SpringIOC;

public class Telusko { //extends java //inheritance not good.

    private AllCourses c;

    public void setCourse(AllCourses c){
        this.c = c;

    }
    public Boolean buyTheCourse(int amount){
//        Dsa obj = new Dsa();
//        Boolean status = obj.course(amount);
//        return status; composition method not good

        return c.course(amount);
    }
    //1st public Boolean buy(int amt){
    //return true;
}
//target class using the service of other classes.

