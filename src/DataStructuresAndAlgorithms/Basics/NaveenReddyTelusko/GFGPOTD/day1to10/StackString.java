package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

public class StackString {
    public static void main(String[] args) {
        class Solution {
            public String lexicographicallySmallest(String s, int k) {
                // code here
                int n = s.length();
                int len;

                if(power(n) == true){
                    len = k/2;
                }else{
                    len = k * 2;
                }
                if(len >= n){
                    return "-1";
                }

                StringBuilder stack  = new StringBuilder();

                for(char ch : s.toCharArray()){
                    while(stack.length()>0 && len>0 &&
                            stack.charAt(stack.length()-1) > ch){
                        stack.deleteCharAt(stack.length()-1);
                        len--;
                    }
                    stack.append(ch);
                }
                while(len>0){
                    stack.deleteCharAt(stack.length()-1);
                    len--;
                }

                return stack.toString();

            }
            public static boolean power(int n){
                return n>0 && (n & (n-1))==0;
            }
        }
    }
}
/*
Lexicographically smallest after removing k
Difficulty: MediumAccuracy: 49.97%Submissions: 20K+Points: 4
Given a string s consisting of n lowercase characters. Return the lexicographically smallest string after removing exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k characters.

Note: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.

Examples:

Input: s = "fooland", k = 2
Output: "and"
Explanation: As the size of the string = 7 which is not a power of 2, hence k = 4.
 After removing 4 characters from the given string, the lexicographically smallest string is "and".
Input: s = "code", k = 4
Output: "cd"
Explanation: As the length of the string = 4, which is 2 to the power 2, hence k = 2.
Hence, lexicographically smallest string after removal of 2 characters is "cd".

Now I completely understand why your intuition was to use a frequency array. 👍

But here's the catch:

## Your intuition is close, but the frequency-array approach is wrong for this problem.

The statement says:

> "You can remove any k characters"

It does **not** say you can rearrange the remaining characters.

The order of the remaining characters must stay the same.

---

### Example 1

```text
s = "code"
k = 4

length = 4 (power of 2)

k = k/2 = 2
```

You need a string of length:

```text
4 - 2 = 2
```

Possible results:

```text
co
cd
ce
od
oe
de
```

Lexicographically smallest is:

```text
cd
```

Notice:

```text
cd
```

is NOT obtained by sorting frequencies.

It is obtained by choosing characters while preserving order.

---

## What is this problem actually?

After correction of k:

```text
keep = n - k
```

Now:

> Find the lexicographically smallest subsequence of length `keep`.

This is a famous greedy + stack problem.

---

## Let's dry run

```text
s = "fooland"
n = 7

7 is not power of 2

k = 2 * 2 = 4
```

Need to remove:

```text
4 chars
```

---

Start:

```text
stack = []
k = 4
```

### f

```text
[f]
```

### o

```text
[f,o]
```

### o

```text
[f,o,o]
```

### l

l < o

Remove o

```text
[f,o]
k=3
```

Again:

l < o

Remove o

```text
[f]
k=2
```

Again:

l < f

Remove f

```text
[]
k=1
```

Push l

```text
[l]
```

### a

a < l

Remove l

```text
[]
k=0
```

Push a

```text
[a]
```

### n

```text
[a,n]
```

### d

```text
[a,n,d]
```

Result:

```text
and
```

Exactly the expected answer.

---

## Pattern to Remember

Whenever you hear:

> Remove k characters to get the lexicographically smallest string

think:

```text
Monotonic Increasing Stack
```

The greedy rule is:

```java
while(
    stack not empty &&
    k > 0 &&
    stack.peekLast() > currentChar
)
{
    remove from stack;
    k--;
}
```

Then push the current character.

---

## Why your frequency-array idea fails

Consider:

```text
s = "baca"
k = 1
```

Frequency:

```text
a -> 2
b -> 1
c -> 1
```

Removing largest character:

```text
c
```

Result:

```text
baa
```

But the actual lexicographically smallest result is:

```text
aca
```

(remove the first 'b')

So frequency counts alone don't contain enough information. The position of characters matters.

---

This is a very good attempt from you, though. The moment you started thinking:

> "Should I remove bigger characters first?"
you were already moving toward the correct greedy solution. The only missing realization was:

> **lexicographical order depends on character positions, not just frequencies.**
That's why this problem is typically solved using a stack (or StringBuilder used as a stack),
not a hash/frequency array.

That's completely normal, Aryan.

You've mainly worked with Arrays, HashMaps, Strings, Two Pointers, etc. Monotonic Stack problems usually appear a bit later in DSA journeys. In fact, many people stare at this problem for hours before realizing it's a stack problem.

Let's build it step by step.

---

## Step 1: Correct k

```java
int n = s.length();

if (isPowerOfTwo(n)) {
    k = k / 2;
} else {
    k = k * 2;
}
```

---

## Step 2: Check impossible cases

The problem says:

> If it is not possible to remove k characters or resulting string is empty return -1.

So:

```java
if (k >= n) {
    return "-1";
}
```

Because after removing all characters, the string becomes empty.

---

## Step 3: Use StringBuilder as a Stack

Since you haven't studied Stack yet, we'll use:

```java
StringBuilder stack = new StringBuilder();
```

Think of:

```java
append()
```

as Push

and

```java
deleteCharAt(length - 1)
```

as Pop.

---

## Step 4: Main Logic

```java
for(char ch : s.toCharArray()) {

    while(
        stack.length() > 0 &&
        k > 0 &&
        stack.charAt(stack.length() - 1) > ch
    ) {
        stack.deleteCharAt(stack.length() - 1);
        k--;
    }

    stack.append(ch);
}
```

### Meaning

Suppose stack contains:

```text
f o o
```

Current character:

```text
l
```

Since:

```text
o > l
```

we remove the bigger character because a smaller character earlier in the string makes the whole string lexicographically smaller.

---

## Step 5: What if removals are still left?

Example:

```text
abcd
```

No character was removed because:

```text
a < b < c < d
```

But we still need to remove characters.

Suppose:

```text
k = 2
```

Then remove from the end.

```java
while(k > 0) {
    stack.deleteCharAt(stack.length() - 1);
    k--;
}
```

Result:

```text
ab
```

---

## Complete Code

```java
class Solution {

    public String lexicographicallySmallest(String s, int k) {

        int n = s.length();

        if(isPowerOfTwo(n)) {
            k = k / 2;
        } else {
            k = k * 2;
        }

        if(k >= n) {
            return "-1";
        }

        StringBuilder stack = new StringBuilder();

        for(char ch : s.toCharArray()) {

            while(
                stack.length() > 0 &&
                k > 0 &&
                stack.charAt(stack.length() - 1) > ch
            ) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(ch);
        }

        while(k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        return stack.toString();
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

---

## Dry Run

```text
s = "code"
k = 4

n = 4 (power of 2)

k = 2
```

Process:

```text
c -> [c]

o -> [c,o]

d arrives

o > d

remove o
k = 1

[c]

append d

[c,d]

e

[c,d,e]
```

Still:

```text
k = 1
```

Remove from end:

```text
[c,d]
```

Result:

```text
"cd"
```

✅ Expected output.

---

One more thing: before looking at the code again, try to explain **in your own words** why removing `'o'` when `'d'` arrives in `"code"` helps create a smaller answer. If you can explain that intuition, you've understood the greedy logic, not just memorized the code.
Excellent catch! 👏

You're absolutely right.

I made a mistake in that dry run.

Let's check it carefully.

We had:

```text
s = "fooland"
k = 4
```

After reading:

```text
f o o
```

Stack:

```text
[f,o,o]
```

Current character:

```text
l
```

Now the while loop checks:

```java
stack.peek() > currentChar
```

Top is:

```text
o
```

and

```text
o > l
```

✅ Remove

```text
[f,o]
k = 3
```

Again:

```text
o > l
```

✅ Remove

```text
[f]
k = 2
```

Now top is:

```text
f
```

Check:

```text
f > l ?
```

No.

Because:

```text
'f' = 102
'l' = 108
```

So:

```text
f < l
```

❌ Cannot remove `f`.

The while loop stops here.

The correct stack becomes:

```text
[f,l]
```

not

```text
[l]
```

as I previously wrote.

---

Let's continue correctly.

Current stack:

```text
[f,l]
k = 2
```

Next character:

```text
a
```

Check:

```text
l > a
```

✅ Remove l

```text
[f]
k = 1
```

Again:

```text
f > a
```

✅ Remove f

```text
[]
k = 0
```

Push a

```text
[a]
```

Then:

```text
n -> [a,n]
d -> [a,n,d]
```

Result:

```text
and
```

---

This is actually a very important lesson about the algorithm.

The loop is **not**:

```java
while(current is smaller than everything before it)
```

The loop is:

```java
while(last element in stack > current element)
```

It only compares with the **top** (last character) repeatedly.

For `l`:

```text
o > l  ✅
o > l  ✅
f > l  ❌
```

Stop immediately.

You don't get to remove `f` until a later character (`a`) arrives.

This attention to detail is exactly what helps when learning stack-based greedy algorithms.
You spotted an inconsistency in the dry run instead of just trusting it,
 which is the right habit for interviews and DSA practice.


 */