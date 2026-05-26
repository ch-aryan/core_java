package com.OopsFundamental.MultiThreading.MultiThreadingRevision;
class Producer implements Runnable{
    int i;
    Queue  q;
    Producer(Queue q){
        this.q =  q;
    }
    @Override
    public void run() {
        while(true){
            q.produce(i++);
        }
    }
}
class Consumer implements Runnable{
    int i;
    Queue q;
    Consumer(Queue q){
        this.q = q;
    }
    @Override
    public void run() {
        while(true){
            q.consume();
        }
    }
}
class Queue {
    int data;
    boolean flag = false;
  synchronized   public void produce(int i) {
        try {
            if(flag == true){
                System.out.println("producer is in wating state");
                wait();
            }else{

                data = i;
                flag = true;
                System.out.println("i have produced the data " + data);
                notify();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 synchronized    public void consume() {
        try {
            if(flag == false){
                System.out.println("consumer is in waitng state");
                wait();
            }else {
                System.out.println("i have consumed the data " + data);
                flag = false;
                notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) {
    Queue qo = new Queue();
    Producer pro = new Producer(qo);
    Consumer con = new Consumer(qo);

    Thread t1 = new Thread(pro);
    Thread t2 = new Thread(con);

    t1.start();
    t2.start();
    }
}
