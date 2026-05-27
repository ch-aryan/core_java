package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class LaunchObjLevLock {
    public static void main(String[] args) {
        HSBC bank = new HSBC(6000);

        ATM atm = new ATM(bank);
        Thread t1 = new Thread(atm);
        t1.setName("Atm thread");

        GooglePay gpay= new GooglePay(bank);
        Thread t2 = new Thread(gpay);
        t2.setName("Gpay thread");

        Paytm paytm = new Paytm(bank);
        Thread t3 = new Thread(paytm);
        t3.setName("Paytm thread");

        t1.start();
        t2.start();
        t3.start();


    }
}
