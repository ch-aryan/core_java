package com.OopsFundamental;
interface I{
    public static final int var = 1;//bydefault var are public static final.
    void a();
    public abstract int b();
    static void methInt(){
        System.out.println("this is an first interface");
        System.out.println("static methods cannot be inherited right.");
    }
//    void c(){
//        System.out.println("We cannot create a body for interface class becuase we " +
//                "can't achieve 100% polymorphism");
//    }
    default int methWithBody(){
        System.out.println("this is allowed from java 1.8 using default keyword");
        return 111;
    }
    static int methWithoutAbstract(){
        System.out.println("we can have static methods aslo but this are not abstracted because they" +
                "should have implementation in interface hereitself right.However" +
                "it will not get inherited in any implementing child classes");
        return 1;
    }
}
//interface J implements I{
//    //we cannot implement a interface for interface class. means one interface cann't
//    //implement other interface
//}

interface J extends  I{
    //but we can extend the interface for one interface. means 1 interface can extend
    //another interface.
    void a();
    int b();
    void z();
    int x();
    void c();
    default int methWithBody(){
        I.super.methWithBody();
        System.out.println("Not compulsory but if need arises we can override aslo. it is" +
                "already inherited bydefault.");
        return 1;
    }



}
abstract  class KK implements J {
    abstract int meth();
 public    int methKK(){
     System.out.println("this is abstract class methkk");
        return 1;
    }

}

class LL extends KK implements I,J{//or else we can write as class ll extends kk fine

    public int methWithBody() {
        super.methWithBody();
        System.out.println("this is overridden meth mama from which class i don't know perfectly");
        return 1;
    }

    @Override
    public void c() {
        System.out.println("this is method from normal class c LL interface is J");
    }

    @Override
    public void a() {
        System.out.println("this is method of normal classs ll a.but interface is J and I i think");
    }

    public void z() {
        System.out.println("this is method of normal class interface is J");
    }

    @Override
    public int b() {
        System.out.println("this is method of interface I and J may be .");
        return 0;
    }

    public int x() {
        System.out.println("this is method of interface J for sure");
        return 11;
    }

    @Override
    int meth() {
        System.out.println("this is abstract class method which should be properly be implemented");
        return 0;
    }

    public int specializedMethOfLL() {
        System.out.println("we can have specialized methods of class which is implementing inte" +
                "rface but however to achieve this using interface type reference" +
                "we need to downcast it.");
        return 1;
    }
}

    class AllAcceptance{
        void allClassInterfaceAbstraction(I obj, J obj1 , KK obj2){
            obj.a();
            obj.b();
            obj.methWithBody();
//            obj.methWithoutAbstract(); not allowed because of static method.

            obj1.a();
            obj1.b();
            obj1.z();
            obj1.x();
            obj1.c();
            obj1.methWithBody();

            obj2.meth();
            obj2.methKK();

        }

    }


public class Interface1 {
    public static void main(String[] args) {
//    I obj = new I(); we cannot create a object of interfaces;
        I obj ; //we can create a refernce of interfaces to achieve polymorphism.
        I.methWithoutAbstract();//calling it here.
    //    KK obj1 = new KK();// we cannot create a object for abstract classes.
        KK obj1;// we can create a refernce for them.
        J objmain = new LL();
        ((LL)objmain).specializedMethOfLL();// accessing the specialized methods.
    objmain.methWithBody();
        KK objmain0 = new LL();

        LL objmain1 = new LL();
        AllAcceptance objmain2 = new AllAcceptance();
        objmain2.allClassInterfaceAbstraction(
                objmain1,
                objmain,
                objmain0
        );
    }
}
