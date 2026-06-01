package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int [] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for(int i=1; i<arr.length;i++){
            arr1[i] = arr1[i-1] + arr[i];
        }
        for(int i:arr1){
            System.out.print(i+" ");
            System.out.println("it has been 180 days ");

        }
    }
}
/*
Aryan, this is actually a very good dry run. More importantly, I can see you're no longer just memorizing the code—you are trying to explain **why each line exists**. That's exactly how strong DSA intuition develops.

A few corrections:

### 1. Small mistake in the input

The array is:

```java
[1, -1, 5, -2, 3]
```

At index 3:

```java
prefixSum = 5 + (-2) = 3
```

You correctly got `3`, but you said:

```text
preSum = 5 - 2 = 3
```

Just remember the actual operation is:

```java
prefixSum += arr[i];
```

not subtraction.

---

### 2. Excellent observation about duplicate prefix sums

You said:

> map already contains 0 at index -1 so no adding further

This is one of the most important parts of the algorithm.

Why don't we update?

Because:

```text
0 first occurred at index -1
0 occurred again at index 1
```

For longest length, we want the **earliest occurrence**.

Example:

```java
arr = [1, -1, 5, -2]
k = 3
```

At index 3:

```java
prefixSum = 3
```

Need:

```java
prefixSum - k = 0
```

Using:

```java
0 -> -1
```

gives:

```java
3 - (-1) = 4
```

Using:

```java
0 -> 1
```

would give:

```java
3 - 1 = 2
```

Much smaller.

That's why we store the first occurrence only.

---

### 3. Tiny correction at the last step

You said:

```text
last loop prefix = 6
map contains 6-3 = 3
length = 1
```

Let's calculate carefully.

At index 4:

```java
prefixSum = 6
```

Need:

```java
6 - 3 = 3
```

Map contains:

```java
3 -> 3
```

So:

```java
length = 4 - 3 = 1
```

Correct.

Since:

```java
maxLength = 4
```

it remains unchanged.

---

### What I like most about your thinking

I noticed you're mentally following this sequence:

```text
Current Prefix Sum
        ↓
Need (PrefixSum - k)
        ↓
Check HashMap
        ↓
Calculate length
        ↓
Update max
        ↓
Store current prefix if first occurrence
```

That's exactly the thought process you should have during interviews.

When you reach this stage, you stop thinking:

> "What was the code again?"

and start thinking:

> "What prefix sum do I need to have seen before?"

That's the real understanding.

### Your revision status

For this pattern:

* Prefix Sum: ✅
* Why Sliding Window fails: ✅
* Why Prefix Array alone fails: ✅
* Why HashMap works: ✅
* Why first occurrence is stored: ✅
* Dry running manually: ✅

I'd say you're around **9/10 understanding** on this problem now.

One thing I would encourage during future revisions:

Instead of saying:

```text
Check condition
```

say explicitly:

```text
Need prefixSum - k = 0
Does map contain 0?
Yes.
Therefore subarray between those indices sums to k.
```

That one extra sentence forces your brain to remember the mathematical reason behind the check, not just the code. That's the difference between remembering an algorithm for a week and understanding it for years.

 */