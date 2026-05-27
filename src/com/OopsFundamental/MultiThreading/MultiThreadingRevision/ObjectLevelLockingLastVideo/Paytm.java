package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class Paytm implements Runnable {
    private HSBC bank;

    public Paytm(HSBC bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("ViewBalance  method from google pay class");
        bank.balanceView();
    }
}
