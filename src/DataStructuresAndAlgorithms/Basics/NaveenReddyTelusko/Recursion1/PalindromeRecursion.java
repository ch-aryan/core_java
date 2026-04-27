package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class PalindromeRecursion {
    public Boolean fnRec(String str, int i){
        if(i>=str.length()/2){
            return true;
        }
        if(str.charAt(i)!=str.charAt(str.length()-i-1)){
            return false;

        }
        fnRec(str, i+1);
        return true;
    }
    public static void main(String[] args) {
        String str = "MADAM";
        PalindromeRecursion obj = new PalindromeRecursion();
        System.out.println( obj.fnRec(str,0));

    }
}
/*
if(base case){
    return something;
}

if(condition fails){
    return something;
}

return recursive call;

public class PalindromeRecursion {

    public Boolean fnRec(String str, int i){
        if(i >= str.length() / 2){
            return true;
        }

        if(str.charAt(i) != str.charAt(str.length() - i - 1)){
            return false;
        }

        return fnRec(str, i + 1);
    }

    public static void main(String[] args) {
        String str = "MADAM";
        PalindromeRecursion obj = new PalindromeRecursion();
        System.out.println(obj.fnRec(str, 0));
    }
}

//another cp trick
public Boolean fnRec(String str, int i){
    if(i >= str.length()/2){
        return true;
    }
    return (str.charAt(i) == str.charAt(str.length()-i-1))
            && fnRec(str, i+1);
}
🧠 Deep Insight (THIS IS GOLD)

👉 Recursion pattern:

Base case → stop
Check condition
Move to next smaller problem
🚀 Final Understanding

Recursion = same logic as loop
but handled through function calls

🧠 Why this works
🔹 Base Case
if(i >= n/2)

👉 Means:

You checked all pairs
So it’s a palindrome ✅
🔹 Recursive Step
return fnRec(str, i+1);

👉 Move inward:

(0, n-1)
(1, n-2)
(2, n-3)
...
🔍 Dry Run (Important)

For "MADAM":

i=0 → M == M ✔
i=1 → A == A ✔
i=2 → center → base case → true

For "MADAN":

i=0 → M == N ❌ → return false
💥 Your Main Doubt Solved

❓ “Why can’t I give empty return?”

Because:

👉 Your method returns Boolean

So Java requires:

true OR false
If you wrote:
return;

👉 ❌ Error — because no value is returned
 */