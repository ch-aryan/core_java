package com.OopsFundamental.MultiThreading.Synchonization;
class Counter{
    private int count;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
class A extends Thread{
    Counter obj ;
    public A(Counter obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i = 0;i<1000;i++){
            obj.increment();
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter a = new Counter();
        Counter b = new Counter();
        A objMain = new A(a);
        objMain.start();


        A objMain1 = new A(a);
        objMain1.start();

        objMain.join();
        objMain1.join();


        System.out.println(  a.getCount());
        System.out.println(b.getCount());


    }
}
