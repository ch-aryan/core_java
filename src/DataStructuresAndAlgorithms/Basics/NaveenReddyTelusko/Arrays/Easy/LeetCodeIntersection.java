package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;
import java.util.*;
public class LeetCodeIntersection {
    class Solution {
        public ArrayList<Integer> intersect(int[] a, int[] b) {
            // code here
            ArrayList<Integer> res = new ArrayList<>();

            int n = a.length;
            int m = b.length;
            Arrays.sort(a);
            Arrays.sort(b);
            int left =0;
            int right = 0;
            while(left<n && right<m){
                if(a[left] < b[right]){
                    left++;
                }else if(a[left] > b[right]){
                    right++;
                }else{
                    if(res.size() == 0 ||res.get(res.size() - 1) != a[left]){
                        res.add(a[left]);
                    }
                    left++;
                    right++;
                }
            }

            return res;
        }
    }
}
/* Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both the arrays. The intersection should not have duplicate elements and the result should contain items in any order.

Note: The driver code will sort the resulting array in increasing order before printing.

Examples:

Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
Output: [1, 3]
Explanation: 1 and 3 are the only common elements and we need to print only one occurrence of common elements.
Input: a[] = [1, 1, 1], b[] = [1, 1, 1, 1, 1]
Output: [1]
Explanation: 1 is the only common element present in both the arrays.
Input: a[] = [1, 2, 3], b[] = [4, 5, 6]
Output: []
Explanation: No common element in both the arrays.

 */