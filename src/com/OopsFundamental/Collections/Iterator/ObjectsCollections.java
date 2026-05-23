package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;

class Emp{
    private Integer id;
    private String name;
    private Character grade;

    public Emp(Integer id, String name, Character grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
public class ObjectsCollections {
    public static void main(String[] args) {
        ArrayList<Emp>  obj  = new ArrayList<>();
        obj.add(new Emp(0, "chil", 'a'));
        Emp emp1 = new Emp(1,"Aryan", 'a');
        Emp emp2 = new Emp(2, "bhavana" , 'o');
        Emp emp3 = new Emp(3, "anil", 'a');
        Emp emp4 = new Emp(4,"vani", 'o');
        obj.add(emp1);
        obj.add(emp2);
        obj.add(emp3);
        obj.add(emp4);

        System.out.println(obj);

        for(Emp o : obj){
            System.out.println(o+" ");
        }
    }
}
