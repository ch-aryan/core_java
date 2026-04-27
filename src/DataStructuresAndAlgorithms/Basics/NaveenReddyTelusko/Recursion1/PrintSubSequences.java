package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

import java.util.ArrayList;
//sum
public class PrintSubSequences {
    public static void fn1(int arr[], int index, int K, ArrayList<Integer> temp,
                           ArrayList<ArrayList<Integer>> res, int sum){
        if(index == arr.length){
            if(sum==K){
                res.add(new ArrayList<>(temp));
                return;
            }else{
                return;
            }
        }

        temp.add(arr[index]);
        fn1(arr, index+1, K, temp, res, sum + arr[index]);
        temp.remove(temp.size()-1);
        fn1(arr, index+1, K, temp, res, sum);
    }
   //ai logic for this question strivers also explained.
        public static boolean fn(int index, int[] arr, int K, int sum) {

            // ✅ Base case
            if (index == arr.length) {
                return sum == K;
            }

            // ✅ Pick
            if (fn(index + 1, arr, K, sum + arr[index])) {
                return true;
            }

            // ❌ Not pick
            if (fn(index + 1, arr, K, sum)) {
                return true;
            }

            return false;
        }



    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5,6};
        int K = 6;
        int index = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int sum =0;

        fn1(arr,index, K, temp, res, sum);

        for(ArrayList i: res){
            System.out.print(i+" ");
        }
    }
    /*
    boolean pick = fn(index + 1, arr, K, sum + arr[index]);
boolean notPick = fn(index + 1, arr, K, sum);

return pick || notPick;
     */
}
/*
✅ Correct Logic (Very Important)

👉 At every step:

Try pick
Try not pick
If ANY returns true → return true

🧠 Key Insight (THIS IS THE CORE)
Return true if ANY path gives sum = K
⚡ Simplified Thinking

Instead of:

Do everything → then decide

Think:

As soon as you find answer → STOP
🎯 Why Your Code Failed
Issue	Impact
Not returning recursive result	Loses answers
No proper base return	Undefined behavior
Always returning false	Wrong output
🔥 Interview-Level Tip

👉 This is a classic:

Backtracking + early return

dry run
✔ Logic = basic recursion (beginner-friendly concept)
✔ Style = slightly optimized (early return / short-circuiting)

🔥 Let’s Dry Run Step by Step

Take a small example:

arr = [1, 2, 3]
K = 3

Code:

if (fn(index + 1, arr, K, sum + arr[index])) return true;
if (fn(index + 1, arr, K, sum)) return true;
🌳 Recursion Tree (Think Like This)

At each index → 2 choices:

Pick
Not pick
🔹 Start
fn(0, sum=0)
🔹 Step 1: index = 0 (value = 1)
👉 Pick 1
fn(1, sum=1)
🔹 Step 2: index = 1 (value = 2)
👉 Pick 2
fn(2, sum=3)
🔹 Step 3: index = 2 (value = 3)
👉 Pick 3
fn(3, sum=6)

Base case:

sum != K → return false
👉 Not Pick 3
fn(3, sum=3)

Base case:

sum == K → return true ✅
🔥 Now IMPORTANT PART (your confusion)
if (fn(...)) return true;

👉 When this becomes true:

return true → immediately goes back up
So flow becomes:
fn(3, sum=3) → true
fn(2, sum=3) → returns true
fn(1, sum=1) → returns true
fn(0, sum=0) → returns true

👉 Entire recursion stops early 🚀

🔴 Why This Style Feels Confusing

Because you’re expecting:

Do both calls → then decide

But here we do:

Call → if true → STOP immediately
🔥 Simple Translation of That Code

This:

if (fn(...)) return true;
if (fn(...)) return true;

👉 Means:

Try first option
If it works → stop

Else try second option
If it works → stop

Else → return false
 */