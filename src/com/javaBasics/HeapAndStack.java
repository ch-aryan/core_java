package com.javabasics;
class ClassAb{

}
class ClassBa{

}
public class HeapAndStack {
    public static void main(String[] args) {
        String a = "a";
        System.out.println("in java stirngs are intilazied with double quotes.");

        int ABC = 123;
        int abc = 321;
        System.out.println(abc);//here both are diff.
        System.out.println(ABC);
        System.out.println("Haan bhai, Java aur JavaScript dono case-sensitive languages hain.");

        if(true){
            System.out.println("hello true");
        }else{
            System.out.println("hello false");
        }
        boolean i = false;
        while(i==false){
            System.out.println("hello true while looop");
            System.out.println("need to learn lot of things.");
        }
    }
}
