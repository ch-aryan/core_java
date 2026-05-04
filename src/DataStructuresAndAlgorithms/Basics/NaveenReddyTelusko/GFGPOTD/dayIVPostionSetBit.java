package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD;

public class dayIVPostionSetBit {
    public static int methodPT(int n){
        if(n<=1) return -1;
        int count = 1;
        while(n > 1){
            if(n % 2 !=0) return -1;
            n = n / 2;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(methodPT(n));

        int n1 = 10;
        System.out.println(methodPT(n1));
    }
}
/*
Position of the Set Bit
Difficulty: BasicAccuracy: 49.62%Submissions: 85K+Points: 1
Given an integer n, determine position of the only set bit (1) in its binary representation. The position is counted starting from 1 at the least significant bit (LSB).

If n contains exactly one set bit, return its position.
If n contains no set bits or more than one set bit, return -1.
Examples:

Input: n = 2
Output: 2
Explanation: 2 is represented as "10" in binary. It has only one set bit, which is at position 2.
Input: n = 5
Output: -1
Explanation: 5 is represented as "101" in binary. It has two set bits; therefore, the output is -1.

👉 “Perfect square” is the wrong direction.
What you actually discovered is close to:

Numbers with exactly one set bit are powers of 2, not perfect squares.

🔥 Important clarity
Number	Binary	Set bits	Type
2	10	1	✅ power of 2
4	100	1	✅ power of 2
8	1000	1	✅ power of 2
9	1001	2	❌ perfect square but NOT valid

👉 So your intuition was close, but:

❌ Perfect square → wrong
✅ Power of 2 → correct
🧠 Can you solve WITHOUT bit manipulation? YES ✅
Step 1: Check if number is power of 2

Using division:

while (n % 2 == 0) {
    n = n / 2;
}

👉 After this:

If n == 1 → only one set bit
Else → multiple bits → return -1
Step 2: Find position

Count how many times you divided:

int pos = 1;

while (n > 1) {
    if (n % 2 != 0) return -1; // not power of 2
    n = n / 2;
    pos++;
}
✅ Final Code (your approach, no bit tricks)
class Solution {
    static int findPosition(int n) {
        if (n <= 0) return -1;

        int pos = 1;

        while (n > 1) {
            if (n % 2 != 0) return -1; // more than one set bit
            n = n / 2;
            pos++;
        }

        return pos;
    }
}
💡 Example:
n = 8

8 → 4 → 2 → 1
pos = 4

Binary: 1000 → position = 4 ✅
⚠️ Why your "perfect square" idea fails:
16 → works (but coincidence, it’s also 2⁴)
9 → fails (1001 → 2 bits ❌)
25 → fails ❌
🏆 Clean understanding:

👉 “Exactly one set bit” = power of 2
👉 You can solve it using:

Division (what you know ✅)
Bit manipulation (later 🚀)
 */