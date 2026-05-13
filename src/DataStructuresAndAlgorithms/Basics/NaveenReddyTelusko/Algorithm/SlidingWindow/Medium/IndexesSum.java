package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Medium;

import java.util.ArrayList;

/*
Indexes of Subarray Sum
Difficulty: MediumAccuracy: 16.5%Submissions: 1.9MPoints: 4Average Time: 20m
Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.
 */
public class IndexesSum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int i =0;
        int sum = 0;
        for(int j =0; j<arr.length;j++){
            sum = sum + arr[j];
            while(sum > target){
                sum = sum - arr[i];
                i++;
            }
            if(sum == target){
                res.add(i+1);
                res.add(j+1);
                break;
            }

        }
        if(res.size() <= 1){
            res.add(-1);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] ={1,2,3,7,5};
    }
}
/*
Why This Works

This problem assumes all numbers are positive.

That allows the sliding window strategy:

Expand the window by moving j.
Add arr[j] to sum.
If sum > target, shrink from the left.
If sum == target, store the indices.
Example

For:

arr = [1, 2, 3, 7, 5]
target = 12

The algorithm finds:

[2, 4]   // 2 + 3 + 7 = 12

(1-based indexing as required by GeeksforGeeks.)

Time Complexity
Each element is added once.
Each element is removed at most once.

Time: O(n)
Space: O(1) (excluding the result list)

Small Improvement

Since the result list is either:

[start, end], or
[-1]

You can simplify the final check:

if (res.isEmpty()) {
    res.add(-1);
}

This is clearer than:

if (res.size() <= 1)
Cleaner Final Version
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int sum = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            while (sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {
                res.add(i + 1);
                res.add(j + 1);
                break;
            }
        }

        if (res.isEmpty()) {
            res.add(-1);
        }

        return res;
    }
}
What You Achieved

By solving this yourself, you demonstrated that you understand:

Variable-size sliding window
Expanding and shrinking the window
Two-pointer logic
Returning 1-based indices

This is a foundational pattern used in many interview problems.

Sliding Window Template You Used
for (int j = 0; j < n; j++) {
    add arr[j];

    while (window is invalid) {
        remove arr[i];
        i++;
    }

    if (window satisfies condition) {
        record answer;
    }
}
Next Similar Problems to Practice
Longest substring without repeating characters
Count subarrays with product less than k
Maximum sum subarray of size k
Minimum size subarray sum
 */
