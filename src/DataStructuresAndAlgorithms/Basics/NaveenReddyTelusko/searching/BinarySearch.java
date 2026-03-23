package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.searching;
class Algorithm{
    public void methBinary(int[] arr, int tar){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == tar){
                System.out.println(mid);
                return ;
            }else if(arr[mid] > tar){
                end = mid;

            }else{
                start = mid;
            }
            start++;
            end --;
        }
    }
}
class Recursion {
    public void methRecBinary(int[] arr, int start, int end, int target) {

        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
            } else if (arr[mid] > target) {
                methRecBinary(arr, start, mid-1, target);
            } else {
                methRecBinary(arr, mid+1, end, target);
            }
        }else{
            System.out.println("not found");
        }

    }
}
public class BinarySearch {
    public static void main(String[] args) {
        //array must be sorted for binary search
    int arr[]  = {3,5,7,9,12,15,18};
    int target = 12;
    new Algorithm().methBinary(arr, target);

    new Recursion().methRecBinary(arr,0,arr.length-1,151);
    }
}
