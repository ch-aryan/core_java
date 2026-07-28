package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

public class SelectMinimumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        for(int i =0; i<arr.length; i++){
            System.out.println("subArrays single" + arr[i]);
            for(int j = i; j<arr.length; j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
            System.out.println("hello");
        }
    }
}
