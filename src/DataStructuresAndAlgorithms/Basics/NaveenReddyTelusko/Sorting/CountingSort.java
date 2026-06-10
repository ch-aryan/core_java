package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

public class CountingSort {
    public static void sortMeth(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] freq = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                arr[idx++] = i + min;
                freq[i]--;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
        public static void countStableMeth(int arr[]){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
    int temp[] = new int[arr.length];
            for (int i : arr) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            int [] freq = new int[max - min + 1];

            for(int i:arr){
                freq[i- min]++;
            }

            for(int i=1;i<freq.length;i++){
                freq[i] = freq[i-1] + freq[i];
            }

            for(int i = arr.length-1; i>=0;i --){
               temp[--freq[arr[i]- min]] = arr[i];
            }
            /*
            The line
temp[--freq[arr[i]-min]] = arr[i];
can be read as:
"Find the last available position for this value and place it there."
The prefix sum tells you where the block of a value ends, and the --freq[...] moves backward through
that block as duplicates are placed. That's the entire trick behind stable counting sort.
             */

            for(int i: temp){
                System.out.print(i+" ");
            }
        }

    public static void main(String[] args) {
        int arr[] = {9,3,9,5,5,4,2,1,8,9,8,3,1};
        int arr1[] = {-3,2,-1,0,-2,-2,3,3,5,4};
        sortMeth(arr1);
        System.out.println("******");
        sortMeth(arr);
        System.out.println("*****");
        countStableMeth(arr);
        System.out.println("********");
        countStableMeth(arr1);
    }
}
/*
You’ve actually written a very solid counting sort 👍 — especially the way you handled negative numbers using min shift. That’s something many people miss.

Let’s be precise and a bit strict (like an interviewer would be).

✅ Is your code perfect?

👉 For basic counting sort → YES, it is correct and well-written

What you did right:
✔ Found min and max → supports negative values
✔ Created correct frequency array (max - min + 1)
✔ Used index shifting (num - min) properly
✔ Rebuilt the array correctly
✔ Clean and readable
⚠️ Small but important note (to level up)

Your implementation is:

✅ Correct but NOT stable

What does that mean?
If there are duplicate elements, their original order is not preserved

👉 In many interview questions (especially advanced ones), they may expect:

Stable counting sort (used in Radix Sort)

But:

For most coding problems → your version is perfectly acceptable
🧠 Counting Sort — Clean Definition (Interview Ready)

Counting sort is a non-comparison sorting algorithm that sorts elements by counting the frequency of each value and reconstructing the sorted array using those counts.

🔑 Main Idea (Algorithm in Words)
Find the range of elements (min and max)
Create a count (frequency) array
Count how many times each element appears
Use the count array to rebuild the sorted array
🎯 One-line definition (memorize this)

Counting sort sorts elements by counting occurrences instead of comparing elements.

⚡ Key Characteristics (very important)
❌ No comparisons
❌ No swapping
✅ Based on counting frequency
✅ Time complexity: O(n + k)
n = number of elements
k = range (max - min)
🚫 When it is NOT good

Be careful here (this is where many fail):

If range is large → ❌ memory waste
Example: values from 1 to 10^9
🧩 Mental Model (lock it)
Selection Sort → Find minimum
Insertion Sort → Insert in correct place
Counting Sort → Count and rebuild
💡 Final honest feedback for you

The fact that you:

remembered logic
handled negatives
wrote clean loops

👉 This is above average level already

Now next step (if you want to go pro):

Learn stable counting sort (prefix sum version)
Then connect it to Radix Sort

Exactly! You're thinking in the right direction.

Let's break this line into two parts:

```java
temp[--freq[arr[i] - min]] = arr[i];
```

Suppose:

```java
arr[i] = 2
```

and

```java
freq[0] = 2
```

(after prefix sum).

---

### First the `--freq[...]`

```java
--freq[0]
```

This is **pre-decrement**.

So:

```java
freq[0] = 2
```

becomes

```java
freq[0] = 1
```

and the expression returns:

```java
1
```

Therefore:

```java
temp[1] = 2;
```

---

### Why decrement first?

Remember that after prefix sums:

```java
freq[0] = 2
```

means:

> "The value 2 should occupy positions up to index 1."

Not index 2.

Because arrays are 0-based.

For example:

```java
temp = [_, _, _, _, _]
         0  1  2  3  4
```

If there are 2 occurrences of value 2, their positions are:

```java
0 and 1
```

not

```java
1 and 2
```

So we must convert:

```java
2 -> 1
```

before using it as an index.

That's why we do:

```java
--freq[0]
```

instead of

```java
freq[0]--
```

---

### What if we used `freq[0]--`?

Suppose:

```java
freq[0] = 2
```

Then:

```java
temp[freq[0]--] = 2;
```

would place at:

```java
temp[2]
```

which is wrong.

Afterward freq becomes:

```java
1
```

But the placement already happened at the wrong index.

---

### So `--freq[...]` does TWO things

1. **Converts the prefix sum position into a valid array index**

   ```java
   2 -> 1
   ```

2. **Updates the next available slot for duplicates**

   ```java
   freq[0] = 2
   freq[0] = 1
   freq[0] = 0
   ```

---

Example with two 2's:

Prefix sum:

```java
freq[0] = 2
```

First 2:

```java
--freq[0]  // 1
temp[1] = 2
```

Second 2:

```java
--freq[0]  // 0
temp[0] = 2
```

Result:

```java
temp = [2, 2, _, _, _]
```

So yes, your understanding is correct:

> `--freq[...]` both decreases the frequency counter and gives the correct 0-based position in the `temp` array where the element should be placed.

Yes. Both are **Counting Sort**, but they solve slightly different problems.

---

# 1. First Method: Simple Counting Sort

```java
for (int i = 0; i < freq.length; i++) {
    while (freq[i] > 0) {
        arr[idx++] = i + min;
        freq[i]--;
    }
}
```

### Idea

Count how many times each number appears.

Example:

```java
arr = [4, 2, 2, 8, 3]
```

Frequency array:

```java
2 -> 2 times
3 -> 1 time
4 -> 1 time
8 -> 1 time
```

Then simply write them back:

```java
2 2 3 4 8
```

---

### Dry Run

Input:

```java
[4,2,2,8,3]
```

Freq:

```java
index: 0 1 2 3 4 5 6
value: 2 1 1 0 0 0 1
```

(assuming min=2)

Now:

```java
i=0 -> write 2 twice
i=1 -> write 3 once
i=2 -> write 4 once
i=6 -> write 8 once
```

Result:

```java
[2,2,3,4,8]
```

---

### Time Complexity

```text
O(n + range)
```

### Space

```text
O(range)
```

---

### Limitation

This version is **NOT STABLE**.

Why?

Because it only knows frequencies.

It completely forgets the original order of equal elements.

---

Suppose:

```java
[(2,A), (1,B), (2,C)]
```

After sorting:

```java
(1,B), (2,?), (2,?)
```

The algorithm doesn't know whether A came before C.

That information is lost.

---

# 2. Second Method: Stable Counting Sort

This is the version used internally when counting sort is used as a subroutine in algorithms like:

* Radix Sort
* Bucket Sort variants

---

## Step 1: Frequency Count

```java
for(int i : arr){
    freq[i-min]++;
}
```

Example:

```java
arr = [4,2,2,8,3]
```

Freq:

```java
[2,1,1,0,0,0,1]
```

---

## Step 2: Prefix Sum

```java
for(int i=1;i<freq.length;i++){
    freq[i] = freq[i-1] + freq[i];
}
```

This converts frequencies into positions.

---

Example

Before:

```java
[2,1,1,0,0,0,1]
```

After prefix sum:

```java
[2,3,4,4,4,4,5]
```

Meaning:

```text
2 ends at index 1
3 ends at index 2
4 ends at index 3
8 ends at index 4
```

---

# Why Prefix Sum?

Because now we know the exact final position of every value.

---

Example:

```java
[4,2,2,8,3]
```

Prefix:

```java
[2,3,4,4,4,4,5]
```

Interpretation:

```text
Value 2 occupies positions 0..1
Value 3 occupies position 2
Value 4 occupies position 3
Value 8 occupies position 4
```

---

# Step 3: Traverse From Right

```java
for(int i = arr.length-1; i>=0; i--){
    temp[--freq[arr[i]-min]] = arr[i];
}
```

This is the most important line.

---

Let's dry run.

Input:

```java
[4,2,2,8,3]
```

Prefix:

```java
[2,3,4,4,4,4,5]
```

Temp:

```java
[_,_,_,_,_]
```

---

### Element 3

```java
freq[1] = 3

--freq[1]
```

becomes

```java
2
```

Place:

```java
temp[2] = 3
```

---

### Element 8

```java
freq[6] = 5

--freq[6]
```

becomes

```java
4
```

Place:

```java
temp[4] = 8
```

---

### Element 2

```java
freq[0] = 2

--freq[0]
```

becomes

```java
1
```

Place:

```java
temp[1] = 2
```

---

### Element 2

```java
freq[0] = 1

--freq[0]
```

becomes

```java
0
```

Place:

```java
temp[0] = 2
```

---

### Element 4

```java
freq[2] = 4

--freq[2]
```

becomes

```java
3
```

Place:

```java
temp[3] = 4
```

---

Result:

```java
[2,2,3,4,8]
```

---

# Why Traverse From Right?

This is what makes it stable.

Consider:

```java
[(2,A), (1,B), (2,C)]
```

Prefix:

```java
1 -> 1
2 -> 3
```

Process from right:

### C

```java
temp[2] = C
```

### A

```java
temp[1] = A
```

Result:

```java
(1,B), (2,A), (2,C)
```

Order preserved.

---

If we processed from left:

### A

```java
temp[2] = A
```

### C

```java
temp[1] = C
```

Result:

```java
(1,B), (2,C), (2,A)
```

Order changed.

Not stable.

---

# Key Difference

| Feature              | Simple Version | Stable Version |
| -------------------- | -------------- | -------------- |
| Uses frequency count | ✅              | ✅              |
| Uses prefix sum      | ❌              | ✅              |
| Extra output array   | ❌              | ✅              |
| Stable               | ❌              | ✅              |
| Space                | O(range)       | O(range + n)   |
| Faster to understand | ✅              | ❌              |
| Used in Radix Sort   | ❌              | ✅              |

---

The line

```java
temp[--freq[arr[i]-min]] = arr[i];
```

can be read as:

> "Find the last available position for this value and place it there."

The prefix sum tells you **where the block of a value ends**, and the `--freq[...]` moves backward through that block as duplicates are placed. That's the entire trick behind stable counting sort.

 */