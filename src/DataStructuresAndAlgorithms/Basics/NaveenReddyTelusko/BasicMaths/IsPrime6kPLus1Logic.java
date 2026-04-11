package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

import java.util.Scanner;

public class IsPrime6kPLus1Logic {
    public static Boolean prime6kLogic(int n ){
        if(n<1) return false;
        if(n<=3) return true;
        if(n % 2 ==0 || n % 3 ==0){
            return false;
        }

        for(int i=5;i*i <=n ; i+=6){
            if(n% i == 0 || n % (i+2) ==0){
                return false;
            }
        }
        return true;
    }
    public static void printAllPrimesInRange(int n){
        for(int i = 0; i<=n;i ++){
            if(prime6kLogic(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number which you want to check the prime upto");//100
        int n = in.nextInt();
        printAllPrimesInRange(n);

    }
}
/*
Good observation 👀 — you’re thinking like a real programmer now.

👉 Your statement is correct:
6k ± 1 rule is NOT perfect for identifying primes.

🔴 Why 25 breaks your understanding

Take 25:

👉 25 = 6×4 + 1 → fits 6k + 1 form ✅
👉 But 25 = 5 × 5 → NOT prime ❌

So yes — your doubt is valid.

💡 Important Truth (THIS is the key concept)

👉 6k ± 1 is NOT a prime test
👉 It is only a filter (candidate generator)

🧠 Think like this

All primes > 3 are of form:

👉 6k − 1 or 6k + 1 ✅

BUT…

❗ Not all numbers of this form are prime

🔍 Example to make it crystal clear

Numbers of form 6k ± 1:

5 ✅ prime
7 ✅ prime
11 ✅ prime
13 ✅ prime
17 ✅ prime
19 ✅ prime
23 ✅ prime
25 ❌ not prime
35 ❌ not prime (5×7)

👉 So this rule gives possible primes, not guaranteed primes.

🔧 Why your code still works for 25

Let’s dry run your code:

n = 25

Step-by-step:

Not ≤ 3
Not divisible by 2 or 3
Enter loop:

👉 i = 5

Check:

25 % 5 == 0  → TRUE

👉 Immediately returns false

✔️ So your code correctly identifies 25 as NOT prime

🚀 Real meaning of your loop
for(int i = 5; i*i <= n; i += 6)

You are checking:

👉 5, 7
👉 11, 13
👉 17, 19
👉 ...

So even though 25 fits 6k+1,
you still check divisibility by 5 → caught!

🎯 Final Understanding (VERY IMPORTANT)

👉 6k ± 1 rule = Optimization technique
👉 NOT = Prime guarantee

🧠 Developer mindset takeaway

Think like this:

“I don’t need to check all numbers…
I only check numbers that can possibly divide n.”

That’s why:

We skip multiples of 2 and 3
We only test smart candidates
But we STILL verify divisibility
⚡ One-line conclusion

👉 All primes follow 6k ± 1
👉 But not all 6k ± 1 numbers are prime
 */
/* ⭐ The powerful idea: 6k ± 1 Rule

After understanding √n logic, mathematicians observed something interesting:

👉 Every prime number greater than 3 can be written in the form

⭐ 6k − 1 or 6k + 1

(where k is an integer)

✅ First see the pattern

All integers can be written as:

6k

6k + 1

6k + 2

6k + 3

6k + 4

6k + 5

Now check divisibility:

6k → divisible by 6 → not prime

6k + 2 → even → not prime

6k + 3 → divisible by 3 → not prime

6k + 4 → even → not prime

Only possibilities left:

⭐ 6k + 1
⭐ 6k + 5 (which is same as 6k − 1)

Example primes:

5 → 6(1) − 1
7 → 6(1) + 1
11 → 6(2) − 1
13 → 6(2) + 1
17 → 6(3) − 1
19 → 6(3) + 1

See the pattern 🙂

⭐ Why this helps in coding

Normally in √n method we check:

👉 2, 3, 4, 5, 6, 7, 8, 9 …

But many numbers are useless checks.

Using 6k ± 1:

👉 We skip all multiples of 2 and 3
👉 We check far fewer numbers

So algorithm becomes faster

⭐ Optimized Prime Check Code (Interview Level)
static boolean isPrime(int n) {

    if (n <= 1) return false;
    if (n <= 3) return true;

    if (n % 2 == 0 || n % 3 == 0)
        return false;

    for (int i = 5; i * i <= n; i += 6) {

        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }

    return true;
}

⭐ How loop works here

Loop values of i become:

👉 5, 11, 17, 23, 29 …

And we also check:

👉 i + 2 → 7, 13, 19, 25, 31 …

So effectively checking:

⭐ 6k − 1 and 6k + 1

Very smart filtering.

⭐ Complexity

Still O(√n)
But constant factor reduced → faster in real execution.

This is called mathematical optimization.

⭐ Developer mindset takeaway

Strong programmers don’t just code.
They ask:

👉 “Which numbers are even worth checking?”

This thinking leads to optimizations like this.⭐ Step-1
if (n <= 1) return false;


Numbers 0, 1, negative numbers are NOT prime.
So immediately reject.

⭐ Step-2
if (n <= 3) return true;


Numbers 2 and 3 are prime.
So accept early and stop further checking.

This saves time.

⭐ Step-3
if (n % 2 == 0 || n % 3 == 0)
    return false;


Now we remove most useless numbers quickly.

If number divisible by:

2 → even → not prime

3 → multiple of 3 → not prime

Example:

👉 100 → divisible by 2 → stop
👉 99 → divisible by 3 → stop

So we filtered many numbers already.

⭐ Step-4 (Main smart loop)
for (int i = 5; i * i <= n; i += 6)


This line is the core trick.

Why start from 5 ?

Because:

2 already checked

3 already checked

next possible prime pattern → 5

Why i += 6 ?

Because primes (after 3) appear near:

⭐ 6k − 1 and 6k + 1

So values of i become:

i = 5

i = 11

i = 17

i = 23

i = 29

Each step jump by 6

⭐ Step-5 (very important line)
if (n % i == 0 || n % (i + 2) == 0)


This means:

For each step we check two numbers

Example first loop:

i = 5 → check divisor 5

i + 2 = 7 → check divisor 7

Next loop:

i = 11 → check 11

i + 2 = 13 → check 13

Next:

17 and 19

So effectively we are checking:

⭐ 6k − 1 and 6k + 1

⭐ Step-6
return true;


If loop finishes without finding divisor →
number is prime.

⭐ Let us dry run once (very important)

Check n = 29

n <= 1 → no

n <= 3 → no

divisible by 2 or 3 → no

Loop start:

i = 5

👉 check √29 ≈ 5.38
So only one loop iteration.

Check:

29 % 5 → not zero
29 % 7 → not zero

Loop ends

👉 return true

So 29 is prime ✔

⭐ Simple mental picture

Instead of checking:

2,3,4,5,6,7,8,9,10,11,12…

We check only:

2,3,5,7,11,13,17,19…

So code is just smart skipping logic
*  */