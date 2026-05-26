package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;

import java.util.ArrayList;
import java.util.LinkedList;

class Nodee{
    public int data;//creating data
   public  Nodee next;
   public  Nodee(int data){
        this.data = data;
       this.next = null;
    }
}
class LinkedList1<T> {
  Nodee head;
    public void add(int data){
       Nodee newNode = new Nodee(data);
       if(head == null){
           head = newNode;
           return;
       }
        Nodee curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;

    }

    public void printList(){
        Nodee temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

}
public class SingleLinkedList1 {
    public static void main(String[] args) {
    Nodee headNode = new Nodee(1);
    headNode.next = new Nodee(2);
    headNode.next.next = new Nodee(3);
    headNode.next.next.next = new Nodee(4);

    Nodee temp = headNode;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
    }
        System.out.println(";;;;");

    LinkedList1<Integer> list = new LinkedList1<>();//inner implementattion of ll.
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.printList();



    ArrayList<Integer> arr = new ArrayList<>();
        LinkedList<Integer> Collectionlist = new LinkedList<>();


    }
}
/*
Understanding Node Structure
In a singly linked list, each node consists of two parts: data and a pointer to the next node.
This structure allows nodes to be dynamically linked together, forming a chain-like sequence.
// Definition of a Node in a singly linked list
public class Node {

    // Data part of the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor to initialize the node with data
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
/*
In this example, the Node class contains an integer data field (data) to store the information and a pointer to another Node (next) to establish the link to the next node in the list.

Creating an Example Linked List of Size 3 to Understand Working
Create the first node

Allocate memory for the first node and Store data in it.
Mark this node as head.
Create the second node

Allocate memory for the second node and Store data in it.
Link the first node’s next to this new node.
Create the third node

Allocate memory for the third node and Store data in it.
Link the second node’s next to this node.
Set its next to NULL to ensure that the next of the last is NULL.

Advantage
Dynamic size (no fixed limit like arrays)
Efficient insertion and deletion at beginning and end. We also have insertion at the middle efficient if we have reference or pointer to the node after which we need to insert.
Can implement complex data structures like stack, queue, graph
Disadvantage
Extra memory required for storing pointers
No direct/random access (need traversal)
Cache unfriendly (not stored in contiguous memory)
 */
