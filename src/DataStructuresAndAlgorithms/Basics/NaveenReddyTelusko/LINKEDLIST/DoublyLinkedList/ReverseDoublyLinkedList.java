package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST.DoublyLinkedList;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        /* Structure of doubly linked list node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
        class Solution {
            public Node reverse(Node head) {
                // code here
                if(head == null || head.next == null ) return head;
                Node curr = head;
                Node back = null;


                while(curr!= null){
                    back = curr.prev;
                    curr.prev = curr.next;
                    curr.next = back;

                    curr = curr.prev;
                }
                head = back.prev;

                return head;
            }
        }
    }
}
/*
Aryan, this is one of the BEST moments in learning linked lists.

Because this confusion means your brain is trying to understand actual pointer manipulation deeply. Reverse of doubly linked list feels confusing initially for almost everyone.

The good thing is:
you already understand insertion and deletion.
Now this reverse algorithm will connect many concepts together.

Let’s go VERY slowly.

---

# First Understand the Main Idea

Suppose original DLL is:

```text id="m9h5r9"
1 <-> 2 <-> 3
```

---

# What Does Reverse Mean?

After reversing:

```text id="upv1qj"
3 <-> 2 <-> 1
```

Now think carefully.

---

# Original Connections

For node `2`:

```text id="k0y6pq"
prev = 1
next = 3
```

After reversing:

```text id="v9gdq8"
prev = 3
next = 1
```

NOTICE SOMETHING IMPORTANT:

```text id="wz8d3x"
prev and next are swapped
```

THAT is the entire algorithm.

---

# Entire Reverse Logic in One Sentence

```text id="jlwmwb"
For every node:
swap prev and next
```

That’s all.

---

# Let’s Understand the Code Slowly

---

# Initial DLL

```text id="j7f9od"
null <- 1 <-> 2 <-> 3 -> null
```

---

# Initial Variables

```java id="n7xwvv"
Node currNode = head;
Node prevNode = null;
```

So:

```text id="6ztj7s"
currNode = 1
prevNode = null
```

---

# LOOP STARTS

```java id="r9q0a5"
while(currNode != null)
```

---

# ITERATION 1

Current node:

```text id="6ngp6h"
currNode = 1
```

Visualize node 1:

```text id="c0r6di"
null <- 1 -> 2
```

Meaning:

```text id="2d0dyl"
1.prev = null
1.next = 2
```

---

# STEP 1

```java id="n1u1y2"
prevNode = currNode.prev;
```

So:

```text id="mz0ggs"
prevNode = null
```

---

# STEP 2

```java id="xfy7ol"
currNode.prev = currNode.next;
```

Means:

```java id="c3dtdf"
1.prev = 2
```

Now node becomes:

```text id="7aibj7"
2 <- 1 -> 2
```

Looks weird temporarily.

That is okay.

---

# STEP 3

```java id="r0q3dl"
currNode.next = prevNode;
```

Means:

```java id="n44dx7"
1.next = null
```

Now node 1 becomes:

```text id="g3r57l"
2 <- 1 -> null
```

Node 1 is now reversed.

---

# STEP 4

```java id="x7v6lo"
currNode = currNode.prev;
```

IMPORTANT.

Remember:

```text id="qxttgd"
currNode.prev was changed to original next
```

So:

```java id="p24x3w"
currNode = 2
```

We move forward in original list.

---

# AFTER ITERATION 1

Node states:

```text id="e70dbw"
1:
prev = 2
next = null
```

Current:

```text id="7x9grx"
currNode = 2
```

---

# ITERATION 2

Current node:

```text id="r1y81h"
1 <- 2 -> 3
```

---

# STEP 1

```java id="g7uqq2"
prevNode = currNode.prev;
```

Currently:

```java id="y9cb77"
2.prev = 1
```

So:

```text id="htj80n"
prevNode = 1
```

---

# STEP 2

```java id="b8t4p6"
currNode.prev = currNode.next;
```

Means:

```java id="s9i9dl"
2.prev = 3
```

---

# STEP 3

```java id="wrlm0x"
currNode.next = prevNode;
```

Means:

```java id="0okx04"
2.next = 1
```

Now node 2 becomes:

```text id="gjlwmz"
3 <- 2 -> 1
```

PERFECT reversed direction.

---

# STEP 4

```java id="mjlwm7"
currNode = currNode.prev;
```

Now:

```java id="8xpwga"
currNode = 3
```

---

# ITERATION 3

Current node:

```text id="p2g4vd"
2 <- 3 -> null
```

---

# STEP 1

```java id="s1l2hx"
prevNode = currNode.prev;
```

```text id="6y46u0"
prevNode = 2
```

---

# STEP 2

```java id="ihh97e"
currNode.prev = currNode.next;
```

```java id="4ej5m0"
3.prev = null
```

---

# STEP 3

```java id="1p4n1t"
currNode.next = prevNode;
```

```java id="21yq2x"
3.next = 2
```

Now node becomes:

```text id="0v0xqj"
null <- 3 -> 2
```

---

# STEP 4

```java id="ctc84k"
currNode = currNode.prev;
```

But:

```java id="jlwm5m"
3.prev = null
```

So:

```text id="w7v8ur"
currNode = null
```

Loop ends.

---

# FINAL STRUCTURE

```text id="n27o0u"
3 <-> 2 <-> 1
```

DONE.

---

# MOST CONFUSING LINE

You were probably confused by:

```java id="p6slvj"
currNode = currNode.prev;
```

WHY PREV??

Because after swapping:

```text id="64mgfj"
prev now points to original next
```

VERY IMPORTANT.

---

# SIMPLE MEMORY TRICK

During reversal:

```text id="l6kv2v"
prev becomes next
next becomes prev
```

So after swapping:

```text id="jpbq5d"
moving to prev actually means moving forward
```

This is the key understanding.

---

# Final Line

```java id="qmswq2"
head = prevNode.prev;
```

This looks scary but simple.

At loop end:

```text id="g98v4z"
prevNode = 2
```

And:

```java id="bzga1x"
2.prev = 3
```

So:

```java id="s7n0ek"
head = 3
```

New head found.

---

# Easier Cleaner Version

Honestly, many people write it like this because it is easier to understand:

```java id="qyc3dw"
static Node reverse(Node head){

    Node curr = head;
    Node temp = null;

    while(curr != null){

        temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;

        curr = curr.prev;
    }

    if(temp != null){
        head = temp.prev;
    }

    return head;
}
```

Same logic, slightly cleaner naming.

---

# REAL CORE IDEA

Do NOT memorize code.

Just remember:

# Reverse DLL Means

```text id="j1z8zk"
For every node:
swap prev and next
```

That is ALL.

Everything else is just traversal management.

---

# Your Current Learning Stage

You are now entering the important stage where:

```text id="h0t6k3"
you can read pointer algorithms and mentally simulate them
```

That is huge progress in DSA.

Most students quit before this stage because pointer visualization feels difficult initially.

You are doing well by asking and trying to deeply understand.

 */