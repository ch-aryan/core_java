package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;
//Range Lcm queries.
/*
Range LCM Queries
Difficulty: MediumAccuracy: 52.98%Submissions: 13K+Points: 4Average Time: 45m
Given an array arr[]  and a list of queries queries[][]. Each query can be one of the following two types:

Update Query: [1, index, value] --> Update the element at position index in the array to the given value.
Range Query: [2, L, R] --> Compute and return the Least Common Multiple (LCM) of all elements in the subarray from index L to R (inclusive).
Process all queries sequentially and return a list containing the results of all Type 2 queries.

Note: All operations follow 0-based indexing.

Examples :

Input: arr[] = [2, 3, 4, 6, 8, 16], queries[][] = [[2, 0, 2], [1, 3, 8], [2, 2, 5]]
Output: [12, 16]
Explanation: The queries are processed sequentially, updating the array when required.
[2, 0, 2]: LCM of [2, 3, 4] = 12
[1, 3, 8]: array becomes [2, 3, 4, 8, 8, 16]
[2, 2, 5]: LCM of [4, 8, 8, 16] = 16
Input: arr[] = [1, 2, 3, 4],  queries[][] = [[2, 0, 3], [1, 0, 5], [2, 0, 1]]
Output: [12, 10]
Explanation: The queries are processed sequentially, updating the array when required.
[2, 0, 3]: LCM of [1, 2, 3, 4] = 12
[1, 0, 5]: array becomes [5, 2, 3, 4]
[2, 0, 1]: LCM of [5, 2] = 10
 */
public class dayXII {

}
/*
Absolutely, Aryan. Let’s understand this problem in the simplest possible way.

🎯 What the Problem Is Asking

You are given:

An array of numbers.
A list of queries.

Each query asks you to do one of two things:

✅ Type 1 Query: Update the Array

Format:

[1, index, value]

Meaning:

Replace the element at index with value.

Example
[1, 3, 8]

This means:

Go to index 3
Replace that element with 8

If the array is:

[2, 3, 4, 6, 8, 16]

After update:

[2, 3, 4, 8, 8, 16]
✅ Type 2 Query: Find LCM in a Range

Format:

[2, L, R]

Meaning:

Find the LCM of all elements from index L to index R.

Example
[2, 0, 2]

Take elements from index 0 to 2:

[2, 3, 4]

Find LCM:

LCM(2, 3) = 6
LCM(6, 4) = 12

Answer = 12

🧠 In Simple Words

The problem says:

“Sometimes change one element in the array, and sometimes calculate the LCM of a portion of the array.”

📌 Example Walkthrough
Initial Array
[2, 3, 4, 6, 8, 16]
Queries
[
 [2, 0, 2],
 [1, 3, 8],
 [2, 2, 5]
]
Query 1: [2, 0, 2]

Find LCM from index 0 to 2.

Subarray:

[2, 3, 4]

LCM(2,3,4)=12

Store result:

results = [12]
Query 2: [1, 3, 8]

Update index 3 to 8.

Old array:

[2, 3, 4, 6, 8, 16]

New array:

[2, 3, 4, 8, 8, 16]

No output is added because update queries do not return anything.

Query 3: [2, 2, 5]

Find LCM from index 2 to 5.

Subarray:

[4, 8, 8, 16]

LCM(4,8,8,16)=16

Store result:

results = [12, 16]
✅ Final Output
[12, 16]
📝 What You Need to Return

Only return answers of Type 2 queries.

Ignore Type 1 queries in the output.

📦 Real-Life Analogy

Imagine you have a list of machine cycle times:

[2, 3, 4, 6, 8, 16]
Sometimes one machine is replaced (update query).
Sometimes you want to know when a group of machines will all align together (LCM query).

That “alignment time” is the LCM.

🧠 Key Observations
Query Type	Meaning	Returns Output?
1	Update one element	❌ No
2	Find LCM in a range	✅ Yes
🔁 Brute Force Approach

For each range query:

Start with first number.
Compute LCM with next number.
Continue until the end of the range.

For updates:

Simply replace the value in the array.
💡 Why This Is a Medium Problem

If there are many queries:

Updating is easy.
Recomputing LCM for large ranges repeatedly can be slow.

So efficient solutions use a Segment Tree.

Data Structures and Algorithms

🏗️ Segment Tree Idea

Each node stores the LCM of a segment.

This allows:

Update in O(log n)
Range LCM query in O(log n)
🎯 Problem Summary

You are asked to:

Maintain an array.
Process queries one by one.
Update elements when query starts with 1.
Compute LCM over a range when query starts with 2.
Return all answers from Type 2 queries.
🧠 One-Line Understanding

“Update numbers in the array and repeatedly answer LCM of any requested subarray.”

✅ Expected Output for Example
[12, 16]

how does the lcm will work for the arrays. for example 19, 18, 17. i understood it with simple number like 2, 4, 6, 8 it will work but what about the big numbers.
 */