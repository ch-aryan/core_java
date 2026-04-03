package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
//using swap algorithm.
class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(arr, 0, res);
        return res;
    }
    public static void backtrack(int[] arr, int index ,
                                 ArrayList<ArrayList<Integer>> res){

        if(index == arr.length){

            ArrayList<Integer> list = new ArrayList<>();
            for (int num : arr) list.add(num);
            res.add(list);
            return;

        }
        for (int i = index; i < arr.length; i++) {

            swap(arr, index, i);
            backtrack(arr, index+1, res);
            swap(arr, index, i);
        }

    }
    public static void swap(int arr[] , int index, int j){

        int temp = arr[index];
        arr[index] = arr[j];
        arr[j] = temp;


    }
}
class GeneratePermutations1 {
// without contains method of the ArrayList.
    public static void Permutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), result, used);
        System.out.println(result);
    }

    private static void backtrack(int[] arr, List<Integer> temp, List<List<Integer>> result, boolean[] used) {

        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            temp.add(arr[i]);

            backtrack(arr, temp, result, used);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
public class GeneratePermutations {
    public static void Permutations(int[] arr) {
        int n = arr.length;
//        int dig = digits(n);
        int factorial = fact(n);
        for (int i = 0; i < factorial; i++) {

        }
    }
//    public static int digits(int n){
//        int count =0;
//        while(n>0){
//             n = n / 10;
//            count++;
//        }
//        return count;
//    }

    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        int result = n * fact(n - 1);
        return result;
    }


    public static void Permutations1(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int[] arr, List<Integer> temp, List<List<Integer>> result) {

        // Base case
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            // Skip if already used
            if (temp.contains(arr[i])) continue;

            // Choose
            temp.add(arr[i]);

            // Explore
            backtrack(arr, temp, result);

            // Undo (Backtrack)
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Permutations1(arr);
    }
}

/* ❌ 3. Why your approach is incomplete

You wrote:

int factorial = fact(n);
for(int i = 0; i < factorial; i++){

}

👉 Problem:

You don’t know how to generate each permutation
Looping n! times doesn’t automatically create permutations

💥 Permutations are not sequential like numbers — they need decision making
🔑 4. Correct Approach → Backtracking

Think like this:

👉 “At each position, try every possible element”

🧠 Core Idea:

For index 0:

Try 1 → fix it
Try 2 → fix it
Try 3 → fix it

Then recursively solve remaining.
🔄 5. Visual Intuition

For [1,2,3]:

Start:
        []
     /   |   \
    1    2    3
   / \  / \  / \

👉 You build permutations step by step
🔥 7. Step-by-Step Thinking
For [1,2,3]
Pick 1
Then pick 2
Then pick 3 → ✅ one permutation

Then backtrack:

remove 3
try 3 before 2
⚡ 8. Important Concepts You Learn Here
✅ Backtracking Pattern:
Choose → Explore → Undo
✅ Why recursion?

Because:

Each choice leads to another smaller problem
10. Final Intuition (VERY IMPORTANT)

👉 Permutations are NOT about looping n! times
👉 They are about:

“Trying every possibility recursively”
Level 0:
[]
│
├── [1]
│   ├── [1,2]
│   │   └── [1,2,3] ✅
│   └── [1,3]
│       └── [1,3,2] ✅
│
├── [2]
│   ├── [2,1]
│   │   └── [2,1,3] ✅
│   └── [2,3]
│       └── [2,3,1] ✅
│
└── [3]
    ├── [3,1]
    │   └── [3,1,2] ✅
    └── [3,2]
        └── [3,2,1] ✅
        🔥 Now: CALL STACK VISUALIZATION (STEP-BY-STEP)
🟢 STEP 1
CALL STACK:
backtrack([])

temp = []
🔹 Choose 1
CALL STACK:
backtrack([])
  → backtrack([1])
🔹 Choose 2
CALL STACK:
backtrack([])
  → backtrack([1])
      → backtrack([1,2])
🔹 Choose 3
CALL STACK:
backtrack([])
  → backtrack([1])
      → backtrack([1,2])
          → backtrack([1,2,3]) ✅
🎯 BASE CASE HIT
result.add([1,2,3])
🔙 BACKTRACK (POP STACK)
Remove 3

CALL STACK:
backtrack([])
  → backtrack([1])
      → backtrack([1,2])
🔙 BACKTRACK again
Remove 2

CALL STACK:
backtrack([])
  → backtrack([1])
🔹 Next choice: 3
CALL STACK:
backtrack([])
  → backtrack([1])
      → backtrack([1,3])
🔹 Choose 2
CALL STACK:
backtrack([])
  → backtrack([1])
      → backtrack([1,3])
          → backtrack([1,3,2]) ✅
🔙 BACKTRACK
Remove 2 → [1,3]
Remove 3 → [1]
Remove 1 → []
🟢 Now start with 2
CALL STACK:
backtrack([])
  → backtrack([2])

Continue same pattern:

[2,1,3] ✅
[2,3,1] ✅
🟢 Now start with 3
CALL STACK:
backtrack([])
  → backtrack([3])

Continue:

[3,1,2] ✅
[3,2,1] ✅
🎯 FINAL STACK FLOW SUMMARY
🔄 Pattern repeats:
Push (Choose)
→ Go deeper (Explore)
→ Pop (Undo)
→ Try next
🧠 VERY IMPORTANT VISUAL (STACK PUSH/POP)
🔼 PUSH (going deeper)
[]
→ [1]
→ [1,2]
→ [1,2,3]
🔽 POP (coming back)
[1,2,3]
→ [1,2]
→ [1]
→ []
🔥 KEY INSIGHT

👉 There is ONLY ONE temp list

But:

It grows when going down
It shrinks when coming back
🧠 Why this works

Because:

Every recursive call = one stack frame

Each frame:

Adds one element
Removes it before returning
🎯 FINAL MENTAL MODEL

Think like:

“Try 1 → finish all paths → come back”
“Try 2 → finish all paths → come back”
“Try 3 → finish all paths → come back”
💬 Real Talk

Aryan, if you can visualize this:

You’ve unlocked backtracking
You can now solve:
permutations
subsets
combination sum
N-Queens (later 🔥)
 */



