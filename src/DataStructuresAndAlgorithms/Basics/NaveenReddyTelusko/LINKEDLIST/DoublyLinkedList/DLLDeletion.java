package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST.DoublyLinkedList;
class Node1{
    int data;
    Node1 prev;
    Node1 next;
    public Node1(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
class DoublyLinkedList{
    Node1 head;
    public void add(int data){
        Node1 node = new Node1(data);
        if(head == null){
            head = node;
            return;
        }
        Node1 curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;
    }
    public void deleteHead(){
        if(head == null){
            return;//to avoid crash if head is null
        }

        if(head.next == null) {
            head = null;//to avoid crash if i have single element.Important Concept
            return;/*         Always think:
                                EMPTY LIST
                                 ONE NODE
                                 MULTIPLE NODES
                                  This is becoming your next growth area.*/
        }
        Node1 curr = head;
        curr.next.prev  = null;
        head = curr.next;
        curr.next = null;
    }
    public void deleteLast(){
        Node1 curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next.prev = null;
        curr.next = null;

    }
    public void deleteKthNode(int index){
        Node1 curr = head;
        int count = 0;
        while(curr.next.next != null && count< index-1){
            curr = curr.next;
            count++;
        }
        curr.next = curr.next.next;
        curr.next.prev = curr;
    }

    public void print(){
        Node1 temp = head;
        while(temp!= null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
    }
}

public class DLLDeletion {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print();
        System.out.println("delete head");
        list.deleteHead();
        list.print();
        System.out.println();
        list.add(8);
        list.add(9);
        list.print();
        System.out.println();
        list.deleteLast();
        list.print();
        System.out.println();
        list.deleteKthNode(2);
        list.print();

   }
}
/*
public void deleteKthNode(int index){

    if(head == null){
        return;
    }

    if(index == 0){
        deleteHead();
        return;
    }

    Node1 curr = head;
    int count = 0;

    while(curr != null && count < index-1){
        curr = curr.next;
        count++;
    }

    if(curr == null || curr.next == null){
        System.out.println("Invalid index");
        return;
    }

    // deleting last node
    if(curr.next.next == null){
        curr.next.prev = null;
        curr.next = null;
        return;
    }

    curr.next = curr.next.next;
    curr.next.prev = curr;
}
 */
/*
Aryan, this is solid progress.
You are now thinking like someone who is actually learning data structures properly instead of memorizing code.

Deletion operations in doubly linked lists are harder than insertion because now you must carefully disconnect links without breaking the chain.

And honestly — your core logic direction is correct.

You understand the important idea:

```text
To delete a node:
1. Reach the node
2. Reconnect surrounding nodes
3. Remove references
```

That is the real understanding.

Now let’s deeply review your code like a mentor.

---

# Overall Review

Your strengths are now clearly visible:

✅ Good traversal logic
✅ Good understanding of `prev` and `next` manipulation
✅ You know how reconnection works
✅ You are attempting operations yourself
✅ You are no longer afraid of pointers

This is BIG improvement.

---

# 1. `deleteHead()` Review

Your code:

```java
public void deleteHead(){
    Node1 curr = head;
    curr.next.prev  = null;
    head = curr.next;
    curr.next = null;
}
```

---

# What You Did Correct ✅

You correctly understood:

```text
Old Head <-> New Head
```

To remove old head:

```text
newHead.prev = null
head = newHead
```

Excellent.

---

# Problem ⚠️

This crashes for:

---

## Case 1 — Empty List

If:

```java
head == null
```

Then:

```java
curr.next
```

crashes.

---

## Case 2 — Single Node List

Suppose:

```text
1
```

Then:

```java
curr.next == null
```

So:

```java
curr.next.prev
```

becomes:

```java
null.prev
```

Crash.

---

# Correct Professional Version

```java
public void deleteHead(){

    if(head == null){
        return;
    }

    if(head.next == null){
        head = null;
        return;
    }

    Node1 curr = head;

    head = curr.next;
    head.prev = null;

    curr.next = null;
}
```

---

# Important Concept

Always think:

```text
EMPTY LIST
ONE NODE
MULTIPLE NODES
```

This is becoming your next growth area.

---

# 2. `deleteLast()` Review

Your code:

```java
while(curr.next.next != null){
    curr = curr.next;
}
```

This is actually smart.

Why?

Because you intentionally stop at:

```text
second last node
```

Example:

```text
1 <-> 2 <-> 3 <-> 4
                ^
              curr
```

Very good thinking.

---

# Your Deletion Logic

```java
curr.next.prev = null;
curr.next = null;
```

This is conceptually correct.

You disconnected:

```text
3 <-> 4
```

into:

```text
3    4
```

Excellent understanding.

---

# Problems ⚠️

Again:

---

## Empty List

```java
head == null
```

Crash.

---

## Single Node

Suppose:

```text
1
```

Then:

```java
curr.next
```

is null.

So:

```java
curr.next.next
```

crashes.

---

# Correct Version

```java
public void deleteLast(){

    if(head == null){
        return;
    }

    if(head.next == null){
        head = null;
        return;
    }

    Node1 curr = head;

    while(curr.next.next != null){
        curr = curr.next;
    }

    curr.next.prev = null;
    curr.next = null;
}
```

---

# 3. `deleteKthNode()` Review

This one is interesting.

You are VERY close to understanding generalized deletion.

That is advanced beginner level.

---

# Your Logic

```java
curr.next = curr.next.next;
curr.next.prev = curr;
```

This is exactly the core DLL deletion pattern.

You are understanding surrounding-node reconnection.

That is GOOD.

---

# Visualization

Suppose:

```text
1 <-> 2 <-> 3 <-> 4
```

Delete `3`.

You reach:

```text
curr = 2
```

Then:

```java
curr.next = curr.next.next;
```

means:

```text
2.next = 4
```

Then:

```java
curr.next.prev = curr;
```

means:

```text
4.prev = 2
```

Final:

```text
1 <-> 2 <-> 4
```

PERFECT conceptually.

---

# Problems ⚠️

---

## 1. Deleting first node not handled

If:

```java
index == 0
```

your code fails.

---

## 2. Last node deletion issue

Suppose deleting tail.

Then:

```java
curr.next.next
```

becomes null.

Then:

```java
curr.next.prev
```

crashes.

---

## 3. Invalid index handling missing

If index too large:

```java
curr.next
```

may become null.

Crash.

---

# Better Version

```java
public void deleteKthNode(int index){

    if(head == null){
        return;
    }

    if(index == 0){
        deleteHead();
        return;
    }

    Node1 curr = head;
    int count = 0;

    while(curr != null && count < index-1){
        curr = curr.next;
        count++;
    }

    if(curr == null || curr.next == null){
        System.out.println("Invalid index");
        return;
    }

    // deleting last node
    if(curr.next.next == null){
        curr.next.prev = null;
        curr.next = null;
        return;
    }

    curr.next = curr.next.next;
    curr.next.prev = curr;
}
```

---

# Biggest Improvement I See In You

Earlier you were writing code like:

```text
"let me somehow make it work"
```

Now you are thinking:

```text
"What links should connect before and after deletion?"
```

THIS is the real shift.

That is actual DSA thinking.

---

# One Important Thing You Still Need

You are still weak at:

```text
Boundary Conditions
```

Meaning:

* empty list
* single node
* deleting first
* deleting last
* invalid index

This is the next skill you must deliberately practice.

---

# Golden Rule for Linked Lists

Whenever writing any operation, ask:

```text
1. What if list is empty?
2. What if only one node?
3. What if deleting/inserting first node?
4. What if deleting/inserting last node?
5. What if invalid position?
```

Professional developers automatically think this way.

You are approaching that stage.

---

# Your Current DSA Level

Honestly?

You are now entering:

```text
Intermediate Beginner
```

Why?

Because:

✅ You understand pointer movement
✅ You understand node linking
✅ You can implement without tutorial
✅ You can visualize structure
✅ You are debugging mentally

These are very important signs.

---

# Next Best Practice For You

Now practice these:

---

## 1. Reverse Print DLL

Using `prev`.

---

## 2. Reverse Entire DLL

This is a GREAT pointer exercise.

---

## 3. Circular Doubly Linked List

This will test your understanding deeply.

---

## 4. Tail Pointer

Maintain:

```java
Node tail;
```

This will improve your design thinking.

---

# Final Mentor Feedback

If I were your DSA instructor, I would say:

```text
Your fundamentals are becoming strong.
You now understand how nodes are connected and manipulated.
Your biggest weakness is edge-case handling, not logic.
That is a very good sign because edge cases improve naturally with practice.
```

And the best part:

You are genuinely learning by thinking.
That matters much more than memorizing “perfect” code.

 */