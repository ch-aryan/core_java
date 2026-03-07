package com.OopsFundamental.MultiThreading;

public class M1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("thread started");
//        Thread.sleep(3000);//which ever thread is executing to know about that we have some static methods of that thread.
        Thread thread =  Thread.currentThread();//helps to know where actually the thread is there.
        System.out.println( thread.getName());//In threads there are static methods.
        System.out.println(thread.getPriority());
        thread.setName("AryanDesktop");
        thread.setPriority(1);
        System.out.println(thread.getPriority());
        System.out.println(thread.getName());
        System.out.println("thread end");
    }
}
