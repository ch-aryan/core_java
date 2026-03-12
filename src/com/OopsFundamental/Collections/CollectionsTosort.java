package com.OopsFundamental.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Sorting implements Comparator<Emp>{

    @Override
    public int compare(Emp o1, Emp o2) {
        if (o1.roll > o2.roll) {
            return 1;
        } else {
            return -1;
        }
    }

}
class Emp{
    public int roll;
    public String name;
    public char grade;

    public Emp(int roll) {
        this.roll = roll;
    }

    public Emp(int roll, String name, char grade) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

public class CollectionsTosort {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(35);
        al.add(123);
        al.add(1);
        al.add(243);
        al.add(0);
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);
        System.out.println("***************");
        ArrayList<String> sl = new ArrayList<>();
        sl.add("Aryan");
        sl.add("Vani");
        sl.add("Bhavana");
        sl.add("Anil");
        System.out.println(sl);
        Collections.sort(sl);
        System.out.println(sl);
        System.out.println("***************");

        Emp obj1 = new Emp(4,"Vishva", 'A');//we can add this type also.
        Emp obj2 = new Emp(5, "Rithwik", 'C');

        ArrayList<Emp> empA = new ArrayList<>();
        empA.add(new Emp(1,"Aryan", 'O'));
        empA.add(new Emp(2,"shubham", 'A'));
        empA.add(new Emp(3,"Akhil", 'b'));
        empA.add(obj1);
        empA.add(obj2);
        System.out.println(empA + "\n");
//        Collections.sort(empA); it will not work like this. we need to use another tech
        //compile time error it seems java is confused how should i sort based on what
        // so we need to use either comparable or comparator.
        //this two are interfaces and they are functional interface.
        //so we have 3 ways to implement the functional interface right
        /* implements keyword
        ananomous inner class
        lambda expression.
         */
Sorting objS = new Sorting();
Collections.sort(empA, objS);
    }
}
