package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;
class QueueArray{
    int arr[] = new int[5];
    int start = -1;
    int curr = -1;
    int cap = 0;
    public void push(int x){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        if(start == -1){
            start = 0;
        }
        curr = (curr + 1 ) % arr.length;
        arr[curr] = x;
        cap++;
    }
    public boolean isEmpty(){
        return cap == 0;
    }
    public boolean isFull(){
        return cap == arr.length;
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int pop = arr[start];
        start = (start + 1) % arr.length;
        cap--;
        if(cap == 0){
            start = -1;
            curr = -1;
        }
        return pop;
    }
    public int getFront() {
        // Get front element
        if(isEmpty()){
            return -1;
        }
        return arr[start];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()){
            return -1;
        }
        return arr[curr];
    }
    public void print(){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
    QueueArray obj = new QueueArray();
        int pop = obj.pop();
        System.out.println(pop);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.print();
        obj.pop();
        obj.push(6);
        int front = obj.getFront();
        System.out.println(front);
        System.out.println(obj.getRear());


        obj.print();

    }
}
