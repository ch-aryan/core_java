package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class Rotateby90Degrees {

    static void usingCycles(int mat[][]){
        int n = mat.length;

        for(int i=0;i<n/2;i++){
            for(int j=i; j<n-i-1; j++){
                int temp = mat[i][j];
               mat[i][j] = mat[n-j-1][i];
              mat[n-j-1][i] = mat[n-i-1][n-j-1];
              mat[n-i-1][n-j-1] = mat[j][n-i-1];
              mat[j][n-i-1] = temp;
            }
        }
    }
    // User function Template for Java
//optimal using transpose and reverse.
    class GFG {
        static void rotate(int mat[][]) {
            // Code Here
            int n = mat.length;
            for(int i=0;i<n;i++){
                for(int j=i+1; j<n; j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            //reverse
            for(int i=0;i<n;i++){
                int start =0; int end = n-1;
                while(start<end){
                    int temp = mat[i][start];
                    mat[i][start] = mat[i][end];
                    mat[i][end] = temp;
                    start ++;
                    end--;
                }
            }
        }
    }
    //bruteforce.
    public static int[][] rotate90(int[][] mat) {
    int n = mat.length; int m = mat[0].length;
    int result[][] = new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            result[j][n - i - 1] = mat[i][j];
        }
    }


    return result;
}

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

      int result[][] =   rotate90(mat);
        System.out.println("*****************");

        // Print the rotated matrix
        for (int[] row : result) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    }

/*
Given a square matrix mat[][], turn it by 90 degrees in an clockwise direction without using any extra space

Examples:

Input: mat[][] = {{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}}
Output: {{7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}}

Input: mat[][] = {{1, 2, 3, 4},
                   {5, 6, 7, 8},
                     {9, 10, 11,12}
                     {13, 14, 15, 16}}
Output: {{13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
Naive Approach] - O(n^2) Time and O(n^2) Space
We mainly need to move first row elements to last column, second row elements to second last column.

Let us first try to find out a pattern to solve the problem for n = 4 (second example matrix above)

mat[0][0] goes to mat[0][3]
mat[0][1] goes to mat[1][3]
.............................................
mat[1][0] goes to mat[0][2]
............................................
mat[3][3] goes to mat[3][0]

Do you see a pattern? Mainly we need to move mat[i][j] to mat[j][n-i-1].
 We first move elements in a temporary matrix, then copy the temporary to the original.
 If we directly copy elements within the matrix, it would cause data loss.

//forming cycles intution
[Expected Approach 1] Forming Cycles - O(n^2) Time and O(1) Space
The approach is similar to Inplace rotate square matrix by 90 degrees counterclockwise. The only thing that is different is to print the elements of the cycle in a clockwise direction i.e. An n x n matrix will have floor(n/2) square cycles.  For example, a 3 X 3 matrix will have 1 cycle and a 4 x 4 matrix will have 2 cycles. The first cycle is formed by its 1st row, last column, last row, and 1st column.

For each square cycle, we swap the elements involved with the corresponding cell in the matrix in the clockwise direction. We just need a temporary variable for this.

Explanation:

Let us consider the below matrix for example
 {{1, 2, 3},
  {4, 5, 6},
  {7, 8, 9}}
During first iteration of first and only cycle
mat[i][j] = Element at first index (leftmost corner top)= 1.
mat[j][n-1-i]= Rightmost corner top Element = 3.
mat[n-1-i][n-1-j] = Rightmost corner bottom element = 9.
mat[n-1-j][i] = Leftmost corner bottom element = 7.
Move these elements in the clockwise direction.
During second iteration of first and only cycle
mat[i][j] = 2.
mat[j][n-1-i] = 6.
mat[n-1-i][n-1-j] = 8.
mat[n-1-j][i] = 4.
Similarly, move these elements in the clockwise direction.

Follow the given steps to solve the problem:

There are n/2 squares or cycles in a matrix of side n. Process a square one at a time.
Run a loop to traverse the matrix a cycle at a time, i.e. loop from 0 to n/2 - 1,
loop counter is i
Consider elements in group of 4 in current square, rotate the 4 elements at a time
Now run a loop in each cycle from i to n - i - 1, loop counter is j
The elements in the current group are P1 (i, j), P2 (n-1-j, i), P3 (n-1-i, n-1-j)
and P4 (j, n-1-i), now rotate these 4 elements, i.e.
temp <- P1, P1 <- P2, P2<- P3, P3<- P4, P4<-temp

[Expected Approach 2] Transposing and Reversing Rows - O(n^2) Time and O(1) Space
When you think about rotating a square matrix 90 degrees clockwise, each element moves to a new position. The top row becomes the right column, the second row becomes the second-right column, and so forth. If we first transpose the matrix and then find reverse of every row, we get the desired result.

Follow the given steps to solve the problem:

Perform Transpose of the matrix
Reverse every individual row of the matrix
1  2  3                                 1  4  7                                            7  4  1

4  5  6   —Transpose->   2  5  8     —-Reverse rows—->   8  5  2

7  8  9                                 3  6  9                                          9  6  3

Below is the implementation of the above approach:
 */
//transpose means row became columns and coulumns became rows.