package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

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
✔ Interview ready*/
