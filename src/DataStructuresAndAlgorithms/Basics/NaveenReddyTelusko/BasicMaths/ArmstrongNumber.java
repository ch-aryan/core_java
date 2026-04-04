package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class ArmstrongNumber {
   //my own logic
        public boolean isArmstrong(int n) {
            int number = n;
            int number1 = n;
            int num =0;
            int rev = 0;
            int count =0;
            while(number >0){
                number = number / 10;
                count ++;
            }
            while(number1 > 0){

                num = number1 % 10;
                number1 = number1 / 10;

                rev = rev +(int) Math.pow(num, count);
            }
            if (rev == n){
                return true;
            }
            return false;

    }
    //AI logic.
    public boolean isArmstrong1(int n) {
        int number = n;
        int number1 = n;
        int num = 0;
        int sum = 0;
        int count = 0;

        // Count digits
        while (number > 0) {
            number = number / 10;
            count++;
        }

        // Calculate sum of powers
        while (number1 > 0) {
            num = number1 % 10;
            number1 = number1 / 10;
            sum += (int) Math.pow(num, count);
        }

        return sum == n;
    }

    public static void main(String[] args) {
        //153 is armstrong number because n = 3. and 1 cube + 5 cube + 3 cube = 153.
    }
}
//optimization code without using Math.pow fucntion.
class Solution {
    public boolean isArmstrong(int n) {
        int original = n;
        int temp = n;
        int count = 0;

        // Count digits
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        temp = n;
        int sum = 0;

        // Process each digit
        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;

            // Compute digit^count manually
            int power = 1;
            for (int i = 0; i < count; i++) {
                power *= digit;
            }

            sum += power;
        }

        return sum == original;
    }
}
/* ✅ 1. Is your code brute force?

👉 Yes — your approach is brute force (but acceptable)

Why?
You:
Count digits → O(d)
Traverse digits again → O(d)
Use Math.pow() inside loop

👉 Overall complexity:

𝑂
(
𝑑
)
O(d)

(where d = number of digits)

💡 That’s already efficient for this problem (since digits ≤ 10 for int)

⚠️ But interview issue is NOT complexity

The real issue is:

👉 Math.pow() uses floating point operations (double)
👉 It’s slower + can cause precision issues

🔥 2. Optimized version (without Math.pow())

We manually compute power using loop (pure integer math).
🚀 Why this is better?
❌ Old way
Math.pow(num, count)
Uses double
Slower
Precision risk
✅ New way
power *= digit;
Pure integer
Faster
Interview-friendly
⚡ Bonus: Even more optimized (for repeated queries)

If you check many numbers:

👉 Precompute powers:

int[][] power = new int[10][11];

But for interviews → not needed unless asked

🧠 Final Interview Answer (IMPORTANT)

If interviewer asks:

👉 “Can you optimize this?”

You say:

“Yes, instead of using Math.pow() which uses floating point operations, I can compute power using integer multiplication inside a loop to improve performance and avoid precision issues.”

🔥 This line alone gives strong impression.

💯 Final Verdict on YOU
Logic → ✅ Correct
Thinking → ✅ Strong
Optimization awareness → 🔥 Improving (this is what matters)
 */