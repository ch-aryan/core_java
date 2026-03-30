package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

import static java.util.Collections.swap;

class QuickAlgorithm{

    public static int[] quickSortRecursive(int[] arr, int l, int h){
        if (l < h) {
            int pivot = partition(arr, l, h);
            quickSortRecursive(arr, l, pivot - 1);
            quickSortRecursive(arr, pivot + 1, h);
        }
            return arr;

    }
    private static int partition(int [] arr, int l , int h) {


            int pivot = arr[h];
            int i = l-1;

            for (int j = l; j < h; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, h);



            return i+1;
        }



    private static void swap( int [] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,3,6,1,4,2};

int arrNew[] = QuickAlgorithm.quickSortRecursive(arr, 0, arr.length-1);
        for(int i:arrNew){
            System.out.print(i+" ");
        }

    }
}
/* 🧠 Quick Sort — Perfect Short Notes (for your revision comments)
⭐ What is Quick Sort

👉 Quick sort is a divide and conquer sorting algorithm
👉 It selects a pivot element
👉 Partitions array into:

elements smaller than pivot
elements greater than pivot

Then recursively sorts subarrays.
⭐ Steps of Quick Sort

1️⃣ Choose pivot (first / last / random / median)
2️⃣ Partition array around pivot
3️⃣ Pivot reaches its correct sorted position
4️⃣ Recursively apply quick sort on left subarray
5️⃣ Recursively apply quick sort on right subarray

⭐ Time Complexity
Best Case → O(n log n)
Average Case → O(n log n)
Worst Case → O(n²) (already sorted + bad pivot choice)
⭐ Space Complexity

👉 O(log n) (recursion stack)

⭐ Important Characteristics

✅ Very fast in practice
✅ In-place sorting
❌ Not stable
✅ Used in many real systems
✅ Cache friendly

⭐ Important Interview Line

👉 Performance depends heavily on pivot selection

Good pivot → balanced partition → fast sorting
Bad pivot → unbalanced → slow sorting

⭐ Intuition of Quick Sort (very simple story)

Think like this:

👉 You choose one element (pivot)
👉 You place pivot at its correct sorted position
👉 All smaller elements go left
👉 All bigger elements go right

Then you repeat same idea on left and right parts.

So quick sort is:

⭐ “Fix one element perfectly, then solve smaller problems.”

This is called Divide & Conquer.

🔥 Visual Dry Run (Very Important)

Array:

5 3 6 1 4 2

We choose last element as pivot → 2

⭐ Partition Step

Start:

Pivot = 2
i = -1

Now scan from left.

j = 0 → element 5
5 < 2 ? NO
(no change)
j = 1 → element 3
3 < 2 ? NO
j = 2 → element 6
6 < 2 ? NO
j = 3 → element 1
1 < 2 ? YES

So:

i++
swap arr[i] and arr[j]

Array becomes:

1 3 6 5 4 2
j = 4 → element 4
4 < 2 ? NO

Loop finished.

⭐ Now final pivot swap

Swap pivot with i+1 position

swap arr[1] and pivot

Array becomes:

1 2 6 5 4 3

⭐ Now pivot is perfectly placed

Left side:

1

Right side:

6 5 4 3

Now quick sort runs recursively.

⭐ Next recursive step (right side)

Pivot = 3

After partition:

1 2 3 5 4 6

Then pivot = 6 → partition
Then pivot = 4 → partition

Finally sorted:

1 2 3 4 5 6
🧠 Final Quick Revision Notes (paste in comments)
⭐ Quick Sort Definition

👉 Quick sort is a divide and conquer sorting algorithm
👉 It partitions array around a pivot
👉 Pivot gets its correct sorted position in each step

⭐ Key Idea

👉 Fix pivot → solve left subarray → solve right subarray
 */
/*
Perfect 👍
Now we will do exactly what you asked —
        👉 Line-by-line dry run of YOUR SAME CODE logic
👉 Especially focus on why partition returns i + 1
        👉 And how recursion uses that index

Take a deep breath 🙂
This is the moment where Quick Sort will finally “click”.

        ⭐ Initial Call from main

Array:

        5 3 6 1 4 2

Call:

quickSortRecursive(arr, 0, 5)

So:

l = 0
h = 5

Since l < h → TRUE
We go inside.

⭐ First Partition Call
int pivot = partition(arr, 0, 5);

Now enter partition.

⭐ Inside partition(arr,0,5)
int pivot = arr[h];

👉 pivot = arr[5] = 2

int i = l - 1;

👉 i = -1

Meaning:

        👉 “So far no element smaller than pivot found.”

        ⭐ Loop starts
for (j = 0 → 4)

We compare each element with pivot.

        🔹 j = 0
arr[0] = 5
        5 < 2 ? NO

👉 nothing happens
👉 i still = -1

🔹 j = 1
arr[1] = 3
        3 < 2 ? NO

👉 nothing happens

🔹 j = 2
arr[2] = 6
        6 < 2 ? NO

👉 nothing happens

🔹 j = 3
arr[3] = 1
        1 < 2 ? YES

Now:

i++

        👉 i becomes 0

Then:

swap(arr, i, j)
swap(arr, 0, 3)

Array becomes:

        1 3 6 5 4 2

Meaning:

        👉 Region [0 … i] = all elements smaller than pivot

So currently:

        [1] | rest unknown
🔹 j = 4
arr[4] = 4
        4 < 2 ? NO

Loop ends.

        ⭐ Now MOST IMPORTANT STEP
swap(arr, i+1, h);
swap(arr, 1, 5)

Array becomes:

        1 2 6 5 4 3

Now observe carefully:

        👉 Pivot = 2
        👉 All elements left of index 1 are smaller
👉 All elements right are bigger

So pivot reached final correct sorted position.

That index is:

i + 1 = 1

So function returns:

        return 1;
        ⭐ THIS is why partition returns i+1

Because:

        👉 i tracks last smaller element index
👉 Correct pivot position must be just after that

So:

        ⭐ pivot index = i + 1

This is the mathematical guarantee of partition logic.

        ⭐ Back to recursion

Now:

pivot = 1

So recursive calls:

quickSortRecursive(arr, 0, 0)
quickSortRecursive(arr, 2, 5)

Meaning:

LEFT SIDE → only element 1 → already sorted
RIGHT SIDE → {6 5 4 3}

Now quick sort continues on right part.

⭐ Second Partition (Right side)

Call:

partition(arr,2,5)
pivot = arr[5] = 3

Dry run quickly:

After partition array becomes:

        1 2 3 5 4 6

Pivot index returned = 2

Now recursion splits:

left → (2,1) stop
right → (3,5)
        ⭐ Next partition

Pivot = 6

After partition:

        1 2 3 5 4 6

Pivot index = 5

Now sort left part (3,4)

⭐ Final partition

Pivot = 4

After partition:

        1 2 3 4 5 6

Sorting finished.

        🌟 SUPER IMPORTANT FINAL UNDERSTANDING

👉 Partition does NOT fully sort array
👉 It only places ONE element (pivot) correctly

Then recursion sorts smaller problems.

So quick sort is like:

        ⭐
        “Fix one correct person in correct seat
Then divide classroom and repeat.”

        ⭐ 5-second mental model to remember i+1

Think:

i → boundary of smaller elements
pivot must sit just after boundary

So always:

pivot index = i + 1

That’s all.
Nice, this is a very important dry run — once you understand this, QuickSort becomes crystal clear 🔥

You gave:

arr = [1, 2, 3, 5, 4, 6]
l = 3
h = 5
pivot = arr[h] = 6

So we are only working on this subarray:

[5, 4, 6]   (indices 3 to 5)
🔹 Step 1: Initial Setup
pivot = arr[h] = 6
i = l - 1 = 3 - 1 = 2

So:

i = 2
j will run from 3 → 4
🔹 Step 2: Loop starts (for j = l to h-1)
👉 Iteration 1: j = 3
arr[j] = arr[3] = 5
pivot = 6

Check:

5 < 6 ✅

So:

i++ → i = 3
swap(arr, i, j) → swap(arr[3], arr[3])

Array stays same:

[1, 2, 3, 5, 4, 6]
👉 Iteration 2: j = 4
arr[j] = arr[4] = 4
pivot = 6

Check:

4 < 6 ✅

So:

i++ → i = 4
swap(arr, 4, 4)

Array still same:

[1, 2, 3, 5, 4, 6]
🔹 Step 3: Final Pivot Swap

After loop:

swap(arr, i + 1, h)
swap(arr, 5, 5)

Array:

[1, 2, 3, 5, 4, 6]
🔹 Step 4: Return pivot index
return i + 1 = 5
🔥 Final Understanding
What happened?
All elements [5, 4] were already less than pivot (6)
So:
No real swaps happened
Pivot stayed in same place
🔹 After Partition

Now recursive calls:

quickSortRecursive(arr, 3, 4)   // LEFT
quickSortRecursive(arr, 6, 5)   // RIGHT (ignored)
🔹 Now focus on LEFT → [5, 4]
New call:
l = 3, h = 4
pivot = arr[4] = 4
i = 2
Loop:
j = 3 → arr[3] = 5
5 < 4 ❌

No swap

Final swap:
swap(arr, i+1, h) → swap(arr, 3, 4)

Array becomes:

[1, 2, 3, 4, 5, 6]
🔥 Final Output
[1, 2, 3, 4, 5, 6]
💡 Key Insight (VERY IMPORTANT)

When pivot is largest element (like 6):

All elements go to left
No real partition happens
Worst-case behavior starts forming
⚡ Pro Insight (Interview Level)

If pivot is always the largest or smallest element, QuickSort degrades to O(n²).
 */