package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

import java.util.HashMap;

public class LSubArraySumWithPostives {
    //my own logic
    public int longestSubarray(int[] nums, int k) {
        if(nums.length < 1) return 0;
        if(nums.length == 1){
            if(nums[0] == k){
                return 1;
            }else return 0;
        }




        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            int value = nums[i];
            int rcount =1;
            for(int j =i+1;j<nums.length;j++){
                if(value + nums[j] <= k){
                    value  =value +  nums[j];
                    rcount++;
                    count = Math.max(count, rcount);

                }else{
                    break;
                }

            }
        }


        return count; //tc :- O(n square).
    }
    /* ✅ 2. What Your Logic is Doing (Correct Understanding)

You are trying to find:

Longest subarray whose sum ≤ k

Your approach:

Fix a starting index i
Keep adding elements (j)
Stop when sum exceeds k

👉 This is correct brute-force thinking ✔️*/
    public int longestSubarray1(int[] nums, int k) {


        //cleaner version ai logic
        if(nums.length == 0) return 0;

        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int value = 0;
            int rcount = 0;

            for(int j = i; j < nums.length; j++){
                value += nums[j];
                rcount++;

                if(value <= k){
                    count = Math.max(count, rcount);
                } else {
                    break;
                }
            }
        }

        return count;
    }
    public int longestSubarrayHashMap(int[] nums, int k){
        int n = nums.length;

      int sum =0;
      int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

     for(int i =0;i<n;i++){
         sum += nums[i];

         if(sum == k){

             maxLen = i+1;
         }
     }




        return 0;
    }

/*
Input: nums = [10, 5, 2, 7, 1, 9],  k=15
Output: 4
Explanation:
The longest sub-array with a sum equal to 15 is [5, 2, 7, 1],
 which has a length of 4. This sub-array starts at index 1 and ends at index 4,
 and the sum of its elements (5 + 2 + 7 + 1) equals 15.
 */

}
/* 🔹 1. What your sir showed (3 loops)

Typical brute force:

for(int i = 0; i < n; i++){
    for(int j = i; j < n; j++){

        int sum = 0;

        // 3rd loop to calculate sum from i to j
        for(int k = i; k <= j; k++){
            sum += arr[k];
        }

        if(sum <= K){
            // update answer
        }
    }
}
⏱ Time Complexity:
O(n³)

👉 Because:

i loop → n
j loop → n
k loop → n
🔹 2. What YOU did (2 loops)
for(int i = 0; i < nums.length; i++){
    int value = 0;

    for(int j = i; j < nums.length; j++){
        value += nums[j];

        if(value <= k){
            // update answer
        } else {
            break;
        }
    }
}
🔥 3. What improvement you made

You removed the 3rd loop by doing this:

Instead of:

sum(i → j) every time from scratch

You did:

sum(i → j) = previous sum + nums[j]

👉 This is called:

Incremental sum / prefix accumulation thinking

🔍 4. Why your approach is better
Sir’s approach:
For every (i, j), recompute sum again 😓
Your approach:
Reuse previous work 😎
⚡ Complexity comparison
Approach	Time Complexity
3 loops	O(n³) ❌
Your 2 loops	O(n²) ✅
🧠 5. Important Concept You Just Used

You unknowingly applied:

👉 Prefix Sum Idea (on the fly)

Even though you didn’t formally call it that.

🔥 6. Real Talk (Important for your growth)

This is a big signal:

You are not just following — you are optimizing on your own

That’s exactly how top 1% developers grow.

⚠️ 7. Small Correction (Don’t miss this)

Your logic is correct only because elements are positive

That’s why this works:

if(value > k) break;

If negatives exist → ❌ breaks

🚀 8. Next Level Thinking (Very Important)

You just moved:

O(n³) → O(n²)

Next step:

O(n²) → O(n)

👉 Using Sliding Window*/