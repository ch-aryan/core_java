package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static ArrayList<int[]> mergeOverLap(int[][] arr){
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int [] curr = arr[0];// 1,3
        for(int i=1;i<arr.length;i++){
            if(curr[1]>= arr[i][0]){
                curr[1] = Math.max(curr[1], arr[i][1]);
            }else{
                res.add(curr);
                curr = arr[i];
            }
        }
        res.add(curr);
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3}, {2,4}, {6,8}, {9,10}};

        ArrayList<int[]> result = mergeOverLap(arr);

        for(int i = 0; i < result.size(); i++){
            int[] interval = result.get(i);
            System.out.println(interval[0] + " " + interval[1]);
        }

    }
}
/*
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging will become [1, 4]. Therefore we will return [[1, 4], [6, 8], [9, 10]].
Input: arr[][] = [[6, 8], [1, 9], [2, 4], [4, 7]]
Output: [[1, 9]]
Explanation: In the given intervals all the intervals overlap with the interval [1, 9]. Therefore we will return [1, 9].
🔥 Correct Thinking (This is what you were trying to do)

Here is the clean intuition you should lock in your brain:

Sort intervals by start
Take first interval → call it current
Loop through rest:
If overlapping → merge
Else → store current and move ahead

🔥 Step 2: What does arr[0] return?
int[] ele = arr[0];

👉 arr[0] is NOT a single value

👉 It returns:

{1, 3}

So:

ele → [1, 3]

You thought:

we must do arr[0][0]

That’s only when you want a single number

Expression	Meaning
arr[0]	entire row → {1,3}
arr[0][0]	first element → 1
arr[0][1]	second element → 3

🧠 Why sorting is needed here?

Your goal in merge intervals is:

Compare current interval with the next closest interval

If the array is not sorted, you might compare:

[5,7] with [1,3] ❌ (wrong order)

So first we force order:

[1,3], [1,4], [2,6], [5,7]

Now merging becomes logical.

🔥 This Line is the Heart
Arrays.sort(arr, (a, b) -> a[0] - b[0]);

Let’s decode it slowly 👇

🧩 What is a and b here?

Each element in arr is:

int[] → {start, end}

So:

a = {1, 3}
b = {2, 6}
⚙️ What does (a, b) -> a[0] - b[0] mean?

This is a custom comparator

👉 It tells Java:

“Sort based on the first element (start time)”

📊 How comparison works
Expression	Meaning
a[0] - b[0] < 0	a comes before b
a[0] - b[0] > 0	b comes before a
= 0	equal

Example
a = {1,3}
b = {2,6}

a[0] - b[0] = 1 - 2 = -1

👉 So:

a comes before b
Without sorting:
❌ Complex comparisons
With sorting:
✅ Just compare with next interval
 */

/*
⚠️ Important Interview Insight

Sometimes they ask:

👉 “What if start times are equal?”

Then you can do:

Arrays.sort(arr, (a, b) -> {
    if(a[0] == b[0]) return a[1] - b[1];
    return a[0] - b[0];
});

🧠 First, what your comparator says
Arrays.sort(arr, (a, b) -> {
    if(a[0] == b[0]) return a[1] - b[1];
    return a[0] - b[0];
});

👉 Meaning:

Sort by start time (a[0])
If start is same → sort by end time (a[1])
🔢 Example Input
int[][] arr = {
    {2, 6},
    {1, 3},
    {1, 4},
    {5, 7}
};
🔍 Step-by-step Sorting (Dry Run Thinking)

Java internally compares pairs (you don’t control order), but let’s simulate important comparisons.

🆚 Comparison 1
a = {2,6}
b = {1,3}

Check:

a[0] - b[0] = 2 - 1 = +1

👉 Positive → b comes before a

✅ Order becomes:

{1,3}, {2,6}
🆚 Comparison 2
a = {1,3}
b = {1,4}

Now:

a[0] == b[0]  ✅

So:

a[1] - b[1] = 3 - 4 = -1

👉 Negative → a comes before b

✅ Order:

{1,3}, {1,4}
🆚 Comparison 3
a = {5,7}
b = {2,6}
5 - 2 = +3

👉 b comes before a

✅ Final Sorted Array
{1,3}, {1,4}, {2,6}, {5,7}
🧠 Now See Why This Helps in Merge

Sorted:

[1,3], [1,4], [2,6], [5,7]

Now merging becomes easy:

[1,3] vs [1,4] → merge → [1,4]
[1,4] vs [2,6] → merge → [1,6]
[1,6] vs [5,7] → merge → [1,7]
⚡ Key Insight (VERY IMPORTANT)

Your comparator ensures:

Smaller start comes first
If equal start → smaller end comes first

So intervals are arranged in the best possible order for merging

🔥 One More Small Example (Edge Case)

Input:

{1,10}, {1,2}, {1,5}

Sorting:

Since all start = 1
Sort by end:

{1,2}, {1,5}, {1,10}

👉 This is PERFECT for merging logic

🧠 Final Mental Model

When you see:

(a, b) -> a[0] - b[0]

Think:

“Sort rows based on first column”

When you see:

if(a[0] == b[0]) return a[1] - b[1];

Think:

“If same row start → sort by second column”

💬 Real Talk

You’re now moving from:

“writing code” → “understanding behavior”

This is exactly how top developers think.
 */



/*
🧠 First Truth (Important)

Sorting is NOT optional for this problem
You can avoid Arrays.sort(), but you cannot avoid sorting logic

So you have two choices:

Use built-in sort ✅ (recommended in real world)
Write your own sorting ❗ (good for learning / interviews sometimes)
🔥 Approach 1: Write Your Own Sorting (e.g., Bubble Sort)

You can manually sort intervals like this:

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;

        // 🔹 Step 1: Manual sorting (Bubble Sort)
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {

                if(arr[j][0] > arr[j+1][0] ||
                   (arr[j][0] == arr[j+1][0] && arr[j][1] > arr[j+1][1])) {

                    // swap
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 🔹 Step 2: Merge logic (same as before)
        ArrayList<int[]> res = new ArrayList<>();
        int[] current = arr[0];

        for(int i = 1; i < n; i++) {
            if(current[1] >= arr[i][0]) {
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                res.add(current);
                current = arr[i];
            }
        }

        res.add(current);
        return res;
    }
}
⚠️ But Reality Check
Approach	Time Complexity
Bubble Sort	❌ O(n²) (slow)
Arrays.sort()	✅ O(n log n) (fast)

👉 In interviews:

If they say “don’t use built-in sort” → write your own
Otherwise → always use Arrays.sort()
 */

/*
🧠 Are there similar problems like this?

YES 🔥 These all use same concept:

1. Merge Intervals (your current problem)
Core concept: sorting + merging
2. Insert Interval

👉 Insert a new interval into sorted list and merge

3. Non-overlapping Intervals

👉 Remove minimum intervals to avoid overlap

4. Meeting Rooms / Scheduling

👉 Check if meetings overlap

🔥 Pattern Name (VERY IMPORTANT)

All these come under:

🧠 Greedy + Sorting Pattern
 */

/*
🔥 Can we Optimize Further?
❗ Key Truth

You CANNOT do better than O(n log n) for this problem (generally)

Why?

👉 Because:

You must compare intervals
Sorting is required to make merging efficient
🚫 Can we make it O(n)?

Only if:

👉 Input is already sorted

Then:

TC = O(n)
🔥 Optimization 1: In-place (Reduce Space)

Right now:

You use extra ArrayList → O(n)

You can modify input array itself:

int index = 0;

for(int i = 1; i < arr.length; i++){
    if(arr[index][1] >= arr[i][0]){
        arr[index][1] = Math.max(arr[index][1], arr[i][1]);
    } else {
        index++;
        arr[index] = arr[i];
    }
}

👉 Now result is stored in:

arr[0 ... index]
✅ New Space Complexity
O(1)  (in-place)
⚠️ Trade-off
Approach	Pros	Cons
ArrayList	Easy, clean	Extra space
In-place	Memory efficient	Slightly tricky
 */