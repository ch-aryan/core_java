package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

public class StriverQuickSort {

        public void quickSort(int[] arr, int low, int high) {
            // code here
            if(low<high){

                int pivot = partition(arr,low,high);
                quickSort(arr, low, pivot-1);
                quickSort(arr,pivot+1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {

            // code here
            int pivot = arr[low];
            int i = low;
            int j = high;

            while(i<j){
                while(i <= high-1 && arr[i] <= pivot){
                    i++;
                }
                while(j >= low + 1 && arr[j] > pivot){
                    j--;
                }
                if(i < j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;
            return j;
        }
    }
/* Aryan, this is that “last-mile confusion”—you understand the idea, but the code flow feels slippery. Let’s slow it down and make it feel natural, not mechanical.

🧠 What this partition is REALLY doing

👉 You picked:

pivot = arr[low];

So your goal is:

👉 Put pivot in its correct position such that:

Left side ≤ pivot
Right side > pivot
🔍 Let’s Dry Run (this is where clarity comes)

Take your array:

[5, 3, 6, 1, 4, 2]
low = 0, high = 5
pivot = 5
🎯 Initial State
pivot = 5
i = 0
j = 5
🔁 First iteration
Move i →
while(i <= high-1 && arr[i] <= pivot)

Check:

arr[0] = 5 ≤ 5 → i = 1
arr[1] = 3 ≤ 5 → i = 2
arr[2] = 6 ❌ stop

👉 Now:

i = 2
Move j ←
while(j >= low+1 && arr[j] > pivot)

Check:

arr[5] = 2 ❌ (not > 5)

👉 So:

j = 5
Swap (because i < j)
swap(arr[2], arr[5])

Array becomes:

[5, 3, 2, 1, 4, 6]
🔁 Second iteration
Move i →
arr[2] = 2 ≤ 5 → i = 3
arr[3] = 1 ≤ 5 → i = 4
arr[4] = 4 ≤ 5 → i = 5

👉 Now:

i = 5
Move j ←
arr[5] = 6 > 5 → j = 4
arr[4] = 4 ❌ stop

👉 Now:

j = 4
🚫 Now:
i = 5, j = 4 → i > j → loop ends
🔥 MOST IMPORTANT STEP (pivot placement)
swap(arr[low], arr[j]);

👉 Swap:

swap(arr[0], arr[4])

Final:

[4, 3, 2, 1, 5, 6]
                ↑
            pivot index = 4
🧠 Now Understand the Logic (THIS IS KEY)
Why do we stop when i >= j?

👉 Because:

i found something > pivot
j found something ≤ pivot

When they cross → all elements are correctly partitioned

Why swap pivot with j?

👉 Because:

j is the last correct position for pivot
Everything left of j ≤ pivot
Everything right of j > pivot
💡 Mental Model (VERY IMPORTANT)

👉 Think like this:

i → searching for wrong element on left
j → searching for wrong element on right
Swap them to fix positions
When done → place pivot correctly
🔥 One-Line Understanding

👉
"i moves forward to find bigger elements, j moves backward to find smaller ones, and we swap them until pivot finds its correct place."

 */
