package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ParenthesisAlgo {
    public static boolean pattern(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            if (first == '(' || first == '{' || first == '[') {
                stack.push(first);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char ch = stack.pop();
                if ((first == ')' && ch == '(')
                        || (first == ']' && ch == '[')
                        || (first == '}' && ch == '{')) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
public class ParenthesisChecker {
    public static void main(String[] args) {
    String str = "{[()]}";
    String str1 = "{}[]()";
    String str2 = "[{)";
    String s = "(){}[]";
    String s1 = "[{()}]";
        System.out.println(ParenthesisAlgo.pattern(str) +" "+
                ParenthesisAlgo.pattern(str1) + " " +
                ParenthesisAlgo.pattern(str2) + " "+ ParenthesisAlgo.pattern(s) + ""+
                ParenthesisAlgo.pattern(s1));
    }
}
/*
Your approach is actually **correct**. You're using the standard **stack algorithm**, which is exactly what interviewers expect for the "Balanced Parentheses" problem.

Let's review it like we would in a code review.

---

## ✅ Your Algorithm

For every character:

* Opening bracket (`(`, `{`, `[`) → **push**
* Closing bracket (`)`, `}`, `]`)

  * if stack is empty → `false`
  * otherwise pop the top
  * compare whether they match
* At the end, stack should be empty.

This is the correct intuition.

---

## The only issue

The problem is **operator precedence** in this condition:

```java
if(s.charAt(i) == ')' && ch == '('
|| s.charAt(i) == ']' && ch == '['
|| s.charAt(i) == '}' && ch == '{'){
```

Although Java evaluates `&&` before `||`, this expression is hard to read.

Write it like this:

```java
if ((s.charAt(i) == ')' && ch == '(') ||
    (s.charAt(i) == ']' && ch == '[') ||
    (s.charAt(i) == '}' && ch == '{')) {
    continue;
} else {
    return false;
}
```

This is much clearer.

---

## Another small improvement

Instead of

```java
char ch = stack.getFirst();
stack.pop();
```

you can simply write

```java
char ch = stack.pop();
```

Because `pop()` already returns the removed element.

---

## Cleaner Version

```java
class Solution {
    public boolean isBalanced(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char ch = stack.pop();

                if ((c == ')' && ch == '(') ||
                    (c == ']' && ch == '[') ||
                    (c == '}' && ch == '{')) {
                    continue;
                }

                return false;
            }
        }

        return stack.isEmpty();
    }
}
```

---

# Even Better (Senior Style)

Experienced Java developers usually avoid the long comparison and instead do this:

```java
if (c == ')') {
    if (stack.pop() != '(') return false;
}
else if (c == ']') {
    if (stack.pop() != '[') return false;
}
else {
    if (stack.pop() != '{') return false;
}
```

Or even push the **expected closing bracket** instead of the opening one.

---

## Overall Review

I would rate your solution:

* ✅ Correct algorithm: **10/10**
* ✅ Time Complexity: **O(n)**
* ✅ Space Complexity: **O(n)**
* ✅ Proper use of `Deque` as a stack.
* 🔸 Minor readability improvements:

  * Use `char c = s.charAt(i);` once per iteration.
  * Use `char ch = stack.pop();`.
  * Add parentheses around the compound condition.

This is a solution I'd expect from someone who understands stacks well. The next step is to learn the alternative pattern of **pushing the expected closing bracket**, which makes the code even shorter and is a common interview optimization.
// anther chat.
Excellent catch. Your **matching logic is correct**. The actual bug is much more subtle.

## The problem is the control flow.

Look carefully at your loop:

```java
if (s.charAt(i) == '(' ||
    s.charAt(i) == '{' ||
    s.charAt(i) == '[') {

    stack.push(s.charAt(i));
}

else if (stack.isEmpty()) {
    return false;
}

char ch = stack.pop();   // <-- This always executes!
```

Notice that `char ch = stack.pop();` is **outside** the `else`.

### Let's dry run with `"()"`

### Iteration 1 (`'('`)

```java
if ('(') {
    stack.push('(');
}
```

Stack:

```
(
```

Now, because there is **no `else`**, execution continues to:

```java
char ch = stack.pop();
```

Now the stack becomes empty.

Then it checks

```java
if ('(' == ')' ...)
```

which is false.

So it immediately executes

```java
return false;
```

It fails on the **very first opening bracket**.

---

## What you intended was this:

```
if (opening bracket) {
    push
}
else {
    if (stack.isEmpty())
        return false;

    pop

    compare
}
```

Notice everything related to closing brackets belongs inside the `else`.

```java
for (int i = 0; i < s.length(); i++) {

    char c = s.charAt(i);

    if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
    } else {

        if (stack.isEmpty()) {
            return false;
        }

        char ch = stack.pop();

        if ((c == ')' && ch == '(') ||
            (c == ']' && ch == '[') ||
            (c == '}' && ch == '{')) {
            continue;
        }

        return false;
    }
}

return stack.isEmpty();
```

---

## A simple way to visualize it

Your current code behaves like this:

```
if (opening)
    push

if (stack empty)
    return false

pop          <-- executes for BOTH opening and closing brackets ❌
compare
```

What you want is:

```
if (opening)
    push
else
    if (stack empty)
        return false

    pop
    compare
```

---

This is a very common mistake when learning stacks—not an algorithm mistake, but a **control flow (branching) mistake**. Your stack logic is sound; you just needed to ensure that `pop()` only happens when you're processing a **closing bracket**, not an opening one.

 */