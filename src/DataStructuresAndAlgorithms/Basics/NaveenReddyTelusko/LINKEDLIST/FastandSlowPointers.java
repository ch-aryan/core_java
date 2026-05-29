package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;
//hare and tortoise algorithm.
/*Middle Node in a Linked List
Last Updated : 28 Aug, 2025
Given the head of singly linked list, find middle node of the linked list.
If the number of nodes is odd, return the middle node.
If the number of nodes is even, there are two middle nodes, so return the second middle node.*/
public class FastandSlowPointers {
    public static int bruteForce(Node head){
        Node curr = head;
        int count = 0;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        int mid = count/2;
        curr = head;
        int i =0;
        while(i<mid){
            curr = curr.next;
            i++;
        }
        return curr.data;
    }
    public static int fastAndSlowPoint(Node head){
        Node fastP = head;
        Node slowP = head;

        while(fastP != null && fastP.next != null){
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        return slowP.data;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(bruteForce(head));
        System.out.println(fastAndSlowPoint(head));
    }
}
/*
[Expected Approach] Hare and Tortoise Algorithm - O(n) Time and O(1) Space
We can use the Tortoise and Hare algorithm to find the middle of the linked list.
Initialize both slow and fast pointers at the head.
Move slow by one step and fast by two steps each iteration.
When fast reaches the end (or null), slow will be at the middle.
For even nodes, slow automatically ends at the second middle.

Absolutely Aryan. This is one of the most important things to understand when learning the **slow-fast pointer technique**.

Let's focus ONLY on this condition:

```java
while (fastptr != null && fastptr.next != null)
```

and understand exactly **which becomes null and when**.

---

# Example 1: Odd Length List

```text
1 -> 2 -> 3 -> 4 -> 5 -> null
```

Initial:

```text
slow = 1
fast = 1
```

---

## Iteration 1

Condition:

```java
fast != null        ✓ (1 exists)
fast.next != null   ✓ (2 exists)
```

Enter loop.

Move:

```java
slow = slow.next;
fast = fast.next.next;
```

Result:

```text
slow = 2
fast = 3
```

Visual:

```text
1 -> 2 -> 3 -> 4 -> 5
     S    F
```

---

## Iteration 2

Check:

```java
fast != null        ✓ (3 exists)
fast.next != null   ✓ (4 exists)
```

Enter.

Move:

```text
slow = 3
fast = 5
```

Visual:

```text
1 -> 2 -> 3 -> 4 -> 5
          S         F
```

---

## Iteration 3

Check:

```java
fast != null        ✓ (5 exists)
fast.next != null   ✗ (5.next is null)
```

Visual:

```text
1 -> 2 -> 3 -> 4 -> 5 -> null
                    F
```

Here:

```text
fast = Node(5)
fast.next = null
```

Condition fails.

Loop stops.

Final:

```text
slow = 3
```

Middle found.

---

# Important Observation

For odd length:

```text
fast is NOT null
fast.next becomes null
```

Loop stops because:

```java
fast.next != null
```

becomes false.

---

# Example 2: Even Length List

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
```

Initial:

```text
slow = 1
fast = 1
```

---

## Iteration 1

Move:

```text
slow = 2
fast = 3
```

---

## Iteration 2

Move:

```text
slow = 3
fast = 5
```

Visual:

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6
          S         F
```

---

## Iteration 3

Check:

```java
fast != null        ✓ (5 exists)
fast.next != null   ✓ (6 exists)
```

Enter.

Move:

```java
fast = fast.next.next;
```

From node 5:

```text
5 -> 6 -> null
```

So:

```text
fast = null
```

Result:

```text
slow = 4
fast = null
```

Visual:

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
               S
```

---

## Next Check

```java
fast != null
```

becomes:

```text
null != null
```

False.

Loop stops.

---

# Important Observation

For even length:

```text
fast itself becomes null
```

Loop stops because:

```java
fast != null
```

becomes false.

---

# Why Two Conditions?

Suppose we only write:

```java
while(fast != null)
```

Inside loop:

```java
fast = fast.next.next;
```

Imagine:

```text
1 -> 2 -> null
```

and

```text
fast = 2
```

Now:

```java
fast.next.next
```

tries to access:

```text
null.next
```

CRASH 💥

NullPointerException.

---

That's why we first verify:

```java
fast.next != null
```

before attempting:

```java
fast.next.next
```

---

# Quick Memory Trick

### Odd Number of Nodes

```text
1 -> 2 -> 3 -> 4 -> 5 -> null
                    F
```

Loop stops because:

```text
fast.next = null
```

---

### Even Number of Nodes

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
```

Fast jumps:

```text
5 -> null
```

Loop stops because:

```text
fast = null
```

---

# Visualization Summary

### 5 Nodes

```text
1 -> 2 -> 3 -> 4 -> 5 -> null
                    F

fast      = Node(5)
fast.next = null
```

Condition fails on:

```java
fast.next != null
```

---

### 6 Nodes

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

fast jumps:

5 -> null
```

Now:

```text
fast = null
```

Condition fails on:

```java
fast != null
```

---

Whenever you see:

```java
while (fast != null && fast.next != null)
```

read it in plain English as:

> "Keep moving as long as Fast exists and Fast can still take two steps ahead safely."

That's the entire idea behind the condition.

 */