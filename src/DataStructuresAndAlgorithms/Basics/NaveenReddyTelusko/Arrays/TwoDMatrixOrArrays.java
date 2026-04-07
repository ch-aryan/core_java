package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class TwoDMatrixOrArrays {
    public static void main(String[] args) {
        int[] [] mat = new int[3][3];
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/* Think of matrix like this:

(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)
🧭 Traversal Logic
Outer loop → Rows
for(int i = 0; i < mat.length; i++)
Inner loop → Columns
for(int j = 0; j < mat[i].length; j++)

👉 So you are doing:

Fix row i
Move across columns j
🔄 Step-by-step flow

For i = 0:

(0,0) → (0,1) → (0,2)

For i = 1:

(1,0) → (1,1) → (1,2)

👉 This is called row-wise traversal.
Always remember:

mat.length        → number of rows
mat[i].length     → number of columns
🚀 Next Step (Important for your growth)

Once you’re clear with this, learn:

Column-wise traversal
Spiral traversal
Diagonal traversal

👉 These are frequently asked in interviews

 */