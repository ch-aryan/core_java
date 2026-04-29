package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

public class DPVSGREEDY {
}
/*
Love this question — this is exactly the point where your DSA thinking levels up 🔥
Let’s make this crystal clear.
🧠 Core Idea
Greedy = make best choice now
DP = consider future consequences
🔴 When Greedy FAILS
Greedy fails when:

Local best choice ≠ Global best answer


💣 Classic Example (you must remember)
🪙 Coin Change Problem
Coins:
[1, 3, 4]
Target:
6

❌ Greedy approach
Pick largest coin first:
4 → remaining 21 → remaining 11 → remaining 0
👉 Coins used = 3

✅ Optimal (DP solution)
3 + 3 = 6
👉 Coins used = 2 (better)

🔥 Why greedy failed?
Greedy said:

“4 is biggest → take it”

But:

That decision blocked a better future combination


🧠 When Greedy WORKS
Greedy works when problem has:
✅ 1. Greedy Choice Property

Choosing best now never hurts future

✅ 2. Optimal Substructure

Problem can be broken into smaller optimal parts


✔️ Examples where Greedy works


Activity Selection
Fractional Knapsack
Assign Cookies
Minimum Coins (only for special coin systems like 1,2,5,10)
🔴 When to switch to DP
Use DP when:
❗ 1. Multiple choices affect future
Picking one option blocks better combinations
❗ 2. Need exact optimal combination
Not just locally best
❗ 3. Overlapping subproblems exist
Same states repeat
🔥 Quick Comparison
ProblemGreedyDPActivity Selection✅❌Fractional Knapsack✅❌0/1 Knapsack❌✅Coin Change (general)❌✅
🧠 Powerful Interview Trick
Ask yourself:
“If I make a choice now, can it ruin future possibilities?”
If NO → Greedy ✅
If YES → DP 🔥
⚡ Another Example (0/1 Knapsack)
Items:
value = [60, 100, 120]weight = [10, 20, 30]capacity = 50
❌ Greedy (by ratio)
Take 60 (10)
Take 100 (20)
Can't fully take 120
👉 Result = 160
✅ DP
Take 100 + 120 = 220
👉 Better solution
🧠 Final Mental Model
Greedy:
“Trust the present”
DP:
“Plan for the future”
🔥 Golden Rule
If problem says:
“maximum count” → often Greedy
“maximum/minimum value with constraints” → often DP
🚀 Your level now
You’ve learned:
Greedy ✔️
When it works ✔️
When it fails ✔️
👉 This is a huge milestone
 */