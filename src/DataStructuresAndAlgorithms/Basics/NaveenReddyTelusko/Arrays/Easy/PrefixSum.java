package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int [] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for(int i=1; i<arr.length;i++){
            arr1[i] = arr1[i-1] + arr[i];
        }
        for(int i:arr1){
            System.out.print(i+" ");
        }
    }
}
