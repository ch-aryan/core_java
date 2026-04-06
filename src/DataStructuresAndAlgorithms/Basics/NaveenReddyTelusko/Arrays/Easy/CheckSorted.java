package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class CheckSorted {
    public static boolean SortedArr(int [] arr){
        if(arr.length <= 1) return true;
        for(int i =1; i<arr.length;i++){

            if(arr[i] >= arr[i-1]){ //if(arr[i] < arr[i-1]){
                                         // return false;


            }else {
                return false;
            }
        }
       return true ;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,3,4};

        int[] arr1 = {4,3,4,2,3};

       System.out.println( SortedArr(arr));
//        System.out.println( SortedArr(arr1));

    }
}
/* 🧠 Important Concept

Your condition:

arr[i] >= arr[i-1]

Means:

✔ Allows duplicates → non-decreasing order

If interviewer asks strictly increasing, use:

arr[i] > arr[i-1]*/