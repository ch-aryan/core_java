package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10.Hard;

import java.util.ArrayList;
//important question KMP.
/*
Search for Subarray
        Difficulty: HardAccuracy: 48.7%Submissions: 6K+Points: 8
        You are given two integer arrays a[] and b[]. Return all the starting indexes of all the occurences of b[] as a subarray in a[].

        Examples:

        Input: a[] = [2, 4, 1, 0, 4, 1, 1], b[] = [4, 1]
        Output: [1, 4]
        Explanation: b[] occurs as a subarray in a[] from index 1 to 2 and from index 4 to 5.
        Input: a[] = [2, 4, 1, 0, 0, 3], b[] = [0]
        Output: [3, 4]
        Explanation: b[] occurs as a subarray in a[] from index 3 to 3 and from index 4 to 4.
        Input: a[] = [1, 3, 5, 3, 0], b[] = [1, 3, 0]
        Output: []
        Explanation: There is no subarray occurs as b[] in a[] */

public class FindSubArraysIndex {
    public static ArrayList<Integer> bruteForce(int[] a , int[] b){
        ArrayList<Integer> res = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int last = n-m;
        for(int i =0;i<=last;i++){
            boolean match = true;
            int j =0;
            while(j < m){
                if(a[i+j] == b[j]){
                    j++;
                }else{
                    match = false;
                    break;
                }
            }
            if(match){
                res.add(i);
            }
        }
        return res;
    }
    public static int[] lpsArray(int [] pat){
        int i = 1;
        int len = 0;
        int lps[] = new int[pat.length];
        while(i< pat.length){
            if(pat[len] == pat[i]){
                len++;
                lps[i] = len;
                i++;

            }else {
                if(len > 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return  lps;
    }
    public static ArrayList<Integer> KMP(int [] txt, int [] pat){
        int n = txt.length;
        int m = pat.length;
        ArrayList<Integer> res = new ArrayList<>();
        int [] lps = lpsArray(pat);
        int i = 0;
        int j = 0;
        while(i < n){
            if(txt[i] == pat[j]){
                i++;
                j++;
            }
            if(j==m){
                res.add(i-j);
                j = lps[j-1];
            }
            else if(i < n && txt[i] != pat[j]){
                if(j>0)
                j = lps[j-1];
                else
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 1, 0, 4, 1, 1} ,b[] = {4, 1};
        bruteForce(a, b).forEach(i-> System.out.print(i+" "));
        System.out.println("****************");
        KMP(a,b).forEach(integer -> System.out.print(integer+" "));
        System.out.println();

        int a1[] = {2, 4, 1, 0, 0, 3} , b1[] = {0};
        bruteForce(a1,b1).forEach(i-> System.out.print(i+" "));
        System.out.println("***********");
        KMP(a1,b1).forEach(i-> System.out.print(i+" "));
    }

}
/*
Great question.

Your current solution is:

O(nm)

where:

n = a.length
m = b.length

This means:

For every starting index in a
You may compare all elements of b
1. Can This Be Optimized?

Yes.

The optimal approach uses the String Matching technique known as the Knuth–Morris–Pratt algorithm (KMP).

KMP reduces the time complexity to:

O(n+m)

2. Why KMP Works

When a mismatch occurs, brute force starts over from the next index.

KMP uses information from the pattern (b) to avoid rechecking elements that are already known to match.

So instead of “going back,” it intelligently jumps.

3. Simple Example
a = [1, 2, 1, 2, 1, 3]
b = [1, 2, 1, 3]

Suppose you matched:

1, 2, 1

and then got a mismatch.

Brute force starts almost from scratch.

KMP knows that the prefix [1] is also a suffix of the matched part, so it can continue from there.

4. Key Idea: LPS Array

KMP builds an array called:

LPS = Longest Proper Prefix which is also Suffix

For each position in b, LPS tells how many elements are still useful after a mismatch.

Example Pattern
b = [1, 2, 1, 2, 1, 3]

LPS:

[0, 0, 1, 2, 3, 0]

This means:

At index 4, if mismatch happens after matching up to there,
You can continue as if 3 elements are already matched.
5. Time Complexity Comparison
Approach	Time Complexity
Brute Force	O(nm)
KMP	O(n + m)
6. When Does Optimization Matter?

If:

n = 100,000
m = 10,000

Brute force can become very slow.

KMP remains efficient.

7. Intuition

Think of searching a word in a sentence.

Brute force:

Starts over repeatedly.

KMP:

Remembers what has already matched and reuses that knowledge.
8. Is Sliding Window Better?

No.

Sliding window does not reduce the complexity here because you still need to compare elements.

The true optimization is a pattern-matching algorithm like KMP.

9. Should You Learn KMP Now?

My recommendation:

Master the brute-force approach first.
Understand why it works.
Then learn KMP as an advanced optimization.

Since you solved the brute-force solution yourself, you are in an excellent position to learn KMP next.

10. High-Level KMP Steps
Build the LPS array for b.
Use two pointers:
i for a
j for b
On match: increment both.
On mismatch:
if j > 0, set j = lps[j - 1]
otherwise increment i
When j == m, record the match and continue.
11. Best Learning Path
✅ Understand brute force deeply.
✅ Learn prefix and suffix concepts.
✅ Build the LPS array.
✅ Implement KMP.
✅ Practice on string and array matching problems.

1. The Core Problem

We want to find:

pattern = b[]

inside

text = a[]

Example:

a = [1, 2, 1, 2, 1, 3]
b = [1, 2, 1, 3]
2. Brute Force Mindset

When a mismatch happens, brute force throws away all previous work and starts again.

That is wasteful.

3. KMP Mindset

When a mismatch happens, ask:

"How much of what I already matched is still useful?"

This is the single most important KMP idea.

4. Real-Life Analogy

Suppose you typed:

ABABC

Then the next character mismatches.

Notice that the prefix:

AB

also appears at the end (suffix) of what you've matched.

So you do not need to restart from zero—you already know AB still matches.

5. Prefix and Suffix

For:

ABABC

Prefixes:

A
AB
ABA
ABAB

Suffixes:

C
BC
ABC
BABC

The longest prefix that is also a suffix is:

AB

Length = 2.

6. LPS Array

LPS = Longest Proper Prefix which is also Suffix.

For every index, it stores the length of the reusable matched part.

Example
Pattern = A B A B C
Index     0 1 2 3 4
LPS       0 0 1 2 0
7. Meaning of LPS

At index 3 (ABAB), LPS = 2.

That means:

Prefix AB
Suffix AB

So if mismatch occurs after matching ABAB, we can continue as if AB is already matched.

8. One Sentence to Remember Forever

LPS tells you how many characters/elements can be reused after a mismatch.

This sentence captures the heart of KMP.

9. Search Phase

Use two pointers:

i → text (a)
j → pattern (b)
If Match
a[i] == b[j]

Move both forward.

If Mismatch and j > 0

Do not move i.

Set:

j = lps[j - 1]
If Mismatch and j == 0

No reusable part exists.

Move i.

10. Why i Does Not Move

The current text element might still match a smaller reusable prefix of the pattern, so we keep i in place and only adjust j.

11. Example Walkthrough
Text    = A B A B A B C
Pattern = A B A B C
LPS     = 0 0 1 2 0

Match:

A B A B

Now compare:

Text:    A
Pattern: C

Mismatch.

Current j = 4.

Set:

j = lps[3] = 2

We keep i at the same position.

Now compare again with pattern index 2.

No already-checked text elements are reprocessed unnecessarily.

12. Full KMP Rulebook

Memorize these four rules:

Match → i++, j++
Full pattern matched (j == m) → record answer, j = lps[j - 1]
Mismatch and j > 0 → j = lps[j - 1]
Mismatch and j == 0 → i++

If you remember only this, you can implement KMP anytime.

13. Visual Formula

j=lps[j−1]

This is the key transition.

14. Why KMP Is Fast

Each pointer only moves forward overall.

Time complexity:

O(n+m)

15. Mental Model

Brute force says:

"Mismatch? Start over."

KMP says:

"Mismatch? Reuse the largest prefix that is still valid."

16. When to Use KMP

Use KMP when you need to:

Search a pattern in text
Find all occurrences
Match one array inside another
Avoid repeated comparisons
17. The Most Important Takeaway

When some part is matched and a mismatch occurs:

Do not discard everything. Keep the longest prefix that is also a suffix.

That reusable amount is exactly what LPS stores.

18. Memory Cheat Sheet
LPS = reusable matched length

Match:
    i++, j++

Mismatch:
    if j > 0:
        j = lps[j - 1]
    else:
        i++

Full match:
    save answer
    j = lps[j - 1]
19. Coding Wisdom to Remember

Many advanced algorithms share this same principle:

Preserve useful work instead of recomputing from scratch.

KMP is one of the clearest examples of this powerful idea.

20. Final Summary

KMP is simply:

Precompute reusable prefix information (LPS).
On mismatch, jump using that information.
Continue without restarting.

If you deeply remember one line, remember this:

LPS tells how much of the matched pattern can still be reused after a mismatch.

//dry run
Given Data
Text    = A B A B A B C
Index   = 0 1 2 3 4 5 6

Pattern = A B A B C
Index   = 0 1 2 3 4

LPS     = 0 0 1 2 0

Meaning of the LPS values:

lps[0] = 0
lps[1] = 0
lps[2] = 1
lps[3] = 2
lps[4] = 0
Two Pointers
i → index in Text
j → index in Pattern

Initially:

i = 0
j = 0
Step 1

Compare:

Text[i]    = A
Pattern[j] = A

Match.

Move both pointers.

i = 1
j = 1
Step 2

Compare:

Text[i]    = B
Pattern[j] = B

Match.

i = 2
j = 2
Step 3

Compare:

Text[i]    = A
Pattern[j] = A

Match.

i = 3
j = 3
Step 4

Compare:

Text[i]    = B
Pattern[j] = B

Match.

i = 4
j = 4
Step 5 (Mismatch Happens)

Compare:

Text[i]    = A
Pattern[j] = C

Mismatch.

Current state:

i = 4
j = 4
KMP Trick

Since j > 0, do:

j=lps[j−1]=lps[3]=2

So:

i = 4   (unchanged)
j = 2

This is the heart of KMP.

Why j = 2?

Before the mismatch, we matched:

A B A B

The longest prefix that is also a suffix is:

A B

Length = 2.

So we keep those two characters as already matched.

Step 6

Now compare again with the same text character.

Text[i]    = A   (still index 4)
Pattern[j] = A   (index 2)

Match.

i = 5
j = 3
Step 7

Compare:

Text[i]    = B
Pattern[j] = B

Match.

i = 6
j = 4
Step 8

Compare:

Text[i]    = C
Pattern[j] = C

Match.

i = 7
j = 5
Full Match Found

Since:

j == pattern.length == 5

The pattern is found.

Starting index:

i−j=7−5=2

So the pattern starts at index 2.

Verify

Text from index 2:

A B A B C

Exactly matches the pattern.

Complete Trace Table
Step  i  j  Text[i] Pattern[j]  Action
----  -  -  ------- ----------  -----------------------
1     0  0    A        A        match -> i=1, j=1
2     1  1    B        B        match -> i=2, j=2
3     2  2    A        A        match -> i=3, j=3
4     3  3    B        B        match -> i=4, j=4
5     4  4    A        C        mismatch
                           j = lps[3] = 2
6     4  2    A        A        match -> i=5, j=3
7     5  3    B        B        match -> i=6, j=4
8     6  4    C        C        match -> i=7, j=5
Match found at index 2
The Big Insight

At the mismatch:

A B A B
        ^

KMP realizes:

Prefix AB
Suffix AB

So there is no need to restart.

It reuses those two characters and continues.

Brute Force vs KMP
Brute Force

Would go back and recheck several characters.

KMP

Immediately jumps to:

j = 2

and continues.

One Sentence to Remember Forever

On mismatch, keep the longest prefix that is also a suffix and continue from there.

That reusable amount is stored in the LPS array.

This single idea is the essence of KMP.

Excellent. Your sir is teaching the search phase of KMP, which is the most important part.

The search phase uses:

i → index in text
j → index in pattern
On mismatch: j = lps[j - 1]

That is the same logic we discussed. Your sir’s explanation with j = 0 and comparing the current text character with the pattern character is exactly how KMP is typically taught.

Complete KMP Code for Integer Arrays
class Solution {

    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = a.length;
        int m = b.length;

        // Build LPS for pattern b
        int[] lps = buildLPS(b);

        // i -> text index, j -> pattern index
        int i = 0;
        int j = 0;

        while (i < n) {

            // Case 1: Match
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            // Case 2: Full pattern matched
            if (j == m) {
                res.add(i - j);   // starting index
                j = lps[j - 1];   // continue searching
            }

            // Case 3: Mismatch
            else if (i < n && a[i] != b[j]) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return res;
    }

    private int[] buildLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];

        int i = 1;
        int j = 0;

        while (i < m) {
            if (pattern[i] == pattern[j]) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
Dry Run
Input
Text    = A B A B A B C
Index   = 0 1 2 3 4 5 6

Pattern = A B A B C
Index   = 0 1 2 3 4

LPS     = 0 0 1 2 0
Initial State
i = 0
j = 0
Step 1

Compare:

Text[0] = A
Pattern[0] = A

Match → i = 1, j = 1

Step 2
Text[1] = B
Pattern[1] = B

Match → i = 2, j = 2

Step 3
Text[2] = A
Pattern[2] = A

Match → i = 3, j = 3

Step 4
Text[3] = B
Pattern[3] = B

Match → i = 4, j = 4

Step 5 (Mismatch)
Text[4] = A
Pattern[4] = C

Mismatch and j > 0.

Set:

j = lps[3] = 2

Important:

i stays 4
Step 6

Compare again:

Text[4] = A
Pattern[2] = A

Match → i = 5, j = 3

Step 7
Text[5] = B
Pattern[3] = B

Match → i = 6, j = 4

Step 8
Text[6] = C
Pattern[4] = C

Match → i = 7, j = 5

Full Match Found

Since j == m:

start = i - j = 7 - 5 = 2

Store 2.

Why the Answer Is 2

Starting from index 2:

Text[2..6] = A B A B C

which matches the pattern exactly.

Search Rules to Memorize
1. Match:
   i++, j++

2. Full match:
   save (i - j)
   j = lps[j - 1]

3. Mismatch and j > 0:
   j = lps[j - 1]

4. Mismatch and j == 0:
   i++
Final Mental Model
i walks through the text.
j walks through the pattern.
On mismatch, j jumps using LPS.
i only moves forward.
 */