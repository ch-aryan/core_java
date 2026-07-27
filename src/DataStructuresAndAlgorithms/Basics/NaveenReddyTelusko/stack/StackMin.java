package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair{
    int value;
    int min;
    Pair(int value, int min){
        this.value = value;
        this.min = min;
    }
}
class StackMinAlgo{
    Deque<Pair> stack = new ArrayDeque<>();
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void push(int x){
        if(isEmpty()) {
            stack.push(new Pair(x, x));
        }
        int currMin = stack.peek().min;
        stack.push(new Pair(x, Math.min(currMin, x)));

    }
    public void pop(){
        if(isEmpty()){
            return;
        }
        stack.pop();
    }
    public int getMin(){
        if(isEmpty()) return -1;
        return stack.peek().min;

    }
    public int peek() {
        // Returns top element of the Stack
        if(isEmpty()){
            return -1;
        }
        return stack.peek().value;
    }
}
public class StackMin {
    public static void main(String[] args) {

    }
}
/*

Yes, you're thinking in the right direction, but there are a few Java issues. More importantly, I want to know **which algorithm your sir taught.**

There are **2 common approaches** for the Min Stack problem.

### Approach 1: Store (value, minimumTillNow) ✅

Each element stores:

* actual value
* minimum value up to that point

Example:

```
Push 5
Stack:
(5,5)

Push 2
Stack:
(5,5)
(2,2)

Push 8
Stack:
(5,5)
(2,2)
(8,2)

Push 1
Stack:
(5,5)
(2,2)
(8,2)
(1,1)
```

Here every node remembers the minimum.

---

### Approach 2: Encoding Technique (O(1) space)

This stores only one stack and one `min` variable by encoding values.

This is a trickier algorithm.

---

## Looking at your code

```java
LinkedList<Integer, Integer> stack = new LinkedList<>();
```

❌ This is not valid Java.

`LinkedList` accepts only **one generic type**.

```java
LinkedList<Integer> stack = new LinkedList<>();
```

or

```java
Stack<Pair>
```

if you want to store two values together.

---

Then I saw this

```java
stack.add(x, x);
```

This tells me your idea is

```
(value, min)
```

which is exactly Approach 1.

So your thinking is correct. 👍

But Java's `LinkedList` doesn't work like that.

---

## If you're storing two integers together

You need something like

```java
class Node {
    int value;
    int min;

    Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
```

Then

```java
Stack<Node> stack = new Stack<>();
```

or

```java
Deque<Node> stack = new ArrayDeque<>();
```

---

## Then your push logic becomes

Pseudo-code only (not full solution)

```
if stack is empty
    push(value, value)
else
    currentMin = top.min

    if value < currentMin
        push(value, value)
    else
        push(value, currentMin)
```

Notice every element stores

```
(actualValue,
minimumTillHere)
```

Exactly what your sir probably explained.

---

## But don't copy this directly.

I want **you** to write it.

Just answer this one question.

Suppose the stack currently is

```
(5,5)
(2,2)
(8,2)
```

Now you push

```
3
```

What pair should be pushed?

```
( ?, ? )
```

Think for a minute and reply with the pair. If you get that correct, your entire `push()` method is basically done.

Exactly! 🔥

If the stack is

```
(5,5)
(2,2)
(8,2)
```

and you push `3`, then the pair is

```
(3,2)
```

Because the minimum till now is still `2`. That means you've understood the algorithm. 👍

Now let's complete your code together. I'll explain every step instead of just dumping the answer.

---

## Step 1: Push

You already have

```java
if(isEmpty()){
    stack.push(new Node(x, x));
}
```

Now think:

* Get the current minimum from the top node.
* Compare it with `x`.
* Store the smaller one.

```java
public void push(int x) {
    if (isEmpty()) {
        stack.push(new Node(x, x));
    } else {
        int currentMin = stack.peek().min;
        stack.push(new Node(x, Math.min(x, currentMin)));
    }
}
```

Notice I used `push()` instead of `add()` because we're implementing a **stack**.

---

## Step 2: Pop

What does pop do?

Just remove the top node.

```java
public void pop() {
    if (!isEmpty()) {
        stack.pop();
    }
}
```

---

## Step 3: Peek

Should return the **value**, not the minimum.

```java
public int peek() {
    if (isEmpty()) {
        return -1;
    }

    return stack.peek().value;
}
```

---

## Step 4: getMin()

The top node already knows the minimum.

```java
public int getMin() {
    if (isEmpty()) {
        return -1;
    }

    return stack.peek().min;
}
```

See how beautiful this is?

We don't traverse the stack at all.

```
Time = O(1)
```

---

## Step 5: isEmpty()

You wrote

```java
return cap == 0;
```

But there is no variable named `cap`.

Instead,

```java
boolean isEmpty() {
    return stack.isEmpty();
}
```

---

## Final Code

```java
class Node {
    int value;
    int min;

    Node(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class SpecialStack {

    Deque<Node> stack = new ArrayDeque<>();

    public SpecialStack() {

    }

    public void push(int x) {
        if (isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            int currentMin = stack.peek().min;
            stack.push(new Node(x, Math.min(x, currentMin)));
        }
    }

    public void pop() {
        if (!isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack.peek().value;
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMin() {
        if (isEmpty()) {
            return -1;
        }
        return stack.peek().min;
    }
}
```

---

### One small suggestion

Since you're learning DSA for interviews, I'd recommend using `push()`, `pop()`, and `peek()` consistently with `Deque`.

Many beginners write:

```java
stack.add(...)
stack.remove(...)
stack.getFirst(...)
```

Those work because `Deque` supports them, but using

```java
push()
pop()
peek()
```

makes it immediately clear to anyone reading your code that you're treating the `Deque` as a **stack**. That's the convention you'll see in most interview solutions and Java codebases.

You're on the right track. I also like that you first understood the algorithm and then tried to implement it yourself—that's a much better way to learn DSA than memorizing solutions.

 */