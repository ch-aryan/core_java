package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSequences {

    public static void fnSeq(int index, ArrayList<Integer> arr,
                             ArrayList<Integer> temp,
                             ArrayList<ArrayList<Integer>> result) {

        // Base case
        if (index == arr.size()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // ✅ Pick the element
        temp.add(arr.get(index));
        fnSeq(index + 1, arr, temp, result);

        // 🔙 Backtrack (remove last added)
        temp.remove(temp.size() - 1);

        // ❌ Do not pick the element
        fnSeq(index + 1, arr, temp, result);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 1, 2));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        fnSeq(0, arr, temp, result);

        // Print result
        for (ArrayList<Integer> seq : result) {
            System.out.println(seq);
        }
    }
}
/*
           []
        /      \
      3         []
    /   \      /   \
  1     []    1     []
 / \   / \   / \   / \
2  [] 2 []  2 []  2 []
One-Line Summary

Subsequence recursion = “Pick or Don’t Pick” + Backtracking
tc: O(2^N).
 */