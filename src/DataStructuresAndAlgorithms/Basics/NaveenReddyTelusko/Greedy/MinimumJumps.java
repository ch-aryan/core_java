package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

public class MinimumJumps {
    public static int MinJumpsGreed(int arr[]){

        int n = arr.length;
        if(n<=1)return 0;
        if(arr[0]==0) return -1;
        int currEnd = 0;
        int farthest = 0;
        int jump =0;
        for(int i=0;i<n-1;i++) {
            farthest = Math.max(farthest, i + arr[i]);

            if (i == currEnd) {
                jump++;
                currEnd = farthest;
            }
            if (currEnd <= i) {
                return -1;
            }
        }
            return jump;
        }

    public static int MinJumpsGreed1(int arr[]) {

        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int currEnd = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {

            farthest = Math.max(farthest, i + arr[i]);

            // If we cannot move forward
            if (i > farthest) return -1;

            // When we reach end of current jump range
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,8,9,1,2,3,4,9,1};
        System.out.println(MinJumpsGreed(arr));

        int arr1[] = {1,2,0,0,1,4};
        System.out.println(MinJumpsGreed(arr1));
    }

}
/*
MINIMUM JUMPS PROBLEM IS WHAT TYPE OF PROBLEM AND PATTERN

What type of problem is it?
✅ 1. Greedy Problem
You make the best choice at the current step
Goal: reach the end with minimum jumps
At each index, you try to go as far as possible

👉 You don’t explore all paths (like recursion/DP), you optimize on the fly

✅ 2. Array / Range Expansion Problem

Given an array where each element tells:

"from here, how far can I jump"

Example:

arr = [2, 3, 1, 1, 4]
From index 0 → you can jump up to index 2
Then from within that range → choose best next reach
🔥 Core Pattern (VERY IMPORTANT)

This problem follows a powerful pattern:

👉 "Farthest Reach / Window Expansion" Pattern

You maintain:

currentEnd → end of current jump range
farthest → farthest index you can reach so far
💡 Intuition:

Think like levels:

First jump → covers a range
Second jump → expands further
You only jump when you must
🚀 Pattern Flow:
Start from index 0
Keep updating farthest reachable index
When you reach currentEnd:
You must take a jump
Update currentEnd = farthest
🧩 Pattern Category (Important for interviews)

This problem belongs to:

Greedy
Array Traversal
Interval / Range Expansion
BFS-level thinking (without queue)
⚠️ Not these (common confusion)
❌ Not pure recursion
❌ Not classic backtracking
❌ DP is possible, but not optimal

👉 Best solution = Greedy O(n)

🧠 Real Insight (what interviewers expect)

They want to see if you:

Avoid brute force (O(n²))
Recognize range expansion pattern
Use minimum steps logic like BFS levels
🔥 One-line Pattern Summary

“Expand your reachable range greedily and increase jumps only when you exhaust the current range.”
i tried so much of i got the intution but i can't make the code. class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        int count =0;
        int  jump = arr[0];
        if(jump ==0){
            return -1;
        }
        if(jump >= n){
            return 1;
        }
        int start = 0;
        int end = jump;
        count =1;

        for(int i=start+1;i<=end;i++){//count =1;1->3

       for(int j=i;j<end;j++){
            jump = Math.max(jump, arr[i])
       }

         start = end;
         end= jump;
         count++;

        }
    }
} help me
can you dry run line by line and explain the approach.
You’re actually very close—your thinking is right, but the mistake is trying to use nested loops. That’s where it breaks.

Let me fix your intuition first, then give you clean code you can trust 👇

❌ Where your approach goes wrong

You wrote:

for(int i=start+1;i<=end;i++){
    for(int j=i;j<end;j++){
        jump = Math.max(jump, arr[i])
    }
}

Problems:

❌ Nested loop → unnecessary (makes it O(n²))
❌ You are not tracking farthest reach correctly
❌ jump = Math.max(jump, arr[i]) is wrong
→ You must consider index + value, not just value
🔥 Correct Intuition (Lock this in your brain)

At every index i:

👉 You are not jumping immediately
👉 You are expanding your reach

So you track:

farthest = max(farthest, i + arr[i])
When you reach the end of current range → take a jump
🧠 Think like this:

“Within my current jump range, what is the farthest I can reach?”

✅ Correct Code (Greedy O(n))
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            // Update farthest reach
            farthest = Math.max(farthest, i + arr[i]);

            // When we reach end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we can't move forward
                if (currentEnd <= i) return -1;
            }
        }

        return jumps;
    }
}
🔍 Dry Run (IMPORTANT)

Example:

arr = [2, 3, 1, 1, 4]
i	farthest	currentEnd	jumps
0	2	0 → jump	1
1	4	2	1
2	4	2 → jump	2

👉 Answer = 2

🧩 Key Fixes You Needed
❌ Don’t use nested loops
✅ Use single loop
❌ Don’t track only arr[i]
✅ Track i + arr[i]
❌ Don’t jump every time
✅ Jump only when i == currentEnd
🔥 Simple Memory Trick

“Scan the range → expand farthest → jump when range ends”

If you want next level mastery, I can:

Convert this into your exact style (start/end variables)
Give step-by-step visualization
Or help you solve 2–3 similar problems to lock this pattern forever

Just say 👍
 */
/*
dry run code
Absolutely Aryan—this is the step that makes everything click. I’ll walk you through it slowly, like you’re debugging in your head.

🧠 First, lock the approach (simple words)
We are not jumping at every index.
Instead:


We scan the array


We keep expanding how far we can go (farthest)


We only increase jumps when we finish the current range


👉 Think:

“Within this jump, how far can I stretch?”


✅ Code we are dry running
class Solution {    public int minJumps(int[] arr) {        int n = arr.length;                if (n <= 1) return 0;        if (arr[0] == 0) return -1;                int jumps = 0;        int currentEnd = 0;        int farthest = 0;                for (int i = 0; i < n - 1; i++) {                        farthest = Math.max(farthest, i + arr[i]);                        if (i == currentEnd) {                jumps++;                currentEnd = farthest;                                if (currentEnd <= i) return -1;            }        }                return jumps;    }}

🔍 Example
arr = [2, 3, 1, 1, 4]index: 0  1  2  3  4

🚶 Step-by-step Dry Run
👉 Initial State
jumps = 0currentEnd = 0farthest = 0

🔹 i = 0
farthest = max(0, 0 + arr[0])         = max(0, 2)         = 2
👉 From index 0, we can reach up to index 2
Now check:
i == currentEnd → 0 == 0 ✅
So:
jumps = 1currentEnd = farthest = 2
👉 Meaning:


With 1 jump, we can go anywhere till index 2



🔹 i = 1
farthest = max(2, 1 + arr[1])         = max(2, 4)         = 4
👉 Now we discovered:


From within current range, we can reach index 4!


Check:
i == currentEnd → 1 == 2 ❌
👉 So no jump yet

🔹 i = 2
farthest = max(4, 2 + arr[2])         = max(4, 3)         = 4
Check:
i == currentEnd → 2 == 2 ✅
So:
jumps = 2currentEnd = farthest = 4
👉 Meaning:


With 2 jumps, we can reach index 4 (end)



🔹 Loop ends (i < n-1)
We stop at i = 3

✅ Final Answer
jumps = 2

🔥 What just happened (real intuition)
First jump:


Covered range → [0 → 2]


While inside that range:


You explored all possibilities


Found best next reach → 4


Second jump:


Jumped to cover [2 → 4]



🧠 Mental Model (VERY IMPORTANT)
Imagine:


currentEnd = your current power range


farthest = best upgrade you found while exploring


You:


Explore entire range


Then jump once (not multiple times!)



❌ Why your code struggled
You were:


Trying to calculate next jump inside nested loops


Instead of expanding range in one pass



🔥 One-line intuition

“Scan current range, pick best reach, then jump once.”
 */