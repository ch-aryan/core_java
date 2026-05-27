package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;

import DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.Easy.Palindrome;

class Ynode{
    int  data;
    Ynode next;
    public Ynode(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList2{
    static Ynode head;
    public static void add(int data){
      Ynode  node = new Ynode(data);
        if(head==null){
            head = node;
            return;
        }
        Ynode curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public static void deleteHead(){

        Ynode newNode = head.next;
        head = newNode;

        //ai
       // Better Version
     /*   public static void deleteHead(){
            if(head == null){ if head is empty then null pointer exception.
                return;
            }
            head = head.next;
        }*/

    }

    public static void deleteElement(int data){
        Ynode curr = head;
        int count = 0;
        Ynode join = null;
        while(curr!=null){
            if(curr.data == data){
                join = curr.next;
                break;
            }

            curr = curr.next;
            count++;
        }
        if(join == null){
            System.out.println("no element is present");
            return;
        }
        curr = head;
        int i=0;
        while(curr!= null && i<count-1){
            curr = curr.next;
            i++;
        }
        curr.next = join;
    }

    public static void deleteAtPos(int index){
        Ynode curr = head;
        Ynode join;
        int count = 0;
        while(curr!=null && count <= index-1){
            curr = curr.next;
            count++;
        }
        join = curr.next;
        curr = head;
        int i =0;
        while(curr != null && i<count-1){
            curr = curr.next;
            i++;
        }
        curr.next = join;

    }

    public static void deleteLast(){
        // empty list
        if(head == null){
            return;
        }

        // only one node
        if(head.next == null){
            head = null;
            return;
        }
        Ynode curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
    }

    public static void printList(){
        Ynode curr = head;
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr = curr.next;
        }
    }
}
public class SingleLinkedList2 {
    public static void main(String[] args) {
        LinkedList2.add(1);
        LinkedList2.add(2);
        LinkedList2.add(3);
        LinkedList2.add(4);
        LinkedList2.printList();
        System.out.println();
        LinkedList2.deleteHead();
        LinkedList2.printList();
        System.out.println();
        LinkedList2.add(1);
        LinkedList2.printList();
        LinkedList2.deleteElement(4);
        System.out.println();
        LinkedList2.printList();
        System.out.println("DELTEION AT POSITION");
        LinkedList2.deleteAtPos(1);
        LinkedList2.printList();
        System.out.println("delete last node");
        LinkedList2.deleteLast();
        LinkedList2.printList();
    }
}
/*
deleteElement(int data) ⚠️ NEEDS IMPROVEMENT

This is where your thinking is good but implementation became complicated.

You used:

count
second traversal
join

Meaning:
You solved it logically but not optimally.
Your Main Mistake

You are traversing the list TWO TIMES.

That is unnecessary.

Another BIG Problem

This code fails if deleting HEAD.

Example:

1 -> 2 -> 3
deleteElement(1)

What happens?

Your logic breaks because there is no previous node before head.

VERY IMPORTANT DSA LESSON 🔥
You currently think like this:
Find node → store count → traverse again → reconnect

Intermediate programmers think like this:
Keep previous pointer → reconnect immediately
That shift is important.
 */