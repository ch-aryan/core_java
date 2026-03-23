package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko;

public class PrintEvenNumberTwoTypes {
    public static void main(String[] args) {
        int arr[] = new int[10];
        int count = 1;
        for(int i=0;i<arr.length;i++){
//           arr[i] = count;
            arr[i] = i+1;
//           count++;
        }
        for(int i = 1; i<arr.length; i= i+2){
            System.out.print(arr[i]+" ");
        }
    }
}
