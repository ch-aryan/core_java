package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;
class Algorithms{
    public static int bruteForce(int [] arr, int k){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int sum  =0;
            for(int j = i;j<n;j++){
                sum = sum + arr[j];
                if(j-i+1 >= k ){
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    public static int betterUsingPre(int [] arr, int k){
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i =1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for (int j = i;j<n;j++){
                if(j-i+1 >= k){
                 int sum = 0;
                if(i == 0){
                    sum =  prefix[j];
                }else{
                    sum = prefix[j] - prefix[i-1];
                }
             max =    Math.max(sum, max);
                }
            }
        }
        return max;
    }
    public static int kadanesUsingArr(int [] arr, int k ){
        int n = arr.length;
        int [] maxEI = new int[n];
        maxEI[0] = arr[0];
        for(int i =1;i<n;i++){
            maxEI[i] = Math.max(arr[i], maxEI[i-1] + arr[i]);//{1,-1, 2, -1}
        }
        int sum =0;
        for(int i =0;i<k;i++){
            sum = sum + arr[i];
        }
        int res = sum;
        int j = 0;
        for(int i =k; i<n;i++) {
            sum = sum + arr[i] - arr[i-k];
            res = Math.max(sum, res);
            res = Math.max(res, sum  + maxEI[i-k]);
        }
        return res;
    }
    public static int kadanesOptimal(int [] arr, int k){
        int n = arr.length;
        int max= Integer.MIN_VALUE;
        int last = 0;
        int sum = 0;
        for(int i =0; i<k ; i++){
            sum = sum + arr[i];
        }
        max = Math.max(sum , max);

        int j = 0;
        for(int i = k; i<n;i++){
            sum = sum + arr[i];
            max = Math.max(sum,max);
            last = last + arr[j++];
            if(last < 0){
                sum = sum - last;
                max = Math.max(sum,max);
                last = 0;
            }
        }
        return max;
    }
}
public class KadanesSumSubArraySizek {
    public static void main(String[] args) {
        int a[] = {1, -2, 2, -3};
        int res = Algorithms.bruteForce(a, 2);
        System.out.println(res);

        System.out.println("*******************");
        int b[] =  {1, 1, 1, 1, 1, 1};
        System.out.println(Algorithms.kadanesUsingArr(b,2));
        System.out.println(Algorithms.kadanesUsingArr(a,2));
        System.out.println("**************************");
        System.out.println(Algorithms.kadanesOptimal(b,2));
        System.out.println(Algorithms.kadanesOptimal(a,2));
    }
}
/*
Largest Sum Subarray of Size at least K
Difficulty: MediumAccuracy: 37.64%Submissions: 61K+Points: 4
Given an array a of length n and a number k, find the largest sum of the subarray containing at
least k numbers. It is guaranteed that the size of array is at-least k.

Example 1:

Input :
n = 4
a[] = {1, -2, 2, -3}
k = 2
Output :
1
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, -2, 2}
 */
/*
Aryan, first of all, good job. This is not an easy problem. Many people can memorize the solution, but understanding **why Kadane + Sliding Window works** takes time.

The fact that:

1. You understood the brute force.
2. Understood why O(n²) happens.
3. Understood the Kadane array.
4. Wrote the optimal solution yourself.

is exactly how algorithmic thinking develops.

---

# Let's Verify Your First Solution

```java
long [] maxEI = new long[(int) n];

maxEI[0] = a[0];

for(int i =1;i<n;i++){
    maxEI[i] = Math.max(a[i], maxEI[i-1] + a[i]);
}
```

Perfect.

This is Kadane's DP.

Meaning:

```java
maxEI[i]
```

=

```text
Maximum sum subarray ending at index i
```

---

Then:

```java
long sum = 0;

for(int i =0;i<k;i++){
    sum += a[i];
}
```

First window of size K.

Perfect.

---

Then:

```java
for(long j = k;j<n;j++){
```

Sliding the window.

---

Window update:

```java
sum = sum + a[j] - a[j-k];
```

Perfect.

---

Then:

```java
res = Math.max(res, sum);
```

Checking exact K length.

Perfect.

---

Then:

```java
res = Math.max(res , sum + maxEI[j-k]);
```

Checking length > K.

Perfect.

---

This is the standard O(n) solution.

Complexity:

```text
Time  : O(n)
Space : O(n)
```

Accepted.

---

# About the Second Solution

Now let's discuss the interesting one.

```java
long sum = 0;
long last = 0;
```

---

What is happening?

You are maintaining:

```text
sum
=
current subarray sum
```

and

```text
last
=
elements that are beyond the minimum K length
```

---

The clever part:

```java
if(last < 0){
    sum = sum - last;
    last = 0;
}
```

Suppose:

```java
last = -5
```

Then:

```java
sum = sum - (-5)
```

which means:

```java
sum += 5
```

You are effectively removing a negative prefix.

---

This is actually a Kadane-like optimization happening on the fly.

Instead of storing:

```java
maxEndingHere[]
```

you are maintaining the useful part dynamically.

---

# Why It Works Intuitively

Imagine:

```java
arr = [1,-10,5,6]
k = 2
```

At some point:

```text
last = -9
```

The prefix before the mandatory K elements is hurting us.

So:

```java
if(last < 0)
```

remove it.

Exactly the same philosophy as Kadane:

```text
If a prefix becomes negative,
throw it away.
```

---

# Which Solution Should You Use?

For interviews:

Use the first one.

```java
Kadane Array + Sliding Window
```

Reason:

* Easier to explain.
* Standard solution.
* Interviewer immediately understands your reasoning.

---

The second solution is more like an optimization/discovery.

If an interviewer asks:

> Can you reduce the extra space?

then you can derive the second approach.

---

# What You Actually Learned Here

This problem teaches a very important pattern:

Normal Kadane:

```text
Maximum subarray sum
```

Constraint added:

```text
Length >= K
```

Whenever a constraint is added, we often combine:

```text
Kadane
+
Another technique
```

Here it became:

```text
Kadane
+
Sliding Window
```

---

And honestly, the most valuable part of your message is this:

> "first it took lot of time to understand the problem and then to understand the solution"

That's normal.

If this took you 1–2 hours, that's productive learning, not slow learning.

The next time you see a problem involving:

* "at least K"
* "exactly K"
* "maximum subarray with constraint"

your brain will immediately start thinking:

```text
Sliding Window?
Prefix Sum?
Kadane?
Can I combine them?
```
[Optimized] Sliding Window with Kadane’s Optimization- O(n) Time and O(1) Space
We can avoid the use of an extra array in the above approach.

Keep two sums: one for the current k-sized window and one for elements before it.
Slide the window through the array, updating the window sum each step.
Reset the previous sum if it becomes negative (Kadane’s idea).
Update the maximum sum using either the window sum alone or window sum + previous sum.

That's a big step forward in DSA problem-solving.
import java.util.*;

class GfG {
    static int maxSumWithK(int[] arr, int k) {

        // Calculate initial sum of
        // first k elements (first window)
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int last = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, sum);

        // Process rest of the array after first k elements
        for (int i = k; i < arr.length; i++) {

            // Add current element to window sum
            sum = sum + arr[i];

            // Add element at j to 'last' and increment j
            last = last + arr[j++];

            // Update answer if current window sum is greater
            ans = Math.max(ans, sum);

            // If sum of elements before window becomes negative
            if (last < 0) {
                sum = sum - last;
                ans = Math.max(ans, sum);
                last = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, -3};
        int k = 2;
        System.out.println(maxSumWithK(arr, k));
    }
}

[Better Approach] Kadane's Algorithm + Window Sliding - O(n) Time and O(n) Space
Use Kadane’s algorithm to store the maximum subarray sum ending at each index in maxSum[].
Find the sum of the first k elements to create the initial window.
Slide the window through the array, updating the window sum each step.
Update the answer using either the window sum or the window sum + maxSum[i-k].

import java.util.*;

class GfG {
    static int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        // maxSum[i] stores maximum sum till index i
        int[] maxSum = new int[n];
        maxSum[0] = arr[0];

        // Use Kadane's algorithm to fill maxSum[]
        int currMax = arr[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSum[i] = currMax;
        }

        // Sum of first k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Use sliding window concept
        int result = sum;
        for (int i = k; i < n; i++) {

            // Compute sum of k elements ending with arr[i]
            sum = sum + arr[i] - arr[i - k];

            // Update result if required
            result = Math.max(result, sum);

            // Include maximum sum till [i-k]
            // if it increases overall max
            result = Math.max(result, sum + maxSum[i - k]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, -3};
        int k = 2;
        System.out.println(maxSumWithK(arr, k));
    }
}
 */