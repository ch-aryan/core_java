package com.javabasics;
class AAAV{
    private int id;
    private String name;
    private char grade;

    public String getName() {
        return name;
    }

    public AAAV(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
    public void print(){
        System.out.println(
                "Roll No: " + id +
                        ", Name: " + name +
                        ", grade: " + grade
        );
    }
}
public class CallingFunctionInForLoop {
    public static void main(String[] args) {
        AAAV aaav = new AAAV(1,"aryan", 'a');
        AAAV aaav1 = new AAAV(2,"Anil", 'o');

        AAAV [] arr = new AAAV[2];
        arr[0] = aaav;
        arr[1] = aaav1;

        AAAV [] arr1 = {aaav1, aaav};

        for(AAAV i : arr){
            i.print();
        }


    }
}
