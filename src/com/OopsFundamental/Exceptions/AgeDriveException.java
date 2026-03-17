package com.OopsFundamental.Exceptions;

import java.util.Scanner;
class UnderAgeException extends Exception{
    public UnderAgeException(String msg){
        super(msg);
    }
}
class OverAgeException extends Exception{
    public OverAgeException(String msg){
        super(msg);
    }
}

class AgeOfPerson{
     private int age ;
    public void collectAge(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the age");
        age = in.nextInt();

    }
    public void verifyAge() throws UnderAgeException, OverAgeException {
        if(age >= 18 && age <=70){
            System.out.println("License approved");
        }else if(age < 18 ){
           UnderAgeException uae = new UnderAgeException("You are a minor");
            System.out.println(uae.getMessage());
            throw uae;

//throw new UnderAgeException("You are a minor");

        }else {
    OverAgeException ore = new OverAgeException("You are a senior citizen");
            System.out.println(ore.getMessage());
            throw ore;

//            throw  new OverAgeException("You are a senior citizen"); this is also allowed.but
            //don't know how to print the ore.getmessage with it without creating the obj.

        }
    }
}
class Rto{
    public void LicenseReq(){
        AgeOfPerson obj = new AgeOfPerson();
        try{
            obj.collectAge();
            obj.verifyAge();
        }catch (UnderAgeException | OverAgeException e){//this syntax is equal to one try and two catch blocks. try {}catch {}catch{}
            System.out.println("Try again ");
            try{
                obj.collectAge();
                obj.verifyAge();
            }catch (UnderAgeException | OverAgeException e2){
                System.out.println("Try again ");
                try{
                    obj.collectAge();
                    obj.verifyAge();
                }catch (UnderAgeException | OverAgeException e3){
                    e.printStackTrace();
                }
            }
        }
    }
}
public class AgeDriveException {
    public static void main(String[] args) {
        Rto obj = new Rto();
        obj.LicenseReq();

    }
}
