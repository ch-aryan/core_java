package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;

import java.util.ArrayList;

public class PascalTriangle {
    //the first question is print the element given the row and column in the given
    // so we use the formula.
    public static int nCRFormulaCode(int n, int r) {
                    //void
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = (res * (n - i)) / (i + 1);
        }
//        System.out.print(res+" ");
        return res;
    }
    //Q2 given the nth row print all the elements of the pascal triangle of that row and column.
    public static void printRowPascal(int n){
        //we know that n rows have n elements. O(N^2).
        //so call the each element by passing to the function in the forloop.
        for(int c=0;c<n; c++){
            nCRFormulaCode(n-1, c);
        }
    }
    //optimal for printingRow
    public static void printRowPascal1(int n){
        int res = 1;
        System.out.print(res+" "); //tc : O(n)
        for(int i=1;i<n;i++){
            res *= n - i ;
            res = res/i;
            System.out.print(res+" ");

        }
        System.out.println();
    }

    public static ArrayList<Integer> printRowPascal2(int n){
        int res = 1;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1); //tc : O(n)
        for(int i=1;i<n;i++){
            res *= n - i ;//instead of this two lines. res = res * (n - i) / i;
            res = res/i;
            result.add(res);
        }
        return result;
    }
    //bruteforce.
    public static void pascalTrianglePrint(int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j=0;j<=i;j++){
                temp.add(nCRFormulaCode(i,j));
            }
            res.add(temp);
        }
        System.out.print(res+" ");
        System.out.println();

    }
    //optimal using the 2nd quesiton optimal approach printpascalrow1.
    public static void pascalTrianglePrint1(int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();



        for(int i=1;i<=n;i++) {

            ArrayList<Integer> temp = printRowPascal2(i); // 👈 calling your function
            //this is fine the above fine but
            //we can also do it like this.  res.add(printRowPascal2(i)); without creating temp list.
            res.add(temp);
        }


        System.out.print(res+" ");

    }



        public static void main(String[] args) {
            int n = 10; int r = 3;
           nCRFormulaCode(n, r);
            System.out.println();
           printRowPascal(5);
            System.out.println();
            printRowPascal1(6);

            //bruteforce function call for the pascal Triangle.
            pascalTrianglePrint(6); //tc O(n^3).

            System.out.println("*************");
            //optimial approach.
            pascalTrianglePrint1(5);

    }
}
/* 📘
📘 1. First, understand your function
public static ArrayList<Integer> printRowPascal2(int n)

👉 This returns one row of Pascal Triangle
👉 Example:

printRowPascal2(1) → [1]
printRowPascal2(2) → [1, 1]
printRowPascal2(3) → [1, 2, 1]
✅ 2. What you want to do

Inside this function:

public static void pascalTrianglePrint1(int n)

👉 You want:

Call printRowPascal2(i)
Add each row to res
❌ 3. Your current mistake

You wrote:

ArrayList<Integer> temp = new ArrayList<>();

for(int i=1;i<=n;i++) {
    int
    temp.add()
}

👉 Problems:

temp should NOT be reused like this
You need to get full row from function
You're trying to manually fill instead of calling function
✅ 4. Correct Approach
public static void pascalTrianglePrint1(int n){
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    for(int i = 1; i <= n; i++) {
        ArrayList<Integer> temp = printRowPascal2(i); // 👈 calling your function
        res.add(temp); // 👈 adding entire row
    }

    System.out.println(res);
}
🧠 5. What Happens Step-by-Step

For n = 5:

i	function call	result
1	printRowPascal2(1)	[1]
2	printRowPascal2(2)	[1,1]
3	printRowPascal2(3)	[1,2,1]
4	printRowPascal2(4)	[1,3,3,1]
5	printRowPascal2(5)	[1,4,6,4,1]

👉 Final res:

[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]
⚠️ 6. Important Concept (VERY IMPORTANT)

👉 Here we use:

res.add(temp);

NOT:

res.addAll(temp); ❌

Because:

res is list of lists
So we add entire row as one element
🔥 7. Small Improvement (Optional Optimization)

Your function:

res *= n - i;
res = res / i;

Better (safer order):

res = res * (n - i) / i;
🎯 8. Final Clean Code
public static ArrayList<Integer> printRowPascal2(int n){
    int res = 1;
    ArrayList<Integer> result = new ArrayList<>();
    result.add(1);

    for(int i = 1; i < n; i++){
        res = res * (n - i) / i;
        result.add(res);
    }
    return result;
}

public static void pascalTrianglePrint1(int n){
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    for(int i = 1; i <= n; i++) {
        res.add(printRowPascal2(i));
    }

    System.out.println(res);
}
🧠 9. One-Line Revision

👉 Call the function that returns a row and directly add it to the result list using res.add().
1. What this line actually means
ArrayList<Integer> temp = printRowPascal2(i);

👉 This is just two steps combined into one line:

🔹 Step-by-step (expanded version)
ArrayList<Integer> temp;      // 1. declare variable
temp = printRowPascal2(i);    // 2. call function and assign result

👉 That’s it. Nothing magical.

✅ 2. Why we combine them

Java allows us to write both steps together:

ArrayList<Integer> temp = printRowPascal2(i);

👉 This is just shorter and cleaner code

🧠 3. What happens in memory

When this runs:

ArrayList<Integer> temp = printRowPascal2(i);

👉 Flow:

printRowPascal2(i) executes
It creates an ArrayList → [1, 2, 1] (for example)
That list is returned
temp now points to that list
🔥 4. Think of it like this (real-life analogy)

👉 Imagine:

Function = factory
Return value = product
ArrayList<Integer> temp = printRowPascal2(i);

👉 Means:

“Go to factory, get the product, and store it in temp”

⚠️ 5. Important Rule

This only works because your function has:

return result;

👉 If function was:

void printRowPascal2(int n)

❌ Then this would NOT work

🧪 6. Another Simple Example
public static int getNumber() {
    return 5;
}

You can do:

int x = getNumber();  // same concept
🔄 7. Even Shorter (Direct Use)

You don’t even need temp:

res.add(printRowPascal2(i));

👉 This means:

Call function
Directly add result into res
⚡ 8. When to use temp variable?

Use temp when:

You want to debug
You want to print intermediate values
You need to modify before adding
🎯 9. One-Line Revision

👉 You can declare a variable and assign a function’s return value in the same line—it’s just shorthand for two steps.

 */