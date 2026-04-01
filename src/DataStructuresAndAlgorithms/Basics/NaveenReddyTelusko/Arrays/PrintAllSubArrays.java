package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class PrintAllSubArrays {
    public static void allSubArrays(int [] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){//better solution the brute force contains 3 loops.
            int sum =0;
            for(int j=i;j<n;j++){
                System.out.print(" " +arr[j]+" ");
                sum = sum + arr[j];
                System.out.print("sum " + sum +" ");

            }
            System.out.println();
        }
    }
    public static void allSubArraysBetter(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            for(int j = i; j<arr.length; j++){
                int sum = 0;
                for(int k =i;k<=j;k++){
                    sum =  sum + arr[k];

                }
                max = Math.max(max, sum);
                System.out.print(sum + " ");
            }
        }
        System.out.println("\nMax Sum: " + max);
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        allSubArrays(arr);
        System.out.println("********************");
        allSubArraysBetter(arr);
    }

}
