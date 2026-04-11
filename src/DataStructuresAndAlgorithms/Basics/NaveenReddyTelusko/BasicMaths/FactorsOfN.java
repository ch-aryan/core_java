package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class FactorsOfN {
    public static void main(String[] args) {
        int n = 48; // -. Tc O(n)
        for(int i =1;i<=n ; i++){
            if(n % i == 0){
                System.out.println(i);
            }

        }
        for(int i = 1; i<=n/2 ; i++){ //tc -> o(n/2) means n only
            if(n % i == 0 ){
                int q = n / i;
                System.out.println(i);
                System.out.println("the i taken when remainder is zero and q is taken when quotent is exactly the factor for the " +
                        "given number");
                System.out.println(q);
            }
        }
        for(int i=1; i*i < n ; i++){
            if(n % i == 0){

                System.out.println(i);
                if(i != n/i)
                System.out.println(n/i);
            }
        }

    }
}/*
⭐ What your current loop does (till n/2)

This loop is trying to find all factors of a number.

Why n/2?

Because:

        👉 Any number greater than n/2
cannot divide n (except n itself).

Example:
n = 20

n/2 = 10

So loop runs:

        1,2,3,4,5,6,7,8,9,10

This works ✅
You will find factors.

But…

        ⭐ Time complexity = O(n) (almost linear)

Because if n = 1,000,000
loop runs 500,000 times

Very slow.

        ⭐ What happens when you loop till √n

Now consider this idea:

        👉 Factors always come in pairs

Example:
n = 36

Pairs:

        1 × 36
        2 × 18
        3 × 12
        4 × 9
        6 × 6

Notice something important:

        ⭐ After √36 = 6
pairs start repeating.

        So:

        👉 If you check till √n
you automatically know the other factor.

Example:

If i = 3 divides 36
then q = 12

So no need to check 12 again later.

        ⭐ So √n loop version
for(int i = 1; i * i <= n; i++){
        if(n % i == 0){
        System.out.println(i);

        if(i != n / i)
        System.out.println(n / i);
    }
            }

            ⭐ Main Differences (VERY IMPORTANT)
✅ 1. Speed difference

Loop till n/2
        👉 Complexity ≈ O(n)

Loop till √n
👉 Complexity ≈ O(√n)

Huge improvement.

Example:

n = 1,000,000

n/2 loop → 500,000 iterations

√n loop → only 1000 iterations

🔥 This is massive optimization.

        ✅ 2. Mathematical thinking level

Loop till n/2 → brute force thinking
Loop till √n → pair factor observation

Interviewers love √n logic.

        ✅ 3. Real usage

Prime checking → always √n

Factor printing → √n

Perfect number → √n

divisor count → √n

competitive coding → √n mandatory

n/2 approach is rarely used in real coding.

⭐ Simple visual intuition

Imagine factors like mirror pairs around √n

1 —— 36
        2 —— 18
        3 —— 12
        4 —— 9
        6 —— 6   ← center (√n)


After center → everything repeats.

So we stop at √n.*/