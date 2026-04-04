package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

import java.util.Arrays;

public class TwoSum {
    //brute force
    public int[] bruteForce(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) { // we can take j =0;
                if (nums[i] + nums[j] == target) {// and write if(i==j) continue means skip.
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }

        }
        return arr;
    }
    //but not recommended.
    public boolean betterApproachUsingHash(int arr[], int target){
        int n = arr.length;
        int max = 1000; // depends on constraints
        boolean[] hash = new boolean[max + 1];

        for (int i = 0; i < arr.length; i++) {
            int remaining = target - arr[i];

            if (remaining >= 0 && remaining <= max && hash[remaining]) {
                return true;
            }

            hash[arr[i]] = true;
        }
        return  false;
    }
    //two pointer approach.

        boolean twoSum(int arr[], int target) {
            // code here
            // HashMap<Integer, Integer> map = new HashMap<>();

            //two pointer approach.
            Arrays.sort(arr);
            int l =0;
            int r = arr.length -1;
            while(l<r){
                if(arr[l] + arr[r] == target){
                    return true;
                }else if(arr[l] + arr[r] > target){
                    r--;
                }else {
                    l++;
                }
            }

            return false;

        }
        //ai notes.
  /*  ✅ Is your two-pointer approach correct?

            👉 Yes, 100% correct for this case (boolean return)

    Your logic:

    Sort array ✔️
    Use l and r ✔️
    Move pointers based on sum ✔️

    This is textbook perfect 👍

            🧠 Why your sir said “only one variation”?

    He’s absolutely right — here’s the key difference:

            ✅ Case 1: Return boolean (your code)

✔️ Two pointer works perfectly
✔️ You don’t care about original indices

❌ Case 2: Return indices (classic Two Sum problem)

👉 Problem:

            Arrays.sort(arr);
    Sorting changes original positions
    You lose index info

    Example:

    Original: [2, 6, 5, 8]
    Sorted:   [2, 5, 6, 8]

            👉 Index mapping is gone ❌

            🔥 That’s why HashMap is used

    With HashMap:

    You store: (value → index)
    No sorting → indices preserved
⚖️ Which is optimal?
    Your Two Pointer:
    Time: O(n log n) (because of sorting)
    Space: O(1)
    HashMap:
    Time: O(n) ✅ (better)
    Space: O(n)
🎯 Interview Understanding (VERY IMPORTANT)

👉 Say like this:

            “Two pointer works only when:
    array is sorted OR
    we don’t need indices”
            “If indices are required → HashMap is preferred”
            🔥 One more improvement in your code

    Small optimization:

    int sum = arr[l] + arr[r];

    Use this instead of recalculating 3 times.

    Final Verdict 💯
            ✅ Your logic → Correct
✅ Your understanding → On right track
🔥 Your sir → Guiding you correctly */
    }

/* Best (what interviewers expect) 🚀

👉 Use HashSet / HashMap

Clean logic:

HashSet<Integer> set = new HashSet<>();

for(int i = 0; i < arr.length; i++){
    int remaining = target - arr[i];

    if(set.contains(remaining)){
        return true;
    }

    set.add(arr[i]);
}
/* Where your thinking is right ✅
You understood:
“Instead of checking all pairs, store something and check remaining (target - value)”
This is the core idea of optimization ✔️
 Given
arr = [2, 6, 5, 8, 11]
target = 14

We use:

boolean[] hash = new boolean[1001]; // all false initially

👉 Meaning:
hash[x] = true → "I have already seen number x"
Step-by-step Dry Run 🧠
👉 i = 0 → arr[i] = 2
remaining = 14 - 2 = 12

Check:

hash[12] → false (not seen yet)

So:

hash[2] = true

✔️ Seen so far: {2}

👉 i = 1 → arr[i] = 6
remaining = 14 - 6 = 8

Check:

hash[8] → false

So:

hash[6] = true

✔️ Seen so far: {2, 6}

👉 i = 2 → arr[i] = 5
remaining = 14 - 5 = 9

Check:

hash[9] → false

So:

hash[5] = true

✔️ Seen so far: {2, 6, 5}

👉 i = 3 → arr[i] = 8
remaining = 14 - 8 = 6

Check:

hash[6] → true ✅

🔥 BOOM! That means:

We already saw 6
Current number is 8
6 + 8 = 14

👉 Pair found → return true

Key Insight (MOST IMPORTANT) 💡

You are not checking future elements
👉 You are checking past elements only

That’s why:

if(hash[remaining])

means:
👉 “Did I already see the number needed to form target?”

Why this works 🔥

Instead of:

checking all pairs (i, j)

You do:

For each number:
    check if its partner already exists
Your Thought vs Reality 🧠

You were thinking:

“We calculate something and store it”

But actual logic is:
👉 Store what you have seen
👉 Check what you need
One Line Summary 🚀

👉 “At every step, ask:
Have I already seen the number required to make target?”
 */