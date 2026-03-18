package com.OopsFundamental.MultiThreading;
class Library implements Runnable{
    String s1 = new String("java");
    String s2 = new String("Dsa");
    String s3 = new String("springboot");
    @Override
    public void run() {
       String name = Thread.currentThread().getName();
    if( name.equals("Student1")){
        try{
            System.out.println("student 1 entered the library");
            Thread.sleep(3000);
           synchronized (s1) {
               System.out.println("student1 acquired the " + s1);
               Thread.sleep(3000);
               synchronized (s2) {
                   System.out.println("student1 acquired the " + s2);
                   Thread.sleep(3000);
                   synchronized (s3) {
                       System.out.println("student1 acquired the " + s3);
                   }
               }
           }

        } catch (Exception e) {
           e.printStackTrace();
        }

    }else{
        try{
            System.out.println("student 2 entered the library");
            Thread.sleep(3000);
            synchronized (s1) {
                System.out.println("student2 acquired the " + s1);
                Thread.sleep(3000);
                synchronized (s2) {
                    System.out.println("student2 acquired the " + s2);
                    Thread.sleep(3000);
                    synchronized (s3) {
                        System.out.println("student2 acquired the " + s3);
                    }
                }
            }
        }catch (Exception e){
           e.printStackTrace();
        }

    }
    }

}
public class M7ImpDeadLock {
    public static void main(String[] args) {
    Library obj = new Library();

    Thread t1 = new Thread(obj);
    Thread t2 = new Thread(obj);

    t1.setName("Student1");
    t2.setName("Student2");

    t1.start();
    t2.start();
    }
}
