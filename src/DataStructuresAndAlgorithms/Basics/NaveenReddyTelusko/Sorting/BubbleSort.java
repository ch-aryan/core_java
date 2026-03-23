package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;
class BubbleAlgo{
    public static void methBub(int [] arr){
        int n = arr.length;
        for(int i =0;i<n-1;i++){
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
/* ⭐ What is Bubble Sort

👉 Bubble sort is a simple comparison-based sorting algorithm
👉 It repeatedly compares adjacent elements
👉 If they are in wrong order → it swaps them
👉 In each pass the largest element “bubbles” to the end
Steps of Bubble Sort

1️⃣ Start from first element
2️⃣ Compare current element with next element
3️⃣ If current > next → swap
4️⃣ Continue till end of array
5️⃣ After first pass → largest element is fixed at last
6️⃣ Repeat process for remaining unsorted part
7️⃣ Continue until array becomes sorted

⭐ Time Complexity
Worst Case → O(n²) (reverse sorted array)
Average Case → O(n²)
Best Case → O(n) (when optimized version + already sorted)
⭐ Space Complexity

👉 O(1) (in-place sorting)
No extra memory required.

⭐ Important Characteristics

✅ Stable sorting algorithm
✅ In-place algorithm
✅ Very easy to understand
❌ Not efficient for large datasets
✅ Good for learning sorting fundamentals

⭐ Optimization concept (very important line)

👉 If in one full pass no swap happens,
array is already sorted → we can stop early

This reduces best case complexity to O(n).
 */