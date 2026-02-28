package com.OopsFundamental;
class Az{
    int a = 88;
    private int b = 9;
    public static int c = 3;// if not declared bydefault the value will be zero.
    private static int d = 4;
    static int e = 5;

    public Az(){
        this(1,2,3);
        System.out.println("this is parent zero para");
    this.a = 44;
    this.b = 49;
    c = 99;
    d = 99;
    e = 55;
    }
    private Az(int a, int b, int c){
        System.out.println("this is parent with para");
        //construcotrs can be private or public or default
        this.a = a;
        this.b = b;
        Az.c = c; //or this.c = c;

    }
    public static int methodA(){
//        return a + b + c + d + e ;// we cannot access the instance var without static inside static methods.
        return c + d + e;
    }
    public int methodAb(){
        System.out.println("this is parent ab");
        return a + b + c + d + e;
    }

}


class By extends  Az{
    int xa = 1;
    int by = 2;
    static int cz = 3;
    static int count = 0;

    public By(){

        System.out.println("this is zero param child construction");
    }
    public By(int xa, int count){

        this();
        System.out.println(" this is child with para");
        this. xa = xa;
        this.count = count;//By.count
    }
    public static int methodBy(){
        System.out.println(cz+ "this is child");
        return cz;

    }
    public int methodBz(int xa, int cz){
        this.xa = xa;
        this.cz = cz;//By.cz = cz;
        System.out.println(xa + " " + cz);
         count = xa + cz;
        return count;
    }
    public  int methodAb(){
        super.methodAb();
        System.out.println("this is overridden");
        return 9;
    }
}

public class ThisAndSuper {
    public static void main(String[] args) {

//        int res =  Az.methodA();
//        System.out.println(res);
//
//       int result = new Az().methodAb();//anonomous object.
//        System.out.println(result);

//        int res1 = new By().methodBz(60, 60);
//        System.out.println(res1);

        By obj = new By();
        System.out.println("*************8");
        By obj1 = new By(1,2);
//        System.out.println(obj.methodBz(70, 70));
//        System.out.println(obj.methodBz(88, 98));
//        System.out.println(obj.methodBz(55, 55));
//
//        By obj1 = new By();
//        System.out.println(By.count);
//
//       obj1.methodAb();
    }
}
