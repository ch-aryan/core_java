package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;
/*
Equal Point in Brackets
Difficulty: EasyAccuracy: 40.8%Submissions: 39K+Points: 2
Given a string s of opening and closing brackets '(' and ')' only, find an equal point in the string. An equal point is a position k (0-based) such that the number of opening brackets before position k is equal to the number of closing brackets from position k to the end of the string. If multiple such points exist, return the first valid position.

The string can be split at any position from 0 to n, where n is the length of the string.
If we split at 0, it means there is an empty string on left.
If we split at n, it means there is an empty string on right.
Examples:

Input: s = "(())))("
Output: 4
Explanation:
 */
public class StringOpenCloseBrackets {
    public static int bruteForce(String str){
        int n = str.length();
        for(int i =0; i<=n;i++){
            int opnB = 0;
            int clsB = 0;
            for(int j = 0; j<i;j++){
                if(str.charAt(j) == '('){
                    opnB++;
                }
            }
            for(int k=i; k<n;k++){
                if(str.charAt(k) == ')'){
                    clsB++;
                }
            }
            if(opnB == clsB){
                return i;
            }
        }
        return -1;
    }
    public static int better(String s){

                int n = s.length();

                int[] rightClose = new int[n + 1];

                for (int i = n - 1; i >= 0; i--) {
                    rightClose[i] = rightClose[i + 1];

                    if (s.charAt(i) == ')') {
                        rightClose[i]++;
                    }
                }

                int openLeft = 0;

                for (int k = 0; k <= n; k++) {

                    if (openLeft == rightClose[k]) {
                        return k;
                    }

                    if (k < n && s.charAt(k) == '(') {
                        openLeft++;
                    }
                }

                return -1;
            }
        public static int Optimal(String str){
        int n = str.length();
        int openC = 0 ;
        int closeC = 0;
        for(int i =0; i<n;i++){
            if(str.charAt(i) == ')'){
                closeC++;
            }
        }
        for(int i=0; i<=n;i++){

            if(openC == closeC){
                return i;
            }

            if(i<n){
                if(str.charAt(i) == '('){
                    openC++;
                }else{
                    closeC--;
                }
            }
        }
        return -1;
        }


    public static void main(String[] args) {
        String str = "(())))(";
        int i = bruteForce(str);
        System.out.println(i);
        System.out.println(better(str));
        System.out.println(Optimal(str));
        System.out.println(Optimal("))"));
    }
}
/*
Ahh, now I see the confusion. The screenshot clarifies it.

The cut position is **k = 4**, not **after index 4**.

Let's carefully understand what "position k" means.

---

## String

```text
Index : 0 1 2 3 4 5 6
Chars : ( ( ) ) ) ) (
```

The valid cut is:

```text
( ( ) ) | ) ) (
        ^
        k = 4
```

Notice:

* Left side contains indices **0,1,2,3**
* Right side starts from index **4**

---

## What the problem asks

For a position `k`:

```text
Opening brackets BEFORE position k
=
Closing brackets FROM position k TO END
```

### Before position 4

Indices considered:

```text
0 1 2 3
```

Substring:

```text
(())
```

Count `'('`:

```text
2
```

---

### From position 4 to end

Indices considered:

```text
4 5 6
```

Substring:

```text
))(
```

Count `')'`:

```text
2
```

---

Therefore:

```text
Opening before 4 = 2
Closing from 4 onwards = 2
```

So answer:

```text
4
```

---

## Why you got confused

Earlier I was discussing cuts like:

```text
( | ())))(
```

which means:

```text
k = 1
```

because the cut is after index 0.

In this problem:

```text
k
```

is not an index of a character.

It is a **split position**.

There are actually `n+1` possible split positions.

For a string of length 7:

```text
| ( ( ) ) ) ) (
0

( | ( ) ) ) ) (
1

( ( | ) ) ) ) (
2

( ( ) | ) ) ) (
3

( ( ) ) | ) ) (
4

( ( ) ) ) | ) (
5

( ( ) ) ) ) | (
6

( ( ) ) ) ) ( |
7
```

Notice there are positions:

```text
0,1,2,3,4,5,6,7
```

even though indices are only:

```text
0,1,2,3,4,5,6
```

That's the key idea.

---

Now let's think about the optimized solution.

At position `k`:

```text
opening before k
=
total opening brackets - opening from k onwards
```

and

```text
closing from k onwards
```

Instead of recounting both sides for every `k`, we can maintain counts while traversing once.

Before I jump into the O(n) solution, tell me:

If

```text
s = "))"
```

can you list all 3 possible split positions (`0,1,2`) and calculate:

```text
opening before k
closing from k onwards
```

for each one? That exercise usually makes the definition crystal clear.

 */