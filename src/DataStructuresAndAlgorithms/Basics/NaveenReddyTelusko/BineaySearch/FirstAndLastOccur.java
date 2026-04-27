package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

import java.util.ArrayList;
import java.util.*;
//AI tc. O(log n).
class Solution {

    public static int firstOcc(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1; // go left
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOcc(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1; // go right
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> firstAndLastOcc(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(firstOcc(arr, x));
        res.add(lastOcc(arr, x));
        return res;
    }
}
public class FirstAndLastOccur {
    public static ArrayList<Integer> firstAndLastOcc(int arr[] , int tar){
        ArrayList<Integer> al = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        int first = -1;
        int last = -1;
        while(low <=high){
            int mid = low + high /2;
            if(arr[mid] == tar){
                first = mid;
                last = mid;
                break;
            }else if(arr[mid] > tar){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

            while(first -1 >= 0 && arr[first-1] == tar){
                first--;
            }
            while(last+1 <= arr.length-1 && arr[last+1] == tar){
                last++;
            }
            al.add(first);
            al.add(last);

            return al;


    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,5,5,5,7,123,125};
        int tar = 5;

        firstAndLastOcc(arr, tar).forEach(v-> System.out.println(v));

    }
}
/*
🧠 Simple understanding

👉 When break is executed:

Loop stops right there
Control moves to the next line after the loop
📌 Example
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }
    System.out.print(i + " ");
}
Output:
1 2 3 4

👉 As soon as i == 5, loop terminates

🔍 Works in all loops

✔ for loop
✔ while loop
✔ do-while loop

⚡ Important note (very important)

👉 break only exits the current loop, not all loops.

Example (nested loop):
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (j == 2) break;
        System.out.println(i + " " + j);
    }
}

👉 Only inner loop breaks, outer loop continues.
🎯 When to use break?

Use it when:

You found exact answer
No need to continue loop

Avoid it when:

You need optimal answer (like lower bound)

❌ Problems in your code
1) 🚨 If element not found → crash
int fK = -1;
...
high = fK;   // ❌ high = -1
arr[fK]      // ❌ arr[-1] → crash

👉 If x is not present, your code breaks badly

2) ❌ Wrong expansion logic
while (low <= high && arr[fK] == x) {
    fK--;
}

Problems:

❌ You are NOT checking boundary (fK >= 0)
❌ low and high are useless here
❌ You overshoot (go one extra step)
3) ❌ Same issue for right side
while (low <= high && arr[lK] == x) {
    lK++;
}
❌ No check for lK < n
❌ Can go out of bounds
🧠 Your idea (what you tried)

✔ Step 1: Find one occurrence using binary search
✔ Step 2: Expand left and right

👉 This idea is valid, but implementation is unsafe

✅ Corrected version (fixing your approach)
class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();

        int low = 0, high = n - 1;
        int fK = -1, lK = -1;

        // Step 1: find any occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                fK = mid;
                lK = mid;
                break;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If not found
        if (fK == -1) {
            al.add(-1);
            al.add(-1);
            return al;
        }

        // Step 2: expand left safely
        while (fK - 1 >= 0 && arr[fK - 1] == x) {
            fK--;
        }

        // Step 3: expand right safely
        while (lK + 1 < n && arr[lK + 1] == x) {
            lK++;
        }

        al.add(fK);
        al.add(lK);

        return al;
    }
}
⚠️ But here’s the truth (important)

👉 Your approach works, but:

❌ Worst-case time = O(n)
(because expansion can scan whole array)

🚀 Better Approach (what interviewer expects)

Use binary search twice:

First occurrence → Lower Bound
Last occurrence → Upper Bound - 1

👉 Time = O(log n)

🎯 Final Verdict
Part	Status
Idea	✅ Good
Implementation	❌ Buggy
Optimal	❌ Not optimal
🧠 What you should learn from this

👉 Always check:

boundaries (index >= 0, < n)
not found case
avoid unnecessary loops
 */
/*
🚨 Why not optimal?

Worst case:

arr = [5,5,5,5,5,5,5,5,5]
Binary search → O(log n)
Expansion → O(n)

👉 Total = O(n) ❌

❌ 3. Bugs in your code
🔴 Bug 1: Mid calculation
int mid = low + high / 2;  // ❌ WRONG

👉 Should be:

int mid = low + (high - low) / 2;  // ✅
🔴 Bug 2: Boundary condition
while(first -1 > 0 && arr[first-1] == tar)

👉 Wrong condition
Should be:

while(first - 1 >= 0)
🔴 Bug 3: Same for last
while(last+1 < arr.length-1)

👉 Should be:

while(last + 1 < arr.length)
🔴 Bug 4: Not handling "not found"

If element not present → first = -1
👉 Your loops will break logic

🚀 4. Optimal Approach (INTERVIEW STANDARD)

👉 Use binary search twice
 */