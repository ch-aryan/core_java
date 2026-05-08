package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

import java.util.ArrayList;
import java.util.Collections;

public class dayIIIKthLargestStream {
    //my own logic . time complexity is high(n square log n).
        static ArrayList<Integer> kthLargest(int[] arr, int k) {
            // code here

            ArrayList<Integer> res = new ArrayList<>();
            int n = arr.length;//Input: arr[] = [1, 2, 3, 4, 5, 6], k = 4
            //ut: [-1, -1, -1, 1, 2, 3]
            ArrayList<Integer> temp =  new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(arr[i]);
                if(temp.size() >= k){
                   int s = kLar(temp, k);

                    res.add(s);

                }else {
                    res.add(-1);
                }
            }
            return res;
        }
        public static int kLar(ArrayList<Integer> temp, int k){
            Collections.sort(temp);
            int larK =  temp.get(temp.size()-k);
            return larK;


        }
    }

/*
priority queues.
⚡ Why this is better
No repeated sorting
Heap automatically maintains order
Complexity:

✅ O(n log k) instead of O(n² log n)

Given an input stream arr[] of n integers. Find the Kth largest element (not Kth largest unique element) after insertion of each element in the stream and if the Kth largest element doesn't exist, the answer will be -1 for that insertion.

Return a list of size n, where each element represents the Kth largest value after the corresponding insertion.

Examples :

Input: arr[] = [1, 2, 3, 4, 5, 6], k = 4
Output: [-1, -1, -1, 1, 2, 3]
Explanation:
After 1, the steam is [1]. The 4th largest does not exist. Output is -1.
After 2, the stream is [1, 2]. The 4th largest does not exist. Output is -1.
After 3, the stream is [1, 2, 3]. The 4th largest does not exist. Output is -1.
After 4, the stream is [1, 2, 3, 4]. The 4th largest is 1.
After 5, the stream is [1, 2, 3, 4, 5]. The 4th largest is 2.
After 6, the stream is [1, 2, 3, 4, 5, 6]. The 4th largest is 3.
Input: arr[] = [3, 2, 1, 3, 3], k = 2
Output: [-1, 2, 2, 3, 3]
Explanation:
After 3, the steam is [3]. Tthe 2nd largest does not exist. Output is -1.
After 2, the stream is [3, 2]. The 2nd largest is 2.
After 1, the stream is [3, 2, 1]. The 2nd largest is 2.
After 3, the stream is [3, 2, 1, 3]. The 2nd largest is 3.
After 3, the stream is [3, 2, 1, 3, 3]. The 2nd largest is 3.
 */