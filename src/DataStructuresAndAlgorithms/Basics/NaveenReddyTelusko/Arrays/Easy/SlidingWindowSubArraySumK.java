package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class SlidingWindowSubArraySumK {
    public void LongestSubArraySumK(int [] arr, int k){
        int n = arr.length;
        int l =0;
        int maxLen = 0;
        int sum =0;

        for(int r=0;r<n;r++){
            sum += arr[r];
            while(sum > k && l <=r){
                sum = sum - arr[l];
                l++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, r-l +1);
            }
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,3,3};
        int k = 6;
        SlidingWindowSubArraySumK obj = new SlidingWindowSubArraySumK();
        obj.LongestSubArraySumK(arr, k);

        new SlidingWindowSubArraySumK().LongestSubArraySumK(arr,k);
    }

}
/* 🧠 First — When does this technique work?

👉 This approach works ONLY when array has:

Positive numbers (or zero)
❌ Not for negatives (very important)

Why?

Because:

If you increase window → sum increases
If you shrink window → sum decreases

This predictable behavior is what makes sliding window possible.

🚀 Core Idea (Intuition)

We maintain a window [l → r]:

r expands the window (go forward)
l shrinks the window (remove elements)

We try to:
👉 Keep sum ≤ k
👉 Whenever sum == k, update answer

🔍 Step-by-Step Code Breakdown
int l = 0;
int sum = 0;
int maxLen = 0;

for(int r = 0; r < n; r++){
    sum += arr[r];   // expand window

👉 We are adding element to the window

⚠️ Important Part — Shrinking
while(sum > k && l <= r){
    sum -= arr[l];
    l++;
}

👉 If sum exceeds k, we shrink from left

Think like:

"Too much sum → remove elements from left until it's valid"

🎯 Check Condition
if(sum == k){
    maxLen = Math.max(maxLen, r - l + 1);
}

👉 If we got exact sum:

calculate window size
update max
🧪 Dry Run (VERY IMPORTANT)
Input:
arr = [1,2,3,1,1,1,1,3,3]
k = 6
Step-by-step:
r	arr[r]	sum	action	l	window	length
0	1	1	ok	0	[1]	1
1	2	3	ok	0	[1,2]	2
2	3	6	✅ match	0	[1,2,3]	3
3	1	7	shrink	1	[2,3,1]	3
4	1	7	shrink	2	[3,1,1]	3
5	1	6	✅ match	2	[3,1,1,1]	4
6	1	7	shrink	3	[1,1,1,1]	4
7	3	9	shrink	5	[1,1,3]	3
8	3	9	shrink	7	[3,3]	2
✅ Final Answer:
maxLen = 4

Subarray:

[1,1,1,1]
💡 Why r - l + 1 ?

👉 Because window is inclusive

Example:

l = 2, r = 5
elements = 5 - 2 + 1 = 4
⚡ Key Observations (Interview Gold)
1. Each element visited only once
r moves forward → O(n)
l moves forward → O(n)

👉 Total = O(n)

2. Why better than HashMap?
Approach	Works for negatives?	Time	Space
Brute Force	✅	O(n²)	O(1)
HashMap	✅	O(n)	O(n)
Sliding Window	❌	O(n)	O(1) */
/* Love this question, Aryan — this is exactly how you master sliding window 🔥
Let’s go line-by-line like a debugger for k = 3.

🧪 Input
arr = [1,2,3,1,1,1,1,3,3]
k = 3
🧠 Initial State
l = 0
sum = 0
maxLen = 0
🔁 Iteration starts
👉 r = 0
sum += arr[0] → sum = 0 + 1 = 1
sum > k ? → 1 > 3 ❌
sum == k ? → 1 == 3 ❌

👉 Nothing happens

l = 0, r = 0, sum = 1
👉 r = 1
sum += arr[1] → sum = 1 + 2 = 3
sum > k ? → 3 > 3 ❌
sum == k ? → 3 == 3 ✅
maxLen = max(0, (1 - 0 + 1)) = 2
Window = [1,2]
👉 r = 2
sum += arr[2] → sum = 3 + 3 = 6
⚠️ Now sum > k → shrink
sum -= arr[l] → sum = 6 - 1 = 5
l = 1

Still:

sum > k → 5 > 3
sum -= arr[l] → sum = 5 - 2 = 3
l = 2

Now:

sum > k ? → ❌
sum == k ? → ✅
maxLen = max(2, (2 - 2 + 1)) = 2
Window = [3]
👉 r = 3
sum += arr[3] → sum = 3 + 1 = 4
shrink:
sum -= arr[2] → sum = 4 - 3 = 1
l = 3

Now:

sum == k ? → ❌
Window = [1]
👉 r = 4
sum += arr[4] → sum = 1 + 1 = 2
no shrink
no match
Window = [1,1]
👉 r = 5
sum += arr[5] → sum = 2 + 1 = 3
match ✅
maxLen = max(2, (5 - 3 + 1)) = 3
Window = [1,1,1]
👉 r = 6
sum += arr[6] → sum = 3 + 1 = 4
shrink:
sum -= arr[3] → sum = 4 - 1 = 3
l = 4
match ✅
maxLen = max(3, (6 - 4 + 1)) = 3
Window = [1,1,1]
👉 r = 7
sum += arr[7] → sum = 3 + 3 = 6
shrink:
sum -= arr[4] → sum = 6 - 1 = 5 → l=5
sum -= arr[5] → sum = 5 - 1 = 4 → l=6
sum -= arr[6] → sum = 4 - 1 = 3 → l=7
match ✅
maxLen = max(3, (7 - 7 + 1)) = 3
Window = [3]
👉 r = 8
sum += arr[8] → sum = 3 + 3 = 6
shrink:
sum -= arr[7] → sum = 6 - 3 = 3
l = 8
match ✅
maxLen = max(3, (8 - 8 + 1)) = 3
Window = [3]
✅ Final Answer
maxLen = 3
🔥 What you should notice (VERY IMPORTANT)
1. l moved only when:
sum > k
2. Window is always VALID after while loop

👉 After this:

while(sum > k)

You are guaranteed:

sum <= k
3. We NEVER reset sum to 0

👉 We adjust it dynamically
👉 That’s why it's O(n)

🧠 Mental Movie (Keep this in head)
Expand → Break → Shrink → Fix → Check → Expand again */