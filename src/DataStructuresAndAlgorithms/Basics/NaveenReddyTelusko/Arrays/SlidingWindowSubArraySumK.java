package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class SlidingWindowSubArraySumK {
    public void LongestSubArraySumK(int [] arr, int k){
        int n = arr.length;
        int l =0;
        int maxLen = 0;
        int sum =0;

        for(int r=0;r<n;r++){
            sum += arr[r];
            while(sum > k && l <=r){
                sum = sum - arr[l];
                l++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, r-l +1);
            }
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,3,3};
        int k = 6;
        SlidingWindowSubArraySumK obj = new SlidingWindowSubArraySumK();
        obj.LongestSubArraySumK(arr, k);

        new SlidingWindowSubArraySumK().LongestSubArraySumK(arr,k);
    }

}
