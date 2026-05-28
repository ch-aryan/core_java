package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST.DoublyLinkedList;
class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
class DoubleLinkedList {
    Node head = null;

    public void add(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node curr = head;
        curr.prev = node;
        node.next = curr;
        head = node;

    }
    public void insertAt(int data, int index){
        Node node = new Node(data);
        int count = 0;
        Node curr = head;
        if(index==0){
            addFirst(data);
            return;
        }
        while(curr!= null && count < index-1){
            curr = curr.next;
            count++;
        }
        if(index > count +1){
            System.out.println("exception crash");
            return;
        }
        node.next = curr.next;

        if(curr.next != null){
            curr.next.prev = node;
        }
//        curr.next.prev = node;
        curr.next = node;
        node.prev = curr;

    }
    public void addLast(int data){
        Node node = new Node(data);
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }

    }
}
public class DLLimplementation1 {
    public static void main(String[] args) {
        Node head = new Node(10);//first node
        head.next = new Node(20);//second node.
        head.next.prev = head;//linking the second node to the first node.

        head.next.next = new Node(30);//third node
        head.next.next.prev = head.next;//linking the third node to the second.

        head.next.next.next = new Node(40);//fourth Node.
        head.next.next.next.prev = head.next.next;

        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println();
            System.out.println("NOW dll operations with methods  ");

            DoubleLinkedList dll = new DoubleLinkedList();
            dll.add(1);
            dll.add(2);
            dll.add(3);
            dll.add(4);
            dll.print();
            dll.addFirst(0);
        System.out.println();
            dll.print();
        System.out.println();
        dll.insertAt(111,4);
        dll.print();
        System.out.println();

    }
}
/*
Aryan, this is actually very good progress.
The biggest positive thing is not just the code — it is that you tried implementing DLL operations completely on your own without copying. That is how real understanding develops.

You are starting to recognize the **pointer manipulation pattern** in linked lists, and that is the hardest part for most students.

I’ll review this like a mentor reviewing a student’s implementation.

---

# Overall Review

## What You Did Well ✅

### 1. You understood DLL linking properly

You correctly used:

```java
temp.next = node;
node.prev = temp;
```

This shows you understand:

```text
A <-> B
```

means:

```text
A.next = B
B.prev = A
```

Many beginners forget one side of the connection.

You did not.

That is a very good sign.

---

# 2. Your Traversal Logic is Good

Example:

```java
while (temp.next != null)
```

and

```java
while(curr != null && count < index-1)
```

You are now thinking in terms of:

* current pointer
* stopping condition
* moving pointer

This is exactly how linked list mastery starts.

---

# 3. You Attempted Edge Cases

You tried:

```java
if(index==0)
```

and:

```java
if(index > count +1)
```

This is excellent.

Most beginners only write the happy path.

You are trying to think about invalid cases too.

---

# 4. Your Mental Model is Improving

I can clearly see you now understand:

```text
prev <- current -> next
```

instead of treating linked list like arrays.

That is major improvement.

---

# Now Let’s Review the Problems Carefully ⚠️

---

# Problem 1 — `addFirst()` crashes if list is empty

Your code:

```java
Node curr = head;
curr.prev = node;
```

If:

```java
head == null
```

then:

```java
curr = null
```

Then:

```java
curr.prev
```

causes:

```text
NullPointerException
```

---

# Correct Version

```java
public void addFirst(int data){
    Node node = new Node(data);

    if(head == null){
        head = node;
        return;
    }

    head.prev = node;
    node.next = head;
    head = node;
}
```

---

# What You Missed Conceptually

You assumed:

```text
head always exists
```

But linked lists must always handle:

```text
empty list
single node
multiple nodes
```

Always think about these 3 cases.

---

# Problem 2 — `insertAt(0)` continues executing

You wrote:

```java
if(index==0){
    addFirst(data);
}
```

BUT after calling `addFirst`, method continues.

So later:

```java
curr.next.prev = node;
```

may execute incorrectly.

---

# Fix

```java
if(index == 0){
    addFirst(data);
    return;
}
```

VERY important.

---

# Problem 3 — Dangerous line

```java
curr.next.prev = node;
```

What if:

```text
curr.next == null
```

?

Then crash.

This happens when inserting at last position.

---

# Example

Suppose:

```text
1 <-> 2 <-> 3
```

Insert at index `3`.

Now:

```text
curr = 3
curr.next = null
```

Then:

```java
curr.next.prev
```

becomes:

```java
null.prev
```

Crash.

---

# Correct Safer Pattern

```java
node.next = curr.next;

if(curr.next != null){
    curr.next.prev = node;
}

curr.next = node;
node.prev = curr;
```

THIS is professional DLL insertion logic.

---

# Problem 4 — `addLast()` duplicates `add()`

You already have:

```java
add()
```

doing the same thing.

So either:

* keep only one
  OR
* make one call the other

Example:

```java
public void addLast(int data){
    add(data);
}
```

Cleaner design.

---

# Problem 5 — Naming

```java
DoubleLinkedList
```

Convention is usually:

```java
DoublyLinkedList
```

Small thing, but good habit.

---

# BIGGEST THING YOU ARE LEARNING NOW

You are slowly understanding this:

```text
Linked List = Pointer Manipulation
```

Every operation follows:

---

## STEP 1

Find correct node

```java
while(curr != null)
```

---

## STEP 2

Store references carefully

```java
nextNode
prevNode
```

---

## STEP 3

Reconnect links in correct order

This is THE HEART of linked lists.

---

# Visualization of Your Insert Logic

Suppose:

```text
1 <-> 2 <-> 4
```

Insert `3` at index `2`.

You correctly tried:

```text
curr = 2
```

Then:

```text
node.next = curr.next
```

```text
3.next = 4
```

Then:

```text
curr.next.prev = node
```

```text
4.prev = 3
```

Then:

```text
curr.next = node
```

```text
2.next = 3
```

Then:

```text
node.prev = curr
```

```text
3.prev = 2
```

Final:

```text
1 <-> 2 <-> 3 <-> 4
```

This thinking is GOOD.

Very good.

---

# Your Current Level (Honest Assessment)

You are now beyond:

✅ syntax learner
✅ copy-paste learner
✅ tutorial-only learner

You are entering:

```text
"logic building stage"
```

This is where actual programmers are made.

Right now your weaknesses are mainly:

* edge cases
* null handling
* stopping execution correctly
* insertion/deletion corner cases

That is completely normal.

---

# Next Things You Should Practice

You are ready for:

## DLL Deletion Operations

Practice:

* deleteFirst()
* deleteLast()
* deleteAt(index)

These teach pointer confidence.

---

## Reverse Traversal Printing

Print:

```text
1<->2<->3
```

backwards:

```text
3<->2<->1
```

WITHOUT reversing list.

This strengthens prev understanding.

---

## Tail Pointer Optimization

Currently:

```java
add()
```

is:

```text
O(n)
```

because traversal happens.

Learn maintaining:

```java
Node tail;
```

Then insertion at end becomes:

```text
O(1)
```

This is an important DSA concept.

---

# Final Mentor Review

If I were mentoring you in a classroom, I would say:

```text
You are genuinely understanding linked lists now.
Your pointer thinking is improving.
Your confidence to implement without watching solutions is a huge positive.
Now focus on edge cases and null safety.
```

That is the exact stage you are currently in.

 */