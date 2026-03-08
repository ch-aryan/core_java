package com.OopsFundamental.Collections;

import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
       // pq.add(1,23);//not allowed
        pq.add(123);
        pq.add(44);
        pq.add(453);
        pq.add(1);//duplicates not allowed
        pq.add(1);//follows min -heap datastructure.
        pq.add(0);
        pq.add(-1);
     //   pq.add("s");//hetrogenous data is not allowed.

        System.out.println(pq);

    }
}
