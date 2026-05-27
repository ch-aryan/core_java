package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class HSBC {
    int accountBal;
    public HSBC(int accountBal){
        this.accountBal = accountBal;
    }
  synchronized   public void withdrawMeth(int withdraw){
    accountBal = accountBal-withdraw;
    }
 synchronized    public void depositMeth(int deposit){
    accountBal = accountBal+deposit;
    }
  synchronized   public void balanceView(){
        System.out.println(accountBal);
    }
}
