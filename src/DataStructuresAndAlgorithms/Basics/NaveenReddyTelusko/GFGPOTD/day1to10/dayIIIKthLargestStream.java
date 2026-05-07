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
 */