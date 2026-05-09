package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;
/*
Example Problem - Maximum Sum of a Subarray with K Elements
Given an array arr[] and an integer k, we need to calculate the maximum sum of a subarray having size exactly k.

Input  : arr[] = [5, 2, -1, 0, 3], k = 3
Output : 6
Explanation : We get maximum sum by considering the subaarray [5, 2 , -1]

Input  : arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output : 39
Explanation : We get maximum sum by adding subarray [4, 2, 10, 23] of size 4.
 */
public class SubArrayWithKElementsMAXSUM {
    //native approach bruteforce.
    public static void bruteForce(int arr[] , int k){
        int n = arr.length;
        int maxSum =0;
        for(int i =0;i<n-k+1;i++){
            int sum = 0;
            for(int j=0;j<k;j++) {

                    sum = sum + arr[i + j];

            }
            maxSum = Math.max(maxSum, sum);

        }
        System.out.println(maxSum);
    }
    //using slidingWindow.
    public static void slidingWindow(int arr[] , int k ){
        int n = arr.length;
        int maxSum = 0;
        for(int i =0;i<k;i++){
            maxSum = maxSum + arr[i];
        }
        int window_sum = maxSum;
        for(int i =k;i<n;i++){
            window_sum = window_sum + arr[i] - arr[i-k];
            maxSum = Math.max(window_sum, maxSum);
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int [] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        bruteForce(arr, k);
        slidingWindow(arr, k);
    }
}
/*
[Naive Approach] Try All Subarrays - O(n×k) Time and O(1) Space
We try all possible subarrays of size k using nested loops. For every starting index i,
 we calculate the sum by traversing all k elements and updates the maximum value found so far,
resulting in redundant calculations and O(n*k) time complexity.

//slidingWindow
[Expected approach] Sliding Window Technique - O(n) Time and O(1) Space
We compute the sum of the first k elements out of n terms using a linear
loop and store the sum in variable window_sum.
Then we will traverse linearly over the array till it reaches the end and simultaneously keep
track of the maximum sum.
To get the current sum of a block of k elements just subtract the first element
 from the previous block and add the last element of the current block.
The below representation will make it clear how the window slides over the array.

Consider an array arr[] = {5, 2, -1, 0, 3} and value of k = 3 and n = 5

This is the initial phase where we have calculated the initial window sum starting from index 0 .
 At this stage the window sum is 6. Now, we set the maximum_sum as current_window i.e 6.


Now, we slide our window by a unit index.
 Therefore, now it discards 5 from the window and adds 0 to the window.
 Hence, we will get our new window sum by subtracting 5 and then adding 0 to it.
 So, our window sum now becomes 1. Now, we will compare this window sum with the maximum_sum.
 As it is smaller, we won't change the maximum_sum.


Similarly, now once again we slide our window by a unit index and obtain the new window sum to be 2.
Again we check if this current window sum is greater than the maximum_sum till now.
Once, again it is smaller so we don't change the maximum_sum.
Therefore, for the above array our maximum_sum is 6.
 */