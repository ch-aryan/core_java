package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow;

public class IDidMySelf {
    class Solution {
        public boolean isSumOfConsecutive(int n) {
            // code here
            if(n <=2) return false;
            int i =2;
            int sum =1;
            int j = 1;
            while(i<=n){
                sum = sum +i;

                while(sum > n){
                    sum = sum-j;
                    j++;
                }
                if(sum==n && (i-j+1) >= 2){
                    return true;//awesome.
                }
                i++;
            }
            return false;
        }
    }
}
/*
Interesting DSA Trick

A number can be expressed as the sum of consecutive positive integers if and only if it is NOT a power of 2.

Examples:

7 → not a power of 2 → ✅ possible
8 = 2
3
 → ❌ not possible
9 → not a power of 2 → ✅ 4+5
16 = 2
4
 → ❌ not possible
15 → not a power of 2 → ✅ 7+8

So in coding interviews, instead of searching for sequences, you can simply check:

return (n & (n - 1)) != 0;

because powers of 2 have exactly one set bit.

For example:

8  = 1000
8-1= 0111
--------------
     0000

Result is 0 → power of 2 → answer is false.

This is a famous bit-manipulation optimization that often appears in DSA problems like "Consecutive Numbers Sum."
 */
