package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }

}

class LinkedList{
    Node head;

    public void add(int data){
        System.out.println(head);
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            System.out.println(head.data);//1 here it is one
            System.out.println(head.next);// and next obviously null.
            return;
        }

        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public void add(int ind, int elm){

    }


    public void addFirst(int data){

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

public void print(){

    Node curr = head;

    while(curr != null){
        System.out.print(curr.data + " ");
        curr = curr.next;
    }

    System.out.println();
}


}

public class LinkList {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.add(1); //--> add by sequence
        obj.add(1);
        obj.add(4);
        obj.add(23);
       // obj.add(2,1);// --> add in the middle
        obj.addFirst(1);//--> add at index 0 means first index.

        obj.print();

    }
}
