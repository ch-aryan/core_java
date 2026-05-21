package com.javabasics;
class Aa{
    String name;
    int iad;
    Integer id;

    Aa(String name, int iad, Integer id){
        this.name = name;
        this.iad = iad;
        this.id = id;
    }

    public String  getDetails(){
        return  "" + name + iad + id;
    }

}
class Ba {

}

public class ObjectsUnderStanding {
    public static void main(String[] args) {
        Aa obja = new Aa("Aryan", 1, 10);
        Aa objb = obja;


        objb.name = "bhavana";
        System.out.println(obja.name +" "+  objb.name);
        System.out.println();
    }
}
