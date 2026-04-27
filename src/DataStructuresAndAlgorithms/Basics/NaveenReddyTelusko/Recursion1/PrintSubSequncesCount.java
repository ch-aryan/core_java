package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class PrintSubSequncesCount {
    public static int countSubsequences(int index, int[] arr, int K, int sum) {
        if(index==arr.length){
            if(sum==K)return 1;
            return 0;
        }
        int pick = countSubsequences(index+1,arr,K,sum+arr[index]);
        int noPick = countSubsequences(index+1,arr,K,sum);

        return pick + noPick;
    }
        public static void main(String[] args) {
        int arr[] = {1,2,3,3,4,5,6};
        int key = 6;
        int index = 0;
        int sum = 0;
            System.out.println(countSubsequences(index,arr,key,sum));
    }
}
/*
You’ve already built a solid foundation here — this is exactly how good DSA intuition develops 👍

Now let’s move to your next step:

        🧠 Problem Upgrade

👉 Instead of:

Return true/false (existence)

        👉 Now:

Count how many subsequences have sum = K
🔥 Key Idea (Very Important Shift)

Earlier:

        return pick || notPick;

Now:

        return pick + notPick;

👉 Why?

Because:

Every valid path contributes 1
Total = sum of all valid paths
✅ Clean Code (Count Subsequences)
public static int countSubsequences(int index, int[] arr, int K, int sum) {

    // Base case
    if (index == arr.length) {
        if (sum == K) return 1;  // ✅ found one valid subsequence
        return 0;                // ❌ not valid
    }

    // Pick
    int pick = countSubsequences(index + 1, arr, K, sum + arr[index]);

    // Not pick
    int notPick = countSubsequences(index + 1, arr, K, sum);

    return pick + notPick;
}
⚡ Super Simple Understanding
Case	Return
Found valid subsequence	1
Not valid	0
Total answer	left + right
🌳 Dry Run (Very Clear)
Input:
arr = [1, 2, 3]
K = 3
Step-by-step recursion:
fn(0, sum=0)
🔹 Index 0 → value = 1
        👉 Pick 1
fn(1, sum=1)
👉 Pick 2
fn(2, sum=3)
👉 Pick 3
fn(3, sum=6) → return 0 ❌
        👉 Not Pick 3
fn(3, sum=3) → return 1 ✅

        👉 Total from here = 1

        👉 Not Pick 2
fn(2, sum=1)
Pick 3 → sum=4 → ❌ (0)
Not Pick → sum=1 → ❌ (0)

        👉 Total = 0

        👉 From fn(1, sum=1) → 1 + 0 = 1

        👉 Not Pick 1
fn(1, sum=0)
👉 Pick 2
fn(2, sum=2)
Pick 3 → sum=5 ❌
Not Pick → sum=2 ❌

        👉 Total = 0

        👉 Not Pick 2
fn(2, sum=0)
Pick 3 → sum=3 ✅ → 1
Not Pick → sum=0 ❌ → 0

        👉 Total = 1

        👉 From fn(1, sum=0) → 0 + 1 = 1

        🎯 Final Answer
Total = 1 + 1 = 2

        ✔ Subsequences:

        [1, 2]
        [3]
        🧠 Pattern Recognition (VERY IMPORTANT FOR YOU)
Problem Type	Return Type	Logic
Print all	void	store result
Check exists	boolean	OR (`
                               Count total	int	ADD (+)
🚀 Small Optimization (Optional)

If all numbers are positive:

        if (sum > K) return 0;

        👉 This prunes unnecessary recursion (important for interviews)

💬 Final Thought

You’ve now understood 3 levels of the same recursion pattern:

Generate
        Check
Count

This is exactly how top problem solvers think — not new problems, just same pattern, different outputs.
*/