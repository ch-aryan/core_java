package com.OopsFundamental.Exceptions;

import java.util.Scanner;
class InvalidException extends  RuntimeException{
  public InvalidException(String msg) {
      super(msg);
  }
}

class Account{
    int acc = 4321;
    int pass = 1234;
    int ac;
    int ps;
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the account number");
        ac = in.nextInt();
        System.out.println("enter the pass");
        ps = in.nextInt();
    }
    public void verify() throws InvalidException {
//        if(acc == ac && pass == ps){
//            System.out.println("confirm legit");
//        }else{ with this strategy we can give n number of attempts to the users or hacker .
//            System.out.println("incorrect user details");
//        }

            if (acc == ac && pass == ps) {
                System.out.println("confirm right");

        }else{

            InvalidException ice = new InvalidException("Invalid Credentials");
                System.out.println( ice.getMessage());
            throw ice;

//                throw new InvalidException();

        }
    }

}
class Bank {
    public void details() {
        Account obj = new Account();
        try {

            obj.input();
            obj.verify();
        } catch (InvalidException ice1) {
            System.out.println("incorrect");
           try{
               obj.input();
               obj.verify();
           }catch (InvalidException ice2){
               System.out.println("incorrect");
               try{
                   obj.input();
                   obj.verify();

               }catch (InvalidException ice3){
                   System.out.println("Incorrect details limit reached");
               }
           }
        }

    }
}
public class CustomsIfElseException {
    public static void main(String[] args) {
        Bank obj = new Bank();
        obj.details();
    }
}
