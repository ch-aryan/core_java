package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class FibonacciRecursion {
    public static int  methFib(int n){
        if(n==0) return 0;
        if(n==1) return 1;

      int res =  methFib(n-1) + methFib(n-2);
        System.out.print(res+" ");
      return res;
    }

    public static void main(String[] args) {
        System.out.println(methFib(8));
    }
}
/*
🌳 Recursion Call Tree for fibonacci(4)
fibo(4)
├── fibo(3)
│   ├── fibo(2)
│   │   ├── fibo(1) → 1
        │   │   └── fibo(0) → 0
        │   │   → returns 1
        │   └── fibo(1) → 1
        │   → returns 2
        └── fibo(2)
    ├── fibo(1) → 1
        └── fibo(0) → 0
        → returns 1

Final: fibo(4) = 2 + 1 = 3
        📦 Call Stack Flow (Step-by-step thinking)
fibo(4) waits for:
fibo(3)
fibo(2)
fibo(3) waits for:
fibo(2)
fibo(1)
fibo(2) waits for:
fibo(1) ✅
fibo(0) ✅
Now values start returning bottom → up
🔥 Important Observation (VERY IMPORTANT)

Look carefully:

fibo(2) is calculated twice
fibo(1) is calculated many times

👉 This is why Fibonacci recursion is inefficient (O(2^n))*/
/*
🧠 Core Rule (Golden Thumb Rule)

👉 Use recursion when the problem naturally breaks into smaller same-type problems
👉 Use loops when you are just iterating linearly

🔁 When to USE Recursion ✅

Use recursion if you see:

        1. Problem = smaller version of itself
Fibonacci → f(n) = f(n-1) + f(n-2)
Factorial → n * factorial(n-1)

👉 Same function calling itself with smaller input

2. Tree / branching structure
Tree traversal (DFS)
Backtracking (permutations, subsets)
Divide & Conquer (Merge Sort)

👉 One call → multiple recursive calls

3. You don’t know number of steps beforehand
Exploring all possibilities
Maze problems
Combinations

👉 Depth is dynamic

4. Backtracking problems
N-Queens
        Sudoku
Permutations

👉 Try → recurse → undo

🔁 When to AVOID Recursion ❌
        1. Simple iteration problem
Print 1 to n
Sum of array
Find max/min

👉 Loop is cleaner + faster

2. Repeated calculations (like Fibonacci)
Without memoization → exponential time

👉 Avoid naive recursion

3. Stack overflow risk
Very deep recursion (large n)

👉 Java stack is limited

🔄 When to USE Loops ✅
        1. Sequential processing
Arrays
        Strings
Sliding window
Two pointers

👉 Straight-line movement

2. No branching
Only one path forward
3. Performance matters
Loops = O(n)
Recursion = extra stack overhead
⚖️ Quick Decision Trick (Use this in exams/interviews)

Ask yourself:

        ❓ “Am I breaking the problem into smaller same problems?”
YES → Recursion ✅
NO → Loop ✅
        🔥 Real Examples (Super Important)
Problem	Best Approach
Fibonacci	Recursion (with DP)
Factorial	Both
Array traversal	Loop
Permutations	Recursion
Binary Tree DFS	Recursion
Sliding Window	Loop
🧠 Your Level Insight (important for YOU)

        Right now, your goal should be:

        👉 Learn recursion deeply (for DSA + interviews)
👉 But in real coding → prefer loops when simple

⚡ One-line Summary

👉 Recursion = thinking tool
👉 Loop = execution tool */