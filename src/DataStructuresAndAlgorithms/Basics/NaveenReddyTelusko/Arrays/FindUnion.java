package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

import java.util.ArrayList;

public class FindUnion {

        public static ArrayList<Integer> findUnion(int a[], int b[]) {
            // code here
            ArrayList<Integer> list = new ArrayList<>();
            int aa = 0, bb = 0;

            while (aa < a.length && bb < b.length) {
                int val;

                if (a[aa] < b[bb]) {
                    val = a[aa++];// first add and then increament add 1 and move to next elmt.
                } else if (a[aa] > b[bb]) {
                    val = b[bb++];
                } else {
                    val = a[aa];
                    aa++;
                    bb++;
                }

                if (list.size() == 0 || list.get(list.size() - 1) != val) {
                    list.add(val);
                }
            }

            // remaining elements
            while (aa < a.length) {
                if (list.size() == 0 || list.get(list.size() - 1) != a[aa]) {
                    list.add(a[aa]);
                }
                aa++;
            }

            while (bb < b.length) {
                if (list.size() == 0 || list.get(list.size() - 1) != b[bb]) {
                    list.add(b[bb]);
                }
                bb++;
            }

            return list;
        }
    }




/*If you want next:

        🔥 I’ll make you dry run yourself (very powerful learning)
🧠 Intersection problem (same pattern, different thinking)

Just tell me 👍
/* Short answer: You can use it, but you should NOT use it here ❌

❌ Why NOT use contains()

If you do:

if (!list.contains(x)) {
    list.add(x);
}

👉 Problem:

contains() = O(n)

👉 And you are inside a loop:

Total = O(n²) ❌
✅ What Should You Do Instead

Use logic + pointers to avoid duplicates.

👉 Trick:

Before adding element → check last inserted element
💡 Smart Check
If list is empty → add
OR
If last element != current → add

👉 This works because:

Arrays are already sorted 🔥
🧠 Why This Works

Since arrays are sorted:

Duplicates come next to each other

So you only need to check:

last added element

NOT entire list ❌

⚖️ Comparison
Approach	Time Complexity	Good?
contains()	O(n²) ❌	No
Last element check	O(n) ✅	Yes
🎯 Interview Answer

If asked:

“Can we use contains?”

You say:

“Yes, but it increases time complexity to O(n²), so I prefer checking the last inserted element since the arrays are sorted.”

🔥 That’s a strong answer.
❌ Where Your Logic Goes Wrong
🔴 1. You’re Adding Both Elements Together
else if(a[aa] > b[bb]){
    list.add(b[bb]);
    list.add(a[aa]); // ❌ wrong
}

👉 Union means:

Take elements in sorted order WITHOUT duplicates

👉 But you’re:

Adding BOTH elements at once ❌
🔴 2. Wrong Pointer Movement

You are doing:

aa++;
bb++;

👉 Always moving both pointers ❌

👉 But correct idea:

Move ONLY the pointer of the smaller element
🔴 3. Duplicate Handling Missing

Union requires:

NO duplicates in result

👉 Your code:

Does NOT check duplicates ❌
🔴 4. Missing Loop Condition
while() // ❌ empty

👉 Should depend on both arrays:

aa < a.length && bb < b.length
🧠 Correct Intuition (Very Important)

Think like merge step of merge sort

👉 Compare:

a[aa] vs b[bb]
💡 Rules
Case 1: Equal
Take once → move both pointers
Case 2: a[aa] < b[bb]
Take a[aa] → move aa
Case 3: a[aa] > b[bb]
Take b[bb] → move bb
⚠️ And VERY IMPORTANT

Before adding:

Check if already added → avoid duplicates
🧪 Example
a = [1,2,4]
b = [2,3,5]

Correct union:

[1,2,3,4,5]
❌ Your Output Would Be Something Like
[1,2,2,3,4,5,...] ❌ duplicates + wrong order
🎯 Core Mistake Summary

👉 Your thinking:

✔ Comparing elements (good)
❌ Adding both elements together
❌ Moving both pointers always
❌ No duplicate check
🚀 Correct Mental Model (Remember This)
Union = Merge + Skip duplicates
🔥 One-Line Rule
Take smaller element → move that pointer
If equal → take once → move both
👍 Final Verdict

👉 Your intuition:

✔ On right track (merge idea)
❌ Implementation logic flawed
Yes — you’re absolutely right ✅

✅ Brute Force Idea (Your Thinking)

👉 Do this:

Traverse first array → add elements to list (check duplicates using contains)
Traverse second array → again add elements (with contains check)
🧠 Why Time Complexity is O(n²)

Because of this line:

list.contains(x)

👉 contains() takes:

O(n)
🔁 Total Work

Let:

n = size of a
m = size of b
First loop:
n iterations × O(n) contains → O(n²)
Second loop:
m iterations × O(n) contains → O(n·m)
🔥 Final TC
O((n + m)²) ≈ O(n²)
⚖️ Summary
Approach	Time	Space	Notes
Brute (contains)	O(n²) ❌	O(n)	Simple but slow
Optimal (2 pointers)	O(n + m) ✅	O(n)	Best
🎯 Interview Line (Very Important)

You can say:

“Brute force uses contains which makes it O(n²). Since arrays are sorted, I can optimize using two pointers to achieve O(n + m).”

🔥 That’s a strong answer.
 */

