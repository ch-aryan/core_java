package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class MatrixZeroes9 {
    //optimized approach using no extra spaces.
    //it may feel confusing but it is important to understand matrixes specially rows and colums.
    public static void setMatrixZeroes1(int[][] mat){
        int n = mat.length ; int m = mat[0].length;
        int c0 = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    //entire row
                    mat[i][0] = 0;
                    //special case.
                    if(j==0){
                        c0 = 0;
                    }else{
                        //entire column
                        mat[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][0] == 0 || mat[0][j] ==0){
                    mat[i][j] =0;
                }
            }
        }

        if(mat[0][0] == 0){
            for(int j=0;j<m;j++){
                mat[0][j] = 0;
            }
        }
        if(c0 == 0){
            for(int i=0;i<n;i++){
                mat[i][0] = 0;
            }
        }
    }

    //bruteforce two arrays for checking.
    public static void setMatrixZeroes(int [][] arr){
        int n = arr.length, m = arr[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rows[i] || cols[j]){
                    arr[i][j]  = 0;
                }
            }
        }


//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
    public static void main(String[] args) {

            int[][] mat = { { 0, 1, 2, 0 },
                    { 3, 4, 0, 2 },
                    { 1, 3, 1, 5 } };

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("************");

            setMatrixZeroes(mat);

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        System.out.println("************");

        int[][] mat1 = { { 0, 1, 2, 0 },
                { 3, 4, 0, 2 },
                { 1, 3, 1, 5 } };

        setMatrixZeroes1(mat1);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        }
    }

/* Set Matrix Rows and Columns to Zeroes
Last Updated : 8 Mar, 2026
Given a matrix mat[][] of size nxm, the task is to update the matrix such that if an element is zero, set its entire row and column to zeroes.

Examples:

Input: mat[][] = [[1, -1, 1],
                            [-1, 0, 1],
                            [1, -1, 1]]
Output: [[1, 0, 1],
               [0, 0, 0],
               [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

Input: mat[][] = [[0, 1, 2, 0],
                            [3, 4, 0, 2],
                           [1, 3, 1, 5]]
Output: [[0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 3, 0, 0]]
Explanation: mat[0][0], mat[1][2] and mat[0][3] are 0s, so all elements in row 0,
row 1, column 0, column 2 and column 3 are updated to zeroes.
[Naive Approach] Using Two Auxiliary Arrays - O(n*m) Time and O(n+m) Space
The idea is to maintain two additional arrays, say rows[] and cols[]
to store the rows and columns which contains at least one element equal to 0.
 So, first traverse the entire matrix and for each mat[i][j] = 0,
  mark rows[i] = true and cols[j] = true. Now in the second traversal, for each cell (i, j),
  if either rows[i] or cols[j] is marked as true, update mat[i][j] = 0 else continue to the next cell.

  O(1) Space 2nd appraoch.
 In the previous approach we took two arrays to store the row's and column's status. Now instead of two auxiliary arrays, we can use the first row and first column of mat[][] to store which row elements and column elements are to be marked as zeroes.

So if the first cell of a row is set to 0, then all cells of that row should be updated with 0. Similarly, if the first cell of a column is set to 0, then all cells of that column should be updated to 0. Since cell (0, 0) is first cell of the first row as well as the first column, so maintain another variable, say c0 to store the status of the first column and cell(0, 0) will store the status of the first row.

Step By Step Algorithm:

Traverse the matrix, and for each cell (i, j) such that mat[i][j] = 0, mark mat[i][0] and mat[0][j] as 0. Note: If i = 0, mark mat[0][0] as 0 and if j = 0, mark c0 as 0.
Again traverse the matrix from (1, 1) to (n-1, m-1), and set mat[i][j] = 0 if either mat[i][0] = 0 or mat[0][j] = 0.
Finally, update the first row and first column: If mat[0][0] = 0, set all elements in
 first row to 0 and if c0 = 0, set all elements in the first column to 0.

 🧠 Core Idea (1 line)

👉 Instead of using extra arrays, we reuse the first row & first column as markers

📦 Example (we’ll track this step by step)
0 1 2 0
3 4 0 2
1 3 1 5
🔥 STEP 1: Mark rows & columns
Code:
if (mat[i][j] == 0) {
    mat[i][0] = 0;

    if (j == 0)
        c0 = 0;
    else
        mat[0][j] = 0;
}
🧠 What this means (IMPORTANT)

When you see a 0 at (i, j):

👉 Mark:

Entire row → mat[i][0] = 0
Entire column → mat[0][j] = 0
⚠️ Special case: j == 0

Why?

Because:

mat[0][0] belongs to both:
first row ❗
first column ❗

👉 So we use:

int c0 = 1;

to track first column separately

📊 After STEP 1 (Marking)

Matrix becomes:

0 1 0 0
0 4 0 2
1 3 1 5

Markers:

Row 1 marked → because mat[1][2] = 0
Column 2 marked → mat[0][2] = 0
Column 3 marked → mat[0][3] = 0
🔥 STEP 2: Fill rest using markers
Code:
for (int i = 1; i < n; i++) {
    for (int j = 1; j < m; j++) {
        if (mat[i][0] == 0 || mat[0][j] == 0) {
            mat[i][j] = 0;
        }
    }
}
🧠 Meaning:

👉 For each cell (i, j):

If row is marked → mat[i][0] == 0
OR column is marked → mat[0][j] == 0

👉 Then make it 0

📊 After STEP 2:
0 1 0 0
0 0 0 0
1 3 0 0
🔥 STEP 3: Handle first row
Code:
if (mat[0][0] == 0) {
    for (int j = 0; j < m; j++)
        mat[0][j] = 0;
}
🧠 Meaning:

👉 If first row had any zero → wipe entire first row

🔥 STEP 4: Handle first column
Code:
if (c0 == 0) {
    for (int i = 0; i < n; i++)
        mat[i][0] = 0;
}
🧠 Meaning:

👉 If first column had any zero → wipe entire first column

🎯 Final Output
0 0 0 0
0 0 0 0
0 3 0 0
🧠 Why this works (IMPORTANT)

Instead of using:

int row[n];
int col[m];

👉 We used:

First column → store row info
First row → store column info

👉 Space optimized → O(1)

⚠️ Where you got confused (I know exactly)

These lines:

if (j == 0)
    c0 = 0;
else
    mat[0][j] = 0;

👉 Feel weird because:

Why special case?
Why not always mat[0][j]?

👉 Answer:
Because mat[0][0] is shared → conflict → so we use c0

🔥 Mental Model (Remember this)

👉 First row = column markers
👉 First column = row markers
👉 c0 = first column protector

🚀 Final Tip (Interview)

If you can explain like this:

“I use first row and column as markers and handle overlap using a separate variable”

👉 Interviewer = impressed
 */