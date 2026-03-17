package com.OopsFundamental.ProjectUdemyCourse.service;

public class Microservices implements Courses{
    @Override
    public Boolean courses(Integer amount) {
        System.out.printf("thanks for having microservices");
        return true;
    }
}
