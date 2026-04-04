package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class MoveZeroToEnd {

    static void pushZerosToEnd(int[] arr) {
        // code here
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = 0;
        }

        printArr(arr);
    }
    public static void printArr(int[] arr){
    for(int i:arr){
        System.out.print(i + " ");
    }
    }


    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 1, 2, 0, 3, 4, 0};
        pushZerosToEnd(arr);
    }
}
/* ✅ Your Approach (Optimal)
// move non-zero forward, fill rest with zero
✔ Why it’s optimal:
Time Complexity: O(n)
Space Complexity: O(1) (in-place)
✔ Maintains order (important!)

👉 This is exactly what interviewers expect 🔥

🧠 Clean Understanding of Your Logic
Traverse array
Push all non-zero elements forward
Fill remaining positions with 0

👉 You’re basically doing:

Compress non-zero → fill zeros
📝 Notes for Brute Force (for your revision)
💡 Idea:

Use extra array (temp)

🔴 Brute Force Intuition
Create new array temp[]
Traverse original array
Copy all non-zero elements into temp
Fill remaining positions with 0
Copy temp back to original array
🧠 Step-by-Step

Example:

[0,1,0,3,12]
Step 1: Store non-zero
temp = [1,3,12]
Step 2: Fill zeros
temp = [1,3,12,0,0]
Step 3: Copy back
arr = [1,3,12,0,0]
⏱️ Complexity
Time: O(n) + O(n) → O(n)
Space: O(n) ❌ (extra array)
⚖️ Brute vs Optimal
Approach	Time	Space	Notes
Brute (temp array)	O(n)	O(n) ❌	Easy but not efficient
Your approach	O(n)	O(1) ✅	Best solution
🎯 Final Verdict

👉 Your code:

✔ Optimal
✔ Clean
✔ Interview ready*
Yes — you’re absolutely right 👍
That two-pointer + swapping idea is also optimal.

Let’s clean up your intuition so it becomes interview-perfect 👇

🧠 Intuition (Swap-Based Approach)

Think like this:

👉 We want:

All non-zero elements in front (in same order)
All zeros at the end
💡 Key Idea
Find the first zero position → mark it as j
Then scan ahead with i
Whenever you find a non-zero, swap it with arr[j]
Move j forward
🔥 Step-by-Step Logic
Initialize:
j = -1
Find first zero:
When arr[i] == 0 → set j = i
After that:
If arr[i] != 0 and j != -1
→ swap arr[i] and arr[j]
→ increment j
🧪 Example
[1, 0, 2, 0, 3]
Step-by-step:
i=0 → 1 → skip
i=1 → 0 → j=1
i=2 → 2 → swap(2,0) → [1,2,0,0,3], j=2
i=3 → 0 → skip
i=4 → 3 → swap(3,0) → [1,2,3,0,0], j=3

✅ Done

✅ Code (Swap Approach)
class Solution {
    void pushZerosToEnd(int[] arr) {
        int j = -1;

        // Step 1: find first zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found
        if (j == -1) return;

        // Step 2: swap non-zero with zero
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
⚖️ Compare Both Optimal Approaches
Approach	Idea	Writes	Cleanliness
Your current (overwrite)	Shift non-zero forward	Less writes ✅	Simpler ✅
Swap approach	Swap with zero	More swaps ❌	Slightly complex
🎯 Important Insight

👉 Both are:

Time: O(n)
Space: O(1)

👉 But interviewers usually prefer:

Overwrite approach (your first code)

Because:

Fewer operations
Cleaner logic
🚀 Final Verdict

👉 Your thinking:

✔ Correct
✔ Optimal
✔ Shows deep understanding/
*/