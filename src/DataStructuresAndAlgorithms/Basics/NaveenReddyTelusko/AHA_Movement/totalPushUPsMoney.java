package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.AHA_Movement;

public class totalPushUPsMoney {
    public static void main(String[] args) {
       // public long total_Money(int n, int k) {
            // code here
    int n = 5; int k = 2;
            long res = 0;
            while(n>=k){
                res = res + k * (n/k);
                n=n-k;
            }


           // return res;
    }
}
//this entire question was solved by me with my own logic and passed all the test cases.
/*
Geek's Weight
Difficulty: BasicAccuracy: 34.31%Submissions: 6K+Points: 1Average Time: 10m
Geek is getting really fat. He wants to lose his weight but can't get the motivation to workout. Seeing this, his friend  Heisenberg offers him a deal.
For every K pushups Geek does, Heisenberg will give him money equal to the number of pushups Geek has done till then (Refer Example for Explanation).
Find out the amount of money he made if he does N pushups.

Example 1:

Input: N = 5, K = 2
Output: 6
Explanation: Pushup 1: No Money, Pushup 2:
+2 Pushup 3: No Money, Pushup 4: +4 and
Pushup 5: No Money.
Example 2:

Input: N = 5, K = 3
Output: 3
Explanation: Pushup 1: No Money, Pushup 2:
No Money, Pushup 3: +3, Pushup 4: No Money
and Pushup 5: No Money.
ai talks.
That feeling is genuinely important, Aryan.
You didn’t just “copy logic” — your brain started recognizing a **pattern** and converting it into code on its own. That’s exactly how problem-solving skills grow.

And honestly, for someone building confidence in DSA, solving a problem independently in 5–10 minutes feels amazing because your mind suddenly says:

> “Wait… I can actually think like a programmer.”

That’s a big moment.

Now about your solution — nice thinking. You observed that:

* Money is given only at multiples of `k`
* So instead of checking every pushup one by one, you tried to directly calculate contributions.

Your code passes because each loop adds:

```java
k * (n/k)
```

Let’s trace quickly for:
`n = 5, k = 2`

Your loop:

### Iteration 1

```java
res += 2 * (5/2)
     += 2 * 2
     += 4
n = 5 - 2 = 3
```

### Iteration 2

```java
res += 2 * (3/2)
     += 2 * 1
     += 2
n = 3 - 2 = 1
```

Total = `6`

Correct answer.

---

But there’s an even cleaner mathematical observation here.

Geek earns money at:

* `k`
* `2k`
* `3k`
* ...
* largest multiple of `k <= n`

So the answer is:

[
k + 2k + 3k + ... + mk
]

where:

[
m = \left\lfloor \frac{n}{k} \right\rfloor
]

Factor out `k`:

[
k(1 + 2 + 3 + ... + m)
]

Using sum formula:

1+2+3+\cdots+n=\frac{n(n+1)}{2}

Final formula:

[
k \times \frac{m(m+1)}{2}
]

Clean solution:

```java
class Solution {
    public long total_Money(int n, int k) {

        long m = n / k;

        return k * (m * (m + 1)) / 2;
    }
}
```

---

What’s more valuable here is not the formula.

It’s that:

* you understood the problem,
* found a pattern,
* built logic yourself,
* passed all test cases.

That’s how strong programmers are made — one small “aha!” moment at a time.

A lot of people quit before reaching this stage. You’re starting to enjoy the thinking process now, and that changes everything.

 */
