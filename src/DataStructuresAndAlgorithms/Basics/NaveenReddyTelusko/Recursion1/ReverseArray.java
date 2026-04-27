package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class ReverseArray {
    //through only one pointer like mid/2;
    public static void printArrRecSwap1(int[] arr, int l , int r){
        if(l>=r/2){
            return;
        }
        swap(arr,l,r);
        printArrRecSwap(arr, l+1, r-l-1);


    }
    public static void printArrRecSwap(int[] arr, int l , int r){
       if(l>=r){
           return;
       }
       swap(arr,l,r);
       printArrRecSwap(arr, l+1, r-1);


    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printArrRecSwap(arr, 0, arr.length-1);
    for(int i:arr){
        System.out.print(i+" ");
    }
        System.out.println();
    printArrRecSwap1(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}
