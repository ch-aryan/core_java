package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void recCST(int index, int[] arr, int target, int sum ,
                              ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){

        if(sum==target){
            res.add(new ArrayList<>(temp));
        }
        if(index == arr.length || sum > target){
            return;
        }
        temp.add(arr[index]);
        recCST(index,arr, target, sum + arr[index] , temp, res);
        temp.remove(temp.size()-1);
        recCST(index+1, arr, target, sum , temp, res);
    }
//for handling duplicates.
    class Solution {

        public static void recursionCST(int index, int[] arr, int target,
                                        ArrayList<Integer> temp,
                                        ArrayList<ArrayList<Integer>> res,
                                        int sum) {

            if (sum == target) {
                res.add(new ArrayList<>(temp));
                return;
            }

            if (sum > target) return;

            for (int i = index; i < arr.length; i++) {

                // 🚫 Skip duplicates
                if (i > index && arr[i] == arr[i - 1]) continue;

                temp.add(arr[i]);

                recursionCST(i + 1, arr, target, temp, res, sum + arr[i]);

                temp.remove(temp.size() - 1);
            }
        }

        public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {

            Arrays.sort(arr);

            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();

            recursionCST(0, arr, target, temp, res, 0);

            return res;
        }
    }
    //strivers approach of combination sum I.
    class Solution1 {

        public static void helper(int index, int[] arr, int target,
                                  ArrayList<Integer> temp,
                                  ArrayList<ArrayList<Integer>> res) {

            // ✅ Base case
            if (target == 0) {
                res.add(new ArrayList<>(temp));
                return;
            }

            // ❌ Out of bounds
            if (index == arr.length) return;

            // 🚫 If target becomes negative → stop
            if (target < 0) return;

            // ✅ Pick (reuse allowed → same index)
            temp.add(arr[index]);
            helper(index, arr, target - arr[index], temp, res);

            // backtrack
            temp.remove(temp.size() - 1);

            // ❌ Not pick → move index
            helper(index + 1, arr, target, temp, res);
        }

        public ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {

            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();

            helper(0, arr, target, temp, res);

            return res;
        }
    }
    /*
    🧠 Two Ways to Think (Same Problem)
🔹 Your way (sum increasing)
sum + arr[index]
if(sum == target)
🔹 Sir’s way (target decreasing) ✅ (preferred)
target - arr[index]
if(target == 0)

👉 Both are 100% equivalent

🔥 Why “target - arr[index]” is better?
✅ Cleaner base case
if (target == 0)

instead of

if (sum == target)
✅ Easy pruning
if (target < 0) return;

👉 No need to track sum
     */
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int target = 5;
        int index = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int sum = 0;
        recCST(index, arr, target, sum, temp, res);

        for(ArrayList<Integer> i : res){
            System.out.print(i+" ");
        }
    }
}
/*
Given an array arr[] of distinct integers and a target, your task is to find all unique combinations in the array where the sum is equal to target. The same number may be chosen from the array any number of times to make target.

Note: You can return your answer in any order, but the driver code will print the combinations in sorted order only.

Examples:

Input: arr[] = [1, 2, 3], target = 5
Output: [[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [2, 3]]
Explanation: All the combination have sum of elements equals to target.
Input: arr[] = [2, 4], target = 1
Output: []
Explanation: No combination exits whose sum is equals to target.

🧠 Correct Thinking (VERY IMPORTANT)

This problem is:

Combination Sum (pick same element multiple times)

So:

Pick → stay at same index
Not pick → move to next index

🌳 Dry Run (simple and clear)
Input:
arr = [2,3]
target = 6
Start:
fn(0, sum=0)
Pick 2:
[2] → sum=2
[2,2] → sum=4
[2,2,2] → sum=6 ✅

👉 store [2,2,2]

Backtrack → try 3:
[3] → sum=3
[3,3] → sum=6 ✅

👉 store [3,3]

🎯 Final Output
[[2,2,2], [3,3]]
🔥 Key Learning (THIS is gold)
🧠 Pattern:
Action	Index
Pick	same index
Not pick	index + 1
⚡ Your real mistake (honest feedback)

You didn’t fail in logic ❌
You failed in structuring recursion properly

👉 That’s NORMAL at your stage

💬 Important mindset shift

Don’t say:

“I did worst thinking”

Say:

“I’m close, just need cleaner structure”

Because honestly — you are very close now.

🔴 What you’re seeing

Your output:

[1, 1, 1, 1, 1] (repeated multiple times)
[1, 1, 1, 2] (repeated)
[1, 1, 3] (repeated)
[1, 2, 2] (repeated)
[2, 3] (repeated)

👉 Same combinations are coming again and again

🧠 Why this happens

Your input probably has duplicate elements, something like:

arr = [1,1,2,3]

👉 Your recursion treats:

first 1
second 1

as different elements

So it generates:

[1(from index 0), 2]
[1(from index 1), 2]

👉 But logically both are same → [1,2]

❓ Why GFG passes but your output looks wrong?
🔹 GFG does NOT care about duplicates in generation
It checks final result correctness
Sometimes test cases don’t expose duplicates strongly

OR

👉 Expected output may allow duplicates in internal recursion but compare sorted/unique

🔥 Real Problem

You are solving:

❌ Combination Sum (your current)
Allows reuse
Does NOT handle duplicates

But your input behaves like:

✅ Combination Sum II
Each element used once
Must avoid duplicates
 */