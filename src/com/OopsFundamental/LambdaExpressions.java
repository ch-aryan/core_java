package com.OopsFundamental;
abstract class An{
    abstract void meth();
}
interface Bbb {
    void meth1();//this is called functional interface . interface with only one method.

    default void meth2() {
        System.out.println("we can create a body for interface by using default keyword right");
    }
}

    interface Ccc{
        int meth2(int x, int y);
    }

    class Dd implements Ccc{
        public int meth2(int x, int y){
            System.out.println("this is implementing the class ccc from dd class");
            return 11;
        }
    }

//class Bn extends An{
//    public void meth(){
//        System.out.println("this is from Bn class");
//    }
//}

public class LambdaExpressions {
    public static void main(String[] args) {
//        An obj = new Bn();
//        obj.meth();

//        An obj = new An(){
//         public  void meth(){
//                System.out.println("this is from annonomous class");
//            }
//        };
//        obj.meth();

      Bbb obj = () -> {
              System.out.println("hello from lambda expressions");
          };
        obj.meth1();

        Ccc objz = new Dd();
        System.out.println(  objz.meth2(8,9));


        Ccc objzs = new Ccc(){
            public int meth2(int x , int y){
                System.out.println("this is from annanomous inner class");
                return 101;
            }
        };
        objzs.meth2(8,9);

        Ccc lambdas = (int x, int y)->{
            System.out.println("hello from lambda expression how you doing");
            return 1;
        };
        System.out.println(  lambdas.meth2(8,9));


//even shorter lambda method
        Ccc lambda1 = (x, y) ->  123;

        System.out.println( lambda1.meth2(9,1));



    }
}
