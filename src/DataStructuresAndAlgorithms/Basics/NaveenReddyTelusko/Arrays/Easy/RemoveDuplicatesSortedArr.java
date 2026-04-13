package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

import java.util.ArrayList;

//another problem.
/* Remove Duplicates Sorted Array
Difficulty: EasyAccuracy: 38.18%Submissions: 368K+Points: 2Average Time: 20m
You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct elements in the same order as they appeared.
Examples :

Input: arr[] = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return array containing [2] after modifying the array.

 */
class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        //two pointers
        int i =0;
        al.add(arr[i]);
        int j = 1;
        while(j<arr.length){
            if(arr[i]==arr[j]){
                j++;
            }
            else if(arr[i] != arr[j]){
                al.add(arr[j]);
                i = j;
                j++;
            }
        }
        return al;
    }
}

public class RemoveDuplicatesSortedArr {

        public int removeDuplicates(int[] nums) {

            int count = 0;

            for(int i =1;i<nums.length;i++){
                if(nums[count] != nums[i]){
                    count += 1;
                    nums[count] = nums[i];
                }
            }

            return count+1; // leetcode problem 26 question.
        }

    public static void main(String[] args) {


    }
}
/* 👉 Correct approach:

✔ O(n) time
✔ O(1) space
✔ Interview ready*/
/*
Code
array is sorted or should be sorted first.
26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores). */