package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    //bruteforce
    public int longest(int [] arr){
        int longest =1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int x = arr[i];
          int  count = 1;
          while(ls(arr,x+1 ) == true){
              count ++;
              x = x+1;
              count++;

          }
          longest = Math.max(longest, count);

        }
        return  longest;
    }
    public boolean ls(int[] arr, int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]+1 == val){
                return true;
            }
        }
        return  false;
    }
    //better solution.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        int max = 1;
        int count = 1;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]) continue;

            if(arr[i]+1 == arr[i+1]){
                count ++;
                max = Math.max(count , max);

            }else{

                count = 0;

            }
        }
        return max;
    }
    //optimal solution using hashset
    public void OptimalHashSet(int [] arr){
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        int count =0;
        for(int i: arr){
            set.add(i);
        }

        for(int i : set){
            if(!set.contains(i-1)){
                 count = 1;
                int start = i;
                while(set.contains(start+1)){
                    start++;
                    count ++;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

}
/* Given an array of integers, the task is to find the length of the longest subsequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation:  The longest consecutive subsequence [2, 6, 1, 4, 5, 3].

Input: arr[] = [1,1,1,2,2,3]
Output: 3
Explanation: The subsequence [1, 2,3] is the longest subsequence of consecutive elements

 */
/* 👉 A HashSet is:

A collection that stores only unique values and gives O(1) lookup

Think of it like:

"Does this number exist?" → instant answer ⚡
💡 Real-world analogy

Imagine:

You have a list → you search one by one (slow)
You have a set (HashSet) → like a dictionary of keys → instant check
⚡ Why HashSet is powerful
🔥 1. Fast lookup (MOST IMPORTANT)
set.contains(x)  // O(1)

👉 This is why problems like Longest Consecutive Sequence become O(n)

🔥 2. No duplicates
set.add(1);
set.add(1);

👉 Only one 1 stored

🔥 3. Cleaner logic

Instead of:

Arrays.sort(arr)

👉 You can directly check:

if(set.contains(num - 1))
🧾 Most Important Methods (YOU MUST KNOW)
✅ 1. Add
set.add(10);
✅ 2. Contains (⭐ most used)
set.contains(10);

👉 Backbone of many problems

✅ 3. Remove
set.remove(10);
✅ 4. Size
set.size();
✅ 5. Loop
for(int num : set) {
    // use num
}
🔥 Example (Your Problem)
HashSet<Integer> set = new HashSet<>();

for(int num : arr) {
    set.add(num);
}

for(int num : set) {
    if(!set.contains(num - 1)) {
        // start of sequence
    }
}

👉 This is where HashSet shines 💯

⚔️ HashSet vs HashMap (IMPORTANT)
🧠 Basic Difference
Feature	HashSet	HashMap
Stores	Only values	Key → Value pair
Duplicate keys	❌ Not allowed	❌ Not allowed
Duplicate values	❌ Not allowed	✅ Allowed
Use case	Membership check	Mapping
💡 Internally

👉 HashSet is actually built on top of HashMap

HashSet = HashMap(key, dummy_value)
🤔 Why NOT use HashMap here?

You can use it:

HashMap<Integer, Boolean> map = new HashMap<>();

But:

👉 It’s unnecessary

Because:

You only care about existence
No value needed
🎯 Clean Thinking

Use:

HashSet → when you need existence
HashMap → when you need mapping
🧠 Interview-Level Insight

When you see:

“Check if element exists”
“Avoid duplicates”
“Find sequence / pair / pattern”

👉 Think:

"Can I use HashSet?"
🔥 When HashSet is MUST
Longest consecutive sequence
Two sum (optimized)
Detect duplicates
Subarray problems
Cycle detection (graphs)
🚀 One-line Summary

👉 HashSet = fastest way to answer: “Does this exist?”

💡 Final clarity for YOU

You said:

“I can answer map vs set only if I know importance”

✔ Now you can confidently say:

“HashSet is used when only presence matters. HashMap is used when we need key-value relationships.”

If you want next level mastery, I can:

Show real interview questions where HashSet is must
Or give you pattern recognition tricks (when to use set vs map instantly)

Just tell me 👍

can you explain me the problem with the hashset logic .

Absolutely Aryan — let’s break this down deeply but simply so you feel the logic, not just remember it 🔥

🧠 Problem Recap

Longest Consecutive Sequence

👉 Example:

[100, 4, 200, 1, 3, 2]

👉 Output:

4   // because 1,2,3,4
❌ Why normal thinking is slow

You might think:

“For every number, check next numbers…”

That becomes:

O(n²) ❌
✅ HashSet Idea (Core Insight)

We use HashSet for instant lookup

🔑 The KEY LOGIC (Most Important Line)
if (!set.contains(num - 1))

👉 This means:

“This number is the start of a sequence”

🧠 Why this works (DEEP UNDERSTANDING)

Let’s take:

[1, 2, 3, 4]

Now think:

Number	num-1 exists?	Start?
1	❌	✅ START
2	✅	❌
3	✅	❌
4	✅	❌

👉 Only 1 starts the sequence

🔥 This avoids duplicate work

Without this check:

You would do:

1 → check 2,3,4
2 → check 3,4 ❌ duplicate work
3 → check 4 ❌

👉 Waste of time

✅ With this check:

Only:

Start from 1 → go till 4

👉 Done in one go ⚡

🌳 Step-by-Step Flow
Step 1: Put all elements in set
HashSet<Integer> set = new HashSet<>();
for (int num : arr) {
    set.add(num);
}
Step 2: Traverse set
for (int num : set)
Step 3: Check if start
if (!set.contains(num - 1))

👉 Only start building sequence here

Step 4: Expand forward
int current = num;
int count = 1;

while (set.contains(current + 1)) {
    current++;
    count++;
}
Step 5: Update max
max = Math.max(max, count);
🔍 Full Code (for clarity)
class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
💡 Visual Intuition

Think of numbers like:

... 1 - 2 - 3 - 4 ...

👉 Only 1 is the “entry point”
👉 Others are just continuation

⚡ Complexity
Insert into set → O(n)
Loop → O(n)
While loop → overall still O(n)

👉 Final = O(n) 🔥

🧠 Final Mental Model

“I only start counting when I find the beginning of a sequence”

 */