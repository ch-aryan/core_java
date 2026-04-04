package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class RemoveDuplicatesSortedArr {

        public int removeDuplicates(int[] nums) {

            int count = 0;

            for(int i =1;i<nums.length;i++){
                if(nums[count] != nums[i]){
                    count += 1;
                    nums[count] = nums[i];
                }
            }

            return count+1; // leetcode problem 26 question.
        }

    public static void main(String[] args) {


    }
}
/* 👉 Correct approach:

✔ O(n) time
✔ O(1) space
✔ Interview ready*/