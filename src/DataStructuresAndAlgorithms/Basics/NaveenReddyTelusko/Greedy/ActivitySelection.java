package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

import java.util.Arrays;

public class ActivitySelection {
    public static int GreedyAlgo(int [] start, int [] finish){
        int n = start.length;
        if(n==0) return 0;
        int[][] resArr = new int[n][2];
        for(int i=0;i<n;i++){
            resArr[i][0] = start[i];
            resArr[i][1] = finish[i];
        }
        Arrays.sort(resArr, (a, b)-> a[1]-b[1]);

        int CurFin = resArr[0][1];
        int count =1;
        for(int i=0;i<n;i++){
            if(resArr[i][0] > CurFin){
                count++;
                CurFin = resArr[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

    }
}
/*
Activity Selection
Difficulty: MediumAccuracy: 36.21%Submissions: 202K+Points: 4Average Time: 20m
You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.

Examples:

Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}
Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.

[Expected Approach 1] - Using Sorting - O(n * log(n)) Time and O(n) Space
The problem can be solved using a greedy approach. The idea is that whenever multiple activities overlap,
 we should pick the one that finishes earliest,
 because finishing sooner leaves the most room to schedule upcoming activities.
 This way, the schedule stays flexible, and more activities can fit without conflict.
To achieve this, we sort all activities by their finishing times.
Then, starting with the first one, we repeatedly pick the next activity that both starts after
the last selected activity ends and has the earliest finish time among the remaining ones.

🧩 Step 0: Input
int[] start  = {1, 3, 0};
int[] finish = {2, 4, 6};
🧩 Step 1: Create 2D array (pairing)
Code:
int[][] activities = new int[n][2];

👉 This means:

index	activities[i][0]	activities[i][1]
0	start	finish
Filling it:
for (int i = 0; i < n; i++) {
    activities[i][0] = start[i];
    activities[i][1] = finish[i];
}
Result in memory:
activities =
[
  [1, 2],
  [3, 4],
  [0, 6]
]

👉 Each row = one activity

🧩 Step 2: Sorting (MOST IMPORTANT PART)
Code:
Arrays.sort(activities, (a, b) -> a[1] - b[1]);
🧠 What is (a, b) -> a[1] - b[1] ?

This is a comparator.

👉 Java is asking:

“For two rows a and b, which should come first?”

Example comparison:

Take:

a = [1,2]
b = [3,4]

Check:

a[1] - b[1] = 2 - 4 = -2

👉 Negative → a comes before b

Another comparison:
a = [0,6]
b = [1,2]
6 - 2 = 4

👉 Positive → b comes before a

🔄 Final sorted result:
[
  [1,2],
  [3,4],
  [0,6]
]

👉 Sorted by finish time (2,4,6)

🧩 Step 3: Pick first activity
Code:
int count = 1;
int lastFinish = activities[0][1];
What happens:
Picked: [1,2]
count = 1
lastFinish = 2

👉 We always pick first because:

It finishes earliest
Safe choice
🧩 Step 4: Loop through remaining
Code:
for (int i = 1; i < n; i++)

👉 Now i = 1

🔍 Iteration 1
Current activity = [3,4]
Check:
if (activities[i][0] >= lastFinish)

👉 Means:

3 >= 2 → TRUE
Action:
count++;
lastFinish = activities[i][1];

👉 Update:

count = 2
lastFinish = 4
🔍 Iteration 2
Current activity = [0,6]
Check:
0 >= 4 → FALSE

👉 Overlaps ❌ → skip

🧩 Final Answer
return count;

👉 Output:

2
🔥 Full Flow Summary
Before sorting:
[1,2], [3,4], [0,6]

After sorting:
[1,2], [3,4], [0,6]

Pick:
[1,2] → lastFinish = 2
[3,4] → lastFinish = 4
Skip:
[0,6]

Answer = 2
🧠 Key Understanding (very important)
Sorting line:
Arrays.sort(activities, (a, b) -> a[1] - b[1]);

👉 Means:

“Sort rows based on column 1 (finish time)”

💡 One-line intuition

“Among all activities, always choose the one that ends earliest.”
 */

/*
Arrays.sort(arr, (a,b) -> a[1] - b[1]); working structure
🧩 Your matrix

You wrote it like:

1  3  2  5
2  4  3  6

👉 This actually represents:

start = [1, 3, 2, 5]
finish = [2, 4, 3, 6]
🧠 Step 1: Convert into pairs (2D array)

We don’t sort like that matrix directly.
We convert into rows = activities:

[1,2]
[3,4]
[2,3]
[5,6]

👉 So internally:

int[][] activities = {
    {1,2},
    {3,4},
    {2,3},
    {5,6}
};
🧩 Step 2: Apply sorting
Code:
Arrays.sort(activities, (a, b) -> a[1] - b[1]);

👉 Means:

Compare rows based on finish time (column index 1)

🔍 Let’s sort step-by-step
Initial:
[1,2]
[3,4]
[2,3]
[5,6]
Compare by finish values:
Activity	Finish
[1,2]	2
[2,3]	3
[3,4]	4
[5,6]	6
After sorting:
[1,2]
[2,3]
[3,4]
[5,6]
🔥 What actually happened?

👉 Java compared rows like:

a[1] - b[1]

Example:

Compare [3,4] and [2,3]

4 - 3 = 1 → swap (because 4 > 3)
⚠️ Important thing you must understand

👉 Sorting does NOT change inside rows

❌ It does NOT become:

[1,3]
[2,4]
...

✅ It only rearranges rows:

[1,2], [2,3], [3,4], [5,6]
🧠 Visual understanding

Think like this:

Before:

Activity A → (1,2)
Activity B → (3,4)
Activity C → (2,3)
Activity D → (5,6)

After sorting:

A → (1,2)
C → (2,3)
B → (3,4)
D → (5,6)

👉 Only order of activities changes, not their values.

💡 Final one-line clarity

“We sort whole activities based on their finish time, not individual numbers.”

 */