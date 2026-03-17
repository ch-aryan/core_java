package com.OopsFundamental;
class LaunchStu{
    private  int age;
    private String name;
    int pass ;
    void disp(){
        System.out.println(   pass);
        System.out.println(getAge());
    }
  void  setAge(int a){
        age = a;
  }
  void setName(String name){
        this.name = name;
  }
  String getName(){
        return name;
  }
  int getAge(){
        return  age;
  }


}

public class Encapsulation {
    public static void main(String[] args) {
        LaunchStu obj = new LaunchStu();
        obj.pass = 1123;
        obj.disp();
        obj.setAge(22);
        obj.disp();
//        System.out.println( obj.getAge());
    }
}
