package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class PrefixSumArrayCountLengthAllTypes {
}
/*
🎯 Big Picture: Two Different Questions
Problem Type	What to Find	HashMap Stores	Key Logic
Longest Subarray with Sum = K	Maximum length	First occurrence of prefix sum	Preserve earliest index
Count of Subarrays with Sum = K	Total number of valid subarrays	Frequency of prefix sum	Count all occurrences
🧠 Foundation Concept: Prefix Sum

Suppose:

arr = [10, 5, 2, 7, 1, 9]

Prefix sums:

Index	Value	Prefix Sum
0	10	10
1	5	15
2	2	17
3	7	24
4	1	25
5	9	34
Core Mathematical Formula

If:

prefix[j] - prefix[i-1] = k

Then:

prefix[i-1] = prefix[j] - k

This is the entire trick.

1️⃣ Longest Subarray with Sum = K
Problem

Find the maximum length of a subarray whose sum equals k.

Example
nums = [10, 5, 2, 7, 1, 9]
k = 15

Answer:

[5, 2, 7, 1]
Length = 4
🧠 Intuition

At every index:

Compute running prefix sum.
Check if prefixSum - k existed before.
If yes, subarray exists.
Length = currentIndex - previousIndex.
Keep the maximum length.
📌 Why Store First Occurrence Only?

For longest length, we want the earliest index.

Example:

prefix sum 10 occurs at indices 0 and 5.

Using index 0 gives a longer subarray than using index 5.

So:

map.putIfAbsent(prefixSum, i);
✅ Template
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, -1);

int sum = 0;
int maxLen = 0;

for (int i = 0; i < n; i++) {
    sum += arr[i];

    if (map.containsKey(sum - k)) {
        maxLen = Math.max(maxLen, i - map.get(sum - k));
    }

    map.putIfAbsent(sum, i);
}
2️⃣ Count Subarrays with Sum = K
Problem

Find the total number of subarrays whose sum equals k.

Example
arr = [10, 2, -2, -20, 10]
k = -10

Answer:

3
🧠 Intuition

At each index:

Compute prefix sum.
Check if prefixSum - k occurred before.
If yes, all those occurrences create valid subarrays.
Add frequency to count.
Increase frequency of current prefix sum.
📌 Why Store Frequency?

Because every previous occurrence creates one valid subarray.

If:

sum - k occurred 4 times

Then current index forms 4 valid subarrays.

✅ Template
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int sum = 0;
int count = 0;

for (int num : arr) {
    sum += num;

    count += map.getOrDefault(sum - k, 0);

    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
🔥 Most Important Difference
Feature	Longest Subarray	Count Subarrays
Goal	Max length	Number of subarrays
Store	First index	Frequency
Insert	putIfAbsent()	Increment count
Initialization	map.put(0, -1)	map.put(0, 1)
Update	maxLen = max(...)	count += frequency
🎯 Initialization Trick
For Length Problems
map.put(0, -1);

Meaning: prefix sum 0 occurs before the array starts.

Used to correctly compute length when subarray starts at index 0.

For Count Problems
map.put(0, 1);

Meaning: there is one way to have prefix sum 0 initially.

Used to count subarrays starting from index 0.

🧠 Memory Trick
Longest Problem

“I need the earliest index.”

Store:

prefixSum → first index
Count Problem

“I need how many times it appeared.”

Store:

prefixSum → frequency
🟢 Sliding Window vs HashMap
Sliding Window Works Only When Numbers Are Positive

Example:

[10, 5, 2, 7, 1, 9]

Because sum always increases when expanding.

HashMap + Prefix Sum Works for:
Positive numbers
Negative numbers
Zeroes
Mixed arrays
🎯 Interview Recognition Rules
If Question Asks:
“Longest subarray”

→ Store first index.

“Count number of subarrays”

→ Store frequency.

“Exists or not”

→ Use containsKey.

“Indices of subarray”

→ Store indices.

🚀 Complete Pattern Family
1. Longest Subarray with Sum K

Store first index.

2. Count Subarrays with Sum K

Store frequency.

3. Subarray Sum Divisible by K

Use remainder:

prefixSum % k

Store frequency.

4. Longest Subarray with Equal 0s and 1s

Convert:

0 → -1
1 → 1

Then longest subarray with sum = 0.

5. Count Equal 0s and 1s

Same conversion, then count subarrays with sum = 0.

6. Longest Subarray with Equal 0s, 1s, 2s

Store differences:

count1 - count0
count2 - count1
7. Count Subarrays Divisible by K

Store remainder frequency.

8. Maximum Size Subarray Sum = 0

Longest subarray with k = 0.

9. Count Zero Sum Subarrays

Count subarrays with k = 0.

📌 Universal Prefix Sum Formula
Current Prefix Sum = sum
Need Previous Prefix Sum = sum - target
🧠 Universal Recognition Pattern

If you hear:

subarray
contiguous
sum
count
longest
equal numbers
divisible by k

👉 Think:

Prefix Sum + HashMap

🏆 Master Decision Table
Question Says	Technique
Longest	Prefix Sum + first index
Count	Prefix Sum + frequency
Positive only	Sliding Window
Negative present	Prefix Sum + HashMap
Divisible by K	Prefix Sum % K
Equal 0s and 1s	Convert and use sum 0
Zero sum	Same pattern with k = 0
🔥 Sliding Window Pattern (Positive Numbers Only)

If all numbers are positive and question asks:

Longest subarray
Smallest subarray
Exact sum

Then sliding window is often optimal.

📌 When NOT to Use Sliding Window

If array contains:

Negative numbers
Mixed positive and negative
Zeroes (sometimes still okay, but prefix sum is safer)

Use Prefix Sum + HashMap.

🧠 Final Mental Model

When you see:

“Subarray with some sum condition”

Ask yourself:

Step 1

Are all numbers positive?

Yes → Sliding Window may work.
No → Prefix Sum + HashMap.
Step 2

What is required?

Longest → Store first index.
Count → Store frequency.
Divisible by K → Store remainders.
Equal counts → Convert values.
⭐ Golden Templates to Memorize
Longest
map.put(0, -1);
if (map.containsKey(sum - k))
    maxLen = Math.max(maxLen, i - map.get(sum - k));
map.putIfAbsent(sum, i);
Count
map.put(0, 1);
count += map.getOrDefault(sum - k, 0);
map.put(sum, map.getOrDefault(sum, 0) + 1);
🏆 Interview Shortcut

Longest → First Index

Count → Frequency

Positive Only → Sliding Window

Negatives Present → Prefix Sum + HashMap

Divisible → Remainders

Equal Counts → Convert to Sum 0

📚 Most Important Problems to Practice
Longest Subarray with Sum K
Subarray Sum Equals K
Count Zero Sum Subarrays
Largest Subarray with Sum 0
Subarray Sums Divisible by K
Contiguous Array (equal 0s and 1s)
Binary Subarrays With Sum
Longest Well-Performing Interval
🏁 One-Line Summary

If the question is about contiguous subarrays and sum-related conditions, think Prefix Sum + HashMap.

Longest → store earliest index.

Count → store frequency.

Positive only → sliding window may be simpler and faster.
 */