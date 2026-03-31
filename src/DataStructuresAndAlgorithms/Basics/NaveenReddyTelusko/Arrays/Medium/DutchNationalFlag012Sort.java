package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class DutchNationalFlag012Sort {
    public void sort012DutchNationalFlag(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {//if mid == 2. swap with high.
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,2,2,2,0,0,0};

        new DutchNationalFlag012Sort().sort012DutchNationalFlag(arr);

    }
}
/*
🧠 Step 1: First understand the problem deeply

You have:

        [0, 1, 2, 0, 1, 2, ...]

        👉 You need:

All 0s → left
All 1s → middle
All 2s → right
💡 Step 2: Think like a human (not algorithm)

If I give you this array physically, you might:

Push all 0s to left
Push all 2s to right
Leave 1s in middle

👉 So actually:

        0 has a correct side (left)
2 has a correct side (right)
1 is just filler in middle
⚡ Step 3: Divide the array into 4 regions

Your sir said something very powerful. Let’s visualize it:

        |----0s----|----1s----|----unknown----|----2s----|
        0         low       mid             high        n-1
Meaning of each region:
        ✅ 0 → low-1

        👉 All are 0 (correct)

        ✅ low → mid-1

        👉 All are 1 (correct)

        ❓ mid → high

👉 Unsorted / unknown zone (we need to process this)

✅ high+1 → end

👉 All are 2 (correct)

        🎯 Step 4: The Goal

👉 Slowly shrink the unknown region (mid → high)
👉 Expand correct regions

🔥 Step 5: Now the real intuition (IMPORTANT)

We only look at:

arr[mid]

Because:
        👉 Everything before mid is already handled
👉 Everything after high is already handled

So:
        👉 mid is the decision maker

⚡ Step 6: 3 Situations
🟢 Case 1: arr[mid] == 0

        👉 0 should go to LEFT

So:

Swap it with low

Why?
        👉 Because low is where 0 belongs

After swap:

low++
mid++
        🧠 Why mid++?

Because:
        👉 The swapped element from low is already processed (it was 1)

🟡 Case 2: arr[mid] == 1

        👉 Already in correct region

So:

Just move mid++
        🔴 Case 3: arr[mid] == 2

        👉 2 should go to RIGHT

So:

Swap with high
high--
        🧠 IMPORTANT: Why NOT mid++ here?

This is where most people get confused 👇

        👉 Because the element coming from high is unknown

So we must:

stay at mid and re-check
🧠 Step 7: The Deep Insight (THIS IS THE MAGIC)

👉 We are not sorting
👉 We are placing elements in correct zones while scanning once

🔥 Step 8: Example Walkthrough

Let’s take:

        [2, 0, 2, 1, 1, 0]

Initial:

low = 0, mid = 0, high = 5
Step 1:
arr[mid] = 2

        👉 Swap with high

[0, 0, 2, 1, 1, 2]
high--
mid stays
Step 2:
arr[mid] = 0

        👉 Swap with low

[0, 0, 2, 1, 1, 2]
low++, mid++
Step 3:
arr[mid] = 0

        👉 Again swap with low

[0, 0, 2, 1, 1, 2]
low++, mid++
Step 4:
arr[mid] = 2

        👉 Swap with high

[0, 0, 1, 1, 2, 2]
high--
        (mid stays)
Step 5:
arr[mid] = 1

        👉 mid++

Step 6:
arr[mid] = 1

        👉 mid++

Done 🎉

        🧠 Final Mental Model (Remember this forever)

👉 Think like this:

low → next position for 0
high → next position for 2
mid → current explorer
⚡ One-Line Intuition

👉
        “Scan once, push 0s left, push 2s right, let 1s stay.”

        ❤️ Real Talk

Your sir is right:

Most people just memorize this

But you now:

Understand regions ✔️
Understand why swap ✔️
Understand why mid doesn’t move sometimes ✔️

        👉 This is real DSA thinking */
/* 🧠 Connect Code with Intuition

Every line matches what you learned:

low → where next 0 should go
mid → current element we are checking
high → where next 2 should go
🔥 Most Important Line (Don’t Forget)
// NO mid++ when arr[mid] == 2

👉 Because:

Swapped element is unknown
Must re-check it
⚡ Final Checklist (Interview Ready)

If interviewer asks, you should say:

“We maintain 3 pointers: low, mid, high”
“We divide array into 4 regions”
“We process only mid”
“Swap based on value (0,1,2)”
“Single pass → O(n), constant space”
💯 You Just Learned
Not just code
Not just logic
But a pattern used in many problems

Honestly, this is the level where:
👉 You stop being a beginner
👉 You start thinking like an engineer */