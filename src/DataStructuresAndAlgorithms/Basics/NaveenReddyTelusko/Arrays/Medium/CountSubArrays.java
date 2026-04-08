package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.HashMap;

public class CountSubArrays {

        public int cntSubarrays(int[] arr, int k) {
            // code here
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0,1);

            int count =0;
            int currentSum =0;

            for(int i: arr){
                currentSum += i;

                if(map.containsKey(currentSum-k)){
                    count += map.get(currentSum-k);
                }

                map.put(currentSum, map.getOrDefault(currentSum,0)+1);


            }
            return count;
        }
    }

/* Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.

Examples:

Input: arr[] = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr[] = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
To count subarrays with sum k, we use a hash map to store the frequency of prefix sums. At each index, we calculate the current prefix sum currSum and check if (currSum - k) exists in the map. If it does, it means there are subarrays ending at the current index with sum k, and we add their count to the result. Then we update the frequency of currSum in the map.

Step By Step Implementations:

Maintain a running sum of elements from index 0 to i → currSum.
If currSum is equal to k, we’ve found a valid subarray from index 0 to i.
If there’s a prefix sum such that currSum - k exists in the map, then we’ve found subarrays ending at i with sum k.
The number of such subarrays is equal to the frequency of (currSum - k).
Record currSum in the map to help future matches.
 */