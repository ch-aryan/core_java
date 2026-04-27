package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

import java.util.Arrays;

public class FloorAndCeil {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);

        int res[] = new int[2];
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        // Find Ceil (>= x)
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // RESET
        low = 0;
        high = arr.length - 1;

        // Find Floor (<= x)
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        res[0] = floor;
        res[1] = ceil;

        return res;
    }


/*
🧠 Idea
Lower Bound (LB) = first index where arr[i] >= x
👉 gives ceil directly
Upper Bound (UB) = first index where arr[i] > x
👉 (UB - 1) gives floor
⚡ Even better approach (advanced)

You can actually:

use lower bound → ceil
use upper bound - 1 → floor

👉 That avoids writing two loops.
 */
    class Solution {
        public int[] getFloorAndCeil(int x, int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;

            int lb = lowerBound(arr, x); // first >= x
            int ub = upperBound(arr, x); // first > x

            int ceil = (lb < n) ? arr[lb] : -1;
            int floor = (ub - 1 >= 0) ? arr[ub - 1] : -1;

            return new int[]{floor, ceil};
        }

        int lowerBound(int[] arr, int x) {
            int low = 0, high = arr.length - 1;
            int ans = arr.length;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] >= x) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }

        int upperBound(int[] arr, int x) {
            int low = 0, high = arr.length - 1;
            int ans = arr.length;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] > x) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }


public static void main(String[] args) {
  int  [] arr = {1, 3, 5, 7, 9};
   int  x = 6;
   // Floor = 5
    //Ceil = 7
}
}

/*
🧠 Floor & Ceil (Binary Search Notes)
📌 Definitions
✅ Floor

Greatest element ≤ x

👉 Largest value in array that is not greater than x

✅ Ceil

Smallest element ≥ x

👉 Smallest value in array that is not smaller than x

📊 Example
arr = [1, 3, 5, 7, 9]
x = 6
Floor = 5
Ceil = 7
⚡ Edge Cases (VERY IMPORTANT)
Condition	Floor	Ceil
x < smallest	-1	arr[0]
x > largest	arr[n-1]	-1
x present	x	x
🧠 Key Observations
Array must be sorted
Use Binary Search → O(log n)
Floor & Ceil are opposite directions
🧠 Concept Check (important)
Concept	Condition	Movement
Ceil	≥ x	move left
Floor	≤ x	move right
⚡ Even better approach (advanced)

You can actually:

use lower bound → ceil
use upper bound - 1 → floor

👉 That avoids writing two loops.

🎯 Final Verdict

👉 Your approach is correct ✅
👉 Your implementation had a small bug ❌ (not resetting)

This is a very common mistake, not a conceptual issue.

⚡ Even better approach (advanced)

You can actually:

use lower bound → ceil
use upper bound - 1 → floor

👉 That avoids writing two loops.
 */