package com.OopsFundamental.SpringIOC;

public class JavaMicroservices implements AllCourses{

    @Override
    public Boolean course(int amount) {
        System.out.println("JavaMicroservices");
        return true;
    }
}
