package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD;

public class dayIMinSwaps {
    public static int minSwapsTo1(int [] arr){
        int n = arr.length;
        int ones =0;
        for(int i:arr){
            if(i==1) ones++;
        }
        int currOnes =0;

        for(int i=0;i<ones;i++){
            if(arr[i] ==1) currOnes++;
        }
        int maxOnes = currOnes;
        for(int i=ones ; i<n;i++){
            if(arr[i]==1) currOnes++;
            if(arr[i-ones] ==1) currOnes--;

            maxOnes = Math.max(maxOnes, currOnes);
        }

        return ones - maxOnes;


    }
    public static void main(String[] args) {
        int arr[] = {1,1,0,0,0,1,1,0,0,0,1};
        int i = minSwapsTo1(arr);
        System.out.println(i);
    }
}
/*
Min Swaps to Group 1s
Difficulty: MediumAccuracy: 40.3%Submissions: 24K+Points: 4
You are given a binary array arr[] consisting only of 0s and 1s. Determine the minimum number of swaps required to group all the 1s together in a contiguous subarray.

A swap operation allows you to choose any two indices i and j and exchange their values (i.e., swap(arr[i], arr[j])).

If the array contains no 1s, return -1.

Examples:

Input: arr[] = [1, 0, 1, 0, 1]
Output: 1
Explanation: Only 1 swap is required to group all 1's together. Swapping index 1 and 4 will give arr[] = [1, 1, 1, 0, 0].
Input: arr[] = [1, 0, 1, 0, 1, 1]
Output: 1
Explanation: Only 1 swap is required to group all 1's together. Swapping index 0 and 3 will give arr[] = [0, 0, 1, 1, 1, 1].
Input: arr[] = [0, 0, 0]
Output: -1
Explanation: No 1s are present in the array, so return -1.

✅ Correct Thinking (Key Shift 🧠)
Instead of swapping blindly:
Count total 1s → k
Find a window of size k
Count how many 1s already exist in that window
Maximize that count
👉 Because fewer 0s inside = fewer swaps needed
🧩 Why this works
Each 0 inside the window:
👉 needs to be swapped with a 1 outside
So:
min swaps = number of 0s in best window
          = k - maxOnesInWindow

          🧠 What you should take from this

This is a classic transition moment in DSA:

👉 When swaps are allowed between any indices
👉 Don’t simulate swaps
👉 Think in terms of counting + positioning

Good—you’ve got the intuition. Now let’s turn that into a repeatable coding pattern so you don’t get stuck mid-way.

Your current issue is:

you don’t know how to structure the sliding window loop

Let’s fix that cleanly.

🧠 The Pattern You Should Memorize (Fixed-Size Sliding Window)

Whenever you see:

“subarray of size k”

Use this exact structure:

// 1. Build first window
for (int i = 0; i < k; i++) {
    // process arr[i]
}

// 2. Slide the window
for (int i = k; i < n; i++) {
    // include arr[i]
    // remove arr[i - k]
}

That’s it. No while(temp1 != 0) or random i, j.

🔥 Apply it to THIS problem step-by-step
Step 1: Count total 1s → window size
int ones = 0;
for (int num : arr) {
    if (num == 1) ones++;
}

Edge case:

if (ones == 0) return -1;
Step 2: First window (size = ones)
int currOnes = 0;

for (int i = 0; i < ones; i++) {
    if (arr[i] == 1) currOnes++;
}
Step 3: Slide the window
int maxOnes = currOnes;

for (int i = ones; i < arr.length; i++) {
    if (arr[i] == 1) currOnes++;          // add new element
    if (arr[i - ones] == 1) currOnes--;   // remove old element

    maxOnes = Math.max(maxOnes, currOnes);
}
Step 4: Final answer
return ones - maxOnes;
✅ Final Clean Code (Full)
 */
/*
That “shock” you felt is actually a great sign—it means your brain just saw a better abstraction than brute force. This is exactly how strong problem-solvers think, and you can train it.

Let me show you how to build that level of thinking, not just admire it.

🔑 The Real Shift (what happened here)

You were thinking:

“How do I perform swaps?”

Top solution thinks:

“What does a perfect arrangement look like?”

That’s the key upgrade.

👉 Instead of simulating actions, you describe the goal state mathematically.

🧠 The Hidden Pattern Behind This Problem

Ask these 3 questions whenever you see “group things together”:

1. What am I grouping?

👉 1s

2. How many are there?

👉 k = total 1s

3. What does a perfect group look like?

👉 A window of size k full of 1s

Boom 💥 — problem is transformed.

⚡ The Magic Insight (why it feels genius)

Once you say:

“Final answer must be a block of size k”

Then automatically:

Try all blocks of size k (sliding window)
Pick the best one

That’s not magic—it’s constraint → structure → optimization

🔁 How YOU can learn this (practical method)

Don’t try to “think genius”.

Instead, follow this 4-step mental checklist every time:

✅ Step 1: Ignore operations (swaps, moves, etc.)

Ask:

“What does the final answer look like?”

Here:
👉 contiguous 1s

✅ Step 2: Fix the structure

Ask:

“What is fixed in the final answer?”

Here:
👉 size = number of 1s

✅ Step 3: Convert to counting problem

Ask:

“Instead of doing, can I measure?”

Here:
👉 count 1s inside window

✅ Step 4: Optimize

Ask:

“What do I maximize/minimize?”

Here:
👉 maximize 1s → minimize swaps

🧩 Why your brain didn’t go there yet

Because currently you:

Think in operations (swap, move, simulate)

But top problem solvers:

Think in structure (window, count, constraint)

That’s the gap—and it’s trainable.

🏋️ How to train this skill (real strategy)

Do this for next 15–20 problems:

After solving, ask:

❓ What is the final shape of the answer?
❓ What is fixed?
❓ Can I convert this into a window / count / prefix problem?
❓ Did I simulate unnecessarily?
 */