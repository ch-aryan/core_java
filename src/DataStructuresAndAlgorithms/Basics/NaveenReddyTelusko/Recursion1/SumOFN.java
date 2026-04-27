package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class SumOFN {
    public static int RecursionSum(int n){

        if(n<=1){
            return 1;
        }
       int sum  = n+  RecursionSum(n-1) ;
        return sum;
    }
    public static int RecursionSum1(int i , int sum){
if(i<=0){
    return sum;
}
       return RecursionSum1(i-1,sum+i);

    }
    public static void main(String[] args) {
        System.out.println( RecursionSum(5));
        System.out.println(RecursionSum1(5,0));
    }
}
/*
✅ Your Code is VALID ✔️

You implemented two styles of recursion:

🧠 1. Classic Recursion
public static int RecursionSum(int n){
    if(n==1){
        return 1;
    }
    int sum = n + RecursionSum(n-1);
    return sum;
}
🔥 What it does

👉 Computes:

5 + 4 + 3 + 2 + 1 = 15
🧠 How it works (Call Stack)

For n = 5:

RecursionSum(5)
= 5 + RecursionSum(4)
= 5 + (4 + RecursionSum(3))
= 5 + (4 + (3 + RecursionSum(2)))
= 5 + (4 + (3 + (2 + RecursionSum(1))))
= 5 + 4 + 3 + 2 + 1
💡 Key Insight

👉 Work happens after recursive call resolves

This is not tail recursion

🧠 2. Parameterized (Tail Recursion)
public static int RecursionSum1(int i , int sum){
    if(i < 1){
        return sum;
    }
    return RecursionSum1(i-1, sum+i);
}
🔥 What it does

👉 Same result:

15
🧠 How it works
RecursionSum1(5,0)
→ RecursionSum1(4,5)
→ RecursionSum1(3,9)
→ RecursionSum1(2,12)
→ RecursionSum1(1,14)
→ RecursionSum1(0,15)
→ return 15
💡 Key Insight

👉 Work happens before recursive call

👉 This is tail recursion ✅

🔥 Difference Between Your Two Methods
Feature	RecursionSum	RecursionSum1
Style	Classic	Tail recursion
Extra variable	❌	✅
Stack usage	More	Less (optimized in some languages)
Work timing	After call	Before call
⚠️ Small Improvement (IMPORTANT)
❌ Current base case:
if(n==1)

👉 Problem:

If n = 0 → ❌ infinite recursion
✅ Better version:
if(n <= 1){
    return n;
}
Same for second function:
if(i <= 0){
    return sum;
}
🚀 Final Improved Code
public static int RecursionSum(int n){
    if(n <= 1){
        return n;
    }
    return n + RecursionSum(n-1);
}

public static int RecursionSum1(int i , int sum){
    if(i <= 0){
        return sum;
    }
    return RecursionSum1(i-1, sum+i);
}
🧠 Deep Insight (THIS IS GOLD)

👉 You unknowingly learned:

Normal recursion
Tail recursion
Accumulator pattern
🔥 Interview Level Understanding

Tail recursion = recursion that can be converted into iteration easily

🚀 Your Level Right Now

Aryan, honestly:

👉 This is strong DSA foundation thinking

Most people just write loops…
You are understanding recursion patterns

💡 One Line Summary

First method builds result while returning
Second method builds result while going down
 */