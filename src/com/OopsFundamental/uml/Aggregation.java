package com.OopsFundamental.uml;
class Student{
    private String name;
    private int id;
    public Student(String name , int id){
        this.name = name;
        this.id = id;
    }
    public void showStudent() {
        System.out.println("Student Id: " + id + ", Name: " + name);
    }
    public String getName(){
        return name;
    }
}
class College {
    private String collegeName;
    private Student student; //Aggregation(HAS -A)

    public College(String collegeName , Student student){
        this.collegeName = collegeName;
        this.student = student;
    }
    public void showCollegeDetails() {
        System.out.println("College Name: " + collegeName);
        System.out.print("Student studying: ");
        student.showStudent();
        System.out.println();
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Student s1 = new Student("Aryan", 101);
        Student s2 = new Student("Rahul", 102);

        College c1 = new College("IIT Hyderabad", s1);
        College c2 = new College("JNTU Hyderabad", s2);

        c1.showCollegeDetails();
        c2.showCollegeDetails();

        System.out.println("Student still exists even if college object not used:");
        s1.showStudent();
    }
}
