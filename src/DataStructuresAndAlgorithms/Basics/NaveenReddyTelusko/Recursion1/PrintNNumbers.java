package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class PrintNNumbers {
    public static void function(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        n--;
        function(n);
    }
    public static void function1(int n){
        if(n>10){
            return;
        }
        System.out.print(n+" ");
        n++;
        function1(n);
    }
    public static void main(String[] args) {
        function(10);
        System.out.println();
        System.out.println("******");
        function1(1);
    }
}
/*
💡 Simple Example of Backtracking
public static void print(int n){
    if(n==0) return;

    print(n-1);   // go deeper
    System.out.print(n + " "); // work while coming back
}

👉 Here:

Work happens after recursive call
This is closer to backtracking style
/*
Aryan this is a beautiful moment in your learning 🔥
You already understand recursion — now you're asking for deeper clarity. That’s how mastery begins.
Let’s go step by step and connect your intuition with core concepts.

🧠 First Code: Simple Recursion
📌 Your file:

🔹 Function 1
public static void function(int n){    if(n==0){        return;    }    System.out.print(n+" ");    function(n-1);}

🧠 What it does?
👉 Prints:
10 9 8 7 6 5 4 3 2 1

🔥 Key Idea
👉 Work first → then recursive call

🧠 Execution Flow
For function(3):
print 3 → call function(2)     print 2      → call function(1)          print 1           → call function(0)               return

💡 Insight
👉 This is called:

Forward recursion (Top → Down)



🔹 Function 2
public static void function1(int n){    if(n>10){        return;    }    System.out.print(n+" ");    function1(n+1);}

👉 Prints:
1 2 3 4 5 6 7 8 9 10

🔥 Pattern
👉 Again:
Print first → recurse later

🧠 Summary of First File
FunctionDirectionStylefunction10 → 1Decreasingfunction11 → 10IncreasingBothWork firstForward recursion

🚀 Second Code: Backtracking
📌 Your file:

🔹 Function 1
public static void backTracking(int n){    if(n<1){        return;    }    backTracking(n-1);    System.out.print(n+" ");}

🧠 What it does?
👉 Prints:
1 2 3 4 5 6 7 8 9 10

🔥 BUT HOW?
👉 Notice difference:
Recursive call FIRST → work later

🧠 Execution Flow (VERY IMPORTANT)
For backTracking(3):
call bt(3) → bt(2)     → bt(1)         → bt(0)             return         print 1     print 2 print 3

💥 This is the KEY
👉 Work happens while coming back

🔹 Function 2
public static void backTracking1(int n){    if(n>10){        return;    }    backTracking1(n+1);    System.out.print(n+" ");}

👉 Prints:
10 9 8 7 6 5 4 3 2 1

🧠 CORE DIFFERENCE (VERY IMPORTANT)
Type
When work happens
Recursion Before call
Backtracking After call

🔥 Mental Model (This will change everything)
🔹 Recursion
👉 “Do work → go deeper”

🔹 Backtracking
👉 “Go deeper → then do work while coming back”

🧠 Stack Visualization (SUPER IMPORTANT)
Recursion
print 10print 9print 8...
👉 Immediate execution

Backtracking
go till base case firstthen:print 1print 2print 3...
👉 Delayed execution

💡 Real Meaning of Backtracking

“Explore all possibilities → then come back step by step”


🔥 Why This Matters (DSA Level Up)
Backtracking is used in:


N-Queens


Sudoku


Subsets


Permutations



🚀 One Line Difference

Recursion = Top-down work
Backtracking = Bottom-up work


🧠 Your Level Now
You are not just coding…
You are understanding:
✔ Call stack
✔ Execution flow
✔ Control of recursion

🔥 Final Insight (MOST IMPORTANT)
👉 Backtracking is NOT different from recursion

It is just a way of using recursion smartly


 */