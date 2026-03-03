package com.OopsFundamental;

import com.OopsFundamental.Aa.Cc;

import java.sql.SQLOutput;

class Aa{
    int meth = 1;
    public void maaan (){
        System.out.println("hello world this is aryan here from outer class");
    }
    static class Bb{
        int b = 2;
        public int methBa(int n){
            System.out.println("this is from inner class");
            return 1;
        }
    }

    class Cc{
        int c =3;
        public int methCc(int C){
            System.out.println("this is the inner Cc class");
            return 2;
        }

    }
}

class Zzz{
    int n =1;
    public void showZzz(){
        System.out.println("This will not print");
    }
    public int methZZZ(int i){
        System.out.println("this is method zzz will not print ");
        return i;
    }

}
public class InnerClass {
    public static void main(String[] args) {
        Aa obj = new Aa();
        Aa.Bb objInner = new Aa.Bb();

        Aa.Cc i =  obj.new Cc(); // this is non static inner class without static and it is
        //accessed like this Outerclass.Innerclass objname = Outerclass(objname).new Innerclass();
            Zzz newObj = new Zzz(){
                public void showZzz(){
                    System.out.println("this is something big");
                }

                public int methZZZ(int i){
                    System.out.println("this is methZZZ from anonomous inner class it is only used to override the methods of the class.");
                    return i;
                }

                public void hello(){
                    System.out.println("we can create new method but we cannot access. in annonomous inner class or with obj");
                }
            };

            newObj.showZzz();
            newObj.methZZZ(1408);
    }
}
