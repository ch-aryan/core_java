package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.ArrayList;
// Java program to rearrange positive and negative numbers
// alternately using Two pointers
import java.util.*;

class GfG {
//gfg code.
    // Function to rearrange positive and negative numbers
    // in alternate fashion
    static void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0)
                pos.add(arr.get(i));
            else
                neg.add(arr.get(i));
        }

        int posIdx = 0, negIdx = 0;
        int i = 0;

        // Place positive and negative numbers alternately
        // in the original array
        while (posIdx < pos.size() && negIdx < neg.size()) {
            if (i % 2 == 0)
                arr.set(i++, pos.get(posIdx++));
            else
                arr.set(i++, neg.get(negIdx++));
        }

        // Append remaining positive numbers (if any)
        while (posIdx < pos.size())
            arr.set(i++, pos.get(posIdx++));

        // Append remaining negative numbers (if any)
        while (negIdx < neg.size())
            arr.set(i++, neg.get(negIdx++));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, -4, -1, 4));
        rearrange(arr);
        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
    }
}

public class RearrangeSigns {
    public static void AlgorithmLogical(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0) {
                pos.add(arr.get(i));
            } else {
                neg.add(arr.get(i));
            }
        }
        int min = Math.min(pos.size(), neg.size());

        for (int i = 0; i < min; i++) {
            int index = i * 2;
            arr.set(index, pos.get(i));
            arr.set(index+1, neg.get(i));
        }

        int index = min * 2;
        if (pos.size() > neg.size()) {
            for (int i = min; i < pos.size(); i++) {
                arr.set(index++, pos.get(i));

            }
        } else {
            for (int i = min; i < neg.size(); i++) {
                arr.set(index++, neg.get(i));
            }
        }
        printArr(arr);
    }



    public static void printArr(ArrayList<Integer> arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-1);
        arr.add(2);arr.add(-2);arr.add(3);arr.add(-3);arr.add(1);arr.add(1);arr.add(1);

        AlgorithmLogical(arr);
    }
}
/*
Given an array arr[] of size n, the task is to rearrange it in alternate positive and negative manner without changing the relative order of positive and negative numbers. In case of extra positive/negative numbers, they appear at the end of the array.

Note: The rearranged array should start with a positive number and 0 (zero) should be considered as a positive number.

Examples:

Input:  arr[] = [1, 2, 3, -4, -1, 4]
Output: arr[] = [1, -4, 2, -1, 3, 4]

Input:  arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
Output: arr[] = [5, -5, 2, -2, 4, -8, 7, 1, 8, 0]
Working of Code With Example :

1. Let us consider arr = [1, 2, 3, -4, -1, 4]

2. First we create two vectors to store positive and negative numbers of the given array

pos[] = [1, 2, 3, 4], neg[] = [-4, -1]

4. Now we traverse both pos[] and neg[] and fill elements back into arr[] at alternate indexs

i = 0, Since i is even, we pick from pos, arr = [1, _, _, _, _, _]
i = 1, Since i is odd, we pick from neg, arr = [1, -4, _, _, _, _]
i = 2, Since i is even, we pick from pos, arr = [1, -4, 2, _, _, _]
i = 3, Since i is odd, we pick from neg, arr = [1, -4, 2, -1, _, _]
5. One List Exhausted, neg[] in this case, so we put remaining pos[] elements

Remaining pos[] = [3, 4]
Final arr[] = [1, -4, 2, -1, 3, 4]
 */
/* ❌ 1. Biggest Issue: arr.set() arguments are reversed

You wrote:

arr.set(pos.get(i), evenOdd);
arr.set(neg.get(i), evenOdd+1);

👉 But ArrayList.set(index, value) expects:

arr.set(index, value)
🔴 What you did:
pos.get(i) → this is a value, NOT an index
evenOdd → this is an index, NOT the value

💥 So you're doing:

“Put index into value position and value into index position”

✅ Correct thinking:
arr.set(evenOdd, pos.get(i));     // index = evenOdd
arr.set(evenOdd + 1, neg.get(i));
❌ 2. Second Loop is Completely Wrong
for(int i=min; i<arr.size() ; i++)

Problems:

❌ Issue A:

arr.size() is original size → but you're using pos.get(i) / neg.get(i)

👉 i might go out of bounds for pos or neg

❌ Issue B:
arr.set(pos.get(i));

👉 set() needs 2 arguments, not 1
💥 This won’t even compile

❌ Issue C:

Logic is incorrect:

if(min != pos.size())

👉 This condition does NOT correctly tell which list has extra elements

🧠 3. Correct Logic for Remaining Elements

After alternating:

If pos has extra → fill remaining positions
If neg has extra → fill remaining positions
✅ 4. Fully Correct Code (Your Version Fixed)
class Solution {
    void rearrange(ArrayList<Integer> arr) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Step 1: Separate
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) >= 0){
                pos.add(arr.get(i));
            } else {
                neg.add(arr.get(i));
            }
        }

        int min = Math.min(pos.size(), neg.size());

        // Step 2: Alternate placement
        for(int i = 0; i < min; i++){
            int index = i * 2;
            arr.set(index, pos.get(i));
            arr.set(index + 1, neg.get(i));
        }

        // Step 3: Remaining elements
        int index = min * 2;

        if(pos.size() > neg.size()){
            for(int i = min; i < pos.size(); i++){
                arr.set(index++, pos.get(i));
            }
        } else {
            for(int i = min; i < neg.size(); i++){
                arr.set(index++, neg.get(i));
            }
        }
    }
}
🔥 5. Key Lessons (VERY IMPORTANT)
💡 1. Always remember:
arr.set(index, value)

NOT:

arr.set(value, index) ❌
💡 2. Index vs Value (Your main confusion)
Expression	Meaning
pos.get(i)	VALUE
i or i*2	INDEX
💡 3. ArrayList Rule
add() → grows size
set() → replaces existing element
🚀 6. Where You Are Right Now

Honestly:

✔ Your approach → correct
✔ Your understanding → 70% solid
❌ Index/value handling → needs fixing
💬 Real Talk

This exact mistake (index vs value) is VERY common — even experienced developers slip sometimes.

But once this clicks, your ArrayList handling will become sharp and confident.

If you want next step (🔥 important):

👉 I’ll teach you in-place rearrangement (no extra arrays)
👉 That’s a top interview twist

Just say: in-place version 👍

can you explain the remaining elements code.    int index = min * 2;

        if(pos.size() > neg.size()){
            for(int i = min; i < pos.size(); i++){
                arr.set(index++, pos.get(i));
            }
        } else {
            for(int i = min; i < neg.size(); i++){
                arr.set(index++, neg.get(i));
            }
        } i can't understand what was wrong with my version and what's happening with your version.

Great question, Aryan — this is exactly the part where most people get confused. Let’s slow it down and make it crystal clear.

🧠 First: What happened before this code?

After this loop:

for(int i = 0; i < min; i++){
    int index = i * 2;
    arr.set(index, pos.get(i));
    arr.set(index + 1, neg.get(i));
}

👉 You already filled:

index: 0   1   2   3   4   5 ...
value: +   -   +   -   +   -
🔍 Example
arr = [1, 2, 3, -1, -2]
pos = [1, 2, 3]
neg = [-1, -2]

min = 2

After alternating:

arr = [1, -1, 2, -2, ?]

👉 Index used = 0,1,2,3
👉 Next free index = 4

🔑 Why int index = min * 2;
int index = min * 2;

👉 Each i fills 2 positions
👉 So total filled = min * 2

In example:
min = 2
index = 2 * 2 = 4

✅ Correct next position

⚡ Now Remaining Elements Logic

We check:

if(pos.size() > neg.size())

👉 Which list still has elements left?

✅ Case 1: More positives
for(int i = min; i < pos.size(); i++){
    arr.set(index++, pos.get(i));
}
🔍 What does this mean?
Start from leftover part: i = min
Fill remaining positions one by one
index++ → move forward
Example:
pos = [1,2,3]
neg = [-1,-2]

Already used:
pos[0], pos[1]
neg[0], neg[1]

Remaining:
pos[2]

Execution:

arr[4] = pos[2] = 3

Final:

[1, -1, 2, -2, 3]
✅ Case 2: More negatives (same logic)
❌ Now YOUR VERSION — What went wrong?
❌ Problem 1: Wrong loop range
for(int i=min; i<arr.size() ; i++)

👉 arr.size() = original array size
👉 But pos or neg may be smaller

💥 Leads to:

IndexOutOfBoundsException
❌ Problem 2: You didn’t track correct index

You missed:

int index = min * 2;

👉 So you don’t know where to insert remaining elements

❌ Problem 3: Wrong set() usage
arr.set(pos.get(i)); // ❌ invalid

👉 Missing index
👉 Also confusing value vs index again

❌ Problem 4: Wrong condition
if(min != pos.size())

👉 This is unclear logic

Correct logic is:

if(pos.size() > neg.size())

👉 Direct and meaningful

🧠 Core Intuition Difference
🔴 Your Thinking:

“Loop over full array and try to adjust”

🟢 Correct Thinking:

“I already filled part of array → now continue from where I stopped”

🔥 Key Idea (MOST IMPORTANT)

👉 Think like this:

Phase 1 → alternate filling (0 to min*2 - 1)
Phase 2 → leftover filling (min*2 to end)
🎯 One Line Summary

index = min * 2 means
👉 “Start filling from where alternating stopped”

💬 Real Talk

You were very close, just missing:

tracking the correct index
understanding partial fill vs full traversal

Once this clicks, your array problems will become much easier. */