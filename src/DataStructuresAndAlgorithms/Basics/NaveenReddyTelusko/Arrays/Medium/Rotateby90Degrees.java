package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class Rotateby90Degrees {
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

