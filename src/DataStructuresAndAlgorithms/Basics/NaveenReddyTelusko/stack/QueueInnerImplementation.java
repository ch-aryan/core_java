package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;
class QueuePredefined {
    int [] arr = new int[4];
    int start = -1;
    int end = -1;
    int cap = 0;
    int n = arr.length;
    public void push(int x){
        if(isFull()){
            System.out.println("its full already");
            return;
        }
        if(start == -1){
            start++;
        }
        end = (end + 1) % n;
        arr[end] = x;
        cap++;
    }
    public void pop(){
    if(isEmpty()){
        System.out.println("its empty");
        return;
        }
    arr[start] = 0;
    start = (start + 1) % n;
    cap--;

    }
    public int getTop(){
    if(isEmpty()){
        return -1;
    }
    return arr[start];
    }
    public int getLast(){
    if(isEmpty()){
        return -1;
    }
    return arr[end];
    }
    public boolean isEmpty(){
        return cap == 0;
    }
    public boolean isFull(){
        return cap == n;
    }
}
public class QueueInnerImplementation {
    public static void main(String[] args) {


        QueuePredefined queue = new QueuePredefined();
        queue.pop();
        queue.push(1);
        queue.push(4);
        System.out.println( queue.getTop());
        System.out.println( queue.getLast());
        queue.pop();
        System.out.println(queue.isFull());
        queue.push(3);
        queue.push(4);
        queue.push(1);
        queue.push(2);
        System.out.println(queue.isFull());
        queue.pop();
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());


    }
}
