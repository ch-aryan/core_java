package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

import java.util.Arrays;

/*
Pairs with certain difference
Difficulty: EasyAccuracy: 63.41%Submissions: 44K+Points: 2
Given an array of integers and a number k, the task is the find maximum pair sum with the following conditions on the pairs.

Pair difference should be less than k.
Pairs should be disjoint. For example if (x, y) is a result pair, then neither x nor y should appear in any other result pair.
Sum of p pairs means sum of 2p elements in the result.
If no valid pairs can be formed, return 0.

Examples:

Input: arr[] = [3, 5, 10, 15, 17, 12, 9], K = 4
Output: 62
Explanation :
The valid disjoint pairs with difference less than K are:
(3, 5), (10, 12), (15, 17)
The maximum sum obtained from these pairs is:
3 + 5 + 10 + 12 + 15 + 17 = 62
An alternative pairing could be:
(3, 5), (9, 12), (15, 17)
However, this combination results in a smaller total sum, so it is not optimal.
Input: arr[] = [5, 15, 10, 300], k = 12
Output: 25
Explanation:
The valid disjoint pairs with difference less than k are:
(5, 10)
The maximum sum obtained from these pairs is:
5 + 10 = 15
An alternative pairing could be:
(10, 15)
However, this combination results in a larger total sum:
10 + 15 = 25. So this pairing is optimal.
 */
public class DPProblem {
    //this is greedy and two pointer like that.
    public static int usingBhavanasHelp(int [] arr, int k){
        int n = arr.length;
        int res = 0;
        Arrays.sort(arr);
        for(int i = n-1; i>0; ){
            int pair = arr[i] - arr[i-1];
            if(pair < k){
                res = res + arr[i] + arr[i-1];
                i=i-2;
            }else{
                i--;
            }
        }
        return res;
    }
    public static int dynamicProgram(int [] arr , int k ){
        int n = arr.length;
        int dp[] = new int[n];
        int sum = 0;
        Arrays.sort(arr);
        for(int i =1;i<n;i++){
            dp[i] = dp[i-1];
            sum = arr[i] - arr[i-1];
            if(sum <= k){
                int pair = arr[i] + arr[i-1];
                if(i >=2){
                    pair = pair + dp[i-2];
                }
                dp[i] = Math.max(dp[i] , pair);
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int [] arr = {3, 5, 10, 15, 17, 12, 9};
        int k = 4;
        int result = usingBhavanasHelp(arr,k);
        System.out.println(result);
    }
}
/*
Aryan, it's not a mistake. The issue is that we jumped into DP before your brain fully understood **what the problem is actually asking**.

Let's forget DP, sorting, code, everything.

---

# Imagine 4 friends

```text
1  3  4  6
```

And:

```text
k = 3
```

Rule:

> Two friends can become a pair only if their difference is less than 3.

---

Let's check.

### Can 1 and 3 become a pair?

```text
3 - 1 = 2
```

2 < 3

✅ Yes

Pair:

```text
(1,3)
```

---

### Can 3 and 4 become a pair?

```text
4 - 3 = 1
```

1 < 3

✅ Yes

Pair:

```text
(3,4)
```

---

### Can 4 and 6 become a pair?

```text
6 - 4 = 2
```

2 < 3

✅ Yes

Pair:

```text
(4,6)
```

---

Now the important rule.

# A number can be used only once

If I choose:

```text
(1,3)
```

then 3 is already busy.

I cannot do:

```text
(3,4)
```

because 3 is already used.

---

Think of it like marriage.

If 3 marries 1,

then 3 cannot marry 4 also. 😄

---

# Question

Among all possible valid pairings,

which pairing gives the biggest total sum?

---

Let's try.

## Option 1

Choose:

```text
(1,3)
```

Sum:

```text
1+3 = 4
## Option 2

Choose:

```text
(3,4)
```

Sum:

```text
3+4 = 7
## Option 3
Choose:
```text
(4,6)

Sum:```text
4+6 = 10

---
## Option 4
Choose:
`text
(1,3)
(4,6)
``
Allowed?
Yes.
No umber repeats.
Sum:```text
1+3+4+6
=
14

Now tell me:
Among
```text
4
7
10
14
```
which is biggest?
Obviously:

```text
14
```

So answer is:

```text
14
```

---

Now let's revisit the original example.

```text
arr = [5,15,10,300]
k = 12
```
Forget code.
Just tell me:
### Pair 1
```text
(5,10)
```
Difference?

```text
10-5 = 5
```
Valid.
Sum?
```text
15
```
-
### Pair 2

```text
(10,15)
```

Difference?

```text
15-10 = 5
```

Valid.

Sum?

```text
25
```
---
Can we take both?

```text
(5,10)
(10,15)
```

No
Because 10 appears twice.---
So if you had to choose:

text
15
or
25
```
which one would you choose
That's literally the entire problem.
Don't think about DP yet
First answer this question:
For
```text
arr = [1,2,4,5]
k = 3
List all valid pairs and tell me what maximum sum you think we can get. We'll solve it like a puzzle, not like a coding problem.

Aryan, first, **you're not dumb** and nothing in this conversation suggests that.

What actually happened is something very common:

* You were still trying to understand the **problem statement**.
* I jumped ahead and started explaining a **DP solution**.
* Your brain was asking: *"Wait, what are we even maximizing here?"*
* Then the DP recurrence naturally felt confusing.

That's a teaching mistake, not an intelligence issue.

---

Now let's talk about your solution.

```java
Arrays.sort(arr);

for(int i=n-1;i>0;){
    if(arr[i]-arr[i-1]<k){
        sum+=arr[i]+arr[i-1];
        i-=2;
    }
    else{
        i--;
    }
}
```

This is actually the well-known greedy solution for this problem.

### Why does it work?

After sorting:

```text
3 5 9 10 12 15 17
```

Start from the end:

```text
17 15
```

Difference:

```text
17 - 15 = 2 < 4
```

Valid pair.

Take it immediately:

```text
sum += 32
```

Move left by 2.

---

Now:

```text
12 10
```

Difference:

```text
2 < 4
```

Take it.

```text
sum += 22
```

Move left by 2.

---

Now:

```text
5 3
```

Difference:

```text
2 < 4
```

Take it.

```text
sum += 8
```

Total:

```text
32 + 22 + 8 = 62
```

Correct answer.

---

### Why is greedy enough here?

Suppose we have:

```text
... 9 10 12
```

Both pairs are possible:

```text
(9,10)  -> sum = 19
(10,12) -> sum = 22
```

If we're scanning from the right:

```text
10,12
```

we take:

```text
(10,12)
```

because it contributes more.

Since the array is sorted, pairing larger numbers together gives the maximum contribution.

That's the key greedy observation.

---

### Then why do some solutions use DP?

Because this problem is often presented in two forms:

1. **Greedy version** (what GFG usually expects here)
2. **DP version** (a more general formulation)

The DP recurrence:

```java
dp[i] = max(
    dp[i-1],
    dp[i-2] + arr[i] + arr[i-1]
)
```

also works.

But if you discover the greedy property, the solution becomes much simpler.

---

And honestly, looking at your journey:

* You've been solving prefix-sum problems.
* You've been working through DSA consistently.
* You correctly reasoned through the sample.
* You immediately understood the disjoint-pair constraint.
* You even recognized a greedy pattern after seeing the sorted array.

Those are not signs of someone struggling with fundamentals.

The real lesson here is:

> When a problem feels impossible, spend more time understanding the rules before thinking about DP, recursion, or advanced techniques.

You were ready for the greedy solution long before we started discussing DP.

Perfect. This is exactly the attitude needed to understand DP deeply.

Let's go very slowly and not write a single line of code.

---

## Example

```text
arr = [1,2,4,5]
k = 3
```

### Step 1: Find all valid pairs

Check every possible pair.

```text
(1,2) -> diff = 1 ✓
(1,4) -> diff = 3 ✗
(1,5) -> diff = 4 ✗

(2,4) -> diff = 2 ✓
(2,5) -> diff = 3 ✗

(4,5) -> diff = 1 ✓
```

Valid pairs:

```text
(1,2)
(2,4)
(4,5)
```

Agree so far?

---

## Step 2: Which pairs can coexist?

Can we take:

```text
(1,2)
(2,4)
```

No.

Because 2 is used twice.

---

Can we take:

```text
(2,4)
(4,5)
```

No.

Because 4 is used twice.

---

Can we take:

```text
(1,2)
(4,5)
```

Yes!

No element repeats.

---

## Step 3: Calculate sums

### Option 1

```text
(1,2)
```

Sum = 3

---

### Option 2

```text
(2,4)
```

Sum = 6

---

### Option 3

```text
(4,5)
```

Sum = 9

---

### Option 4

```text
(1,2) + (4,5)
```

Sum:

```text
1+2+4+5 = 12
```

---

Maximum:

```text
12
```

So answer = 12.

---

Now let's start thinking like DP.

Suppose the sorted array is:

```text
index : 0 1 2 3
value : 1 2 4 5
```

Let's define:

```text
dp[i]
```

as:

> Maximum sum we can make using elements from index 0 to i.

---

### dp[0]

Only element:

```text
1
```

No pair possible.

```text
dp[0] = 0
```

---

### dp[1]

Elements:

```text
1 2
```

Can form pair:

```text
(1,2)
```

Sum:

```text
3
```

So:

```text
dp[1] = 3
```

Current DP:

```text
[0,3,?,?]
```

---

### dp[2]

Elements:

```text
1 2 4
```

Now we ask:

### Choice 1

Don't use 4.

Then answer is whatever we already had.

```text
dp[1] = 3
```

---

### Choice 2

Use pair:

```text
(2,4)
```

Pair sum:

```text
6
```

If we use 2 and 4, can we also use (1,2)?

No.

Because 2 is already taken.

So before this pair, the best we can keep is:

```text
dp[0]
```

which is:

```text
0
```

Therefore:

```text
0 + 6 = 6
```

Now compare:

```text
3 vs 6
```

Take maximum.

```text
dp[2] = 6
```

DP becomes:

```text
[0,3,6,?]
```

---

Stop here.

This is the most important DP idea.

When we choose pair:

```text
(2,4)
```

why do we add:

```text
dp[0]
```

and NOT

```text
dp[1]
```

Tell me your reasoning.

Don't worry about being right or wrong. Just explain what you think. Once this clicks, the whole recurrence will feel natural.
YES! 🎉

That is exactly the reason.

Let's make your explanation slightly more precise.

---

At:

```text
dp[2]
```

we are considering:

```text
[1, 2, 4]
```

and we decide to take the pair:

```text
(2,4)
```

Now ask:

> What is the best answer from the elements before this pair?

The pair uses:

```text
index 1 -> 2
index 2 -> 4
```

Both are consumed.

So we cannot use anything that already used index 1.

---

Look at:

```text
dp[1]
```

What does it represent?

```text
Best answer using [1,2]
```

And that answer is:

```text
(1,2)
```

sum = 3

If we do:

```text
dp[1] + (2,4)
```

then we are effectively doing:

```text
(1,2) + (2,4)
```

which uses:

```text
2
```

twice.

That violates the problem condition.

---

Therefore we must jump back to:

```text
dp[0]
```

which means:

```text
everything before index 1
```

There is nothing there that conflicts with our new pair.

So:

```text
dp[2]
=
max(
    dp[1],          // don't take (2,4)
    dp[0] + 2 + 4   // take (2,4)
)
```

---

This is the entire heart of the DP.

You just explained it correctly:

> "We already used 2 in dp[1], so if we pair 2 with 4 again, 2 would be used twice."

Exactly.

---

Now let's finish the example ourselves.

We currently have:

```text
arr = [1,2,4,5]

dp = [0,3,6,?]
```

Now compute:

```text
dp[3]
```

We are looking at:

```text
[1,2,4,5]
```

and the new possible pair is:

```text
(4,5)
```

Try it yourself.

### Choice 1

Don't take `(4,5)`

What value do we get?

### Choice 2

Take `(4,5)`

* Pair sum = ?
* Which DP state should we add?

  * `dp[2]`?
  * `dp[1]`?
  * `dp[0]`?

And why?

Walk through it exactly the way you did for `dp[2]`. You're very close to seeing the full recurrence on your own.
YES! 🎉

That is exactly the reason.

Let's make your explanation slightly more precise.

---

At:

```text
dp[2]
```

we are considering:

```text
[1, 2, 4]
```

and we decide to take the pair:

```text
(2,4)
```

Now ask:

> What is the best answer from the elements before this pair?

The pair uses:

```text
index 1 -> 2
index 2 -> 4
```

Both are consumed.

So we cannot use anything that already used index 1.

---

Look at:

```text
dp[1]
```

What does it represent?

```text
Best answer using [1,2]
```

And that answer is:

```text
(1,2)
```

sum = 3

If we do:

```text
dp[1] + (2,4)
```

then we are effectively doing:

```text
(1,2) + (2,4)
```

which uses:

```text
2
```

twice.

That violates the problem condition.

---

Therefore we must jump back to:

```text
dp[0]
```

which means:

```text
everything before index 1
```

There is nothing there that conflicts with our new pair.

So:

```text
dp[2]
=
max(
    dp[1],          // don't take (2,4)
    dp[0] + 2 + 4   // take (2,4)
)
```

---

This is the entire heart of the DP.

You just explained it correctly:

> "We already used 2 in dp[1], so if we pair 2 with 4 again, 2 would be used twice."

Exactly.

---

Now let's finish the example ourselves.

We currently have:

```text
arr = [1,2,4,5]

dp = [0,3,6,?]
```

Now compute:

```text
dp[3]
```

We are looking at:

```text
[1,2,4,5]
```

and the new possible pair is:

```text
(4,5)
```

Try it yourself.

### Choice 1

Don't take `(4,5)`

What value do we get?

### Choice 2

Take `(4,5)`

* Pair sum = ?
* Which DP state should we add?

  * `dp[2]`?
  * `dp[1]`?
  * `dp[0]`?

And why?

Walk through it exactly the way you did for `dp[2]`. You're very close to seeing the full recurrence on your own.
Excellent. You got it.

For `dp[3]`:

### Choice 1: Don't take `(4,5)`

```text
dp[2] = 6
```

---

### Choice 2: Take `(4,5)`

Pair sum:

```text
4 + 5 = 9
```

Now we cannot use 4 again.

So we cannot add `dp[2]` because `dp[2]` may already contain a pair using 4.

Instead we jump back to:

```text
dp[1]
```

which is:

```text
3
```

Therefore:

```text
9 + 3 = 12
```

---

Take maximum:

```text
max(6, 12) = 12
```

So:

```text
dp[3] = 12
```

Final DP:

```text
[0, 3, 6, 12]
```

Answer:

```text
12
```

You understood the recurrence correctly.

---

# Now let's derive the code from the thinking

## Step 1: Sort

```java
Arrays.sort(arr);
```

Why?

Because after sorting, if a pair exists, it is enough to consider neighboring elements.

Example:

```text
Before:
[3,5,10,15,17,12,9]

After:
[3,5,9,10,12,15,17]
```

---

## Step 2: Create DP

```java
int[] dp = new int[n];
```

Meaning:

```text
dp[i]
=
maximum sum obtainable using
elements from 0 to i
```

---

## Step 3: Base cases

Initially:

```java
dp[0] = 0;
```

Because:

```text
Only one element.

No pair can be formed.
```

---

## Step 4: Process from left to right

```java
for(int i = 1; i < n; i++)
```

Start from 1 because we need:

```java
arr[i-1]
```

to form a pair.

---

# First choice

Suppose we don't take the current pair.

```java
dp[i] = dp[i-1];
```

Meaning:

```text
Whatever answer we had before,
keep it.
```

---

# Check if pair is valid

```java
if(arr[i] - arr[i-1] < k)
```

Example:

```text
10 and 12

12 - 10 = 2

2 < 4

Valid pair
```

---

# Pair sum

```java
int pairSum = arr[i] + arr[i-1];
```

Example:

```text
10 + 12 = 22
```

---

# Add previous non-conflicting answer

If:

```java
i >= 2
```

then:

```java
pairSum += dp[i-2];
```

Why?

Because:

```text
Current pair uses

i-1
i

So we must jump behind them.

Best answer there is dp[i-2].
```

---

# Choose best

```java
dp[i] = Math.max(dp[i], pairSum);
```

Meaning:

```text
Either

don't take pair

OR

take pair

whichever gives bigger answer.
```

---

# Full Code

```java
import java.util.Arrays;

class Solution {

    public int maxSumPairWithDifferenceLessThanK(int arr[], int n, int k) {

        Arrays.sort(arr);

        int[] dp = new int[n];

        dp[0] = 0;

        for(int i = 1; i < n; i++) {

            // Choice 1: don't take current pair
            dp[i] = dp[i - 1];

            // Check if current pair is valid
            if(arr[i] - arr[i - 1] < k) {

                int pairSum = arr[i] + arr[i - 1];

                // Add best answer before this pair
                if(i >= 2) {
                    pairSum += dp[i - 2];
                }

                // Choice 2: take current pair
                dp[i] = Math.max(dp[i], pairSum);
            }
        }

        return dp[n - 1];
    }
}
```

---

# Complete Dry Run on Original Example

```text
arr = [3,5,10,15,17,12,9]
k = 4
```

After sorting:

```text
[3,5,9,10,12,15,17]
```

Indexes:

```text
0 1 2 3 4 5 6
```

---

### i = 1

Pair:

```text
(3,5)
```

Valid.

```text
pairSum = 8
```

```text
dp[1] = max(0,8)
      = 8
```

DP:

```text
[0,8,0,0,0,0,0]
```

---

### i = 2

Pair:

```text
(5,9)
```

Difference:

```text
4
```

Not less than 4.

Invalid.

```text
dp[2] = dp[1]
      = 8
```

DP:

```text
[0,8,8,0,0,0,0]
```

---

### i = 3

Pair:

```text
(9,10)
```

Valid.

Choice 1:

```text
dp[2] = 8
```

Choice 2:

```text
19 + dp[1]
=
19 + 8
=
27
```

```text
dp[3] = 27
```

DP:

```text
[0,8,8,27,0,0,0]
```

---

### i = 4

Pair:

```text
(10,12)
```

Valid.

Choice 1:

```text
27
```

Choice 2:

```text
22 + dp[2]
=
22 + 8
=
30
```

```text
dp[4] = 30
```

DP:

```text
[0,8,8,27,30,0,0]
```

---

### i = 5

Pair:

```text
(12,15)
```

Difference:

```text
3
```

Valid.

Choice 1:

```text
30
```

Choice 2:

```text
27 + dp[3]
=
27 + 27
=
54
```

```text
dp[5] = 54
```

DP:

```text
[0,8,8,27,30,54,0]
```

---

### i = 6

Pair:

```text
(15,17)
```

Valid.

Choice 1:

```text
54
```

Choice 2:

```text
32 + dp[4]
=
32 + 30
=
62
```

```text
dp[6] = 62
```

Final:

```text
[0,8,8,27,30,54,62]
```

Answer:

```text
62
```

One tiny correction to your thinking from earlier: when taking `(4,5)` we add **`dp[1]`**, not because it is "unique", but because `dp[1]` is the best answer that uses only elements **before index 2**, so it cannot conflict with the pair `(4,5)`. That's the DP pattern you'll see again in problems like House Robber and Weighted Interval Scheduling.
Good. This is exactly where you should stop and ask questions.

Let's forget code again.

---

Suppose we have:

```text
Index : 0 1 2
Value : 1 2 4
```

We are computing:

```text
dp[2]
```

and we decide to take the pair:

```text
(2,4)
```

which uses:

```text
index 1
index 2
```

---

Now ask yourself:

### Can I also use anything from index 0?

```text
1
```

Yes.

Because 1 is not part of the pair.

---

### Can I use anything from index 1?

```text
2
```

No.

Because 2 is already used in:

```text
(2,4)
```

---

So when we take:

```text
(2,4)
```

the only safe area is:

```text
everything before index 1
```

which is:

```text
index 0
```

---

Now let's map this to DP.

What DP state represents:

```text
everything before index 1
```

?

Answer:

```text
dp[0]
```

That's why:

```text
pairSum = (2+4) + dp[0]
```

---

# Another example

```text
Index : 0 1 2 3
Value : 1 2 4 5
```

Suppose we take:

```text
(4,5)
```

which uses:

```text
index 2
index 3
```

---

Now ask:

### Can I use index 2 again?

No.

Already used.

---

### Can I use index 3 again?

No.

Already used.

---

### Which indices are completely safe?

```text
0
1
```

because they are before index 2.

---

What DP state represents:

```text
best answer using indices 0 and 1
```

?

Answer:

```text
dp[1]
```

Therefore:

```text
(4+5) + dp[1]
```

which is:

```text
9 + 3 = 12
```

---

Notice a pattern?

### Pair chosen

```text
(i-1, i)
```

uses two positions:

```text
i-1
i
```

---

Therefore the largest safe DP state is:

```text
dp[i-2]
```

because it ends **before** `i-1`.

---

Let's draw it visually.

Suppose:

```text
Index : 0 1 2 3 4 5
Value : a b c d e f
```

and we choose:

```text
(e,f)
```

which is:

```text
(i-1, i)
```

---

Used:

```text
a b c d [e f]
        ^ ^
      i-1 i
```

The safe part is:

```text
a b c d
```

Which DP state stores the best answer for that safe part?

```text
dp[4-1]
=
dp[3]
```

which is:

```text
dp[i-2]
```

---

Let me ask you a very small question.

```text
Index : 0 1 2 3 4
Value : 3 5 9 10 12
```

Suppose we decide to take:

```text
(10,12)
```

which is:

```text
index 3 and index 4
```

Then:

1. Which indices are already consumed?
2. Which indices are still safe to use?
3. Which DP state should we add:

   * dp[4]
   * dp[3]
   * dp[2]
   * dp[1]

Don't calculate anything. Just answer those 3 questions. Once you answer them, the `dp[i-2]` part usually clicks permanently.
That's exactly it, Aryan. 😊

What happened here is something I see often with DP:

At first, the recurrence

```java
dp[i] = max(dp[i-1], dp[i-2] + arr[i] + arr[i-1])
```

looks like magic.

People try to memorize:

```java
dp[i-2]
```

without understanding why.

Then a week later they forget it.

---

But when you sat down and asked:

> Which elements are consumed?
>
> Which elements are still safe?

suddenly:

```java
dp[i-2]
```

stopped being a formula and became a logical consequence.

You derived it yourself.

That's a much deeper level of understanding.

---

One thing I've noticed from our DSA discussions:

When you struggle, it's usually **not because you can't understand the algorithm**.

It's because you want to understand:

1. What the problem is asking.
2. Why a particular decision is made.
3. What each variable/state actually represents.

Once those are clear, you often figure out the recurrence yourself.

That's exactly what happened here.

---

And yes, pen-and-paper dry runs are incredibly powerful for DP.

For every DP problem, try this process:

### Step 1

Write:

```text
Index : 0 1 2 3 ...
Value : ...
```

---

### Step 2

Define in plain English:

```text
dp[i] means ...
```

Not code.

Just English.

Example:

```text
dp[i] = maximum sum obtainable using elements from 0 to i
```

---

### Step 3

At every index ask:

```text
What happens if I don't take it?
```

and

```text
What happens if I take it?
```

---

### Step 4

Draw which elements become unavailable.

For this problem:

```text
Take pair (i-1, i)

Consumed:
i-1, i

Safe:
0 ... i-2
```

The recurrence practically writes itself.

---

The best part is that this same thinking appears in many famous DP problems:

* House Robber
* Maximum Sum of Non-Adjacent Elements
* Weighted Interval Scheduling
* Stock DP variants
* Rod Cutting
* Knapsack

The details change, but the question stays the same:

> If I choose this option, what becomes unavailable?
>
> What's the best answer from the remaining safe part?

That's the core DP mindset.

And today, you actually experienced that moment where a recurrence stopped looking like magic and started looking like logic. That's a big step forward.
Yes, but with one important refinement.

**DP is not just recurrence relations.**

A lot of beginners think:

```text
DP = recurrence formula
```

But actually:

```text
DP = State + Choices + Recurrence + Storing results
```

The recurrence is only one piece.

---

Let's use the problem you just understood.

### 1. State

First we define:

```text
dp[i]
```

Meaning:

> Maximum sum obtainable using elements from index 0 to i.

This is the **state**.

Without a clear state, you cannot build a DP solution.

---

### 2. Choices

At index `i`, we had two choices:

```text
Don't take pair (i-1, i)
```

or

```text
Take pair (i-1, i)
```

DP is usually about making choices.

---

### 3. Recurrence

Now we translate those choices into math:

Don't take:

```text
dp[i-1]
```

Take:

```text
dp[i-2] + arr[i-1] + arr[i]
```

Combine:

```text
dp[i] =
max(
    dp[i-1],
    dp[i-2] + arr[i-1] + arr[i]
)
```

This is the recurrence relation.

---

### 4. Store results

Instead of recalculating the same thing repeatedly, we store:

```text
dp[0]
dp[1]
dp[2]
...
```

That's the "dynamic programming" part.

---

Think about a famous example:

### Fibonacci

Recurrence:

```text
F(n) = F(n-1) + F(n-2)
```

Is Fibonacci automatically DP?

❌ No.

If you write:

```java
fib(n) {
    return fib(n-1) + fib(n-2);
}
```

that's just recursion.

---

It becomes DP when you store previously computed answers:

```java
dp[n]
```

and reuse them.

---

A better way to think about DP is:

> DP is solving a big problem by solving smaller versions of the same problem and remembering their answers.

The recurrence tells you **how the big problem depends on the smaller problems**.

---

When you solve future DP problems, don't start by asking:

> What's the recurrence?

Start by asking:

### Question 1

"What does `dp[i]` mean?"

If you can't answer this clearly, don't move on.

---

### Question 2

"What choices do I have?"

Usually 2–4 choices.

Examples:

* Take / Not Take
* Rob / Don't Rob
* Include / Exclude
* Buy / Sell / Hold

---

### Question 3

"If I make this choice, which smaller problem remains?"

That's where `dp[i-1]`, `dp[i-2]`, etc. come from.

---

For the pair problem, your breakthrough was not understanding the recurrence.

It was understanding:

> If I use indices 3 and 4, then only indices 0,1,2 are safe.

Once you understood that, the recurrence appeared naturally.

That's how strong DP intuition is built.

 */