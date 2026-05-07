package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;
//i did my own.
public class dayVIPalindromeBinary {
    class Solution {
        public boolean isBinaryPalindrome(int n) {
            if(n%2 ==0){
                return false;
            }

            int arr[] = new int[32];
            int c=0;
            while(n >=1){
                arr[c] = n % 2;
                n = n / 2;
                c++;
            }

            for(int i=0;i<=c/2;i++){
                if(arr[i] != arr[c-i-1]){
                    return false;
                }
            }
            // code here
            return true;

        }
    }
}
/*
Given an integer n, determine whether its binary representation forms a palindrome. Return true if the binary representation of n is a palindrome; otherwise, return false.

Note: A binary representation is considered a palindrome if it reads the same forward and backward.

Examples:

Input: n = 17
Output: true
Explanation: Binary representation of 17 is (10001)2, which reads the same forward and backward, so it is a palindrome.
Input: n = 16
Output: false
Explanation: Binary representation of 16 is (10000)2, which is not a palindrome.
 */