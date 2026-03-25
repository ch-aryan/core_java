package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

public class MergeSortArrayOne {
    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = l + (r-l)/2;// (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1, r);

            merge(arr,l,mid, r);
        }
    }
    public static void merge(int[] arr, int l, int mid, int r){
        int [] temp = new int[r-l+1];
        int i = l;
        int j = mid+1;
        int k = 0;

        while(i<= mid && j <=r){
            if(arr[i] > arr[j]){
                temp[k] = arr[j];
                j++;
            }else{
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=r){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(int x=0; x < temp.length; x++){
            arr[l+x] = temp[x];
        }
    }


    public static void main(String[] args) {
        int arr[] = {5,3,6,1,4,2};

        mergeSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");

        }
    }
}
