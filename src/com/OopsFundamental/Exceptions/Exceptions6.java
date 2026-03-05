package com.OopsFundamental.Exceptions;

import java.io.IOException;

class AK {
    public void meth() throws ArithmeticException {
        int a = 10/0;
        System.out.println("parent");
    }
}


//class Bk extends AK{
//    public void meth() throws IOException{
//        System.out.println("this is not allowed.");
//    }
//}
class Ck extends AK{
    public void meth(){
        System.out.println("this is allowed.");
    }
}
//class Dk extends AK{
//    public void meth() throws Exception {
//        System.out.println("this is not allowed al");
//    }
//}
class RK {
    public void meth1() throws IOException {
        System.out.println("parent");
    }
}
class Sk extends RK{
    public void meth1() throws ArithmeticException{
        System.out.println("this is allowed.");
    }
}
class Tk extends RK{
    public void meth1() {
        System.out.println("this is allowed.");
    }

}
class UK extends RK{
    public void meth1() throws IOException{
        System.out.println("this is allowed");
    }
}//same but partially is not allowed here also i am not writing because i am commenting it.
public class Exceptions6 {
    public static void main(String[] args) {

    }
}
