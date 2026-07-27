package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;
class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
        next = null;
    }
}
class StackLinkedList{
   private Node top;
   private int count;
   StackLinkedList(){
       top = null;
   }
    public boolean isEmpty(){
        return top==null;
    }
    public int size(){
       return count;
    }
    public void push(int x){
       Node temp = new Node(x);
       temp.next = top;
       top = temp;
       count++;
    }
    public int pop(){
       if(isEmpty()){
           System.out.println("stack is empty");
           return -1;
       }
       Node temp = top;
       top = top.next;
       count--;
       return temp.value;
    }
    // peek operation
    int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.value;
    }


}
public class StackUsinLL {
    public static void main(String[] args) {
        StackLinkedList st = new StackLinkedList();

        // pushing elements
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        // popping one element
        System.out.println("Popped: " + st.pop());

        // checking top element
        System.out.println("Top element: " + st.peek());

        // checking if stack is empty
        System.out.println("Is stack empty: " + (st.isEmpty() ? "Yes" : "No"));

        // checking current size
        System.out.println("Current size: " + st.size());

        System.out.println(st);
    }
    }

