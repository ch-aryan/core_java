package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class ReverseArray {
    public static void ReverseThroughSwap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr1[] = {1,2,3,4,5};

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        for (int k : arr) {
            System.out.print(k + " ");

        }

        System.out.println("*****************");
        ReverseThroughSwap(arr1);


    }
}

