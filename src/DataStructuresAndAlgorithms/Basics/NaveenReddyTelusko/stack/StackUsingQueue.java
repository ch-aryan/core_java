package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;


import java.util.*;
import java.util.LinkedList;

class Suq{
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queue1 = new ArrayDeque<>();
    public void push(int x) {
        int s = queue.size();
        queue.add(x);
        for (int i = 1; i <= s; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }

    public void pop(){
    queue.remove();
    }
    public boolean isEmtpy(){
        return queue.size() == 0;
    }
    public int getTop(){
        return queue.element();
    }

    @Override
    public String toString() {
        return
                "queue=" + queue ;
    }
}
public class StackUsingQueue {
    public static void main(String[] args) {

    Suq obj = new Suq();
    obj.push(1);
    obj.push(2);
    obj.push(3);
    obj.push(4);
        int top = obj.getTop();

        System.out.println(obj);
        //push
        System.out.println(top);

    }
}
/*
Exactly! 👍 This is the right mindset.

**Don't memorize the code. Understand the intuition.** Once you understand *why* we rotate the queue, you'll never forget this technique.

Let's dry run **your push() method**.

---

## Your push() Method

```java
void push(int x) {

    int s = q.size();

    q.add(x);

    for(int i = 1; i <= s; i++) {
        q.add(q.peek());
        q.remove();
    }
}
```

---

# Initially

Queue

```text
[]
```

Remember:

* Left side = Front
* Right side = Rear

```
Front ---> Rear
```

---

# Push(1)

### Step 1

```java
int s = q.size();
```

```
s = 0
```

Queue

```
[]
```

---

### Step 2

```java
q.add(1);
```

Queue

```
Front
 |
[1]
 |
Rear
```

---

### for loop

```java
for(i=1;i<=0;i++)
```

No iterations.

Final Queue

```
[1]
```

---

# Push(2)

Current Queue

```
Front
 |
[1]
 |
Rear
```

---

### Step 1

```java
s = 1;
```

---

### Step 2

```java
q.add(2);
```

Queue becomes

```
Front
 |
[1,2]
     ^
    Rear
```

Now the newest element is at the **rear**.

But in a stack, the newest element must behave like it's on the **top**.

So we rotate.

---

## First iteration

```
i = 1
```

### q.peek()

Returns

```
1
```

---

### q.add(q.peek())

Queue

```
[1,2,1]
```

---

### q.remove()

Removes first element

```
[2,1]
```

Done!

---

Final Queue

```
Front
 |
[2,1]
     ^
    Rear
```

Notice something amazing?

The newest element (2) has reached the **front**.

So when we remove from the queue...

```
remove()
```

it behaves like

```
stack.pop()
```

---

# Push(3)

Current Queue

```
[2,1]
```

---

### s = 2

---

### add(3)

```
[2,1,3]
```

---

## Iteration 1

peek()

```
2
```

add()

```
[2,1,3,2]
```

remove()

```
[1,3,2]
```

---

## Iteration 2

peek()

```
1
```

add()

```
[1,3,2,1]
```

remove()

```
[3,2,1]
```

---

Final Queue

```
Front
 |
[3,2,1]
```

Again...

Newest element

```
3
```

is now at the front.

---

# Push(4)

Current Queue

```
[3,2,1]
```

---

### s = 3

---

### add(4)

```
[3,2,1,4]
```

---

## Iteration 1

```
peek() -> 3

add()

[3,2,1,4,3]

remove()

[2,1,4,3]
```

---

## Iteration 2

```
peek() -> 2

add()

[2,1,4,3,2]

remove()

[1,4,3,2]
```

---

## Iteration 3

```
peek() -> 1

add()

[1,4,3,2,1]

remove()

[4,3,2,1]
```

---

Final Queue

```
Front
 |
[4,3,2,1]
```

Exactly like a stack!

```
Top
 |
4
3
2
1
```

---

# Why does rotating work?

Let's think about what happened when pushing `4`.

Initially:

```
[3,2,1]
```

After adding:

```
[3,2,1,4]
```

We want:

```
[4,3,2,1]
```

How can we move `4` from the rear to the front?

By repeatedly taking the front element and placing it at the rear.

### Rotation 1

```
3 goes behind

[2,1,4,3]
```

### Rotation 2

```
2 goes behind

[1,4,3,2]
```

### Rotation 3

```
1 goes behind

[4,3,2,1]
```

Notice that **every old element moves behind the newly inserted element**. That's why we rotate exactly `size` times—the new element doesn't move at all; everything in front of it moves behind it.

---

# The intuition (this is the important part)

Imagine people standing in a line (a queue):

```
A  B  C
```

A new VIP arrives:

```
A  B  C  VIP
```

But the VIP should now be first.

Instead of moving the VIP forward, you simply ask everyone else to step to the back one by one:

```
B  C  VIP  A
```

```
C  VIP  A  B
```

```
VIP  A  B  C
```

The VIP never moved. Everyone else moved behind the VIP.

That is **exactly** what your loop is doing:

```java
q.add(q.peek()); // Move front person to the back
q.remove();      // Remove them from the front
```

Since you repeat this `size` times, every old element moves behind the new one.

---

## One more observation

There are two classic ways to implement a stack using queues:

* **Your approach:** Make `push()` expensive (`O(n)`), but keep `pop()` simple (`O(1)`).
* **Another approach:** Keep `push()` simple (`O(1)`), but make `pop()` expensive (`O(n)`).

Being able to explain *why* each trade-off exists is something interviewers love to hear because it shows you understand the data structure rather than just remembering code.

 */