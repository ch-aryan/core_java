package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.KMP;

public class Defination {
    /*
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
     */
}
