package com.OopsFundamental.ProjectUdemyCourse.main;

import com.OopsFundamental.ProjectUdemyCourse.service.DsaInJava;
import com.OopsFundamental.ProjectUdemyCourse.service.Microservices;
import com.OopsFundamental.ProjectUdemyCourse.service.SpringBoot;

public class CoursesAvailable {
    public static void main(String[] args) {
        UdemyWebsite course1 = new UdemyWebsite(new DsaInJava());
        course1.subscription(100);//constructor injection.

        UdemyWebsite coures2 = new UdemyWebsite();
        coures2.setter(new SpringBoot());
        coures2.subscription(200);
        coures2.setter(new Microservices());
        coures2.subscription(300);
    }
}
