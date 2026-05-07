package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

public class dayVIISumOfXorAllPairs {
    //i did it using the two for loops bruteforce but all test cases are not passed.

        public long sumXOR(int[] arr) {
           //  code here
            if(arr.length <=1){
                return 0; }
            int sum = 0; int n = arr.length;
            for(int i=0;i<n-1;i++){
                for(int j =i+1;j<n;j++){
                    sum = sum + (arr[i] ^ arr[j] );
                } }
            return sum; }
}

/*
❌ Why your HashMap idea is wrong

Prefix XOR works when:

You want subarrays
You care about XOR equality (like XOR = k)

But here:

You need all pairs (i, j)
You need sum of XOR values, not count

👉 So this approach won’t work even if you fix syntax.

✅ Optimal Idea (Bit Manipulation)

Instead of checking all pairs, think bit by bit.

Key Insight:

For each bit position:

Count how many numbers have that bit = 1
Count how many have that bit = 0

If:

count1 = number of 1s
count0 = number of 0s

Then:

XOR at that bit contributes 1 only when bits differ
So total pairs contributing = count1 * count0

Contribution from that bit:

count1 * count0 * (1 << bit)
💡 Formula
Total Sum=
bit=0
∑
31
	​

(count1×count0×2
bit
)
✅ Optimized Code (O(n * 32))
need bit manipulation idea to understand this.
class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long totalSum = 0;

        for (int bit = 0; bit < 32; bit++) {
            long count1 = 0;

            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count1++;
                }
            }

            long count0 = n - count1;

            totalSum += count1 * count0 * (1L << bit);
        }

        return totalSum;
    }
}
🧠 Intuition (Very Important)

Let’s say:

arr = [1, 2, 3]

Binary:

1 = 01
2 = 10
3 = 11

At bit 0:

Ones = 2 (1,3)
Zeros = 1 (2)
→ Contribution = 2 × 1 × 1 = 2

At bit 1:

Ones = 2 (2,3)
Zeros = 1 (1)
→ Contribution = 2 × 1 × 2 = 4

Total = 6 ✅

⚡ Complexity Comparison
Approach	Time
Brute Force	O(n²) ❌
Bit Method	O(n * 32) ✅
🔥 Important Learning
Prefix XOR + HashMap → subarrays
Bit counting → pairwise operations
 */