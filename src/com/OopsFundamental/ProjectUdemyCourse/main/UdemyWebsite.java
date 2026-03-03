package com.OopsFundamental.ProjectUdemyCourse.main;

import com.OopsFundamental.ProjectUdemyCourse.service.Courses;

public class UdemyWebsite {
    Courses course_obj;

   public  UdemyWebsite (Courses course_obj){
        this.course_obj = course_obj;
    }
    public UdemyWebsite(){
       super();
    }

    public void setter(Courses course_obj){
       this.course_obj = course_obj;
    }

    public Boolean subscription(Integer am){
      return  course_obj.courses(am);

    }
}
