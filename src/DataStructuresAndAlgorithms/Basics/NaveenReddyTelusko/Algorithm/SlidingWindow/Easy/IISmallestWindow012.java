package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;

import java.util.Arrays;

/*
Smallest window containing 0, 1 and 2
Last Updated : 20 Apr, 2026
Given a string s consisting of the characters 0, 1 and 2, find the length of the smallest substring
 of string s that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.
Examples:
Input: s = "01212"
Output: 3
Explanation: The substring 012 is the smallest substring that contains the characters 0, 1 and 2.
Input: s = "12121"
Output: -1
Explanation:  As the character 0 is not present in the string s, therefore no
substring containing all the three characters 0, 1 and 2 exists. Hence, the answer is -1 in this case.
 */
public class IISmallestWindow012 {
    public static void usingIndexes(String s){
        int n = s.length();
        int res = Integer.MAX_VALUE;
        boolean zero = false, one = false, two = false;
        int zeroI = 0, oneI = 0, twoI = 0;


        for(int i =0;i<n;i++){
           if(s.charAt(i) == '0'){
               zeroI = i;
               zero = true;
           }else  if(s.charAt(i) == '1'){
               oneI = i;
               one = true;
           }else if(s.charAt(i) == '2'){
               two = true;
               twoI = i;
           }

           if(one && two && zero){
               res = Math.min(res, Math.max(zeroI, Math.max(twoI, oneI)) -
                       Math.min(zeroI, Math.min(oneI, twoI)));
           }
        }
        if(res==Integer.MAX_VALUE) System.out.println("-1");

        else System.out.println(res+1);
    }
    public static void usingSlidingWindow(String s){
        int n = s.length();
        int i =0;
         int j = 0;
         int cnt = 0;
         int res =Integer.MAX_VALUE;
        int [] freq = new int[3];
        Arrays.fill(freq, 0);

        while(j<n){
            freq[s.charAt(j)-'0']++;
            if(freq[s.charAt(j)-'0'] ==1 ){
                cnt++;
            }

            if(cnt == 3){
                while(freq[s.charAt(i) -'0'] > 1){
                    freq[s.charAt(i)-'0']--;
                    i++;
                }
                res = Math.min(res, j-i+1);
                freq[s.charAt(i)-'0']--;
                cnt--;
                i++;
            }
            j++;
        }
        if(res == Integer.MAX_VALUE) System.out.println(-10);
        else System.out.println(res);
    }

    public static void main(String[] args) {
        String s = "01212";
        String s1 = "11221";
        usingIndexes(s);
        usingIndexes(s1);
        usingSlidingWindow(s);
        usingSlidingWindow(s1);
    }
}
/*
Using Index Tracking - O(n) Time and O(1) Space
The idea is to keep track of the last seen indices of '0', '1', and '2' while iterating
 through the string. Once all three characters are found, compute the
 substring length as the difference between the maximum and minimum of
 the three indices. Update the minimum length found and print the result.

 //very neat explaination of the slidingWindow algorithm.
 Absolutely, Aryan! This is one of the most important patterns in Data Structures and Algorithms: the Sliding Window Technique.

Once you understand this deeply, you'll solve hundreds of substring and subarray problems.

🎯 Problem Goal
Given:

s = "01212"
Find the smallest substring that contains:

'0'

'1'

'2'

🪟 What Is a Sliding Window?
A sliding window is simply a range:

[i .... j]
Where:

i = left boundary

j = right boundary

This window "slides" through the string.

🧠 Main Strategy
Expand the window by moving j.

When the window becomes valid (contains 0, 1, and 2):

Try to shrink it from the left (i) to make it as small as possible.

Update the minimum length.

📌 Variables Used
i = 0;   // left pointer
j = 0;   // right pointer
freq[3]; // frequency of 0,1,2
cnt = 0; // number of distinct digits currently present
min_len = Integer.MAX_VALUE;
📦 Meaning of freq
freq[0] = count of '0'
freq[1] = count of '1'
freq[2] = count of '2'
Example:

Window = "0112"
freq = [1, 2, 1]
🔢 Meaning of cnt
cnt tells us how many unique digits among 0, 1, and 2 are present.

Examples:

freq = [1, 0, 0] → cnt = 1
freq = [1, 2, 0] → cnt = 2
freq = [1, 2, 1] → cnt = 3  ✅ valid window
🚀 Step-by-Step Dry Run
String
s = "01212"
Indices:

0 1 2 3 4
0 1 2 1 2
Step 1: j = 0
Add '0'

Window = "0"
freq = [1,0,0]
cnt = 1
Not valid yet.

Step 2: j = 1
Add '1'

Window = "01"
freq = [1,1,0]
cnt = 2
Not valid.

Step 3: j = 2
Add '2'

Window = "012"
freq = [1,1,1]
cnt = 3
Now the window contains all three digits. ✅

✂️ Shrink the Window
We try to remove extra characters from the left.

while (freq[s.charAt(i) - '0'] > 1)
Meaning:

"If the leftmost character appears more than once, remove it."

In "012":

'0' appears only once.

Cannot remove it.

📏 Update Answer
min_len = Math.min(min_len, j - i + 1);
length
=
𝑗
−
𝑖
+
1
length=j−i+1

Here:

i = 0

j = 2

So:

2 - 0 + 1 = 3
Minimum length becomes 3.

🔄 Force Window to Move Forward
After recording the answer:

freq[s.charAt(i) - '0']--;
i++;
cnt--;
We remove the leftmost required character.

Remove '0'
freq = [0,1,1]
i = 1
cnt = 2
Window is no longer valid.

Step 4: j = 3
Add '1'

Window = "121"
freq = [0,2,1]
cnt = 2
Still missing '0'.

Step 5: j = 4
Add '2'

Window = "1212"
freq = [0,2,2]
cnt = 2
Still missing '0'.

🏁 Final Answer
min_len = 3
🔥 Why the Inner while Loop Is Important
Suppose window is:

"0012"
Frequencies:

freq = [2,1,1]
This is valid, but contains an extra '0'.

The loop removes unnecessary characters:

"0012" -> "012"
This ensures we always keep the smallest valid window ending at j.

🎯 Why We Remove One More Character After Updating
Once we've found the smallest valid window for the current j, we remove one essential character to make the window invalid again.

That forces us to continue expanding j and search for a potentially better window later.

🧠 Visual Summary
Expand j  ---> until window becomes valid
Shrink i  ---> remove duplicates
Record answer
Remove one required character
Continue
📌 General Sliding Window Pattern
while (j < n) {
    add s[j];

    while (window can be shrunk) {
        remove unnecessary characters;
    }

    if (window is valid) {
        update answer;
        remove one required character;
    }

    j++;
}
🌟 Real-Life Analogy
Imagine collecting three Pokémon:

Pikachu (0)

Charizard (1)

Bulbasaur (2)

You walk forward (j) collecting Pokémon.

As soon as you have all three, you discard unnecessary duplicates from your backpack (i) until only the smallest possible collection remains.

🏆 Key Takeaways
j expands the window.

i shrinks the window.

freq[] tracks counts.

cnt == 3 means the window is valid.

j - i + 1 gives the current window length.

Remove duplicates to keep the window minimal.

💎 Golden Rule
Expand until valid. Shrink until minimal. Record the answer. Repeat.

This exact technique is used in many classic problems like:

Minimum Window Substring

Longest Substring Without Repeating Characters

Permutation in String

Fruit Into Baskets

Master this pattern and you'll recognize it everywhere.

//doubts i got.
is this not a infinite loop.  if (cnt == 3) {
                while (freq[s.charAt(i) - '0'] > 1) {
                    freq[s.charAt(i) - '0']--;
                    i++;
                } because we are increasing i and checking in the while.

                Excellent question, Aryan! This is exactly the kind of doubt strong problem solvers ask.

No, this is not an infinite loop.

while (freq[s.charAt(i) - '0'] > 1) {
    freq[s.charAt(i) - '0']--;
    i++;
}

Let’s understand why.

🎯 What This Loop Does

This loop removes extra duplicate characters from the left side of the window.

It keeps shrinking the window until the leftmost character appears only once.

✅ Why It Must Eventually Stop

Each iteration does two things:

Decreases a frequency:

freq[...]--;

Moves the left pointer forward:

i++;

So:

Frequencies are getting smaller.
i is moving right.
The condition freq[...] > 1 will eventually become false.

Therefore, the loop must terminate.

🔍 Example Walkthrough

Suppose the current window is:

"0012"

Indices:

0 1 2 3
0 0 1 2
^
i = 0

Frequencies:

freq = [2, 1, 1]
First Iteration

Condition:

freq['0'] > 1   // 2 > 1 => true

Execute:

freq['0']--;   // 2 -> 1
i++;           // 0 -> 1

Now:

freq = [1,1,1]
i = 1
Check Again

Condition:

freq[s.charAt(i) - '0'] > 1

Now s.charAt(1) = '0'

freq['0'] = 1
1 > 1 => false
Loop stops.
🏁 Final Window
"012"
The duplicate '0' was removed successfully.
🧠 Important Insight
Even though i changes, the frequency of the current leftmost character is reduced each time.
Eventually, the current character's count becomes 1, and the condition fails.
📌 Another Example
Window:
"000112"
Frequencies:
freq = [3,2,1]
Iteration 1
freq['0'] = 3 > 1
Decrease to 2
i++
Iteration 2
freq['0'] = 2 > 1
Decrease to 1
i++
Iteration 3
freq['0'] = 1
Condition becomes false

Loop stops.

🔥 Can i Move Forever?

No.

Each character can be removed only once.

Since the string has n characters, i can move at most n times total.

That is why the whole algorithm is still O(n).

📈 Why Total Time Is O(n)
j moves from 0 to n - 1 once.
i also moves from 0 to n - 1 at most once.

So total operations are bounded by:

2n

Which is:

O(n)
🏃 Real-Life Analogy

Imagine you are walking through a hallway.

j walks forward collecting items.
i walks forward discarding unnecessary duplicates.

Neither pointer ever moves backward.

Since both only move forward, they must eventually reach the end.

🏆 Final Answer

This is not an infinite loop because:

i increases on every iteration.
The relevant frequency decreases.
The condition freq[...] > 1 eventually becomes false.
i can move at most n times.

 */

/*
some test cASES
✅ Goal

Find the smallest substring that contains:

'0'
'1'
'2'

At least one occurrence of each.

🟢 Test Case 1: Basic Example
s = "10212"
Possible substrings containing all three:
"102" → length 3 ✅
"1021" → length 4
"10212" → length 5
"021" → length 3 ✅
"012" → length 3 ✅
Answer:
3
🟢 Test Case 2: Exact Match
s = "012"

The whole string already contains all three.

Answer:
3
🟢 Test Case 3: Repeated Characters
s = "000111222"

To get all three, you need:

one 0
one 1
one 2

Shortest valid substring:

"01112"

Length = 5

Answer:
5
🟢 Test Case 4: Many Small Windows
s = "120201"

Valid substrings:

"120" → 3 ✅
"201" → 3 ✅
"0201" → 4
Answer:
3
🟢 Test Case 5: Missing One Character
s = "111222"

There is no '0'.

Answer:
-1
🟢 Test Case 6: Single Character String
s = "0"

Cannot contain all three.

Answer:
-1
🟢 Test Case 7: Two Characters Only
s = "01"

Missing '2'.

Answer:
-1
🟢 Test Case 8: All Characters Repeated
s = "012012"

Several valid substrings:

"012" → 3
"120" → 3
"201" → 3
Answer:
3
🟢 Test Case 9: Valid Window at the End
s = "1111102"

Shortest valid substring:

"102" → length 3
Answer:
3
🟢 Test Case 10: Valid Window at the Beginning
s = "0121111"

Shortest valid substring:

"012" → length 3
Answer:
3
🟢 Test Case 11: Large Gap Between Characters
s = "00000000122222220"

Contains 0 and 2, but no 1.

Answer:
-1
🟢 Test Case 12: Minimal Window in the Middle
s = "111012111"

Shortest valid substring:

"012" → length 3
Answer:
3
🟢 Test Case 13: Overlapping Valid Windows
s = "2012012"

Valid substrings:

"201" → 3
"012" → 3
"120" → 3
Answer:
3
🟢 Test Case 14: Longer Than 3
s = "00112"

Possible valid substring:

"00112" → length 5
"0112" → length 4 ✅
Answer:
4
 */