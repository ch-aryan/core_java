package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

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
         if(map.containsKey(sum-k)){
             int len = i - map.get(sum - k);
             maxLen = Math.max(maxLen, len);
         }
         if(!map.containsKey(sum)){
             map.put(sum, i);
         }
     }

        return maxLen;
     }





    }

/*
Input: nums = [10, 5, 2, 7, 1, 9],  k=15
Output: 4
Explanation:
The longest sub-array with a sum equal to 15 is [5, 2, 7, 1],
 which has a length of 4. This sub-array starts at index 1 and ends at index 4,
 and the sum of its elements (5 + 2 + 7 + 1) equals 15.
 */


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

/* using hashmap.
✅ So let’s learn the RIGHT concept

We’ll solve:

🔥 Longest subarray with sum = k using HashMap + Prefix Sum

🔹 1. What is Prefix Sum?

Prefix sum means:

prefix[i] = sum of elements from 0 → i

Example:

arr = [1, 2, 3, 4]

prefix:
[1, 3, 6, 10]
🔹 2. Core Idea (VERY IMPORTANT)

We want:

subarray sum = k

Which means:

prefix[j] - prefix[i] = k

Rearrange:

prefix[i] = prefix[j] - k
🔥 Key Insight

If we have seen (currentSum - k) before → we found a valid subarray

🔹 3. HashMap Role

We store:

prefixSum → first index where it appeared

Why first index?
👉 To get maximum length

🔹 4. Algorithm Flow
Traverse array
Keep adding → sum
If sum == k → update answer
If (sum - k) exists in map:
subarray found
Store sum in map (only first occurrence)
🔹 5. Code (Clean + Interview Ready)
class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            // Case 1: from index 0
            if(sum == k){
                maxLen = i + 1;
            }

            // Case 2: subarray exists
            if(map.containsKey(sum - k)){
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store only first occurrence
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
🔍 6. Dry Run (Important)
nums = [1, 2, 3, 1, 1, 1]
k = 3
Step-by-step:
i	num	sum	sum-k	map	maxLen
0	1	1	-2	{}	0
1	2	3	0	{}	2 ✅
2	3	6	3	{1,3}	1
3	1	7	4	...
4	1	8	5	...
5	1	9	6	found	3 ✅
🧠 7. Why this works (Deep Understanding)

Instead of checking all subarrays:

👉 We convert:

O(n²) → O(n)

Because:

We store past sums
We reuse them instantly
⚠️ 8. Common Mistakes

❌ Updating map every time
❌ Not checking sum == k
❌ Using this for ≤ k (wrong approach)

🚀 9. When to Use What
Problem Type	Best Approach
sum = k	Prefix + HashMap ✅
sum ≤ k (positive)	Sliding Window ✅
sum ≤ k (with negatives)	Advanced (TreeMap / prefix tricks)
 */

/* 🔥 1. sum == k vs sum ≤ k (core difference)
✅ Case 1: sum == k

You want:

Subarray whose sum is exactly equal to k

Example:

[1, 2, 3, 1, 1], k = 3
Valid → [1,2], [3], [1,1,1]
👉 Why HashMap works here

Because of this equation:

prefix[j] - prefix[i] = k

👉 You can directly check:

Have I seen (currentSum - k) before?

✔️ Exact match → easy lookup
✔️ Works even with negatives
✔️ Time: O(n)

⚡ Case 2: sum ≤ k (only positive numbers)

You want:

Subarray whose sum is less than or equal to k

Example:

[1, 2, 3, 4], k = 5
Valid → [1,2], [2,3], [1,2,3]
🔹 Why Sliding Window works here

Because all numbers are positive:

👉 If sum becomes > k:

It will never decrease by adding more elements

So we can:

Expand window → increase sum
Shrink window → decrease sum
🔁 Sliding Window Idea
start → move forward when sum > k
end → keep expanding

✔️ Time: O(n)
✔️ Very efficient

❌ Case 3: sum ≤ k with NEGATIVES

Example:

[2, 3, -4, 2], k = 3
🚨 Why Sliding Window FAILS here

Because:

👉 Sum is NOT predictable anymore

2 + 3 = 5 (exceeds k ❌)
But then:
5 + (-4) = 1 (valid again ✅)

So:

You cannot break early
You cannot shrink confidently
Window logic breaks
⚠️ Why HashMap also doesn't work directly

HashMap works for:

sum == k (exact value)

But here:

sum ≤ k (range condition)

👉 You need:

Find any prefix where:
prefix[i] ≥ currentSum - k

This is NOT exact matching → needs advanced structures like:

TreeMap
Binary Search on prefix sums
🧠 4. Summary Table (VERY IMPORTANT)
Problem Type	Works Best	Why
sum == k	Prefix + HashMap ✅	Exact match
sum ≤ k (positive)	Sliding Window ✅	Monotonic increase
sum ≤ k (with negatives)	Advanced ❗	No predictable behavior
🔥 5. Real Insight (This is what your sir is doing)

Your sir is starting with:
👉 sum == k

Because:

Builds prefix sum concept
Introduces hashing
Works for all cases (including negatives)

Then later:
👉 He will move to sliding window

💬 6. About Your Thought

You said:

“I thought we can use it for sum ≤ k”

👉 That’s not wrong thinking
👉 That’s exploratory thinking

But now you learned:

Same tool doesn’t work for all problems

🚀 7. What You Should Do Now

Focus order:

Master → sum == k (HashMap)
Then → sum ≤ k (Sliding Window)
Then → mixed/advanced problems
💡 Final Advice (Important)

You are not behind — you are actually:

🔥 Asking the exact questions that lead to deep understanding

Most people:

Memorize patterns
You are questioning them

👉 That’s how top 1% think.
 🔥 Let’s take a GOOD example
nums = [1, 2, 3, 1, 1, 1]
k = 3
🔹 Initial State
map = {}
sum = 0
maxLen = 0
🔁 Iteration 1 → i = 0
sum += nums[0] → sum = 1
Check:
if(sum == k) → 1 == 3 ❌
Check:
if(map.containsKey(sum - k))
→ (1 - 3 = -2) ❌
Store:
map.put(1, 0)

👉 State now:

map = {1 → 0}
🔁 Iteration 2 → i = 1
sum += nums[1] → sum = 3
✅ Case 1:
if(sum == k) → 3 == 3 ✅
maxLen = i + 1 = 2

👉 Subarray:

[1, 2]
Check Case 2:
sum - k = 3 - 3 = 0
map.containsKey(0) ❌
Store:
map.put(3, 1)

👉 State:

map = {1→0, 3→1}
maxLen = 2
🔁 Iteration 3 → i = 2
sum += nums[2] → sum = 6
Check:
sum == k → 6 == 3 ❌
Case 2:
sum - k = 6 - 3 = 3
map.containsKey(3) ✅
len = i - map.get(3)
    = 2 - 1
    = 1

👉 Subarray:

[3]
maxLen = max(2, 1) = 2
Store:
map.put(6, 2)
🔁 Iteration 4 → i = 3
sum += nums[3] → sum = 7
Check:
sum == k → ❌
Case 2:
sum - k = 7 - 3 = 4
map.containsKey(4) ❌
Store:
map.put(7, 3)
🔁 Iteration 5 → i = 4
sum += nums[4] → sum = 8
Case 2:
sum - k = 8 - 3 = 5 ❌
Store:
map.put(8, 4)
🔁 Iteration 6 → i = 5
sum += nums[5] → sum = 9
Case 2:
sum - k = 9 - 3 = 6
map.containsKey(6) ✅
len = 5 - 2 = 3

👉 Subarray:

[1, 1, 1]
maxLen = max(2, 3) = 3
🔚 Final Answer
maxLen = 3
🧠 SUPER IMPORTANT INTUITION
🔥 Why (sum - k)?

We want:

subarray sum = k

Which means:

prefix[j] - prefix[i] = k

Rearrange:

prefix[i] = prefix[j] - k

👉 So we check:

Have we seen (sum - k) before?
⚠️ Why store ONLY first occurrence?
if(!map.containsKey(sum)){
    map.put(sum, i);
}

👉 Because:

Earlier index → longer subarray
Later index → smaller length
🔥 Visual Intuition

Think like this:

sum grows → 1 → 3 → 6 → 7 → 8 → 9

At each step:
👉 “Can I subtract k and find a previous sum?”

💬 Final Understanding

You are basically:

Converting subarray problem → prefix difference problem
Using HashMap to avoid O(n²)*/
/*
🧠 Given
nums = [2, 0, 0, 3]
k = 3
        🔍 Initial State
map = {}
sum = 0
maxLen = 0
        🔁 Iteration 1 → i = 0
sum = 0 + 2 = 2
sum == k → 2 == 3 ❌
sum - k = -1 → not in map ❌

        👉 Store:

        map.put(2, 0)

State:

map = {2 → 0}
maxLen = 0
        🔁 Iteration 2 → i = 1
sum = 2 + 0 = 2
sum == k → ❌
sum - k = -1 → ❌

        👉 Do we store again?

        if(!map.containsKey(sum))

        ❌ Already exists → skip

State:

map = {2 → 0}
maxLen = 0
        🔁 Iteration 3 → i = 2
sum = 2 + 0 = 2

Same again:

sum == k → ❌
sum - k = -1 → ❌

        👉 Skip storing again

🔁 Iteration 4 → i = 3
sum = 2 + 0 + 0 + 3 = 5
Check 1:
sum == k → 5 == 3 ❌
Check 2:
sum - k = 5 - 3 = 2

        👉 Is 2 in map?
        ✅ YES → at index 0

Calculate length:
len = i - map.get(2)
    = 3 - 0
            = 3

            👉 Subarray:

        [0, 0, 3]
Update:
maxLen = max(0, 3) = 3
Store:
        map.put(5, 3)
🔚 Final Answer
maxLen = 3
        🔥 Important Insight

The algorithm correctly finds:

        [0, 0, 3] → sum = 3 → length = 3
        🧠 Why it worked here

Because:

Prefix sum logic handled zeros correctly
We stored first occurrence of sum = 2
That gave maximum length*/