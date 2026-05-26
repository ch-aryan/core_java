package com.OopsFundamental.MultiThreading.MultiThreadingRevision;
class Abc extends Thread {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.equals("learn")) {
            learning();
        } else if (name.equals("write")) {
            writing();
        } else {
            reading();
        }

    }

     public void learning() {
        try {

            for (int i = 0; i < 3; i++) {
                Thread.sleep(2000);
                System.out.println("learning");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writing() {
        try {
            for (;;) {
                Thread.sleep(2000);
                System.out.println("writing");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void reading() {
        try {
            for (;;) {
                Thread.sleep(2000);
                System.out.println("reading");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class DeamonThreadsCode {
    public static void main(String[] args) {
        Abc obj = new Abc();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);
        t1.setName("learn");
        t2.setName("write");
        t3.setName("read");

        t2.setDaemon(true);
        t3.setDaemon(true);
        t2.setPriority(4);
        t3.setPriority(3);
        t1.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
    }
}
