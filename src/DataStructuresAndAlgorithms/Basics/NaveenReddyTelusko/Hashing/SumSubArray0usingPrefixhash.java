package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Hashing;

import java.util.HashMap;

public class SumSubArray0usingPrefixhash {
    public static int maxIndex(int [] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int maxLen = 0;
        int prefix = 0;
        for(i = 0; i<n ; i++)
        {
            prefix += arr[i];
            if(map.containsKey(prefix)){
                int prevIndex = map.get(prefix);
                maxLen = Math.max(maxLen , i-prevIndex);
            }else{
                map.put(arr[i], i);
            }

        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {15,-2, 2, -8, 1,7, 15, 10 , 23};
        System.out.println(maxIndex(arr));
        System.out.println(maxIndex(new int[]{1,2 ,3}));
    }
}
