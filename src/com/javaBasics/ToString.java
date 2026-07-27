package com.javabasics;
class User {
    String name;
    public  User(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User name is :"+ name;
    }
}
public class ToString {
    public static void main(String[] args) {


        User u = new User("Aryan");
        System.out.println(u);
    }
}
