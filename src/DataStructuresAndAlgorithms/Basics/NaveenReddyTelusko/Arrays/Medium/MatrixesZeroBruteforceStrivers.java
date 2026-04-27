package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class MatrixesZeroBruteforceStrivers {

    public static void methodMinus(int[][] arr ) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i);
                    markCol(arr, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void markRow(int [][] arr, int i){
        for(int a =0;a<arr[0].length; a++){
            if(arr[i][a] != 0){
                arr[i][a] = -1;
            }
        }
    }
    public static void markCol(int [][] arr, int j){
        for(int a =0;a<arr.length; a++){
            if(arr[a][j] != 0){
                arr[a][j] = -1;
            }
        }
    }



    public static void main(String[] args) {
        int arr[][] = {{1,2,3}, {1,0,3}, {1,2,0}};
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }

        System.out.println("*******");

        methodMinus(arr);
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }

    }
}
/*
Great question — this is exactly the kind of doubt that builds real clarity. You’re not ratifying, you’re trying to understand the mapping, which is the right instinct.

Let’s slow it down and make it visual.

🧠 Core Idea (This will remove your confusion)

A matrix is indexed as:

arr[row][col]

👉 First index → row (vertical)
👉 Second index → column (horizontal)

🔵 What does “markRow(i)” mean?

👉 “Fix the row, move across columns”

arr[i][0], arr[i][1], arr[i][2], ..., arr[i][m-1]

So:

for(int a = 0; a < arr[0].length; a++)
a → column index
i → fixed row

✅ This is correct

🔍 Visual (3 × 4 matrix)
[ 1  2  3  4 ]
[ 5  6  7  8 ]
[ 9 10 11 12 ]
markRow(1) → row = 1

We change:

arr[1][0], arr[1][1], arr[1][2], arr[1][3]

👉 Entire row:

[ 5  6  7  8 ]
🔴 What does “markCol(j)” mean?

👉 “Fix the column, move across rows”

arr[0][j], arr[1][j], arr[2][j], ..., arr[n-1][j]

So:

for(int a = 0; a < arr.length; a++)
a → row index
j → fixed column

✅ This is correct

🔍 Visual (3 × 4 matrix)

Same matrix:

[ 1  2  3  4 ]
[ 5  6  7  8 ]
[ 9 10 11 12 ]
markCol(2) → column = 2

We change:

arr[0][2], arr[1][2], arr[2][2]

👉 Entire column:

3, 7, 11
❌ Your Earlier Mistake (Now you’ll see clearly)

You wrote:

arr[j][a]

👉 That means:

treating j as row ❌
treating a as column ❌

This flips the matrix access

🔥 Why It Still Worked for 3×3 (Your doubt)

You said:

“It works for 3×3 but may fail for 3×4”

👉 Exactly correct 👏

Because:

In 3×3:
rows = columns
so swapping indices doesn’t crash
In 3×4:
rows = 3
cols = 4

If you do:

arr[j][a]

👉 Suppose:

j = 3 (column index)
but rows only go till 2

💥 ArrayIndexOutOfBoundsException

🧠 Golden Rule (Memorize this)
✅ Row Traversal
arr[row][col] → row fixed, col changes
✅ Column Traversal
arr[row][col] → col fixed, row changes
💡 Mental Trick (Very Powerful)

Think like this:

Task	Fix	Move
Row	row	column
Column	column	row
🚀 Final Clean Code (Correct)
public static void markRow(int [][] arr, int i){
    for(int a = 0; a < arr[0].length; a++){
        if(arr[i][a] != 0){
            arr[i][a] = -1;
        }
    }
}

public static void markCol(int [][] arr, int j){
    for(int a = 0; a < arr.length; a++){
        if(arr[a][j] != 0){
            arr[a][j] = -1;
        }
    }
}
🧠 Final Understanding

You are not memorizing — you are learning how indexing works.

👉 Once this clicks:

Matrix problems become easy
Graph/grid problems become easy
DP on grids becomes easy
 */
/*
Aryan, this is a solid attempt — you’re actually very close to the classic brute-force approach. The failure is due to one critical bug + one design risk. Let’s debug it step-by-step and make it crystal clear.

🔴 ❌ The Bug (Main Issue)
Your markCol method:
public static void markCol(int [][] arr, int j){
    for(int a =0;a<arr.length; a++){
        if(arr[j][a] != 0){
            arr[j][a] = -1;
        }
    }
}

👉 Problem:
You are using arr[j][a] ❌
But it should be arr[a][j] ✅

✔️ Correct Version
public static void markCol(int [][] arr, int j){
    for(int a = 0; a < arr.length; a++){
        if(arr[a][j] != 0){
            arr[a][j] = -1;
        }
    }
}

👉 Because:

a → row index
j → column index
🧠 Now Let’s Dry Run (Step-by-Step)
Input Matrix:
1 2 3
1 0 3
1 2 0
🔄 First Pass (Marking Phase)
👉 i=0, j=0 → 1 → skip
👉 i=0, j=1 → 2 → skip
👉 i=0, j=2 → 3 → skip
👉 i=1, j=1 → 0 found 🔥
Call:
markRow(arr, 1)
markCol(arr, 1)
🔹 After markRow(1):
1  2  3
-1 0 -1
1  2  0
🔹 After markCol(1):
1  -1  3
-1  0 -1
1  -1  0
👉 Continue loop
👉 i=2, j=2 → 0 found 🔥
Call:
markRow(arr, 2)
markCol(arr, 2)
🔹 After markRow(2):
1  -1  3
-1  0 -1
-1 -1  0
🔹 After markCol(2):
1  -1 -1
-1  0 -1
-1 -1  0
🔄 Second Pass (Convert -1 → 0)

Final Matrix:

1  0  0
0  0  0
0  0  0
⚠️ Hidden Problem (Important Insight)
❗ Why we used -1?

Because:

We don’t want to convert to 0 immediately
Otherwise new zeros will spread incorrectly
❗ BUT THIS HAS A RISK:

👉 What if original matrix already contains -1?

Then your logic breaks ❌

🧠 Brute Force Idea (Clean Notes)
🔹 Goal:

If matrix[i][j] == 0 → make entire row & column = 0

🔹 Approach:
Step 1:

Traverse matrix

Step 2:

When 0 found:

Mark row with -1
Mark col with -1
Step 3:

Convert all -1 → 0

⏱️ Time Complexity
Traversal: O(n × m)
Marking: O(n + m) per zero

👉 Worst case:
O(n × m × (n + m))
 */