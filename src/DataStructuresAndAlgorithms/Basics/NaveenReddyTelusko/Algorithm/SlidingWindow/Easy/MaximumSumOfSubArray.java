package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;
/*
You are given an array of non-negative integers and a target sum. Your task is to find a contiguous subarray whose sum is the maximum possible, while ensuring that it does not exceed the given target sum.

Note: The given array contains only non-negative integers.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], sum = 11
Output: 10
Explanation: Subarray having maximum sum is [1, 2, 3, 4]


Input: arr[] = [2, 4, 6, 8, 10], sum = 7
Output: 6
Explanation: Subarray having maximum sum is [2, 4]or [6]
 */
public class MaximumSumOfSubArray {
    public static int generateSubArrSum(int[] arr, int x){
        int n = arr.length;
        int max_sum =0;
        for(int i=0;i<n-1;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + arr[j];
                if(sum < x){
                    max_sum = Math.max(sum, max_sum);
                }
            }

        }
        return max_sum;
    }
    public static int algorithm(int[] arr, int x){
        int max_sum = 0;
        int n = arr.length;
        int curr_sum =0;
        int j =0;
        for(int i=0;i<n;i++){
            curr_sum += arr[i];
            while(curr_sum > x){
                curr_sum = curr_sum - arr[j];
                j++;
            }
            max_sum = Math.max(curr_sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int x = 11;
        int res = algorithm(arr,x);
        System.out.println(res);

        System.out.println(generateSubArrSum(arr, x));
    }
}
/*
[Naive Approach] - Generate all Subarrays - O(n^2) Time and O(1) Space
We can solve this problem by generating all substrings, comparing their sums with the given sum,
 and updating the answer accordingly.

 [Expected Approach] - Using Sliding Window - O(n) Time and O(n) Space
The maximum sum subarray can be found using a sliding window approach.
Start by adding elements to curr_sum while it's less than the target sum.
If curr_sum exceeds the sum, remove elements from the start until it fits within the limit.
(Note: This method works only for non-negative elements.)
 */