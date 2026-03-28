package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;
/* Given a sorted array arr[] of n positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Examples :

Input: n = 5, arr[] = {1, 1, 2, 5, 5}
Output: 2
Explanation: Since 2 occurs once, while other numbers occur twice, 2 is the answer.
Input: n = 7, arr[] = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.*/

public class XORTricks {
    public static int search(int n, int arr[]) {
        int i = 0;
//        { int xor = 0;
//        for (int num : arr) {
//            xor ^= num;
//        }
//        return xor }; another way of handling the question. using xor.
//
//Instead of two pointers, use:
//
//Check pairs: arr[i] == arr[i+1]
//If not → arr[i] is answer
        while (i < n - 1) {
            if (arr[i] == arr[i + 1]) {
                i += 2;
            } else {
                return arr[i];
            }
        }

        return arr[n - 1]; // last element case
    }

}
//importnat
/* ❌ 1. Operator Precedence Bug (Very Important)
if(arr[i]  ^ arr[j] == 0)

👉 This is parsed as:

arr[i] ^ (arr[j] == 0)  // ❌ WRONG

Because:

== has higher precedence than ^
✅ Fix
if ( (arr[i] ^ arr[j]) == 0 )
/*Great question, Aryan — this is exactly where most people get confused 👍
Let’s slowly dry run + fix your doubt about 3 ^ 4.

🧠 First: What XOR is doing here

👉 XOR is not comparing numbers
👉 It works on bits (binary)

🔑 Key Property (Most Important)
a ^ a = 0
a ^ 0 = a

👉 So:

Pairs cancel out → only single element remains
🧪 Dry Run Example
arr = [1,1,2,2,3]
Step-by-step

Start:

xor = 0
Step 1:
xor = 0 ^ 1 = 1
Step 2:
xor = 1 ^ 1 = 0   (cancel)
Step 3:
xor = 0 ^ 2 = 2
Step 4:
xor = 2 ^ 2 = 0   (cancel)
Step 5:
xor = 0 ^ 3 = 3
✅ Final Answer
3
❓ Your Doubt: “What if 3 ^ 4 happens?”

Let’s see 👇

🔍 Binary Form
3 = 011
4 = 100
XOR
  011
^ 100
-----
  111 = 7

👉 So:

3 ^ 4 = 7
⚠️ Important Understanding

👉 YES, intermediate values can be weird:

xor = 3 ^ 4 = 7

👉 But later:

7 ^ 4 = 3  (4 cancels)
🔥 Full Example with Confusion Case
arr = [3,4,3]
Step-by-step:
xor = 0

xor = 0 ^ 3 = 3
xor = 3 ^ 4 = 7   (weird value)
xor = 7 ^ 3 = 4   (3 cancels)
✅ Final Answer
4
🧠 Key Insight (VERY IMPORTANT)
Intermediate XOR values don’t matter ❗
Only final result matters
💡 Why This Works

Because:

a ^ b ^ a = b

👉 Order doesn’t matter

🎯 One-Line Understanding
All duplicates cancel → only unique element remains
🚀 Final Answer to Your Question

“What if 3 ^ 4 comes?”

👉 It may produce a different number (like 7)
👉 But later XOR cancels duplicates and correct answer remains
For this type of problem (missing number / single missing in range), the progression is:

Brute → Linear Search
Better → Hashing
Optimal → XOR / Sum

Let’s write clean notes + code for brute and better 👇

🥉 1. Brute Force (Linear Search)
🧠 Idea
For every number from 1 → n,
check if it exists in array
If not → that is missing
✅ Code
class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;

        for (int i = 1; i <= n; i++) {
            boolean found = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }
        }

        return -1;
    }
}
⏱️ Complexity
Time: O(n²) ❌
Space: O(1)
🥈 2. Better (Hashing)
🧠 Idea
Store frequency of elements using array
Then find which number is missing
💡 Key Point
Index = number
Value = frequency
✅ Code
class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;

        int hash[] = new int[n + 1];

        // mark presence
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        // find missing
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
⏱️ Complexity
Time: O(n) ✅
Space: O(n) ❌
⚖️ Comparison
Approach	Time	Space	Idea
Brute	O(n²)	O(1)	Linear search
Better	O(n)	O(n)	Hashing
Optimal	O(n)	O(1)	XOR / Math
🎯 Final Understanding

👉 Yes, your thinking is correct:

✔ Linear search → brute
✔ Hashing → better
✔ XOR → optimal
 */