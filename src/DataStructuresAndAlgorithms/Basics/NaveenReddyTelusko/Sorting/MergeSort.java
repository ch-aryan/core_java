package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;
class MergeSortAlgo{
    public static void mergeSort(int arr[] , int l , int r){
        if(l < r){
            int mid = (l + r )/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);

            merge(arr, l, mid, r);
        }


    }


    private static void merge(int[] arr, int l, int mid, int r) {
        int lsize = mid - l + 1;

        int rsiz = r - mid ;


        int[] lArr = new int[lsize];
        int[] rArr = new int[rsiz];

        for(int x =0; x<lsize ; x++){
            lArr[x] = arr[x+l];
        }
        for(int z=0; z<rsiz; z++){
            rArr[z] = arr[mid+1+z];
        }
        int i =0;
        int j =0;
        int k =l;
        while(i<lsize && j<rsiz){
            if(lArr[i] <= rArr[j]){
                arr[k] = lArr[i];
                i++;
            }else{
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while(i<lsize){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j<rsiz){
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }
}

public class MergeSort {
    public static void main(String[] args) {

        int [] arr = {5,3,6,1,4,2};
        MergeSortAlgo.mergeSort(arr, 0, arr.length-1);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
