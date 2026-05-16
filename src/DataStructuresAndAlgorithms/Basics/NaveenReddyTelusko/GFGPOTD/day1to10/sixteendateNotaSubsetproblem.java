package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

import java.util.Arrays;
/*
Not a subset sum
Difficulty: MediumAccuracy: 45.92%Submissions: 86K+Points: 4
Given a array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

Examples:

Input: arr[] = [3, 1, 2]
Output: 7
Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
Input: arr[] = [3, 10, 9, 6, 20, 28]
Output: 1
Explanation: 1 is the smallest positive number for which no subset is there with sum 1.
 */

public class sixteendateNotaSubsetproblem {

        public int findSmallest(int[] arr) {
            // code here
            Arrays.sort(arr);
            int n = arr.length;
            int res = 1;
            for(int i=0; i<n; i++){
                if(arr[i] <= res){
                    res = res + arr[i];
                }else{
                    break;
                }
            }
            return res;

        }
    }

/*
What is a Subset?

A subset means choosing any combination of elements without changing their values.

For example, if:

arr = [1, 2, 3]

Possible subsets and their sums:

Subset	Sum
{}	0
{1}	1
{2}	2
{3}	3
{1,2}	3
{1,3}	4
{2,3}	5
{1,2,3}	6

So we can make:

1, 2, 3, 4, 5, 6

The smallest positive number missing is:

7

So the answer is 7.

Example 1
arr = [3, 1, 2]

After sorting:

[1, 2, 3]

Subset sums can make:

1, 2, 3, 4, 5, 6

Cannot make:

7

Answer = 7

Example 2
arr = [3, 10, 9, 6, 20, 28]

There is no 1 in the array.

So:

We cannot form 1.

Answer = 1

Real-Life Analogy (Currency Notes)

Suppose you have notes of:

₹1, ₹2, ₹3

You can make every amount from ₹1 to ₹6.

But you cannot make ₹7.

So ₹7 is the smallest amount you cannot form.

More Examples
Example 3
arr = [1, 1, 3]

Possible sums:

1
2 (1 + 1)
3
4 (1 + 3)
5 (1 + 1 + 3)

Missing smallest positive integer = 6

Example 4
arr = [2, 3, 4]

There is no 1.

So answer = 1

Important Observations
If 1 is missing

Then answer is immediately:

1

Because you cannot create 1 without a 1.

If you can form all numbers from 1 to X

And the next number is ≤ X + 1,
then you can now form all numbers up to X + next.

If the next number is > X + 1

Then X + 1 cannot be formed.

That is the answer.

Example Walkthrough
arr = [1, 2, 5]

Sorted array:

[1, 2, 5]
Step 1: Start with res = 1

This means:

We are trying to find whether we can form 1.

Step 2: Use 1

Since 1 <= res, we can now form all values up to:

res = 1 + 1 = 2

Now we can form:

1
Step 3: Use 2

Since 2 <= res, we can extend the reachable range.

res = 2 + 2 = 4

Now we can form:

1, 2, 3
Step 4: Check 5

But:

5 > res (4)

So we cannot form:

4

Answer = 4

Meaning of res

At every step:

We can form all numbers from 1 to res - 1.

If the next number is small enough (<= res), we extend the range.

Otherwise, res is the smallest missing number.

Final Summary

The problem asks:

"What is the smallest positive integer that cannot be obtained by adding some subset of the given numbers?"

Example Recap
Array	Answer	Reason
[1,2,3]	7	Can form 1 to 6
[3,10,9]	1	No 1 present
[1,2,5]	4	Can form 1 to 3 only
[1,1,3]	6	Can form 1 to 5
Intuition to Remember Forever

Think of maintaining a continuous reachable range:

We can create every value from 1 to res - 1.

If next number <= res, merge it into the range.
If next number > res, then res is impossible to form.

Once this intuition clicks, the greedy solution becomes one of the most beautiful patterns
Why Your Logic Is Correct

At every step, res represents:

The smallest positive number that we cannot form yet.

Equivalently:

We can form every number from 1 to res - 1.

Case 1: arr[i] <= res

If the next number is small enough, we can extend the reachable range.

Previously: 1 ... res - 1
After adding arr[i]: 1 ... res + arr[i] - 1

So:

res = res + arr[i];
Case 2: arr[i] > res

There is a gap at res, so res cannot be formed.

We stop and return res.

Example

For:

arr = [1, 2, 3]

After sorting:

[1, 2, 3]
res = 1
Use 1 → res = 2
Use 2 → res = 4
Use 3 → res = 7

Answer = 7

Time Complexity
Sorting: O(n log n)
Traversal: O(n)

Overall:

O(n log n)
Space Complexity
O(1)

(ignoring sorting's internal implementation details)

Small Improvement for Large Values

If array values can be very large, use long instead of int to avoid overflow:

long res = 1;

But for most coding platforms, int is often accepted depending on constraints.

Your Solution Quality
✔ Correct
✔ Optimal
✔ Clean and readable
✔ Interview-ready
One Tiny Style Suggestion

You can write the condition more naturally as:

if (arr[i] <= res)

This is exactly the same as res >= arr[i], but aligns better with the common explanation.

Final Version
class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        long res = 1;

        for (int num : arr) {
            if (num <= res) {
                res += num;
            } else {
                break;
            }
        }

        return (int) res;
    }
}

And thank you for saying that. That means a lot. But the most important part is this: you understood the idea and wrote the solution yourself. That is exactly how strong problem-solving skills are built.

You’re becoming the kind of engineer who can look at a problem, reason deeply, and arrive at an elegant solution. Keep going — this is the path to becoming an exceptional software engineer. 🚀
 */