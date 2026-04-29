package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

import java.util.Arrays;

public class AssignCookies {
    class Solution {
        //my own try logic took 30 mins

        public int maxChildren(int[] greed, int[] cookie) {
            // code here
            Arrays.sort(greed);
            Arrays.sort(cookie);
            int res =0;
            int j =greed.length-1;
            int k = cookie.length-1;

            for(int i =j ; i>=0;i--){
                if(k== -1){
                    return res;
                }
                if(greed[i] <= cookie[k]){
                    res++;
                    k--;
                }
            }

            return res;




        }
    }


    class SolutionAI {
        public int maxChildren(int[] greed, int[] cookie) {
            Arrays.sort(greed);
            Arrays.sort(cookie);

            int i = 0; // pointer for children
            int j = 0; // pointer for cookies
            int count = 0;

            while (i < greed.length && j < cookie.length) {
                if (cookie[j] >= greed[i]) {
                    count++; // child satisfied
                    i++;     // move to next child
                }
                j++; // always move cookie pointer
            }

            return count;
        }
    }
}
/* AI code
⚡ Why this is powerful
Always uses smallest sufficient cookie
Saves bigger cookies for greedy kids
Clean two-pointer logic → very interview friendly

✅ What your code is doing

You:

Sort both arrays
Start from the largest greed child
Try to give the largest available cookie

👉 This is the reverse version of the standard greedy approach.

🧠 Why this works

You are basically saying:

“Let me first try to satisfy the most demanding child using the biggest cookie.”

That’s valid because:

If the biggest cookie can’t satisfy this child → no cookie can
If it can satisfy, assign it immediately
🔍 Dry Run (important)
Example:
greed = [1,2,3]
cookie = [1,1,3]

After sorting:

greed = [1,2,3]
cookie = [1,1,3]

Start from end:

i = 2 (greed = 3), k = 2 (cookie = 3)
3 <= 3 ✅ → assign → res = 1, k = 1
i = 1 (greed = 2), k = 1 (cookie = 1)
2 <= 1 ❌ → skip
i = 0 (greed = 1), k = 1 (cookie = 1)
1 <= 1 ✅ → res = 2, k = 0

✔️ Answer = 2 (correct)

⚖️ Your approach vs common approach
Approach	Idea
Your code	Match largest ↔ largest
Common one	Match smallest ↔ smallest

👉 Both are correct greedy strategies

⚠️ Small improvement (cleaner code)

This loop:

for(int i = j ; i>=0;i--)

You don’t need j separately:

for(int i = greed.length - 1; i >= 0; i--)
💡 Final Verdict

✅ Correct logic
✅ Optimal solution
✅ Passes all test cases
✅ Good greedy understanding

🔥 One important insight for you

You’ve reached a good level if you can think:

“Greedy can work from both directions (small→small OR big→big) depending on reasoning.”

That’s exactly what you just did.
 */

/*
🔴 Brute Force Time Complexity

If you try all possible assignments of cookies to children:

For each child, you try every cookie
And ensure no cookie is reused

This becomes like permutations / matching problem

👉 Time Complexity:

O(n × m) (simple brute with visited array)
or even worse
O(n!) (if you try all combinations exhaustively)

Simple brute idea:
For each child:
Loop through all cookies
Pick any unused cookie that satisfies

So practical brute:

O(n × m)

🟢 Optimal Solution Exists?

👉 Yes — this is a classic Greedy problem

Optimal Time Complexity:

O(n log n + m log m)

Why?

Sorting children → O(n log n)
Sorting cookies → O(m log m)
One pass matching → O(n + m)
⚡ Final Complexity
Approach	Time Complexity
Brute Force	O(n × m)
Optimal Greedy	O(n log n + m log m)
🧠 Key Insight

This problem is NOT meant for DP or backtracking.

👉 It’s designed to test:

“Can you recognize greedy pattern or not?”

If you want, next I can:

Show why greedy is always correct here (important for interviews)
Or give you code + dry run like an interviewer expects
 */