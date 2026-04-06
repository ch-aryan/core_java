package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;
class SelectionAlgo {
    public static void selectionMeth(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
           int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            for (int k : arr) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {9,6,5,4,3,2,1};
        System.out.println("Before");
        for(int i =0;i< arr.length;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
        SelectionAlgo.selectionMeth(arr);

        System.out.println("****************");

    }
}
/* What is Selection Sort

👉 Selection sort is a simple comparison-based sorting algorithm
👉 It repeatedly selects the minimum element from unsorted part
👉 Then places it at the correct sorted position

⭐ Steps of Selection Sort

1️⃣ Start from first index
2️⃣ Assume current index element as minimum
3️⃣ Traverse remaining array to find actual minimum
4️⃣ Swap minimum element with current index
5️⃣ Move boundary of sorted part by one
6️⃣ Repeat until array becomes sorted

⭐ Time Complexity
Best Case → O(n²)
Average Case → O(n²)
Worst Case → O(n²)

👉 Because comparisons always happen even if array is sorted.

⭐ Space Complexity

👉 O(1)
It is an in-place sorting algorithm

⭐ Important Characteristics

✅ Simple logic
✅ In-place sorting
❌ Not stable (important interview point ⚠️)
❌ Not suitable for large datasets
✅ Performs less swaps than bubble sort

⭐ Important Interview Line

👉 Selection sort always makes (n-1) swaps maximum
But comparisons are always n²

So sometimes used when swap cost is high*/