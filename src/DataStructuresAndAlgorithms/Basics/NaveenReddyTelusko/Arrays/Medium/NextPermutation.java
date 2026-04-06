package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;
import java.util.*;

class GfG1 {
//bruteforce. i copied it as it is. no need because the better one is awesome.
    // Function to generate all possible permutations
    static void generatePermutations(List<List<Integer>> res,
                                     int[] arr, int idx) {

        // Base case: if idx reaches the end of array
        if (idx == arr.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            res.add(temp);
            return;
        }

        // Generate all permutations by swapping
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);

            // Recur for the next index
            generatePermutations(res, arr, idx + 1);

            // Backtrack to restore original array
            swap(arr, idx, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // Function to find the next permutation
    static void nextPermutation(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        // Generate all permutations
        generatePermutations(res, arr, 0);

        // Sort all permutations lexicographically
        Collections.sort(res, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        // Find the current permutation index
        for (int i = 0; i < res.size(); i++) {

            // If current permutation matches input
            boolean match = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != res.get(i).get(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {

                // If it's not the last permutation
                if (i < res.size() - 1) {
                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = res.get(i + 1).get(j);
                    }
                }

                // If it's the last permutation
                else {
                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = res.get(0).get(j);
                    }
                }

                break;
            }
        }
    }

}
public class NextPermutation {

        void nextPermutation(int[] arr) {
            // code here
            int n = arr.length;

            int i =n-2;
            //find pivot
            while(i>=0 && arr[i] >= arr[i+1]){
                i--;
            }

            //if pivot exist find just larger element.
            if(i>=0){
                int j = n-1;
                while(arr[j] <= arr[i]){
                    j--;
                }
                swap(arr, i, j);
            }


            reverse(arr, i+1, n-1);

        }

        public void swap(int [] arr, int i , int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void reverse(int [] arr, int i, int j){
            while(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

class GfG12 {

    static void nextPermutation(int[] arr) {

        int n = arr.length;

        // Find the pivot index
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If pivot point does not exist,
        // reverse the whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return ;
        }

        // Find the element from the right
        // that is greater than pivot
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }

        // Reverse the elements from pivot + 1 to the end
        reverse(arr, pivot + 1, n - 1);
    }

    // Helper method to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        nextPermutation(arr);

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}

/* Given an array of integers arr[] representing a permutation (i.e., all elements are unique and arranged in some order), find the next lexicographically greater permutation by rearranging the elements of the array.
If such a permutation does not exist (i.e., the array is the last possible permutation), rearrange the elements to form the lowest possible order (i.e., sorted in ascending order).

Examples:

Input: arr[] = [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]
Explanation: The next lexicographically greater arrangement of the elements in the array arr[] is [2, 4, 5, 0, 1, 7].

Input: arr[] = [3, 2, 1]
Output: [1, 2, 3]
Explanation: This is the last permutation, so we return the lowest possible permutation (ascending order).

Input: arr[] = [1, 3, 5, 4, 2]
Output: [1, 4, 2, 3, 5]
Explanation: The next lexicographically greater arrangement of the elements in the array arr[] is [1, 4, 2, 3, 5].
*/
/* [Expected Approach] Generating Only Next - O(n) Time and O(1) Space
Let's try some examples to see if we can recognize some patterns.
[1, 2, 3, 4, 5]: next is [1, 2, 3, 5, 4]
Observation: 4 moves and 5 comes in place of it

[1, 2, 3, 5, 4]: next is [1, 2, 4, 3, 5]
Observation: 3 moves, 4 comes in place of it. 3 comes before 5 (mainly 3 and 5 are in sorted order)

[1, 2, 3, 6, 5, 4]: next is [1, 2, 4, 3, 5, 6]
Observation: 3 moves, 4 comes in place of it. [3, 5 and 6 are placed in sorted order]

[3, 2, 1]: next is [1, 2, 3]
Observation: All elements are reverse sorted. Result is whole array sorted.

Observations of Next permutation:

To get the next permutation we change the number in a position which is as right as possible.
The first number to be moved is the rightmost number smaller than its next.
The number to come in-place is the rightmost greater number on right side of the pivot.
Each permutation (except the very first) has an increasing suffix. Now if we change the pattern from the pivot point (where the increasing suffix breaks) to its next possible lexicographic representation we will get the next greater permutation.

To understand how to change the pattern from pivot, see the below image:
Step-By-Step Approach:

Iterate over the given array from end and find the first index (pivot) which doesn't follow property of non-increasing suffix, (i.e,  arr[i] < arr[i + 1]).
If pivot index does not exist, then the given sequence in the array is the largest as possible. So, reverse the complete array. For example, for [3, 2, 1], the output would be [1, 2, 3]
Otherwise, Iterate the array from the end and find for the successor (rightmost greater element) of pivot in suffix.
Swap the pivot and successor
Minimize the suffix part by reversing the array from pivot + 1 till n.
 */