package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int nums[] = new int[10];
        //linear search will work for anytype of array.
        for(int i=0;i<nums.length;i++){
            nums[i] = i+1;
        }
        System.out.println(nums[4]);
        int target = 5;
        for(int i:nums){
            if(i==target){
                System.out.println("found ");
            }
        }
    }
}
