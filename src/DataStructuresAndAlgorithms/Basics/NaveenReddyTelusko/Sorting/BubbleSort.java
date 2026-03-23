package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;
class BubbleAlgo{
    public static void methBub(int [] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            for(int j = 0; j<n-1 ; j++){
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

}
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {9,6,5,4,3,2,1};
        BubbleAlgo.methBub(arr);
    }
}
//tc complexity big O (n square)