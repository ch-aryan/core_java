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
    /* static void merge(int[] arr, int l, int mid, int r) {

    int[] temp = new int[r - l + 1];

    int i = l;        // left pointer
    int j = mid + 1;  // right pointer
    int k = 0;        // temp pointer

    while (i <= mid && j <= r) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= r) {
        temp[k++] = arr[j++];
    }

    // copy back to original array
    for (int x = 0; x < temp.length; x++) {
        arr[l + x] = temp[x];
    }
}*/
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
/* 🌟 STEP-BY-STEP LINE BY LINE EXECUTION
✅ MAIN METHOD STARTS
int[] arr = {5,3,6,1,4,2};
mergeSort(arr, 0, 5);

Now control goes to:

mergeSort(arr, 0, 5)
🔷 CALL 1 → mergeSort(arr,0,5)
Line:
if(l < r) → if(0 < 5) → TRUE

So enter block.

mid = (0 + 5) / 2 = 2

Now two recursive calls will happen.

🔷 CALL 2 → mergeSort(arr,0,2)

Stack grows.

if(0 < 2) → TRUE
mid = (0+2)/2 = 1
🔷 CALL 3 → mergeSort(arr,0,1)
if(0 < 1) → TRUE
mid = 0
🔷 CALL 4 → mergeSort(arr,0,0)
if(0 < 0) → FALSE

👉 Function returns immediately
(single element already sorted)

Stack goes back.

🔷 CALL 5 → mergeSort(arr,1,1)
if(1 < 1) → FALSE

Return.

🔷 NOW MERGE(arr,0,0,1)

Now merging [5] and [3]

Inside merge()
lsize = mid-l+1 = 0-0+1 = 1
rsiz = r-mid = 1-0 = 1

Create arrays:

lArr = [5]
rArr = [3]

Pointers:

i=0 , j=0 , k=0
While loop check
i<1 && j<1 → TRUE

Compare:

lArr[i] <= rArr[j]
5 <= 3 → FALSE

So:

arr[k] = rArr[j]
arr[0] = 3

Now:

j=1
k=1

Loop again:

i<1 && j<1 → FALSE

Exit.

Remaining left elements loop
i<1 → TRUE
arr[1] = lArr[0] = 5

Now:

i=1
k=2

Merge finished.

🔥 Array becomes:

3 5 6 1 4 2

Return.

🔷 CALL 6 → mergeSort(arr,2,2)
if(2<2) → FALSE

Return.

🔷 NOW MERGE(arr,0,1,2)

Merging [3 5] and [6]

Sizes:

lsize = 2
rsiz = 1

Temp arrays:

lArr = [3 5]
rArr = [6]

Pointers:

i=0 j=0 k=0

Compare:

3 <= 6 → TRUE
arr[0]=3
i=1 k=1

Next:

5 <= 6 → TRUE
arr[1]=5
i=2 k=2

Now main loop stops.

Copy remaining right:

arr[2]=6

Left side sorted:

3 5 6 1 4 2

Return to CALL 1.

🔷 CALL 7 → mergeSort(arr,3,5)
if(3<5) → TRUE
mid = 4
🔷 CALL 8 → mergeSort(arr,3,4)
mid = 3
🔷 CALL 9 → mergeSort(arr,3,3)

Return.

🔷 CALL 10 → mergeSort(arr,4,4)

Return.

🔷 MERGE(arr,3,3,4)

Merge [1] and [4]

Result:

3 5 6 1 4 2

(no change actually)

🔷 CALL 11 → mergeSort(arr,5,5)

Return.

🔷 MERGE(arr,3,4,5)

Merge [1 4] and [2]

Compare:

1<=2 → arr[3]=1
4<=2 → FALSE → arr[4]=2
remaining → arr[5]=4

Array becomes:

3 5 6 1 2 4

Return.

🔷 FINAL MERGE(arr,0,2,5)

Merge:

Left  = [3 5 6]
Right = [1 2 4]

Pointers:

i=0 j=0 k=0

Comparisons:

3<=1 → NO → arr[0]=1
3<=2 → NO → arr[1]=2
3<=4 → YES → arr[2]=3
5<=4 → NO → arr[3]=4
remaining left → arr[4]=5
arr[5]=6

🔥 FINAL ARRAY:

1 2 3 4 5 6

Program ends.

🌟 VERY IMPORTANT UNDERSTANDING

👉 Recursion first goes deep till single elements
👉 Then merging happens while returning

This is called:

⭐ Divide phase (going down stack)
⭐ Conquer phase (coming back stack) We are sorting:

arr = {5,3,6,1,4,2}

Initial call:

mergeSort(0,5)
🌟 COMPLETE MERGE SORT CALL TREE (STEP-BY-STEP)
mergeSort(0,5)
   |
   ├── mergeSort(0,2)
   |      |
   |      ├── mergeSort(0,1)
   |      |      |
   |      |      ├── mergeSort(0,0)   ✅ stop (single element)
   |      |      |
   |      |      └── mergeSort(1,1)   ✅ stop (single element)
   |      |
   |      |      🔵 merge(0,0,1)   → sort [5,3]
   |      |
   |      └── mergeSort(2,2)       ✅ stop
   |
   |      🔵 merge(0,1,2)          → sort [3,5,6]
   |
   └── mergeSort(3,5)
          |
          ├── mergeSort(3,4)
          |      |
          |      ├── mergeSort(3,3)   ✅ stop
          |      |
          |      └── mergeSort(4,4)   ✅ stop
          |
          |      🔵 merge(3,3,4)   → sort [1,4]
          |
          └── mergeSort(5,5)       ✅ stop

          🔵 merge(3,4,5)          → sort [1,2,4]

🔴 FINAL merge(0,2,5)               → whole array sorted
🌟 How to READ this (Very Important)

👉 Recursion always goes LEFT → LEFT → LEFT
until it reaches single element

Then merging starts while coming back up

So execution order in real program is like:

mergeSort(0,5)
mergeSort(0,2)
mergeSort(0,1)
mergeSort(0,0)  ← return
mergeSort(1,1)  ← return
merge(0,0,1)

mergeSort(2,2)  ← return
merge(0,1,2)

mergeSort(3,5)
mergeSort(3,4)
mergeSort(3,3)  ← return
mergeSort(4,4)  ← return
merge(3,3,4)

mergeSort(5,5)  ← return
merge(3,4,5)

merge(0,2,5)  ← FINAL

This is the actual call sequence CPU follows.

🌟 VERY GOLDEN INTERVIEW UNDERSTANDING

👉 Total levels of splitting = log₂ n
👉 At each level merging touches n elements

So time complexity becomes:

n log n

That is the real intuition behind complexity.

If you want next, I can:*/