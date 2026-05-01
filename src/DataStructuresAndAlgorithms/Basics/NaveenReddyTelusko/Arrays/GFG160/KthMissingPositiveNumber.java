package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.GFG160;

public class KthMissingPositiveNumber {

        public int kthMissing(int[] arr, int k) {
            // code here
            int n =arr.length;
            int number = arr[n-1];
            int missingNumbers = number - n;

            int count = 0;
            int iter = 0;
            int arr1[] = new int[missingNumbers+k];
            int i =0;
            int j=0;
            while(i<arr1.length){
                if(j+1 != arr[count]){
                    arr1[iter] = j+1;
                    iter++;
                    i++;
                }else if(j+1 == arr[count] && count < arr.length-1){
                    count++;

                }else{
                    arr1[iter] = j+1;

                    iter++;
                    i++;
                }
                j++;
            }

            //   if(missingNumbers > 0){
            //       return arr1[k-1];
            //   }
            //  return arr[n-1] + k;
            // }
            if(k<=missingNumbers){
                return arr1[k-1];
            }
            return arr[n-1] + (k - missingNumbers);

        }
    }

/*
Kth Missing Positive Number in a Sorted Array
Difficulty: MediumAccuracy: 53.02%Submissions: 54K+Points: 4
Given a sorted array of distinct positive integers arr[], You need to find the kth positive number that is missing from the arr[].

Examples:

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.

Good—you’re very close. The issue is not your idea, it’s how you’re handling the edge when k goes beyond the missing numbers inside the array range.

Let’s walk through your exact doubt:

🔴 What you tried

You computed:

missingNumbers = arr[n-1] - n

For your test case:

arr = [1,2,4,5,7,8]
n = 6
arr[n-1] = 8
missingNumbers = 8 - 6 = 2

So inside [1..8], missing numbers are:

[3, 6] → total 2
🔴 Now k = 5

You want the 5th missing number, but:

Only 2 missing numbers exist inside the array range
So remaining:
k - missingNumbers = 5 - 2 = 3

That means:
👉 go beyond the array
👉 continue after 8

So missing numbers continue:

9 (3rd), 10 (4th), 11 (5th)

✅ Answer = 11

❌ Your mistake

You wrote:

if(missingNumbers > 0){
    return arr1[k-1];
}
return arr[n-1] + k;

Problem:

You are always using arr1[k-1] if missingNumbers > 0
But you should NOT if k > missingNumbers
✅ Fix (minimal change mindset)

Replace this logic with:

if(k <= missingNumbers){
    return arr1[k-1];
} else {
    return arr[n-1] + (k - missingNumbers);
}
🔥 Why this works
Case	What to do
k ≤ missingNumbers	Answer is inside arr1
k > missingNumbers	Go beyond last element
⚠️ One more subtle bug (important)

Your loop condition:

else if(j+1 == arr[count] && count < arr.length-1)

⚠️ count < arr.length-1 should come before accessing arr[count]

Safer:

if(count < arr.length && j+1 == arr[count])

Otherwise you risk ArrayIndexOutOfBounds.

🧠 Final intuition (this is the key you missed)

You already did the hardest part:

Finding how many missing numbers exist inside range

Now always think:

“If k is bigger than what exists inside → continue outside”
 */