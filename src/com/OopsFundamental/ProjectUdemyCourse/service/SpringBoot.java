package com.OopsFundamental.ProjectUdemyCourse.service;

public class SpringBoot implements Courses{

    @Override
    public Boolean courses(Integer amount) {
        System.out.println("Thankyou for buying springboot course");
        return true;
    }
}
