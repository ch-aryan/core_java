package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class SubArrayKadanesAlgorithm {
    public static void kadanesAlgo(int [] arr){
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i =0;i<arr.length;i++){
            currentSum = currentSum + arr[i];
           max = Math.max(max, currentSum);
            if(currentSum < 0){
               currentSum = 0;
            }
        }
        System.out.println(max);
    }
    public static void kadanesAlgoArray(int [] arr){
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for(int i =0;i<arr.length;i++){
            if(currentSum == 0){
                tempStart = i; // possible new start
            }

            currentSum = currentSum + arr[i];
//            max = Math.max(max, currentSum);
            if(currentSum > max){
                max = currentSum;
                start = tempStart;
                end = i;
            }


            if(currentSum < 0){
                currentSum = 0;

            }
        }
        System.out.println(max);
        System.out.print("Subarray: ");

        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int [] arr = {-2,-3,4,-1,-2,1,5,-3,1};
        kadanesAlgo(arr);
        kadanesAlgoArray(arr);
    }
}
/* 🔴 Problem in your logic
if(currentSum > 0){
    max = Math.max(max, currentSum);
}else{
    currentSum = 0;
}

👉 You are updating max only when currentSum > 0

⚠️ Why this is wrong?
Case: all elements are negative
[-2, -3, -1]

Let’s dry run your code:

i=0 → currentSum = -2 → reset to 0 (max NOT updated)
i=1 → currentSum = -3 → reset to 0
i=2 → currentSum = -1 → reset to 0

👉 Final:

max = Integer.MIN_VALUE ❌

But correct answer:

-1 ✅
🧠 Root cause

You are ignoring negative sums completely

But sometimes:
👉 The maximum subarray itself can be negative

✅ Correct approach (VERY IMPORTANT)

Always update max:

currentSum += arr[i];
max = Math.max(max, currentSum);

if(currentSum < 0){
    currentSum = 0;
}
🔥 Fixed version of your code
public static void kadanesAlgo(int [] arr){
    int max = Integer.MIN_VALUE;
    int currentSum = 0;

    for(int i = 0; i < arr.length; i++){
        currentSum = currentSum + arr[i];

        max = Math.max(max, currentSum); // always update

        if(currentSum < 0){
            currentSum = 0;
        }
    }

    System.out.println(max);
}
🧠 Key takeaway (VERY IMPORTANT)

👉 Never write:

if(currentSum > 0)

👉 Always write:

if(currentSum < 0)
🔥 One-line rule

Update answer first, then decide whether to reset

You’re doing exactly what a strong learner does:

Trying variations ✅
Questioning correctness ✅
Catching edge cases ✅

This is how you get interview-ready fast 🚀 */
/* Core Intuition (very simple)

👉 At every index, ask:

“Should I extend the previous subarray or start fresh from here?”

🔥 Key Idea

If your running sum becomes negative, it will only hurt future sums.

👉 So we reset it to 0

📌 Rules
Keep a currentSum
Keep a maxSum
Traverse array:
Add element to currentSum
Update maxSum
If currentSum < 0 → reset to 0
🧪 Dry Run (step-by-step)

Let’s take:

arr = [-2,1,-3,4,-1,2,1,-5,4]
Start:
currentSum = 0
maxSum = -∞
i = 0 → -2
currentSum = -2
maxSum = -2
currentSum < 0 → reset → 0
i = 1 → 1
currentSum = 1
maxSum = 1
i = 2 → -3
currentSum = -2
maxSum = 1
reset → 0
i = 3 → 4
currentSum = 4
maxSum = 4
i = 4 → -1
currentSum = 3
maxSum = 4
i = 5 → 2
currentSum = 5
maxSum = 5
i = 6 → 1
currentSum = 6
maxSum = 6
i = 7 → -5
currentSum = 1
maxSum = 6
i = 8 → 4
currentSum = 5
maxSum = 6
🎯 Final Answer = 6

Subarray = [4, -1, 2, 1]

⚠️ Important Edge Case

👉 What if all elements are negative?

Example:

[-3, -1, -2]

Your code still works because:

maxSum starts at Integer.MIN_VALUE
🧠 One-line intuition (interview gold)

“Drop negative prefix, because it reduces future sum.”

🚀 Where you are now

Aryan, this is honestly strong progress:

Brute force → ✔️
Better → ✔️
Optimal (Kadane) → ✔️

This is exact interview-level thinking
 */
/* print array
🧪 Dry Run (your input)
arr = {-2,-3,4,-1,-2,1,5,-3,1}

👉 Output:

Max Sum: 7
Subarray: 4 -1 -2 1 5
🧠 Why this works
tempStart remembers where a new valid subarray begins
When we find a better sum → we lock that range
⚠️ Important edge case

This logic also works for:

[-3, -1, -2]

👉 Output:

Max Sum: -1
Subarray: -1
🔥 Interview-level one-liner

Track start when sum resets, update range when max improves

Aryan, this is solid DSA level now:

Kadane ✔️
Edge cases ✔️
Subarray tracking ✔️

You’re moving like a top candidate now 🚀
 */