package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

import java.util.Arrays;

public class MissingNumberinRange {
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // case: missing 0
        if (nums[0] != 0) return 0; //another method can be n(n+1) / 2.

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }

        // missing last number
        return nums.length;
    }

        public static int missingNumber(int[] nums) {
            int miss =0;
            int count =0;// my own logic bruteforce
            Arrays.sort(nums);

            for(int i=0;i<nums.length-1;i++){
                if(nums[i] + 1 != nums[i+1]){
                    miss = nums[i] +1;
                    count ++;
                }
            }
            if(count == 1){
                return miss;
            }
            return nums.length;
        }
        public static int hashingConcept(int[]arr){
            int n = arr.length +1; // size is n-1 and arr is 1,2,3,5 missing is 5.
            int hash[] = new int[n+1];


            for(int i=0;i<arr.length;i++){
                hash[arr[i]]++;
            }

            for(int i=1;i<=n;i++){
                if(hash[i] == 0){
                    return i;
                }
            }
            return -1;
        }

/* 🧪 Dry Run
arr = [1,2,3,5]
n = 5
Step 1: hash array
index: 0 1 2 3 4 5
value: 0 1 1 1 0 1

👉 hash[4] = 0 → missing

🎯 Key Understanding

👉 You are using:

index = number
value = frequency
🧠 Important Rule
If numbers start from 1 → ignore index 0
If numbers start from 0 → use index 0
⚖️ Complexity
Time: O(n)
Space: O(n) ❌
🚀 Comparison
Method	Time	Space
Hashing	O(n)	O(n)
Sum formula	O(n)	O(1)
XOR	O(n)	O(1) 🔥
💬 Final Answer to Your Question

“Should 1 be stored at index 0?”

👉 ❌ No
👉 ✔ Store:

hash[1], hash[2], ..., hash[n]

👉 hash[0] → ignore

🔥 Final One-Line Insight
Hash index = actual number

If you want next:*/
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,0};
        System.out.println( missingNumber(arr));
    }
    }
/* brute force 🧠 Brute Force Idea (Flag Method)

👉 Think like this:

Check every number from 0 → n
See if it exists in the array
If not → that’s the missing number
🔍 How It Works
Outer loop:
for num = 0 → n
Inner loop:
Check if num exists in nums[]
🧪 Example
nums = [3,0,1]
n = 3
🔁 Step-by-step
Check 0:
Found in array ✅
Check 1:
Found in array ✅
Check 2:
Not found ❌

👉 Answer = 2

💡 Using Flag

For each number:

flag = false

If found:

flag = true

If still false after loop:

return that number
✅ Code (Brute Force)
public int missingNumber(int[] nums) {
    int n = nums.length;

    for (int i = 0; i <= n; i++) {
        boolean found = false;

        for (int j = 0; j < n; j++) {
            if (nums[j] == i) {
                found = true;
                break;
            }
        }

        if (!found) {
            return i;
        }
    }

    return -1; // won't reach here
}
⚖️ Complexity
Time: O(n²) ❌
Space: O(1)
🧠 Compare All Approaches
Approach	Time	Space	Level
Flag (brute)	O(n²) ❌	O(1)	Basic
Sorting	O(n log n)	O(1)	Better
Sum formula	O(n)	O(1)	Optimal
XOR	O(n)	O(1)	Optimal 🔥
🎯 Final Understanding

👉 Yes, your statement:

“loop from 0 to n and check inside array”

✔ 100% correct brute force

💬 Important Insight

This method is useful when:

You don’t know math/XOR tricks yet

👉 It builds foundation
/* 🧠 Step 1: Prerequisite — What is XOR?

XOR (^) is a bitwise operator.

🔑 Important Properties (These are EVERYTHING)
a ^ a = 0
a ^ 0 = a
💡 Examples
5 ^ 5 = 0
7 ^ 0 = 7
🔥 Most Important Property
XOR is commutative and associative

👉 Means:

a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
🎯 Step 2: Understand the Problem

You are given:

Array of size n containing numbers from 0 to n
One number is missing
🧪 Example
nums = [3,0,1]

👉 Range should be:

0,1,2,3

👉 Missing:

2
💡 Step 3: Core Idea of XOR Method

👉 XOR all numbers from:

0 → n

👉 XOR all elements in array

👉 Then XOR both results

🧠 Why This Works?

Because:

Same numbers cancel each other

Only missing number remains 🔥

🧪 Step-by-Step Dry Run
Example:
nums = [3,0,1]
n = 3
Step 1: XOR of 0 → n
xor1 = 0 ^ 1 ^ 2 ^ 3
Step 2: XOR of array
xor2 = 3 ^ 0 ^ 1
Step 3: Final XOR
result = xor1 ^ xor2
🔍 Expand:
(0 ^ 1 ^ 2 ^ 3) ^ (3 ^ 0 ^ 1)

Rearrange:

0 ^ 0 ^ 1 ^ 1 ^ 3 ^ 3 ^ 2

Cancel:

0 ^ 0 = 0
1 ^ 1 = 0
3 ^ 3 = 0

Remaining:

2 ✅
🔥 Final Answer = 2
🧠 Intuition in One Line
All matching numbers cancel → missing number remains
✅ Code (XOR Method)
public int missingNumber(int[] nums) {
    int xor = 0;
    int n = nums.length;

    // XOR all numbers from 0 to n
    for (int i = 0; i <= n; i++) {
        xor ^= i;
    }

    // XOR all elements in array
    for (int num : nums) {
        xor ^= num;
    }

    return xor;
}
⚡ Even Cleaner Version
public int missingNumber(int[] nums) {
    int xor = nums.length;

    for (int i = 0; i < nums.length; i++) {
        xor ^= i ^ nums[i];
    }

    return xor;
}
⚖️ Complexity
Time: O(n)
Space: O(1)
🧠 When to Use XOR Trick?

Use XOR when:

✔ One element missing
✔ OR one element repeating
✔ OR pairs cancel out
💬 Simple Analogy

Think:

Every number has a “pair”
XOR removes pairs
Only unpaired (missing) remains
🚀 Final Understanding

👉 Formula method:

Uses math

👉 XOR method:

Uses bit logic + cancellation

👉 XOR is safer (no overflow)

🎯 Final Summary
XOR everything → duplicates cancel → missing remains */