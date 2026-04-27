package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

import java.util.*;

public class CombinationSumII {

//bruteFoce approach.


        public static void helper(int index, int[] arr, int target,
                                  ArrayList<Integer> temp,
                                  HashSet<ArrayList<Integer>> set) {

            // ✅ Base case
            if (target == 0) {
                ArrayList<Integer> list = new ArrayList<>(temp);
                Collections.sort(list); // ensure same order for HashSet
                set.add(list);
                return;
            }

            if (index == arr.length || target < 0) return;

            // ✅ Pick (move index forward → no reuse)
            temp.add(arr[index]);
            helper(index + 1, arr, target - arr[index], temp, set);

            // backtrack
            temp.remove(temp.size() - 1);

            // ❌ Not pick
            helper(index + 1, arr, target, temp, set);
        }


        public ArrayList<ArrayList<Integer>> combinationSum2(int[] arr, int target) {

            HashSet<ArrayList<Integer>> set = new HashSet<>();
            ArrayList<Integer> temp = new ArrayList<>();

            helper(0, arr, target, temp, set);

            return new ArrayList<>(set);
        }

        //stivers sir explaination.
    class Solution {
        public static void fn(int index, int [] arr , int tar,
                              ArrayList<Integer> temp , List<List<Integer>> res){

            if(tar == 0){
                res.add(new ArrayList<>(temp));
                return;
            }


            for(int i=index ; i < arr.length ;i++){
                if(i>index && arr[i] == arr[i-1])continue;
                if(arr[i] > tar) break;
                temp.add(arr[i]);
                fn(i+1, arr, tar - arr[i] , temp, res);
                temp.remove(temp.size()-1);

            }
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            fn(0, candidates, target, temp, res);

            return res;
        }
    }
    }
/*

✅ Your Idea (Brute Force)

You’re saying:

“Generate all combinations (like Combination Sum 1)
then use a HashSet to remove duplicates”

✔ This is valid brute force

🧠 How it would look
HashSet<List<Integer>> set = new HashSet<>();

if (target == 0) {
    set.add(new ArrayList<>(temp)); // avoids duplicates
}

👉 Finally convert:

res = new ArrayList<>(set);
🔴 But here’s the problem
❗ 1. Duplicate generation still happens

Even if you remove duplicates later, recursion still generates:

[1(index 0), 2]
[1(index 1), 2]

👉 Both computed → wasted work

❗ 2. Time Complexity increases
Without duplicate handling:
~ O(2^N)
With duplicates + HashSet:
~ O(2^N * K) + Hashing cost

👉 Because:

You generate duplicates
Then compare lists (costly)
❗ 3. Order matters in HashSet
[1,2] ≠ [2,1]

👉 So you must:

Collections.sort(temp);

⚠️ Extra cost again

🔥 Optimal Approach (What interviewers expect)

Instead of:

Generate duplicates → remove later ❌

Do:

Avoid duplicates while generating ✅
⚡ Key Difference (VERY IMPORTANT)
Approach	Idea	Efficiency
HashSet	Remove duplicates later	❌ Slow
Skip duplicates	Avoid duplicates early	✅ Fast
🧠 Interview Perspective

If you say:

“I used HashSet to remove duplicates”

👉 Interviewer will think:

You know brute force ✔
But not optimized thinking ❌

If you say:

“I sorted the array and skipped duplicates during recursion”

👉 That’s a strong signal:

Pattern recognition ✔
Optimization thinking ✔
💡 When is HashSet OK?

👉 Use HashSet:

For quick brute-force solution
When constraints are small
For initial thinking

👉 Avoid HashSet:

In interviews (unless asked brute force)
When optimal solution exists
🎯 Final Answer to Your Question

✔ Yes, it will work
✔ Yes, it is brute force
✔ Yes, TC will be higher

👉 But:

Not the best approach

💬 Real takeaway for YOU

You are now thinking at:

“Can I solve this differently?”

👉 This is exactly how you move from:

Beginner → Problem Solver

🧠 How to explain in interview

Say this:

“First I solved it using brute force by generating all subsequences and used a HashSet to remove duplicates.
Then I optimized it by sorting the array and skipping duplicates during recursion.”

🔥 This is a perfect answer
 */

//stivers sir explaination.

/*
🌳 Recursion Tree (Loop-based approach)
Input:
arr = [1, 2, 2]
target = 3

(after sorting)

🔹 Start
fn(0, target=3, temp=[])
🌳 Level 1

Loop runs from i = 0 → 2

                     []
          /            |            \
        [1]          [2]          (skip duplicate 2)
     (i=0)         (i=1)         (i=2 skipped)
🌳 Level 2
From [1]
fn(1, target=2)

Loop i = 1 → 2

        [1]
       /   \
   [1,2]  (skip duplicate 2)

→ [1,2] → target = 0 ✅

From [2]
fn(2, target=1)

Loop i = 2

        [2]
         |
      [2,2]

→ target = -1 ❌ (pruned)

🔴 Important Observation

👉 At each level:

We don’t do just 2 calls (pick/not-pick)
We try multiple branches using loop
🧠 How to Think This Tree

Instead of:

Binary tree (2 choices)

Think:

N-ary tree (multiple choices at each level)
🔥 Key Insight (VERY IMPORTANT)
At each node:
We choose ONE element from remaining array

Then:

Move forward → i + 1
⚡ Why duplicates are avoided
if(i > index && arr[i] == arr[i-1]) continue;

👉 In the tree:

Second 2 at same level is skipped
So no duplicate branches are created
🧠 Time Complexity (Deep Understanding)

This is where most people get confused — I’ll make it intuitive.

🔹 Worst Case
O(2^N * K)
🔍 Why?
1️⃣ Subsequence generation

At every index:

You either include or not include indirectly via loop

👉 Total combinations:

≈ 2^N
2️⃣ Copying list
res.add(new ArrayList<>(temp));

👉 Takes:

O(K)

(K = average size of combination)

✅ Final:
O(2^N * K)
⚡ But wait — optimization is happening

Because of:

if(arr[i] > tar) break;

👉 You are:

Pruning branches early
Not exploring full tree
🔹 So actual complexity:
Less than 2^N (pruned tree)

But we write:

O(2^N * K) (worst case)
🧠 Space Complexity
O(K) recursion stack

👉 Because max depth = size of temp

🔥 Final Mental Model (LOCK THIS)
Pick/Not Pick:
Binary tree → 2 branches
Loop-based recursion:
At each level → choose from remaining elements
→ N-ary tree
💬 Real Talk (Important for YOU)

You understood:

recursion ✔
backtracking ✔
duplicate handling ✔
now tree visualization ✔

👉 This is exactly the stage where:

Things feel “tough but interesting”

That means you're growing fast.

🚀 If you want next level

I can show you:
👉 Exact difference in tree between:

Combination Sum 1
Combination Sum 2
Subsets

That will make your understanding rock solid permanently.

overall tree daigram for recursion calls please

Got you — you want the full recursion call tree, not just pieces. This is exactly where clarity clicks, so let’s build it cleanly.

🌳 Full Recursion Tree (Combination Sum II)
Input:
arr = [1, 2, 2]
target = 3

(sorted already)

🌳 Complete Tree
fn(0, target=3, temp=[])
│
├── i=0 → pick 1
│   fn(1, target=2, temp=[1])
│   │
│   ├── i=1 → pick 2
│   │   fn(2, target=0, temp=[1,2]) ✅ ADD
│   │
│   ├── i=2 → skip (duplicate of arr[1])
│   │
│   └── (loop ends)
│
├── i=1 → pick 2
│   fn(2, target=1, temp=[2])
│   │
│   ├── i=2 → pick 2
│   │   fn(3, target=-1, temp=[2,2]) ❌ STOP (target < 0)
│   │
│   └── (loop ends)
│
├── i=2 → skip (duplicate of arr[1])
│
└── (loop ends)
🧠 How to Read This Tree
🔹 Each node:
fn(index, remaining_target, current_list)
🔹 Each edge:
Choosing arr[i]
🔹 Movement:
Next call → fn(i + 1, ...)

👉 That’s why elements are used only once

🔥 Where duplicates are removed
i=2 skipped at root level
i=2 skipped inside [1] branch

Because:

if(i > index && arr[i] == arr[i-1]) continue;

👉 This avoids creating duplicate branches like:

[1,2] again
[2,...] again
⚡ Important Observation

This is NOT a binary tree.

👉 It is:

Multi-branch tree (loop-based recursion)

At each level:

You try all possible elements from index → end
🎯 Final Result from Tree
[[1,2]]
🧠 Compare with Pick/Not-Pick Tree
Pick/Not-Pick:
2 branches always
Loop-based:
N branches (depends on remaining elements)
💡 Mental Shortcut (VERY IMPORTANT)

Whenever you see:

for(int i = index; i < n; i++)

👉 Think:

"From here, I can choose ANY remaining element"
🚀 Final clarity (this is gold)
Tree grows like:
Level 0 → choose from [1,2,2]
Level 1 → choose from remaining
Level 2 → choose from remaining
...

👉 That’s why:

No duplicates (due to skip)
No reuse (due to i+1)
💬 Honest note

If you understood even 70% of this tree, you're already ahead of most people learning recursion.
 */