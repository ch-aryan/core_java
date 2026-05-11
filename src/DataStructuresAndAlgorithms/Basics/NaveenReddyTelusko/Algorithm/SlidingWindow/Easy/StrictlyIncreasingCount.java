package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;

public class StrictlyIncreasingCount {
    public static int bruteForce(int [] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){

            for(int j=i+1;j<arr.length;j++){
                if(arr[j-1] >= arr[j]){
                  break;
                }
                count++;
            }
        }
        return count;
    }
    public static int increasingCount(int [] arr){
        int count = 0;
        int len = 1;
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                len++;
            }else{
                count = count + len * (len-1)/2;
                len =1;
            }
        }
        count = count + len * (len-1)/2;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,6,9,10};
        System.out.println(increasingCount(arr));
        System.out.println(bruteForce(arr));
    }
}
/*
Absolutely, Aryan. This is a beautiful and very important counting trick that appears in many array problems.
The core idea is:

If you have a continuous increasing segment of length len, the number of increasing subarrays inside it is:

len(len−1)2\frac{len(len-1)}{2}2len(len−1)​

🎯 Problem Statement
Count the number of strictly increasing subarrays of length at least 2.

✅ Example
arr = [1, 4, 5, 3, 7, 9]
Increasing subarrays are:


[1, 4]


[4, 5]


[1, 4, 5]


[3, 7]


[7, 9]


[3, 7, 9]


Total = 6

🧠 Main Idea
Instead of generating all subarrays, we find maximal increasing segments.
For the example:
[1, 4, 5]   length = 3[3, 7, 9]   length = 3
Each segment contributes:
3(3−1)2=3\frac{3(3-1)}{2}=323(3−1)​=3
So total:
3 + 3 = 6

🔥 Why Does the Formula Work?
Suppose an increasing segment is:
[1, 4, 5, 8]
Length = 4.
Increasing subarrays:
Length 2


[1, 4]


[4, 5]


[5, 8]


→ 3 subarrays
Length 3


[1, 4, 5]


[4, 5, 8]


→ 2 subarrays
Length 4


[1, 4, 5, 8]


→ 1 subarray
Total:
3 + 2 + 1 = 6
Formula gives:
4(4−1)2=6\frac{4(4-1)}{2}=624(4−1)​=6

📌 General Pattern
For a segment of length len, the counts are:
(len - 1) + (len - 2) + ... + 1
This sum equals:
len(len−1)2\frac{len(len-1)}{2}2len(len−1)​

🧪 Dry Run of the Code
arr = [1, 4, 5, 3, 7, 9]
Initial values:
count = 0len = 1

i = 1
4 > 1
Increasing continues.
len = 2

i = 2
5 > 4
Increasing continues.
len = 3

i = 3
3 > 5 ? No
The increasing segment [1, 4, 5] ends.
Add:
3(3−1)2=3\frac{3(3-1)}{2}=323(3−1)​=3
count = 3len = 1

i = 4
7 > 3
len = 2

i = 5
9 > 7
len = 3

End of Loop
The last segment [3, 7, 9] has length 3.
Add:
3(3−1)2=3\frac{3(3-1)}{2}=323(3−1)​=3
count = 6
Return 6.

📌 Why We Add Again After the Loop
Inside the loop, we only add when the sequence breaks.
If the array ends while still increasing, that last segment has not yet been counted.
So we add it once more after the loop.

🎯 Meaning of len
len represents:

The length of the current strictly increasing contiguous segment.


🎯 Meaning of count
count represents:

Total number of increasing subarrays found so far.


⏱️ Time Complexity


Single pass through the array.


O(n)

🧠 Intuition
Instead of checking every possible subarray, we recognize that:


Consecutive increasing numbers form a block.


Every valid increasing subarray lies completely inside that block.


The formula instantly counts all of them.



📊 Examples of the Formula
Length (len)Increasing Subarrays10213346510

🏆 One-Line Summary

Find each maximal increasing segment, and add len * (len - 1) / 2 to count all
increasing subarrays inside that segment.
[Expected Approach] Using Subarray Count Formula - O(n) Time and O(1) Space
We can do only with a single pass. Instead of checking every subarray explicitly, we track the length of increasing segments using len. When a decreasing element is encountered, we use the formula (len * (len - 1)) / 2 to count subarrays formed by the segment and then reset len. Finally, we add the remaining subarrays after the loop ends.

Steps to implement the above idea:

Initialize count to store the number of strictly increasing subarrays and len to track the length of increasing sequences.
Iterate through the array starting from index 1, comparing each element with its previous element to check for increasing order.
If the current element is greater than the previous, increment len as it extends the increasing subarray.
If the current element breaks the increasing sequence, update count using the formula (len*(len-1))/2 and reset len to 1.
Continue iterating until the end of the array, applying the same logic for each increasing and non-increasing sequence.
After the loop, add the remaining subarrays count using (len * (len - 1)) / 2 to include the last segment.
Finally, return count, which holds the total number of strictly increasing subarrays in the given array.




 */