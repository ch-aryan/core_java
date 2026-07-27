package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;
class QUL{
    Node start = null;
    Node end = null;
    int count = 0;
    public void push(int x){
        Node temp = new Node(x);
    if(isEmpty()){
        start = temp;
        end = temp;
    }else{
        end.next = temp;
        end = temp;
    }
    count++;

    }
    public boolean isEmpty(){
        return count==0;
    }
    public int pop(){
    if(isEmpty()){
        return -1;
    }
    Node temp = start;
    start = start.next;
    count--;
    if(start == null){
        end = null;
    }
    int value = temp.value;
    return value;
    }
    public int peek(){
        if(isEmpty()) return -1;
    return start.value;
    }
    public int getLast(){
        if(isEmpty()) return -1;
     return end.value;
    }
    public int size(){
        return count;
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args) {
    QUL queue = new QUL();
    queue.push(1);
    queue.push(2);
    queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
