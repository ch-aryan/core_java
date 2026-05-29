package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.LINKEDLIST;

import java.util.List;

class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //YOUR CODE GOES HERE
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        int sum =  0;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1!=null){
                sum = sum + l1.data;
            }
            if(l2 != null){
                sum = sum + l2.data;
            }
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = node;

            curr = curr.next;
            if(l1!= null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }



        }
        if(carry >0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }
}
public class AddTwoNumbersReverseOrderStrivers6 {
    public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);

    ListNode node2 = new ListNode(3);
    node2.next = new ListNode(2);
    node2.next.next = new ListNode(1);

        ListNode listNode = Solution.addTwoNumbers(node, node2);
        while(listNode!=null){
            System.out.print(listNode.data);
            listNode = listNode.next;
        }


    }
}
/*
Aryan, your overall approach is **absolutely correct**. In fact, this is the standard optimal solution for the "Add Two Numbers" linked list problem.

There are just a few mistakes and small improvements.

---

## ❌ Mistake 1: Invalid `if(l1)` and `if(l2)`

In Java, you cannot write:

```java
if(l1){
    l1 = l1.next;
}
```

because `l1` is a `ListNode` object, not a boolean.

You must write:

```java
if(l1 != null){
    l1 = l1.next;
}
if(l2 != null){
    l2 = l2.next;
}
```

---

## ❌ Mistake 2: Loop condition

Your loop is:

```java
while(l1 != null || l2 != null)
```

This works for most cases.

But consider:

```
l1 = [9]
l2 = [9]
```

### Dry Run

```
9 + 9 = 18

digit = 8
carry = 1
```

Now:

```
l1 = null
l2 = null
carry = 1
```

Loop stops.

Then you are handling carry separately:

```java
if(carry > 0){
    curr.next = new ListNode(carry);
}
```

So your code still works.

---

### Better Approach

Many interviewers write:

```java
while(l1 != null || l2 != null || carry != 0)
```

Then the carry is handled inside the loop itself.

Example:

```java
while(l1 != null || l2 != null || carry != 0)
```

This removes the need for:

```java
if(carry > 0)
```

after the loop.

Your approach is still correct though.

---

## ✅ Good Thing 1: Dummy Node

```java
ListNode dummy = new ListNode(-1);
```

Excellent.

This avoids special handling for the first node.

Visualization:

```text
dummy(-1)
   |
   v
 null
```

After first digit:

```text
dummy(-1)
   |
   v
   9
```

At the end:

```java
return dummy.next;
```

returns the actual answer.

---

## ✅ Good Thing 2: Carry Handling

```java
sum = carry;
```

Very good.

Then:

```java
sum += l1.data;
sum += l2.data;
```

Example:

```
carry = 1
l1 = 5
l2 = 8

sum = 1 + 5 + 8
    = 14
```

Then:

```java
digit = 14 % 10 = 4
carry = 14 / 10 = 1
```

Perfect.

---

## ✅ Good Thing 3: Creating New Node

```java
ListNode node = new ListNode(sum % 10);
```

Correct.

Example:

```
sum = 17

17 % 10 = 7
```

Node stores:

```text
7
```

Carry becomes:

```
17 / 10 = 1
```

---

# Visual Dry Run

Suppose:

```text
l1 = [2,4,3]
l2 = [5,6,4]
```

These represent:

```text
342
465
```

---

### Iteration 1

```text
2 + 5 + 0
= 7
```

Create:

```text
7
```

Carry:

```text
0
```

Result:

```text
dummy -> 7
```

---

### Iteration 2

```text
4 + 6 + 0
= 10
```

Create:

```text
0
```

Carry:

```text
1
```

Result:

```text
dummy -> 7 -> 0
```

---

### Iteration 3

```text
3 + 4 + 1
= 8
```

Create:

```text
8
```

Result:

```text
dummy -> 7 -> 0 -> 8
```

Return:

```text
7 -> 0 -> 8
```

which represents:

```text
807
```

Correct because:

```text
342 + 465 = 807
```

---

# Review as your teacher

For a student who is learning linked lists, I would give this:

| Area             | Rating |
| ---------------- | ------ |
| Dummy Node Usage | ⭐⭐⭐⭐⭐  |
| Carry Logic      | ⭐⭐⭐⭐⭐  |
| Traversal        | ⭐⭐⭐⭐⭐  |
| Edge Cases       | ⭐⭐⭐⭐   |
| Java Syntax      | ⭐⭐⭐    |

### Final Score: 8.5/10

The logic is strong. The main issue is the Java syntax mistake:

```java
if(l1)
if(l2)
```

which won't compile.

Apart from that, you're thinking in the right direction and using the same pattern that experienced developers use for this problem. You're showing a much better understanding of linked list traversal compared to many beginners because you're correctly maintaining:

```text
dummy → curr → newNode
```
and updating the carry at every step.

 */