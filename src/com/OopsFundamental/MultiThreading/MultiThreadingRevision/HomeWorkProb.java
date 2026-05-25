package com.OopsFundamental.MultiThreading.MultiThreadingRevision;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable<Integer>{
    @Override
    public Integer call()  {
        System.out.println("Child thread is computing");
        return 1;
    }
}




public class HomeWorkProb {
    public static void main(String[] args)throws Exception {
        MyTask task = new MyTask();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(task);
        Integer result= future.get();

        System.out.println("Result = " + result);

        service.shutdown();


    }
}
