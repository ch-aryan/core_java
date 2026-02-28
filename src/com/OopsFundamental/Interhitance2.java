package com.OopsFundamental;
class Tel{
    String name = "aryan";
    private int roll = 1;
    private String gname;
    void meth(String name){
        this.name = name;
        System.out.println(name);
//        System.out.println(roll);
    }
    public void meth2(String gname){
    this.gname = gname;
    }
    public String get(){
      return gname;
    }

}
class Ali extends Tel{
    void aliMeth(String name){
        this.name = name;
        //roll = 3;//private members of the class will not get inherited

        System.out.println(name);
    }

}
public class Interhitance2 {
    public static void main(String[] args) {
        Ali obj1 = new Ali();
//        obj1.aliMeth("bhavana");
        obj1.meth("Kamalamma");
        obj1.meth2("Sattanaryana");
        System.out.println(obj1.get());

//        obj1.meth2(); private methods also cannot be inheritted to ensure encapsulation


        Tel obj = new Tel();
//        obj.meth2("Sattanarayana");
        obj.meth("Anil");
        obj.meth("Vani");
//        System.out.println(  obj.get());



        Tel obj2 = new Ali();
        obj2.meth("Bhavana");
        ((Ali) obj2).aliMeth("Aryan");
    }
}
