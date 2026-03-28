package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

import java.util.Arrays;

public class MissingNumberinRange {
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);

        // case: missing 0
        if (nums[0] != 0) return 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }

        // missing last number
        return nums.length;
    }

        public static int missingNumber(int[] nums) {
            int miss =0;
            int count =0;// my own logic bruteforce
            Arrays.sort(nums);

            for(int i=0;i<nums.length-1;i++){
                if(nums[i] + 1 != nums[i+1]){
                    miss = nums[i] +1;
                    count ++;
                }
            }
            if(count == 1){
                return miss;
            }
            return nums.length;
        }

    public static void main(String[] args) {
        int arr[] = {1,2,4,5,0};
        System.out.println( missingNumber(arr));
    }
    }

