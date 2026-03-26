package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int [] arr = {5,4,5};
        int largest = Integer.MIN_VALUE;
        int secondLar = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > largest ){
                secondLar = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLar && arr[i] != largest){
                secondLar = arr[i];
            }
        }
        System.out.println(largest);
        System.out.println(secondLar);
    }
}
