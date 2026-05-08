package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10.Hard;

import java.util.*;

public class dayXfirstHardValidParenthesis {
    class Solution {

        public ArrayList<String> removeInvalidParentheses(String s) {

            ArrayList<String> ans = new ArrayList<>();

            Queue<String> queue = new LinkedList<>();

            HashSet<String> visited = new HashSet<>();

            queue.add(s);
            visited.add(s);

            boolean found = false;

            while(!queue.isEmpty()) {

                String curr = queue.poll();

                // check valid
                if(isValid(curr)) {

                    ans.add(curr);
                    found = true;
                }

                // stop deeper removals
                if(found) {
                    continue;
                }

                // generate next level
                for(int i = 0; i < curr.length(); i++) {

                    char ch = curr.charAt(i);

                    if(ch != '(' && ch != ')') {
                        continue;
                    }

                    String next =
                            curr.substring(0, i)
                                    + curr.substring(i + 1);

                    if(!visited.contains(next)) {

                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            Collections.sort(ans);

            return ans;
        }

        public boolean isValid(String s) {

            int count = 0;

            for(char ch : s.toCharArray()) {

                if(ch == '(') {
                    count++;
                }

                else if(ch == ')') {

                    count--;

                    if(count < 0) {
                        return false;
                    }
                }
            }

            return count == 0;
        }
    }

}
/*
Remove Invalid Parentheses
Difficulty: HardAccuracy: 43.53%Submissions: 16K+Points: 8Average Time: 40m
Given a string s consisting of lowercase letters and parentheses '(' and ')'.

A string is considered valid if:

Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
Parentheses are properly nested.
Remove the minimum number of invalid parentheses from s so that the resulting string becomes valid.  Return all the possible distinct valid strings in lexicographically sorted order.

Examples :

Input:  = "()())()"
Output: ["(())()", "()()()"]
Explanation:
The string "()())()" has one extra ')', making it invalid. By removing one ')', we can make it valid in two ways:
Remove the 3rd index ')' -> "(())()"
Remove the 4th index ')' -> "()()()"
Both are valid and require the minimum removals.
Input: s = "(a)())()"
Output: ["(a())()", "(a)()()"]
Explanation:
We remove one ')' (minimum removals) to make it valid. Possible valid results:
Remove a ')' -> "(a())()"
Remove another ')' -> "(a)()()"
Input: s = ")("
Output: [""]
Explanation: The string ")(" is invalid. Removing both parentheses (minimum removals) gives an empty string
 "", which is valid.

 🧠 What is the problem really asking?

You are given a string like:

()())()

It contains:

letters (a, b, c…)
'(' opening brackets
')' closing brackets
✅ Goal:

Make the string valid by removing minimum number of parentheses

AND

👉 Return ALL possible valid results

🔍 What is a “Valid Parentheses String”?

A string is valid if:

1. Every '(' has a matching ')'
()  ✅
(()  ❌
2. Order is correct (proper nesting)
(())  ✅
)(     ❌
⚠️ Important Rule (Most Important)

You must remove the minimum number of parentheses

Not more. Not less.

🧩 Example Breakdown
Example 1:
s = "()())()"
❌ Problem:

There is one extra )

Step 1: Try removing ONE bracket at different places

Let’s remove different ) and see:

Remove index 3:
(())()

✅ Valid

Remove index 4:
()()()

✅ Valid

❌ Don’t do this:

Remove 2 brackets:

()()   ← valid but NOT allowed

👉 Because it's NOT minimum removal

✅ Final Answer:
["(())()", "()()()"]
🧩 Example 2:
s = "(a)())()"

👉 Letters like a are ignored for validity

We only care about ( and )

Possible valid outputs:

"(a())()"
"(a)()()"
🧩 Example 3:
s = ")("
❌ Completely invalid
First ) has no opening
Then ( has no closing

👉 Minimum removals = 2

Final:

""
💡 Key Observations
1. This is NOT just one answer

You must return ALL possible valid strings

2. Remove as few characters as possible

This is the trickiest constraint

3. Order matters

Return results in:
👉 Lexicographically sorted order

🧠 How to Think About This

This is NOT a normal recursion problem.

It’s more like:

“Try removing characters in all possible ways — but carefully”

🔥 Real Concept Behind This Problem

This problem is based on:

👉 Backtracking / BFS + Validity Check

🧪 What You’ll Need (Later for solving)
A function to check if string is valid
Try removing characters one by one
Stop when you reach minimum removals
Store all valid answers
Avoid duplicates
🚫 Common Beginner Mistakes
❌ Removing too many parentheses
❌ Returning only one answer
❌ Ignoring duplicate results
❌ Not checking validity properly
🧠 Simple Mental Model

Think like this:

“I will try deleting parentheses in different ways…
but I will STOP as soon as I find valid strings with minimum deletions”

💬 Honest Note

You said you haven’t started trees yet — and this is a Hard backtracking problem.

So let me be clear:

👉 This problem is NOT beginner-friendly

But:
👉 Understanding it like this = already a big win

🚀 What I suggest for you

Do this in order:

Understand this problem (✅ you’re doing it)
Try writing:
validity checker
Then I’ll help you build solution step-by-step

That’s a very healthy mindset, Aryan 👍

You’re not “behind” because this problem feels hard.
Actually, this is exactly how growth looks:

See hard problem → feel overwhelmed → learn concepts later → revisit → suddenly understand

That cycle is normal in DSA.

And yes 😄 your first Hard problem is memorable for almost everyone.

🧠 First Important Decision

This problem can be solved using:

Backtracking
BFS

But since:

you haven’t learned trees
DFS/BFS concepts are new
you want intuition, not memorization

👉 I’ll teach the BFS-style thinking in the simplest possible way.

🎯 Main Idea of Solution

We want:

minimum removals

That word is the KEY.

🧠 Why BFS is used?

Because BFS explores:

all strings with 1 removal first
then 2 removals
then 3 removals...

So the FIRST valid strings we find:
✅ automatically use minimum removals.

That is the whole magic.

🌳 Think Like Levels

For:

()())()

Level 0:

()())()

Level 1 (remove one character at every position):

)())()
(())()
()()()
()()))
...

Level 2:
remove 2 chars from all above strings...

BUT:

👉 The moment we find valid strings at some level:
STOP going deeper.

Because deeper = more removals.

✅ Step 1: Validity Function

First we need:

isValid(str)
🧠 Why?

To check:

Is this parentheses string balanced?
✅ Logic

Use a counter.

( → count++
) → count--

If count becomes negative:
❌ invalid

At end:
count must be 0

💻 Code
public boolean isValid(String s) {

    int count = 0;

    for(char ch : s.toCharArray()) {

        if(ch == '(') {
            count++;
        }

        else if(ch == ')') {

            count--;

            // more closing brackets
            if(count < 0) {
                return false;
            }
        }
    }

    return count == 0;
}
🧠 Why does this work?

Example:

(())

Process:

( → 1
( → 2
) → 1
) → 0

Balanced ✅

Example:

())(

Process:

( → 1
) → 0
) → -1 ❌

Invalid.

✅ Step 2: BFS Exploration

We use:

Queue<String>
🧠 Why Queue?

Queue helps process:

level by level

Exactly what BFS needs.

✅ Step 3: Avoid Duplicate Work

We use:

HashSet<String>
🧠 Why?

Because many removals create same strings.

Example:

remove index 3
remove index 4

Both produce:

()()()

Without HashSet:

repeated processing
TLE risk
✅ Full Flow
1️⃣ Put original string into queue
queue.add(s);
2️⃣ Take one string from queue
String curr = queue.poll();
3️⃣ Check validity

If valid:

add to answer

AND:

do not generate deeper levels

Because minimum removal already found.

4️⃣ Otherwise

Try removing every bracket:

for every character:
    remove it
    create new string
⚠️ Important Optimization

Only remove:

( or )

Ignore letters.

💻 Core BFS Code
for(int i = 0; i < curr.length(); i++) {

    char ch = curr.charAt(i);

    if(ch != '(' && ch != ')') {
        continue;
    }

    String next =
        curr.substring(0, i)
        + curr.substring(i + 1);

    if(!visited.contains(next)) {

        visited.add(next);
        queue.add(next);
    }
}
🧠 What is happening here?
Suppose:
curr = "()())()"
If:
i = 1
We remove index 1:
curr.substring(0,1)
gives:
(
and
curr.substring(2)
gives:
())()
Combine:
(())()
 */