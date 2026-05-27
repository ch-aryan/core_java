package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class ATM implements Runnable{
    private HSBC bank;
    public ATM(HSBC bank){
        this.bank = bank;
    }
    @Override
    public void run() {
        System.out.println("withdrawl method from atm class");
        bank.withdrawMeth(2000);
    }
}
