package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class NCRFormulaCode {
    public static void main(String[] args) {
        int n = 10; int r = 3;
        int res = 1;//r = Math.min(r, n-r); if r = 7 we can take r = 3.
        for(int i=0;i<r;i++){
            res = (res *  (n-i))/(i+1);
        }
        System.out.println(res);
    }
}
/* 📘 1. What is nCr?
𝑛
𝐶
𝑟
=
𝑛
!
𝑟
!
(
𝑛
−
𝑟
)
!
nCr=
r!(n−r)!
n!
	​


It means: number of ways to choose r items from n.

⚠️ 2. Problem with Brute Force (Factorial Approach)
❌ Code idea:
nCr = fact(n) / (fact(r) * fact(n-r));
❌ Issues:
Time Complexity:
Factorial takes O(n) → total ≈ O(n)
Overflow Problem 🚨
Even for small values:
20! = 2,432,902,008,176,640,000 (too large for int/long)
Unnecessary computation
You're calculating full factorials even though many terms cancel out
✅ 3. Your Optimized Approach (Best Method)
✔️ Code:
int res = 1;
for(int i = 0; i < r; i++){
    res = (res * (n - i)) / (i + 1);
}
🧠 4. Intuition Behind This Formula

Instead of:

𝑛
!
𝑟
!
(
𝑛
−
𝑟
)
!
r!(n−r)!
n!
	​


We rewrite it as:
𝑛𝐶𝑟=𝑛⋅(𝑛−1)⋅(𝑛−2)⋯(𝑛−𝑟+1)𝑟!
nCr=
r!
n⋅(n−1)⋅(n−2)⋯(n−r+1)

💡 Example: n = 10, r = 3
10𝐶3=
10⋅9⋅8/3⋅2⋅1
10C3=3⋅2⋅1
10⋅9⋅8


Your loop does exactly this step-by-step:

i	res calculation
0	(1 × 10) / 1 = 10
1	(10 × 9) / 2 = 45
2	(45 × 8) / 3 = 120

✅ Final Answer = 120

⚡ 5. Why This Approach is Better
🚀 1. Avoids Overflow (Very Important)
Multiplication and division happen simultaneously
Numbers stay small
🚀 2. Time Complexity
Only loop till r
O(r) instead of O(n)

👉 Even better:

r = Math.min(r, n - r);

This reduces loop further

🚀 3. Space Complexity
O(1) → no extra memory
🚀 4. No Factorial Needed
No recursion
No large intermediate values
🔥 6. Key Observation (Very Important for Interviews)
𝑛𝐶𝑟 =𝑛𝐶(𝑛−𝑟)
nCr=nC(n−r)

So always take:

r = Math.min(r, n - r);
🧾 7. Final Optimized Version
int n = 10, r = 3;

r = Math.min(r, n - r);

int res = 1;
for(int i = 0; i < r; i++){
    res = res * (n - i) / (i + 1);
}

System.out.println(res);
🎯 8. When to Use This

Use this approach in:

Combinatorics problems
Pascal Triangle
Probability problems
Competitive programming
DSA interviews
🧠 9. One-Line Summary (Revise Fast)

👉 Instead of computing full factorials,
compute nCr by multiplying numerator and dividing denominator
step-by-step to avoid overflow and reduce time complexity.
Yes 👍 absolutely correct!

(
10
7
)
=
(
10
3
)
(
7
10
	​

)=(
3
10
	​

)
🔥 Why this is true

This comes from a very important identity in combinations:

(
𝑛
𝑟
)
=
(
𝑛
(
𝑛
−
𝑟
)
)
(
r
n
	​

)=(
(n−r)
n
	​

)
🧠 Intuition (very important)

Choosing 7 items out of 10
is the same as
👉 leaving 3 items out of 10

Because:

If you select 7, automatically 3 are not selected
If you select 3 to exclude, automatically 7 are selected

👉 Same situation, just different perspective

🔍 Example with numbers
(
10
7
)
=
10
!
7
!
⋅
3
!
(
7
10
	​

)=
7!⋅3!
10!
	​

(
10
3
)
=
10
!
3
!
⋅
7
!
(
3
10
	​

)=
3!⋅7!
10!
	​


👉 Both are exactly same expression ✔️

🎯 Final takeaway

👉 nCr = nC(n-r) is a VERY important identity
👉 Always use it to reduce calculations

Example:

Instead of calculating 10C7, just do 10C3 (easier)
 */