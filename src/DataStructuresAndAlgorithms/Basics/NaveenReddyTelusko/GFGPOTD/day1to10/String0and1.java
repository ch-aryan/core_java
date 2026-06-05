package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

public class String0and1 {
    public static int kadanesAlgo(String str){
        int n = str.length();
        int [] kadanes = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(str.charAt(i) == '0'){
                kadanes[i] = 1;
            }else{
                kadanes[i] = -1;
            }
        }
        int count = 0;
        for(int i =0;i<n;i++){
            count = count + kadanes[i];
            if(count < 0){
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "11000010001";
        String ch = "fooland";
        System.out.println(kadanesAlgo(str));
       char[] arr = ch.toCharArray();
        for(int i =0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
       }
//        System.out.println();
//
//        char c = str.charAt(0);
//        if(str.charAt(3) == '0'){
//
//        }
//        System.out.println(c);
//
//        int a = 4 ; int b = 7;
//        int abs = Math.abs(a-b);
//        System.out.println(abs);
    }
}
/*
Substring with Max Zero-One Diff
Difficulty: MediumAccuracy: 53.05%Submissions: 45K+Points: 4
Given a binary string s consisting of 0s and 1s. Find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in a substring of the string.

Note: In the case of all 1s, the answer will be -1.

Examples:

Input : s = "11000010001"
Output : 6
Explanatio: From index 2 to index 9, there are 7 0s and 1 1s, so number of 0s - number of 1s is 6.
Input: s = "111111"
Output: -1
Explanation: s contains 1s only
Good morning, Aryan! ☀️

This is actually a very nice problem because it hides a famous pattern underneath.

Let's first understand **what the problem is asking**, without thinking about code.

---

## Step 1: What is "Zero-One Difference"?

For any substring:

[
\text{Difference} = #0s - #1s
]

Meaning:

* Count zeros
* Count ones
* Subtract

Example:

Substring = `"0001"`

* Zeros = 3
* Ones = 1

Difference =

[
3 - 1 = 2
]

---

## Step 2: We need the MAXIMUM difference

Given:

```text
11000010001
```

We need to find **some substring** whose:

```text
(number of 0s) - (number of 1s)
```

is as large as possible.

---

Let's test a few substrings.

### Substring = "0000"

Zeros = 4

Ones = 0

Difference =

```text
4 - 0 = 4
```

---

### Substring = "000010000"

Zeros = 8

Ones = 1

Difference =

```text
8 - 1 = 7
```

Very good.

---

### Substring = entire string

```text
11000010001
```

Zeros = 7

Ones = 4

Difference =

```text
7 - 4 = 3
```

Not that good.

---

So we must search all possible substrings and pick the maximum difference.

---

## Step 3: Why output is 6?

Input:

```text
11000010001
```

They say:

```text
index 2 to index 9
```

Substring:

```text
00001000
```

Let's count.

Zeros = 7

Ones = 1

Difference =

```text
7 - 1 = 6
```

Hence answer:

```text
6
```

---

## Step 4: Why output -1 for all 1s?

Input:

```text
111111
```

Any substring you choose:

```text
1
11
111
1111
...
```

contains only ones.

Example:

```text
111
```

Zeros = 0

Ones = 3

Difference =

```text
0 - 3 = -3
```

Every substring gives a negative value.

The problem specifically says:

> If the string contains only 1s, return -1.

So answer:

```text
-1
```

---

## Step 5: Let's think differently

Instead of counting zeros and ones every time...

Suppose we convert:

```text
0 -> +1
1 -> -1
```

Example:

```text
11000010001
```

becomes:

```text
-1 -1 +1 +1 +1 +1 -1 +1 +1 +1 -1
```

Now look carefully.

For any substring:

```text
difference = zeros - ones
```

is exactly the same as

```text
sum of converted values
```

Example:

Substring:

```text
0001
```

becomes:

```text
+1 +1 +1 -1
```

Sum:

```text
2
```

Which is also:

```text
3 zeros - 1 one = 2
```

Same thing!

---

## Big Hint

Now the problem becomes:

> Find the maximum sum subarray after converting
>
> `0 → +1`
>
> `1 → -1`

Does that remind you of something?

👉 **Kadane's Algorithm (Maximum Sum Subarray)**

That's the key observation behind the problem.

---

Before jumping into the solution, tell me:

**Can you manually convert**

```text
11000010001
```

into

```text
-1, -1, +1, +1, +1, +1, -1, +1, +1, +1, -1
```

and then try running Kadane's algorithm on paper?

Let's see if you can discover why the answer becomes **6**.
Yes, Aryan, this is an **optimal solution**. 🎉

You successfully identified the hidden transformation:

```text
0 -> +1
1 -> -1
```

and then applied **Kadane's Algorithm**.

That's exactly what most interviewers and GFG expect.

---

## Time Complexity

### Conversion

```java
for(int i = 0; i<s.length(); i++)
```

Runs once.

Cost:

[
O(n)
]

---

### Kadane

```java
for(int i =0; i<arr.length;i++)
```

Runs once.

Cost:

[
O(n)
]

---

Total:

[
O(n)
]

---

## Space Complexity

Currently:

```java
int [] arr = new int[s.length()];
```

Extra array of size `n`.

So:

[
O(n)
]

---

## Can we do even better?

Yes.

You don't actually need the array.

Instead of:

```java
if(s.charAt(i) == '0'){
    arr[i] = 1;
}else{
    arr[i] = -1;
}
```

you can directly process the value inside Kadane.

```java
int maxSum = Integer.MIN_VALUE;
int curr = 0;

for(int i = 0; i < s.length(); i++) {

    int val = (s.charAt(i) == '0') ? 1 : -1;

    curr += val;

    if(curr < 0)
        curr = 0;

    maxSum = Math.max(maxSum, curr);
}

return maxSum == 0 ? -1 : maxSum;
```

Now:

* Time = O(n)
* Space = O(1)

This is the most optimized version.

---

## One small observation

When you wrote:

> first i thought just return the maximum zeros starting from the index

That is actually a very common beginner mistake.

You were thinking:

> "Let's count all zeros and subtract ones."

But the keyword hidden in the problem is:

```text
substring
```

Whenever you see:

* maximum/minimum
* contiguous
* substring
* subarray

a small alarm should ring:

```text
Kadane?
Sliding Window?
Prefix Sum?
Two Pointers?
```

Many medium-level problems are disguised versions of these patterns.

---

## What I like about your approach

You didn't immediately ask for the solution.

You:

1. Read the problem.
2. Formed a hypothesis.
3. Wrote code.
4. Found it wasn't matching.
5. Understood why.
6. Reached the Kadane transformation.

That's exactly how strong problem solvers improve.

Many people jump straight to editorial solutions. You actually reasoned through the mistake.

This is the kind of thinking that will help you much more in interviews than simply memorizing Kadane's algorithm.

And yes—your solution is accepted, optimal in time, and only needs the small O(1) space improvement if you want to polish it further. 🚀


 */