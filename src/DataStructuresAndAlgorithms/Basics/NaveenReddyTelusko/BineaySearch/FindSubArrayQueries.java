package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class FindSubArrayQueries {
    public static ArrayList<Integer> algoOptimal(int arr[] , int queries[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            if (!map.containsKey(x)) {
                res.add(0);
                continue;
            }
            ArrayList<Integer> indices = map.get(x);
            int leftFirst = LowerBound(indices, l);
            int rightEnd = UpperBound(indices, r);

            res.add(rightEnd -leftFirst);
        }
        return res;
    }
    public static int LowerBound(ArrayList<Integer> indices, int l){
        int low = 0;
        int high = indices.size();
        while(low < high){
            int mid = low + (high - low) /2;
            if(indices.get(mid) >= l){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int UpperBound(ArrayList<Integer> indices, int l){
        int low = 0;
        int high = indices.size();
        while(low < high){
            int mid = low + (high - low) /2;
            if(indices.get(mid) > l){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static ArrayList<Integer> bruteForce(int arr[] , int queries[][]){
        int n = queries.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i =0; i< n;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];
            int count = 0;
            while(l<=r){
                if(arr[l] == x){
                    count++;
                }
                l++;
            }
            res.add(count);
        }
        return res;
    }
    public static void main(String[] args) {
      int  arr[] = {1, 2, 1, 3, 1, 2, 3} ;
      int queries[][] = {{0, 4, 1}, {2, 5, 2}, {1, 6, 3}, {0, 6, 5}};

        bruteForce(arr, queries).forEach(i-> System.out.print(i+" "));
        System.out.println();
       // ArrayList<Integer> integers = ""
//        Iterator<Integer> iterator = integers.iterator();
//       while (iterator.hasNext()){
//           System.out.println(iterator.next());
//       }
        algoOptimal(arr, queries).forEach(i-> System.out.print(i+" "));
    }
}
/*
Subarray Frequency Count Queries
Difficulty: MediumAccuracy: 63.19%Submissions: 2K+Points: 4Average Time: 25m
Given an array arr[] of n integers and a 2D array queries[][] representing q queries, where each queries[i] consists of three integers: l, r, and x. For each query determine how many times the element x appears in the arr[] from index l to r (both inclusive).

Return a list of integers where the i-th value represents the answer to the i-th query.

Examples:

Input: arr[] = [1, 2, 1, 3, 1, 2, 3], queries[][] = [[0, 4, 1], [2, 5, 2], [1, 6, 3], [0, 6, 5]]
Output: [3, 1, 2, 0]
Explanation:
query [0, 4, 1] -> Subarray = [1, 2, 1, 3, 1], 1 appears 3 times
query [2, 5, 2] -> Subarray = [1, 3, 1, 2], 2 appears 1 time
query [1, 6, 3] -> Subarray = [2, 1, 3, 1, 2, 3] 3 appears 2 times
query [0, 6, 5] -> Subarray = [1, 2, 1, 3, 1, 2, 3],  5 appears 0 times
Input: arr[] = [11, 21, 51, 101, 11, 51], queries[][] = [[0, 4, 11], [2, 5, 51]]
Output: [2, 2]
Explanation:
query [0, 4, 11] -> Subarray = [11, 21, 51, 101, 11], 11 appears 2 times
query [2, 5, 51] -> Subarray = [51, 101, 11, 51], 51 appears 2 times
 */
/*
Absolutely! This is one of those Java lines that looks magical the first time you see it.

Let's break it down **like a table feed**, one step at a time.

---

# First Understand What the Map Stores

```java
HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
```

Read this as:

```text
Key     -> Value

Integer -> ArrayList<Integer>
```

Example:

```java
1 -> [0,2,4]
2 -> [1,5]
3 -> [3,6]
```

So the **value itself is an ArrayList**.

---

# Iteration 1

```java
i = 0
arr[0] = 1
```

---

## Line 1

```java
map.putIfAbsent(1, new ArrayList<>());
```

Since key `1` does not exist:

```java
1 -> []
```

Map becomes:

```java
{
    1 = []
}
```

---

## Line 2

```java
map.get(1)
```

What does this return?

The value associated with key `1`.

So:

```java
map.get(1)
```

returns:

```java
[]
```

which is actually an `ArrayList<Integer>` object.

---

Now substitute:

```java
map.get(1).add(0);
```

becomes conceptually:

```java
[].add(0);
```

After adding:

```java
[0]
```

Map becomes:

```java
{
    1 = [0]
}
```

---

# Iteration 2

```java
i = 1
arr[1] = 2
```

---

### putIfAbsent

```java
map.putIfAbsent(2, new ArrayList<>());
```

Map:

```java
{
    1 = [0],
    2 = []
}
```

---

### get

```java
map.get(2)
```

returns:

```java
[]
```

---

### add

```java
map.get(2).add(1);
```

Map:

```java
{
    1 = [0],
    2 = [1]
}
```

---

# Iteration 3

```java
i = 2
arr[2] = 1
```

---

### putIfAbsent

```java
map.putIfAbsent(1, new ArrayList<>());
```

Key already exists.

Nothing happens.

Map:

```java
{
    1 = [0],
    2 = [1]
}
```

---

### get

```java
map.get(1)
```

returns:

```java
[0]
```

---

### add

```java
map.get(1).add(2);
```

becomes:

```java
[0].add(2);
```

Now:

```java
[0,2]
```

Map:

```java
{
    1 = [0,2],
    2 = [1]
}
```

---

# Why Does add() Update the Map Automatically?

This is the most important part.

Many beginners think:

```java
map.get(1)
```

returns a copy.

❌ No.

It returns a **reference to the actual ArrayList stored inside the map**.

Think:

```java
Map
 |
 +--> key 1 ----> ArrayList Object
                     [0,2]
```

When you do:

```java
map.get(1).add(4);
```

you are modifying the same ArrayList object.

So the map automatically "sees" the change because the map is holding that exact object.

---

# Let's Make It More Explicit

This:

```java
map.get(arr[i]).add(i);
```

can be written as:

```java
ArrayList<Integer> list = map.get(arr[i]);

list.add(i);
```

Exactly the same thing.

---

# Is This Method Chaining?

Technically yes, but not in the Stream API sense.

Example:

```java
map.get(arr[i]).add(i);
```

Step 1:

```java
map.get(arr[i])
```

returns an object.

Step 2:

```java
.add(i)
```

is called on that returned object.

So it is:

```java
(object returned by get()).add(...)
```

which is a form of method chaining.

---

# Think of It Like a Box

Suppose:

```java
1 -> Box A
2 -> Box B
```

and

```java
Box A = [0,2]
Box B = [1]
```

When you do:

```java
map.get(1)
```

you get a handle to **Box A**.

Then:

```java
.add(4)
```

puts `4` inside Box A.

Now Box A becomes:

```java
[0,2,4]
```

Since the map points to Box A, the map automatically shows:

```java
1 -> [0,2,4]
```

without needing another `put()`.

---

This understanding is very important because you'll soon see similar code everywhere:

```java
map.get(key).add(value);

map.get(key).remove(value);

map.get(key).contains(value);
```

especially in Graphs, Hashing, BFS, DFS, and Advanced DSA. Once you understand that **the map stores a reference to an ArrayList object**, these lines stop looking magical and start looking completely normal. 😊


Perfect. Since you've already discovered most of the idea yourself, let's write it step by step and understand **why every line exists**.

---

# Step 1: Build the HashMap

For:

```java
arr = [1,2,1,3,1,2,3]
```

We want:

```java
1 -> [0,2,4]
2 -> [1,5]
3 -> [3,6]
```

Why?

Because for any query asking about `1`, we can directly jump to all positions where `1` occurs instead of scanning the entire array.

---

## Code

```java
HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

for(int i = 0; i < arr.length; i++) {

    // If this number is appearing for the first time,
    // create an empty list for it.
    map.putIfAbsent(arr[i], new ArrayList<>());

    // Store the current index.
    map.get(arr[i]).add(i);
}
```

---

# Dry Run

### i = 0

```java
arr[0] = 1
```

Map:

```java
1 -> [0]
```

---

### i = 1

```java
arr[1] = 2
```

Map:

```java
1 -> [0]
2 -> [1]
```

---

### i = 2

```java
arr[2] = 1
```

Map:

```java
1 -> [0,2]
2 -> [1]
```

---

### i = 3

```java
arr[3] = 3
```

Map:

```java
1 -> [0,2]
2 -> [1]
3 -> [3]
```

---

### i = 4

```java
arr[4] = 1
```

Map:

```java
1 -> [0,2,4]
2 -> [1]
3 -> [3]
```

---

Continue similarly:

```java
1 -> [0,2,4]
2 -> [1,5]
3 -> [3,6]
```

Done.

---

# Step 2: Process Each Query

Suppose query:

```java
[2,5,1]
```

Meaning:

```java
l = 2
r = 5
x = 1
```

---

First check:

```java
if(!map.containsKey(x))
```

Why?

Because:

```java
[0,6,5]
```

asks for number `5`.

But:

```java
5
```

doesn't exist in the array.

Answer:

```java
0
```

immediately.

---

# Step 3: Get Index List

```java
ArrayList<Integer> indices = map.get(x);
```

For:

```java
x = 1
```

we get:

```java
indices = [0,2,4]
```

---

# Step 4: Binary Search

We need:

### Left Boundary

Find first index ≥ l

For:

```java
l = 2
```

inside:

```java
[0,2,4]
```

Answer:

```java
position = 1
```

because:

```java
indices.get(1) = 2
```

---

### Right Boundary

Find first index > r

For:

```java
r = 5
```

inside:

```java
[0,2,4]
```

There is no value > 5.

So insertion position becomes:

```java
3
```

(end of list)

---

Count:

```java
rightPos - leftPos

3 - 1 = 2
```

Answer:

```java
2
```

---

# Complete Code

```java
class Solution {

    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {

        ArrayList<Integer> answer = new ArrayList<>();

        // value -> list of indices where it occurs
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Build the hashmap
        for(int i = 0; i < arr.length; i++) {

            map.putIfAbsent(arr[i], new ArrayList<>());

            map.get(arr[i]).add(i);
        }

        // Process every query
        for(int[] query : queries) {

            int l = query[0];
            int r = query[1];
            int x = query[2];

            // If x does not exist in array
            if(!map.containsKey(x)) {
                answer.add(0);
                continue;
            }

            ArrayList<Integer> indices = map.get(x);

            // First position having value >= l
            int leftPos = lowerBound(indices, l);

            // First position having value > r
            int rightPos = upperBound(indices, r);

            answer.add(rightPos - leftPos);
        }

        return answer;
    }

    // First position where value >= target
    private int lowerBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // First position where value > target
    private int upperBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while(low < high) {

            int mid = low + (high - low) / 2;

            if(list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
```

---

### Time Complexity

Building map:

```text
O(n)
```

Each query:

* lowerBound → O(log n)
* upperBound → O(log n)

So:

```text
O(log n)
```

per query.

Overall:

```text
O(n + q log n)
```

This is a classic pattern worth remembering:

> **Value → Sorted List of Indices → Binary Search on Indices**

You'll see the same idea again in advanced range-query problems and even in some interview questions from companies.

You're very close, but there is a subtle issue.

Suppose:

```java
indices = [0, 2, 4]
l = 2
r = 5
```

You said:

> find where l is and where r is and count

This works if **both l and r exist in the list**.

But what if:

```java
l = 1
r = 3
```

Now:

```java
indices = [0,2,4]
```

Neither `1` nor `3` is present!

Yet the answer should be:

```java
2 is between 1 and 3
```

So count = 1.

---

This is why we don't search for:

```java
find l
find r
```

Instead, we search for:

### 1. First position ≥ l

For:

```java
indices = [0,2,4]
l = 1
```

The first element ≥ 1 is:

```java
2
```

which is at position `1` in the list.

---

### 2. First position > r

For:

```java
r = 3
```

The first element > 3 is:

```java
4
```

which is at position `2` in the list.

---

Then:

```java
count = 2 - 1 = 1
```

Correct answer.

---

Let's test another one:

```java
indices = [0,2,4]

l = 2
r = 5
```

First element ≥ 2:

```java
2
```

position = 1

First element > 5:

No such element.

So binary search returns insertion position:

```java
3
```

(the end of the list)

Count:

```java
3 - 1 = 2
```

which corresponds to:

```java
[2,4]
```

Correct.

---

The beautiful idea is:

You're not searching for the values `l` and `r`.

You're searching for the **boundaries of the valid range** inside the sorted index list.

This is a very common binary search pattern used in:

* Frequency queries
* Lower Bound / Upper Bound problems
* Range counting
* Search Insert Position

And I can see your thinking is improving a lot. A few months ago you would have jumped straight to the solution. Now you're doing what strong problem solvers do:

**Brute Force → Find bottleneck → Think about data structure → Think about searching efficiently inside that data structure.**

That's exactly the skill that helps in interviews and contests.

 */