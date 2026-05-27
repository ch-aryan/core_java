package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class GooglePay implements Runnable {
    private HSBC bank;

    public GooglePay(HSBC bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("deposit  method from google pay class");
        bank.depositMeth(4000);
    }
}
