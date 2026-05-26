package com.OopsFundamental.MultiThreading.MultiThreadingRevision;
class Library implements Runnable{
    String res1 = "Java";
    String res2 = "Dsa";
    String res3 = "SpringBoot";

    @Override
    public void run() {
       String name =  Thread.currentThread().getName();
        try {
            if (name.equals("Aryan")) {
                Thread.sleep(2000);
                System.out.println("Aryan went into lib");
                synchronized (res1) {

                    System.out.println(name + " got acquired the book " + res1);
                    Thread.sleep(3000);

                    synchronized (res2) {

                        System.out.println(name + " got acquired the book" + res2);
                        Thread.sleep(3000);

                        synchronized (res3) {

                            System.out.println(name + " got acqurired the book " + res3);
                            Thread.sleep(3000);
                        }
                    }

                }
            }
             else{
            Thread.sleep(2000);
            System.out.println("shubham went into library");

            synchronized (res3) {

                System.out.println(name + " got acquired the book " + res3);
                Thread.sleep(3000);

                synchronized (res2) {

                    System.out.println(name + " got acquired the book" + res2);
                    Thread.sleep(3000);

                    synchronized (res1) {

                        System.out.println(name + " got acqurired the book " + res1);
                        Thread.sleep(3000);
                    }
                }
            }
        }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class LibraryExample {
    public static void main(String[] args) {
        Library obj = new Library();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.setName("Aryan");
        t2.setName("Shubham");

        t1.start();
        t2.start();
    }
}
