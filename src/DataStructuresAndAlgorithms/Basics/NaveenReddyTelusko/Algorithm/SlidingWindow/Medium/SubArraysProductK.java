package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Medium;
/*
Subarrays having product less than K
Last Updated : 8 Mar, 2026
Given an array of positive numbers, calculate the number of possible contiguous subarrays having product lesser than a given number K.

Input : arr[] = [1, 2, 3, 4]
            K = 10
Output : 7
The subarrays are {1}, {2}, {3}, {4}, {1, 2}, {1, 2, 3} and {2, 3}

Input  : arr[] = [1, 9, 2, 8, 6, 4, 3]
             K = 100
Output : 16

Input  : arr[] = [10, 5, 2, 6]
             K = 100
Output : 8
 */
public class SubArraysProductK {

        static int countsubarray(int array[], int n, int k)
        {
            int count = 0;
            int i, j, mul;

            for (i = 0; i < n; i++) {

                // Counter for single element
                if (array[i] < k)
                    count++;

                mul = array[i];

                for (j = i + 1; j < n; j++) {

                    // Multiple subarray
                    mul = mul * array[j];

                    // If this multiple is less
                    // than k, then increment
                    if (mul < k)
                        count++;
                    else
                        break;
                }
            }

            return count;
        }
        public  static int slidingWindow(int arr[] , int n, int k){
            int j =0;
            int maxCount = 0;
            int sum = 1;//prd
            for(int i=0;i<n;i++){
                sum = sum * arr[i];
                while(sum >= k){
                    sum = sum / arr[j];
                    j++;
                }
              maxCount = maxCount + i-j+1;
            }
            return maxCount;
        }

        public static void main(String args[])
        {
            int array[] = { 1, 2, 3, 4 };
            int k = 10;
            int size = array.length;

            int count = countsubarray(array, size, k);
            System.out.print(count);
            System.out.println("************");

            System.out.println(   slidingWindow(array, size, k));
        }
    }

/*
What This Problem Actually Asks

Count all subarrays whose product is < k.

Example:

arr = [1, 2, 3]
k = 10

Valid subarrays:

[1]
[2]
[3]
[1,2]
[2,3]
[1,2,3]

Answer = 6

Why Your Logic Misses Cases

You are doing:

maxCount++;

only once after finding a valid window.

But a valid window can generate multiple valid subarrays ending at j.

Important Sliding Window Insight

If window [i ... j] is valid,

then ALL subarrays ending at j are also valid.

Count of such subarrays:

j - i + 1
Example
arr = [1, 2, 3]
k = 10

At:

j = 2
window = [1,2,3]
product = 6

Valid subarrays ending at 3:

[3]
[2,3]
[1,2,3]

Count = 3

Which is:

j - i + 1 = 2 - 0 + 1 = 3

This is the missing idea.

Correct Approach
class Solution {

    public long countSubArrayProductLessThanK(long arr[], int n, long k) {

        if (k <= 1) return 0;

        long product = 1;
        long count = 0;

        int i = 0;

        for (int j = 0; j < n; j++) {

            product *= arr[j];

            // Shrink window until valid
            while (product >= k) {
                product /= arr[i];
                i++;
            }

            // Count all valid subarrays ending at j
            count += (j - i + 1);
        }

        return count;
    }
}
Dry Run
Input
arr = [1,2,3]
k = 10
j = 0
product = 1
window = [1]
count += 1

count = 1

j = 1
product = 2
window = [1,2]

Valid subarrays:

[2]
[1,2]

Count added:

j - i + 1 = 2

count = 3

j = 2
product = 6
window = [1,2,3]

Valid subarrays:

[3]
[2,3]
[1,2,3]

Add 3

count = 6

Most Important Pattern Here

This problem teaches a major sliding window pattern:

When window becomes valid:

Number of subarrays ending at j
=
window size
=
j - i + 1

This pattern appears in many problems:

subarray sum less than k
product less than k
at most k distinct characters
binary subarrays
nice subarrays
Your Main Mistake

You were thinking:

1 valid window = 1 answer

But actually:

1 valid window can contain MANY valid subarrays

That debugging observation you made is exactly how strong intuition develops in sliding window problems.

[Expected Approach] Using Sliding Window Approach - O(n) time and O(1) space
Use sliding window for contiguous subarrays; Since elements are positive, we can safely multiply and divide to maintain the product.
Maintain a window (start → end) with product < k; if it becomes ≥ k, move start forward.
 There are two possible cases.
Case 1. p*x < k  :  This means we can move the window's right bound one step further. How many contiguous arrays does this step produce? It is: 1 + (end-start). Indeed, the element itself comprises an array, and also we can add x to all contiguous arrays which have right border at end. There are as many such arrays as the length of the window.
Case 2. p*x >= k : This means we must first adjust the window's left border so that the product is again less than k. After that, we can apply the formula from Case 1.
 */