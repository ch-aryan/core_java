package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class LCMANDGCD {
    public static int lcm(int [] arr){
    int currLcm =arr[0];
    for(int i =1;i<arr.length;i++){
        currLcm = lcmOfTwoN(currLcm,arr[i]);
    }
       return currLcm;
    }

    public static int lcmOfTwoN(int one , int two){
        int res = (one * two)/gcd(one , two);
        return res;
    }

    public static int gcd(int a , int b){
        int remainder = 0;
        while(b != 0){
             remainder = a %b;
            a = b;
            b = remainder;
        }
        return a;
    }


    public static void main(String[] args) {
        int [] arr = {2,4,6,8};
        int[] arr1 = {19,18,17};
        System.out.println(gcd(48,12));
        System.out.println(lcmOfTwoN(24,36));

        System.out.println(lcm(arr));
        System.out.println(lcm(arr1));
    }
}
/*
class GCDExample {

    static int gcd(int a, int b) {

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    public static void main(String[] args) {

        int result = gcd(48, 18);
        System.out.println("GCD = " + result);

    }
}

Yes ✅ Euclid’s Algorithm comes under basic mathematics
(and also very important in programming + DSA + competitive coding + interviews).

⭐ What is Euclid’s Algorithm (in simple words)

👉 It is a method to find the HCF / GCD of two numbers.

HCF → Highest Common Factor
GCD → Greatest Common Divisor

Both mean same thing.

👉 Example:
Numbers = 12 and 18

Factors of 12 → 1, 2, 3, 4, 6, 12
Factors of 18 → 1, 2, 3, 6, 9, 18

Common factors → 1, 2, 3, 6

⭐ Highest = 6
So GCD = 6

⭐ Problem with normal method

If numbers are very big like:

👉 987654 and 123456

Finding all factors becomes very slow and difficult.

So mathematician Euclid gave a smart method.

⭐ Core Idea of Euclid Algorithm

👉 GCD(a , b) = GCD(b , a % b)

Means:

Divide bigger number by smaller number
Take remainder
Repeat process
When remainder becomes 0
👉 the divisor at that step is the GCD
⭐ Step-by-Step Example

Find GCD of 48 and 18

Step-1

48 ÷ 18

Remainder = 12

👉 Now problem becomes
GCD(18 , 12)

Step-2

18 ÷ 12

Remainder = 6

👉 Now problem becomes
GCD(12 , 6)

Step-3

12 ÷ 6

Remainder = 0

👉 STOP

⭐ Answer = 6

⭐ Why this is VERY important in programming

This algorithm is:

✅ Very fast
✅ Used in recursion problems
✅ Used in number theory
✅ Used in cryptography
✅ Asked in coding interviews
✅ Helps in fraction simplification
✅ Used in LCM calculation

⭐ Java code (very basic)
static int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}
⭐ Super simple memory trick

👉 “Divide → take remainder → swap → repeat → remainder 0 → answer”

That’s all 🙂

If you want, next I can teach you
🔥 Euclid algorithm dry run + recursion stack visualization
After that you will NEVER forget it in life.
 */

/*
how to find the lcm .
To find the LCM (Least Common Multiple) of two numbers like 24 and 36, the best and most efficient way is:

LCM = (a × b) / GCD(a, b)

Where:

a = 24
b = 36
GCD = 12

So:

LCM(24,36)=
12
24×36
	​

=72

Step 1: Find GCD

The GCD (Greatest Common Divisor) can be found using the Euclidean algorithm.

while (b != 0) {
    int temp = b;
    b = a % b;
    a = temp;
}

After this loop, a will contain the GCD.

Complete Java Code
public class Main {

    // Method to find GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to find LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 36;

        System.out.println("LCM = " + lcm(a, b));
    }
}
Output
LCM = 72
Simple Explanation

For 24 and 36:

Factors of 24

24, 48, 72, 96, ...

Factors of 36

36, 72, 108, ...

The first common multiple is 72, so LCM = 72.

Important Formula to Remember

LCM(a,b)=
GCD(a,b)
a×b
	​


Interview Tip

When asked to find LCM in coding interviews or DSA problems:

First find GCD.
Use the formula above.
Time complexity: O(log(min(a, b)))

This is the standard and optimal approach used in competitive programming and interviews.
 */