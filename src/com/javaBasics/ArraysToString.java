package com.javabasics;
class TelsukoRey{
    int id;
    String name;
    String address;

    public TelsukoRey(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public TelsukoRey() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TelsukoRey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
public class ArraysToString {
    public static void main(String[] args) {
        TelsukoRey t  = new TelsukoRey(1, "arayn", "lal");
        System.out.println(t);// if we don't override toString method we get this.TelsukoRey@8efb846 address/ of the object.
        //to geet the actual data we need toString() method.

        int [] [] arr = new int [][] { {2,3} , {3,4}};
        System.out.println(arr);//hashcode address is printed. here the team didn't override the toString() method.

        String str = "arayan";// here the team overriden the toString() method from the object class.
        System.out.println(str);

       str =  str.concat("chil");//str = new data now .
        System.out.println(str);
     int a = 7;
     int b = a + 5;
        System.out.println(a);
        System.out.println(b);


        String aa = "aryan";
        String bb = aa + "raj";
        String cc = aa + bb;

        String a1 = "a";
        String b1 = a1 + "a";
        String c1 = "aa";
        System.out.println(c1.equals(b1));

    }
}
