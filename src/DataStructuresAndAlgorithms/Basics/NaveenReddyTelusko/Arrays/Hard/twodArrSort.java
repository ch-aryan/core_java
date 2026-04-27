package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;

import java.util.Arrays;
import java.io.*;
import java.util.*;
public class twodArrSort {


        // Function to sort the 2D array
        // lexicographically
        public static void sort_lexicographically(int arr[][])
        {
            for (int i = 0; i < arr.length; ++i) {

                // Initially sorting the array row-wise
                Arrays.sort(arr[i]);
            }

            // Sort the whole array in lexicographically
            Arrays.sort(arr,
                    (a, b) -> Integer.compare(a[0], b[0]));
        }

        // Driver Code
        public static void main(String[] args)
        {
            int arr[][]
                    = { { 3, 2, 5, 6 }, { 1, 2, 3 }, { 6, 3 },
                    { 9, 99 },      { 6, 3, 2 }, { 5, 4, 2 } };
            sort_lexicographically(arr);

            // Resultant 2-d array after
            // sorting lexicographically
            for (int i = 0; i < arr.length; ++i) {
                for (int j = 0; j < arr[i].length; ++j) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

// This code is contributed by Rohit Pradhan

/*
Given a 2D array arr[] having N rows of variable size, the task is to sort the array in lexicographical order i.e., sort each row lexicographically and then sort those sorted rows.

Examples:

Input: arr[][] = { {23}, {59}, {23, 59} }
Output: { {23}, {23, 59}, {59} }
Explanation: The rows are sorted lexicographically.
Here the row {23, 59} is lexicographically smaller than {59}
because the first element (23) is smaller than 59.
Though {23} and {23, 59} both have 23 as the first element but {23} has only one element.
Hence {23} is lexicographically smaller than {23, 59}



Input: arr[][] = { {3, 2, 5, 6}, {1, 2, 3}, {6, 3}, {5, 4, 2} }
Output: { {1, 2, 3}, {2, 3, 5, 6}, {2, 4, 5}, {3, 6} }



Input: arr[][] = { {3, 2, 5, 6}, {, 2, 3, 5}, {2, 4, 2, 1}, {6, 3, 7, 8} }
Output: { {1, 2, 2, 4}, {1, 2, 3, 5}, {2, 3, 5, 6}, {3, 6, 7, 8} }

o/p
Output
1 2 3
2 3 5 6
2 3 6
2 4 5
3 6
9 99
 */