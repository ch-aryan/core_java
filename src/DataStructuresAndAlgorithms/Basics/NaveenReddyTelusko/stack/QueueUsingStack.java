package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class QUS{
    Deque<Integer> s1 = new ArrayDeque<>();
    Deque<Integer> s2 = new ArrayDeque<>();

    public void push(int x){
       while(!s1.isEmpty()){
           s2.push(s1.getFirst());
           s1.pop();
       }
       s1.push(x);
       while(!s2.isEmpty()){
           s1.push(s2.getFirst());
           s2.pop();
       }
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {

    }
}
