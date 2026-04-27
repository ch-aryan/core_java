package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class subSet {
    class Solution {

        public static Boolean recur(int index, int[] arr, int sum){

            if(index==arr.length){
                return sum == 0;
            }
            if(sum<0){
                return false;
            }

            if(recur(index+1, arr, sum-arr[index])) return true;

            if(recur(index+1, arr, sum)) return true;

            return false;
        }

        static Boolean isSubsetSum(int arr[], int sum) {
            // code here
            int tSum =0;

            return  recur(0,arr, sum);

        }
    }
}
/*
I get why it feels the same — both look like “pick/not pick + target” problems. But the goal and rules are different, and that changes everything.

Let’s lock it in clearly 👇

🧠 Core Difference (one-line)
Subset Sum → Does any subset exist? (YES/NO)
Combination Sum → List all combinations (ACTUAL ANSWERS)
🔥 Side-by-side Comparison
Feature	Subset Sum	Combination Sum
Goal	Boolean (true/false)	List of combinations
Output	true / false	[[...], [...]]
Reuse of elements	❌ Not allowed	✅ Allowed
Return type	boolean	List<List<Integer>>
Stops early	✅ Yes (on first true)	❌ No (explore all)
🧠 Biggest Conceptual Difference
🔹 Subset Sum

👉 You are asking:

“Does at least ONE valid subset exist?”

So:

if (recur(...)) return true;

👉 As soon as you find answer → STOP

🔹 Combination Sum

👉 You are asking:

“Give me ALL possible combinations”

So:

res.add(...)

👉 You must explore every path

🔁 Reuse Difference (VERY IMPORTANT)
Subset Sum
recur(index + 1, ...)

👉 Move forward → element used once

Combination Sum
recur(index, ...)

👉 Stay → reuse allowed

🌳 Tree Difference (intuition)
Subset Sum
Each element → pick OR not pick
(Binary tree)
Combination Sum
Keep picking same element multiple times
(Deeper tree)
⚡ Example (same input, different thinking)
Input:
arr = [2,3]
target = 6
Subset Sum

Check:

2 + 3 = 5 ❌
Only one use allowed

👉 Answer:

false
Combination Sum

Allow reuse:

2+2+2 = 6
3+3 = 6

👉 Answer:

[[2,2,2], [3,3]]
💡 Mental Shortcut (VERY IMPORTANT)

Ask this before coding:

❓ “Do I need ONE answer or ALL answers?”
ONE → Subset Sum
ALL → Combination Sum
🧠 Why you feel they are similar

Because both use:

Pick / Not Pick pattern

👉 Same tool
👉 Different goal

🎯 Final clarity (lock this)
Subset Sum = Decision Problem (YES/NO)

Combination Sum = Construction Problem (BUILD ANSWERS)
💬 Honest note

The fact that you noticed this similarity is a big step forward.
Most people treat them as completely separate — you’re starting to see patterns.
 */