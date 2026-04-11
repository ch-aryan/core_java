package com.OopsFundamental.SpringIOC;

public class Main {
    public static void main(String[] args) {

        Telusko obj = new Telusko();
        JavaMicroservices obj1 = new JavaMicroservices();
        obj.setCourse(obj1);

        obj.setCourse(new Dsa() );
      Boolean status =  obj.buyTheCourse(80);
      if(status){
          System.out.println("successfully enrolled");
      }else{
          System.out.println("Not enrolled");
      }

    }
}
