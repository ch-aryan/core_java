package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackInbuilt {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.add(2);
        System.out.println( s.pop());
        s.push(3);

        Deque<Character> stack = new ArrayDeque<>();
        stack.push('{');
        stack.getFirst();
        stack.pop();

        System.out.println(s);

    }
}
