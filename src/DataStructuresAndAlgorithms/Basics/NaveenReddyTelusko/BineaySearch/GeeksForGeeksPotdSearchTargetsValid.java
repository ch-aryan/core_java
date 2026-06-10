package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

public class GeeksForGeeksPotdSearchTargetsValid {
    class Solution {
        public int binarySearchable(int[] arr) {
            // code here
            int count = binarySearchTree(arr, 0, arr.length-1, -1, (int) 1e9);
            return count;
        }
        public int binarySearchTree(int arr[], int l, int r, int lr, int rl){
            if(l > r) return 0;
            int ans = 0;
            int m = (l+r) /2;
            if(lr < arr[m] && arr[m] < rl) ans=1;

            int lans = binarySearchTree(arr, l, m-1,lr,Math.min(rl, arr[m]));
            int rans = binarySearchTree(arr, m+1, r, Math.max(lr, arr[m]), rl);

            return ans + lans + rans;
        }
    }
}
/*
Absolutely, mama. This problem becomes much easier when you stop thinking about arrays and start thinking about the **binary search decision tree**.

Let's dry-run a small example.

---

# Example

```text
arr = [2,3,1,5,8,7,9]
```

Initial call:

```java
binarySearchable(arr, 0, 6, -INF, INF)
```

Meaning:

```text
We are looking at indices [0..6]

Any searchable element here must satisfy:

-INF < value < INF
```

Obviously every number satisfies this.

---

# Step 1: Root

Current range:

```text
l=0
r=6

mid=(0+6)/2=3
```

```text
arr[3] = 5
```

Tree:

```text
          5
```

Check:

```text
-INF < 5 < INF
```

True.

```text
count = 1
```

---

## Left Recursive Call

Code:

```java
binarySearchable(arr,
                 0,
                 2,
                 -INF,
                 min(INF,5))
```

becomes:

```java
binarySearchable(arr,
                 0,
                 2,
                 -INF,
                 5)
```

Why?

Because anybody in the left subtree must be:

```text
smaller than 5
```

---

## Right Recursive Call

Code:

```java
binarySearchable(arr,
                 4,
                 6,
                 max(-INF,5),
                 INF)
```

becomes:

```java
binarySearchable(arr,
                 4,
                 6,
                 5,
                 INF)
```

Why?

Because anybody in the right subtree must be:

```text
greater than 5
```

---

# Step 2: Left Subtree

Call:

```java
binarySearchable(arr,0,2,-INF,5)
```

Subarray:

```text
[2,3,1]
```

Middle:

```text
mid=1

arr[1]=3
```

Tree:

```text
          5
         /
        3
```

Allowed range:

```text
(-INF,5)
```

Check:

```text
-INF < 3 < 5
```

True.

```text
count++
```

---

## Left of 3

Call:

```java
binarySearchable(arr,
                 0,
                 0,
                 -INF,
                 min(5,3))
```

becomes:

```java
binarySearchable(arr,
                 0,
                 0,
                 -INF,
                 3)
```

Meaning:

```text
Any searchable element here
must be less than 3.
```

---

## Right of 3

Call:

```java
binarySearchable(arr,
                 2,
                 2,
                 max(-INF,3),
                 5)
```

becomes:

```java
binarySearchable(arr,
                 2,
                 2,
                 3,
                 5)
```

Meaning:

```text
Any searchable element here
must satisfy

3 < value < 5
```

---

# Step 3: Node 2

Call:

```java
binarySearchable(arr,0,0,-INF,3)
```

Middle:

```text
arr[0]=2
```

Check:

```text
-INF < 2 < 3
```

True.

Count it.

---

# Step 4: Node 1

Call:

```java
binarySearchable(arr,2,2,3,5)
```

Middle:

```text
arr[2]=1
```

Check:

```text
3 < 1 < 5
```

False.

Don't count.

---

## Why is 1 rejected?

Think about actual Binary Search.

Searching for 1:

```text
mid=3 → value=5

1<5
go left
```

Good.

Then:

```text
mid=1 → value=3

1<3
go left
```

Good.

Then:

```text
mid=0 → value=2

1<2
go left
```

Search ends.

Never reaches index 2.

So 1 is not searchable.

The range check discovered this without simulating the search.

---

# Now Right Subtree

Call:

```java
binarySearchable(arr,4,6,5,INF)
```

Subarray:

```text
[8,7,9]
```

Middle:

```text
arr[5]=7
```

Check:

```text
5 < 7 < INF
```

True.

Count it.

---

Left child:

```java
binarySearchable(arr,4,4,5,7)
```

Value:

```text
8
```

Check:

```text
5 < 8 < 7
```

False.

Rejected.

---

Right child:

```java
binarySearchable(arr,6,6,7,INF)
```

Value:

```text
9
```

Check:

```text
7 < 9 < INF
```

True.

Count it.

---

# Visualizing Constraints

When we reach node 1:

```text
          5
         /
        3
         \
          1
```

The path says:

```text
1 is in right subtree of 3
⇒ should be > 3

1 is in left subtree of 5
⇒ should be < 5
```

Therefore:

```text
3 < value < 5
```

But:

```text
value = 1
```

Violation.

Rejected.

---

# The Recursion Parameters

The most important thing to remember:

```java
(l,r,lr,rl)
```

means:

```text
Look only in subarray [l..r]

Any searchable element here
must satisfy

lr < value < rl
```

Where:

```text
lr = largest lower bound seen so far

rl = smallest upper bound seen so far
```

Every recursive call tightens these bounds.

That's why the solution is called **Range Constraints**.

Instead of asking:

> "Can Binary Search find this element?"

it asks:

> "Is this element valid for all decisions that would be made before reaching it?"

That's the beautiful greedy observation behind the O(n) solution.

Aha! Now everything makes sense. 😄

The reason our prefix-max/suffix-min approach failed is because we were solving a **different condition**.

The editorial's optimization is much smarter. Let's build the intuition.

---

# The Big Insight

Binary Search doesn't compare with **all elements**.

It only compares with the elements that appear on the search path.

For:

```text
[1,3,2]
```

The search path for finding `3` is:

```text
mid = 1
```

Done.

It never looks at `2`.

That's why our condition:

```text
all left smaller
all right larger
```

was too strict.

---

# Think of Binary Search as a Tree

For:

```text
[2,3,1,5,8,7,9]
```

Middle element:

```text
5
```

becomes root.

```text
          5
        /   \
       ?     ?
```

Left half:

```text
[2,3,1]
```

Middle:

```text
3
```

Right half:

```text
[8,7,9]
```

Middle:

```text
7
```

Tree:

```text
          5
        /   \
       3     7
      / \   / \
     2  1  8  9
```

Notice:

This is **not a BST**.

It is just the Binary Search decision tree.

---

# Let's examine node 1

Path from root:

```text
5 -> 3 -> 2
```

To reach node 1:

At 5:

```text
1 < 5
```

must go left.

At 3:

```text
1 < 3
```

must go left.

At 2:

```text
1 < 2
```

must go left.

But node 1 is actually sitting elsewhere.

So Binary Search can never reach it.

---

# Range Idea

Instead of checking every search individually, keep track of:

```text
minimum value allowed
maximum value allowed
```

for each node.

---

For root:

```text
(-∞ , +∞)
```

Everything is allowed.

---

For left child of 5:

```text
(-∞ , 5)
```

because anything found in the left subtree must be smaller than 5.

---

For right child of 5:

```text
(5 , +∞)
```

because anything found in the right subtree must be greater than 5.

---

# Example

Tree:

```text
          5
        /   \
       3     7
```

For node 3:

Allowed range:

```text
(-∞ , 5)
```

Check:

```text
3 belongs to (-∞,5)
```

✔ searchable

---

For node 7:

Allowed range:

```text
(5,+∞)
```

Check:

```text
7 belongs there
```

✔ searchable

---

# Why Greedy?

The clever part is:

When moving left:

```java
newUpper = min(currentUpper, arr[mid]);
```

When moving right:

```java
newLower = max(currentLower, arr[mid]);
```

You're greedily tightening the valid range.

---

That's why the recursion is:

```java
left:
(l, m-1, lr, min(rl, arr[m]))
```

```java
right:
(m+1, r, max(lr, arr[m]), rl)
```

---

# Understanding the Parameters

```java
binarySearchable(arr, l, r, lr, rl)
```

means:

```text
Current subarray = [l...r]

Every searchable element here
must satisfy

lr < element < rl
```

---

For root:

```java
binarySearchable(arr, 0, n-1, -INF, INF)
```

---

# Why O(n)?

Each element becomes a midpoint exactly once.

For every midpoint:

```java
constant work
```

Therefore:

```text
O(n)
```

instead of

```text
O(n log n)
```

---

# The key lesson

Your solution:

```text
For each element,
simulate Binary Search.
```

asks:

> "Can Binary Search find this value?"

The greedy solution asks:

> "What values are even allowed to exist at this position if Binary Search is ever going to reach them?"

That range constraint lets us classify every midpoint in one traversal instead of performing `n` separate binary searches.

This is a beautiful example of converting:

```text
Repeated simulation
```

into

```text
Constraint propagation
```

which is a very common pattern in Greedy, Trees, and Advanced DSA problems.

 */