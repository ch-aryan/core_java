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
    public void addFirst(int data){
        Nodee newhead = new Nodee(data);
        newhead.next = head;
        head = newhead;

    }
    public void addLast(int data){
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
    public int length(){
        int count = 0;
        Nodee curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    public void insertAt(int index, int data){
        Nodee newNode = new Nodee(data);
        if(index < 0){
            System.out.println("return invalid index");
            return;
        }
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }


        Nodee curr = head;
        int count = 0;
        while(curr!=null && count < index-1){
            curr = curr.next;
            count++;
        }
        if(curr == null){
            System.out.println("index out of bounds");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;


    }
    public boolean searchElmt(int data){
        Nodee curr = head;
        while(curr!= null){
            if(curr.data == data){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public int returnSearchElmtIndex(int data){
        Nodee curr = head;
        int index = 0;
        while(curr!=null){

            if(curr.data == data){
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }
    public int searchElemtAtindex(int index){
        Nodee curr = head;
        int count  = 0;
        while(curr!= null && count<index){
            curr = curr.next;
            count++;

        }
        return curr.data;


    }


    public void printList(){
        Nodee temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


}
class Ll{
    Nodee head;
    public static Nodee run(int[]arr){
        //Nodee newNode = new Nodee(arr[0]);
//        if(head==null){
//           Nodee head = new Nodee(arr[0]);
//            return;
//        }
        Nodee head = new Nodee(arr[0]);
        Nodee curr = head;

        for(int i=1;i<arr.length;i++){
            Nodee temp = new Nodee(arr[i]);
            curr.next = temp;
            curr = temp;
        }
        return head;
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
        list.addFirst(9);
        list.addLast(41);

        list.printList();
        System.out.println("");
        list.insertAt(3,99);
        list.printList();
        System.out.println();
      System.out.println( list.length() +" list length");
        System.out.println();
        System.out.println(list.searchElmt(99));
        System.out.println(list.returnSearchElmtIndex(99));
        System.out.println(list.searchElemtAtindex(4));

        System.out.println("***********");


        int arr[] = {14,24,19,15};
        Nodee head = Ll.run(arr);
      System.out.println(head.data+" start");
        Nodee tempp = head;
        while(tempp !=null){
            System.out.println(tempp.data);
            tempp = tempp.next;
        }


        ArrayList<Integer> arr1 = new ArrayList<>();
        LinkedList<Integer> Collectionlist = new LinkedList<>();
        Collectionlist.add(0,1);
        Collectionlist.add(1,40);
        Collectionlist.add(2,25);
        Collectionlist.add(3,1);
        Collectionlist.add(4,35);
        Collectionlist.add(3,14);
        System.out.println(Collectionlist);


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
/*
Absolutely, Aryan. Linked List becomes easy once you understand **what each reference is pointing to in memory**.
Let’s go slowly and visualize everything.

---

# Step 1 — What is a Linked List?

A linked list is a collection of nodes.

Each node contains:

1. Data
2. Address/reference of next node

Example:

```text id="4lhq3z"
[10 | next] -> [20 | next] -> [30 | next] -> null
```

* `10` stores data
* `next` stores address of next node
* last node points to `null`

---

# Step 2 — Understanding Node Class

Your code:

```java
class Nodee{
    int data;
    Nodee next;

    public Nodee(int data){
        this.data = data;
        this.next = null;
    }
}
```

---

## Line by Line

---

## `class Nodee`

```java
class Nodee
```

We are creating a blueprint for a node.

Every node will contain:

* data
* next reference

---

## `int data`

```java
int data;
```

Stores the value.

Example:

```text id="4ef9gk"
10
20
30
```

---

## `Nodee next`

```java
Nodee next;
```

This is VERY IMPORTANT.

This variable stores the reference/address of another node.

Example:

```text id="kl2pxz"
node1.next = node2
```

means:

```text id="b8zn7n"
node1 points to node2
```

---

## Constructor

```java
public Nodee(int data)
```

Whenever a new node is created, this constructor runs.

---

## `this.data = data`

```java
this.data = data;
```

Stores the passed value inside the node.

Example:

```java
Nodee n1 = new Nodee(10);
```

Now:

```text id="d78f25"
n1.data = 10
```

---

## `this.next = null`

```java
this.next = null;
```

Initially node points to nothing.

```text id="zj04s5"
[10 | null]
```

---

# Step 3 — LinkedList Class

```java
class LinkedList1 {

    Nodee head;
```

---

## What is head?

`head` stores the first node of linked list.

Example:

```text id="y77mn2"
head -> [10] -> [20] -> [30]
```

Without head we lose the entire list.

---

# Step 4 — add() Method

```java
public void add(int data)
```

This method inserts nodes.

---

# First Line

```java
Nodee newNode = new Nodee(data);
```

Suppose:

```java
add(10);
```

This creates:

```text id="v7s5q9"
[10 | null]
```

and `newNode` points to it.

---

# Step 5 — First Node Condition

```java
if(head == null){
    head = newNode;
    return;
}
```

---

## Why?

When list is empty:

```text id="g1f8b8"
head -> null
```

there is no node.

So first node becomes head.

After:

```java
head = newNode;
```

```text id="r2zmx0"
head -> [10 | null]
```

---

## Why return?

Because first node is already inserted.

No need to continue.

---

# Step 6 — Traversing the List

```java
Nodee curr = head;
```

We create a temporary pointer.

Suppose list:

```text id="e7jzrm"
head -> [10] -> [20] -> [30]
```

Now:

```text id="ll0dxt"
curr -> [10]
```

---

# Step 7 — while Loop

```java
while(curr.next != null)
```

Meaning:

"Move until last node."

---

# First Iteration

```text id="e01h3p"
curr -> 10
```

Is `curr.next` null?

No, because 10 points to 20.

So:

```java
curr = curr.next;
```

Now:

```text id="j1d1yy"
curr -> 20
```

---

# Second Iteration

20 points to 30.

Move again.

```text id="jlwm61"
curr -> 30
```

---

# Third Iteration

30 points to null.

Loop stops.

Now curr is at LAST NODE.

---

# Step 8 — Insert New Node

```java
curr.next = newNode;
```

Suppose newNode is 40.

Before:

```text id="32kx5e"
10 -> 20 -> 30 -> null
```

After:

```text id="21zv8j"
10 -> 20 -> 30 -> 40 -> null
```

---

# Step 9 — printList()

```java
public void printList(){
```

Used to print all nodes.

---

# Temporary Variable

```java
Nodee temp = head;
```

We NEVER move head directly.

Because if head moves:

```text id="q9n5tx"
head = head.next
```

we lose nodes forever.

So we use temp.

---

# while Loop

```java
while(temp != null)
```

Run until temp becomes null.

---

# Printing

```java
System.out.print(temp.data + " ");
```

Print current node value.

---

# Moving Forward

```java
temp = temp.next;
```

Move to next node.

---

# Complete Flow Visualization

---

## add(10)

```text id="4rj0lv"
head -> [10|null]
```

---

## add(20)

Traversal reaches 10.

```text id="xh88ua"
10.next = 20
```

Result:

```text id="0k5yfi"
head -> [10] -> [20]
```

---

## add(30)

Traversal:

10 → 20

20 is last.

```text id="kl5jzr"
20.next = 30
```

Result:

```text id="p2okv0"
head -> [10] -> [20] -> [30]
```
---
# Most Important Concept
In linked list:
```text id="77ryhc"
variables do NOT store nodes
variables store REFERENCES to nodes
```

Example:

```java
Nodee a = new Nodee(10);
Nodee b = a;
```

Both point to SAME node.

```text id="pr0wt4"
a ----\
       [10]
b ----/
```

That is the core concept of linked lists.

---

# One More Important Thing

This line:

```java
curr = curr.next;
```

does NOT copy node
It only changes the reference.
---
# Final Mental Model
Think like this:
```text id="0iy6xl"
head = starting address
next = address of next house
traversal = walking from house to house
```
That’s exactly how linked lists work internally.
//

//important debuging.
YESSS Aryan. Now you are asking the correct question.
This confusion comes to almost everyone learning linked lists for the first time.

Your confusion is mainly this:

> "How does `curr.next` suddenly know about another node?"
>
> and
>
> "When exactly are nodes getting connected?"

That is the REAL linked list concept.

Let’s go VERY slowly.

---

# Initially Empty List

```text id="dj1im8"
head -> null
```

No nodes exist.

---

# FIRST CALL

```java id="wkm2bd"
list.add(10);
```

---

# Step 1

```java id="sokokm"
Nodee newNode = new Nodee(10);
```

Creates:

```text id="m4l6qy"
[10 | null]
```

`newNode` points to this node.

---

# Step 2

```java id="1a9ibw"
if(head == null)
```

YES head is null.

So:

```java id="d9h48s"
head = newNode;
```

Now:

```text id="d8r7np"
head
 ↓
[10 | null]
```

IMPORTANT:

`10.next` is STILL NULL.

No second node exists yet.

---

# Step 3

```java id="0j5d3j"
return;
```

Method stops.

VERY IMPORTANT.

Nothing else runs.

---

# CURRENT LIST

```text id="4n4zlx"
head -> [10 | null]
```

---

# SECOND CALL

```java id="jlwmvs"
list.add(20);
```

NOW things become interesting.

---

# Step 1

```java id="9j45qx"
Nodee newNode = new Nodee(20);
```

Creates NEW SEPARATE node:

```text id="8a1g1g"
[20 | null]
```

NOT connected yet.

Right now:

```text id="up0x4p"
head -> [10 | null]

newNode -> [20 | null]
```

These are TWO separate nodes.

---

# Step 2

```java id="rcwn0g"
if(head == null)
```

NO.

Because head already points to 10.

So skip if block.

---

# Step 3

```java id="d0c7nq"
Nodee curr = head;
```

Now:

```text id="m6a79v"
curr
 ↓
[10 | null]
```

curr is just another pointer pointing to SAME node.

---

# NOW YOUR MAIN CONFUSION

You asked:

> "curr.next is null right?"

YESSSS.

At this moment:

```text id="gqem9j"
curr -> [10 | null]
```

So:

```java id="2h3f9m"
curr.next == null
```

TRUE.

---

# Then While Loop

```java id="0tv1qd"
while(curr.next != null)
```

becomes:

```java id="yfgj25"
while(null != null)
```

FALSE.

So loop DOES NOT RUN.

---

# Then THIS LINE RUNS

```java id="w2pwkg"
curr.next = newNode;
```

THIS IS THE MOST IMPORTANT LINE.

Currently:

```text id="q9h4v6"
curr -> [10 | null]

newNode -> [20 | null]
```

Now we change:

```text id="p29z4j"
10.next = address of 20
```

After connection:

```text id="m17p44"
head -> [10 | next] -> [20 | null]
```

NOW 10 knows about 20.

NOT before.

ONLY after:

```java id="6njywi"
curr.next = newNode;
```

---

# THIS IS THE KEY IDEA

Linked list nodes DO NOT automatically detect nearby nodes.

YOU manually connect them.

This line:

```java id="jlwm5g"
curr.next = newNode;
```

is literally saying:

> "10, from now on your next should point to 20."

---

# THIRD CALL

```java id="4v2cvq"
list.add(30);
```

---

# Step 1

Create node:

```text id="l83dc4"
[30 | null]
```

---

# Current List Before Insertion

```text id="gr2q13"
head -> [10] -> [20] -> null
```

---

# Step 2

```java id="9y6a72"
curr = head;
```

```text id="rk2qhh"
curr -> 10
```

---

# While Loop Check

```java id="km0kws"
curr.next != null
```

Does 10.next exist?

YES.

10 points to 20.

So loop runs.

---

# Move Forward

```java id="xptg2v"
curr = curr.next;
```

Now:

```text id="1e7lye"
curr -> 20
```

---

# Check Again

Does 20.next exist?

NO.

20.next = null.

Loop stops.

---

# Final Connection

```java id="u9p7zh"
curr.next = newNode;
```

Means:

```text id="sbr0o4"
20.next = 30
```

Result:

```text id="clwht3"
10 -> 20 -> 30 -> null
```

---

# MOST IMPORTANT UNDERSTANDING

This line:

```java id="97j2ys"
curr.next = newNode;
```

does NOT mean:

> "curr becomes newNode"

NO.

It means:

> "curr's next reference should store address of newNode"

---

# Real Visualization

Before:

```text id="mn6ztv"
[10 | address_of_20]

[20 | null]

[30 | null]
```

After:

```text id="s5evj6"
20.next = address_of_30
```

Now:

```text id="q0fwbp"
[10 | address_of_20]
[20 | address_of_30]
[30 | null]
```

---

# Biggest Beginner Confusion

Most beginners think:

```java id="yqon0d"
curr = curr.next;
```

changes the list.

NO.

It only moves the temporary pointer.

The ACTUAL list changes ONLY when:


curr.next = newNode;


runs.

THAT is the line connecting nodes.


 */
/* addFirst and addLast.
Yes, Aryan — your `addFirst()` method is absolutely correct ✅

Your code:

```java
public void addFirst(int data){
    Nodee newhead = new Nodee(data);
    newhead.next = head;
    head = newhead;
}
```

works perfectly for inserting a node at the beginning of a singly linked list.

---

# Let’s Understand Line by Line

Suppose current list is:

```text
head -> 10 -> 20 -> 30 -> null
```

Now you call:

```java
addFirst(5);
```

---

# Step 1

```java
Nodee newhead = new Nodee(data);
```

Creates:

```text
newhead -> [5 | null]
```

---

# Step 2

```java
newhead.next = head;
```

This is the MOST IMPORTANT step.

Currently:

```text
head -> 10 -> 20 -> 30
```

So:

```java
newhead.next = head;
```

means:

```text
5.next = 10
```

Now:

```text
newhead -> 5 -> 10 -> 20 -> 30
```

But head is STILL pointing to 10.

---

# Step 3

```java
head = newhead;
```

Now head starts pointing to 5.

Final list:

```text
head -> 5 -> 10 -> 20 -> 30 -> null
```

---

# Why This Works

You first connect the new node to old list:

```java
newhead.next = head;
```

Then shift head.

If you reversed the order:

```java
head = newhead;
newhead.next = head;
```

then:

```text
5 -> 5 -> 5
```

because head already changed.

So your order is correct.

---

# One Small Naming Suggestion

Instead of:

```java
Nodee newhead
```

usually developers write:

```java
Nodee newNode
```

because it is a node, not actually the head.

Cleaner version:

```java
public void addFirst(int data){
    Nodee newNode = new Nodee(data);
    newNode.next = head;
    head = newNode;
}
```

---

# Special Case — Empty List

Suppose:

```text
head -> null
```

Now:

```java
addFirst(10);
```

Step:

```java
newNode.next = head;
```

means:

```text
10.next = null
```

Then:

```java
head = newNode;
```

Result:

```text
head -> 10 -> null
```
So it works for BOTH:
* empty list
* non-empty list
That’s why this is the standard implementation of `addFirst()`.
Your logic is almost correct, Aryan — but there is one important missing case.

Your code:

```java id="w0j17j"
public void addLast(int data){
    Nodee newNode = new Nodee(data);
    Nodee curr = head;

    while(curr.next!=null){
        curr = curr.next;
    }

    curr.next = newNode;
}
```

works only when the list already has nodes.

---

# Problem — Empty List Case

Suppose:

```text id="th2z8e"
head -> null
```

Now you call:

```java id="0phdln"
addLast(10);
```

---

# What Happens?

```java id="u5fd5s"
Nodee curr = head;
```

So:

```text id="8ovzvl"
curr = null
```

Now this line runs:

```java id="l7p4hq"
while(curr.next != null)
```

BUT:

```text id="u9kmf9"
curr is null
```

So Java tries:

```java id="x8w5xu"
null.next
```

which causes:

```text id="jlwmzc"
NullPointerException
```

---

# Correct Version

You must handle empty list first.

```java id="m8k1bw"
public void addLast(int data){

    Nodee newNode = new Nodee(data);

    if(head == null){
        head = newNode;
        return;
    }

    Nodee curr = head;

    while(curr.next != null){
        curr = curr.next;
    }

    curr.next = newNode;
}
```

---

# Flow Understanding

Suppose:

```text id="izvw6z"
head -> 10 -> 20 -> 30 -> null
```

Now:

```java id="q9frpy"
addLast(40);
```

---

# Step 1

Create:

```text id="u5pdq0"
[40 | null]
```

---

# Step 2

```java id="k8nv2z"
curr = head;
```

```text id="08uk8z"
curr -> 10
```

---

# Step 3 — Traversal

Move:

```text id="jlwmob"
10 -> 20 -> 30
```

Loop stops at 30 because:

```text id="91m49v"
30.next == null
```

---

# Step 4

```java id="zmr9i7"
curr.next = newNode;
```

means:

```text id="ic3mv5"
30.next = 40
```

Final:

```text id="h6dldu"
10 -> 20 -> 30 -> 40 -> null
```

---

# One More Important Thing

Your original `add()` method and `addLast()` method are actually doing the same thing.

Both insert at end.

So usually developers keep only one method:

* either `add()`
* or `addLast()`

because both mean:

> "insert at tail/end of list"

 */