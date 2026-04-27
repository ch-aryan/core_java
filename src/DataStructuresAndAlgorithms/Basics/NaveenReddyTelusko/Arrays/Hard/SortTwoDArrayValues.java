package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;
import java.io.*;
import java.util.*;
public class SortTwoDArrayValues {


    class GFG {
        public static void sortbyColumn(int a[][], int c){
            Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c]));
        }

        public static void main(String args[])
        {
            int m[][] = { { 39, 27, 11, 42 },
                    { 10, 93, 91, 90 },
                    { 54, 78, 56, 89 },
                    { 24, 64, 20, 65 } };

            // Sort this matrix by 3rd Column
            int c = 3;

            sortbyColumn(m, c - 1);

            // Display the sorted Matrix
            for (int i = 0; i < m.length; i++) {

                for (int j = 0; j < m[i].length; j++)
                    System.out.print(m[i][j] + " ");

                System.out.println();

            }
        }
    }
}
/*
We are given a 2D array of order N X M and a column number K ( 1<=K<=m). Our task is to sort the 2D array according to values in Column K.

Examples:

Input: If our 2D array is given as (Order 4X4)
        39 27 11 42
        10 93 91 90
        54 78 56 89
        24 64 20 65

Sorting it by values in column 3

Output:

39 27 11 42
24 64 20 65
54 78 56 89
10 93 91 90

Java Program to Sort a 2D Array
Explanation of the above Program:
If element at 0 index of array a is greater than element at 0 index of array b, their difference will be positive. This means array a is kept after array b.
If element at 0 index of array a is smaller than element at 0 index of array b, their difference will be negative. This means array b is kept after array a.
If both the elements are equal, then their difference will be 0. This means that they will be equally placed.
On the basis of these values, the entire array is sorted.
 */