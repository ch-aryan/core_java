package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;
class SortAlgorithm{
    public static void sortMeth(int arr[]){
       int n = arr.length;
      for(int i = 1; i<n;i++){
          int key = arr[i];// if i would do key = i only and
          int j = i-1;
          while(j>=0 && arr[j] > key ){//condition. //here giving arr[key]
              arr[j+1] = arr[j];
              j--;
          }
          arr[j+1] = key; //here same arr[key] why don't it work. can y0ou explain the code.
          for(int k :arr){
              System.out.print(k+" ");
          }
          System.out.println();
      }

        }

    }


public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {9,6,5,4,3,2,1};
        System.out.println("Before");
        for(int i =0;i< arr.length;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
        SortAlgorithm.sortMeth(arr);
    }
}
/* Good 👍 now this is a very important conceptual doubt.
You are very close to deep understanding of insertion sort.

Let’s do exactly what you asked → clear dry run of YOUR wrong logic.

⭐ Your current logic

You changed:

int key = i;

and using:

arr[j] > arr[key]
arr[j+1] = arr[key]

So here:

👉 key is acting like index pointer
NOT value holder.

This is the root problem.

🔥 Let’s dry run step-by-step (very slowly)

Initial array:

9 6 5 4 3 2 1
✅ Pass-1 (i = 1)
key = i = 1
j = 0

Condition:

arr[j] > arr[key]
arr[0] > arr[1]
9 > 6 → TRUE

So shift:

arr[j+1] = arr[j]
arr[1] = 9

Array becomes:

9 9 5 4 3 2 1

Now:

j-- → j = -1

Loop stops.

Now insertion step:

arr[j+1] = arr[key]
arr[0] = arr[1]

But arr[1] is now 9 (already overwritten!)

So array becomes:

9 9 5 4 3 2 1

👉 You LOST the value 6 permanently.

This is the biggest issue.

⭐ Why this happens (core concept)

In real insertion sort:

👉 We store value safely in variable

int key = arr[i];

So even if array positions change
👉 original value is safe.

But in your logic:

👉 You are not storing value
👉 You are only remembering index

But during shifting:

👉 That index position value gets modified

So later when you try:

arr[key]

You are reading wrong updated value

Hence algorithm fails.

🌟 One sentence golden understanding

👉 In insertion sort we must store
element value BEFORE shifting starts

Because shifting destroys original positions.

⭐ Visual analogy (very intuitive)

Think:

You want to insert book “6” into sorted shelf
First you hold book 6 in hand

Then you shift other books.

But in your logic:

👉 You didn’t hold book
👉 You just remembered shelf position

While shifting
👉 someone replaced that shelf book

Now you lost original book 😄

✅ Correct safe approach

Always:

int key = arr[i];   // store VALUE safely

Never:

int key = i;        // only index memory (unsafe)

If you want next level clarity 🙂
I can show you memory diagram drawing style
which will make all sorting dry runs super easy for you.
🧠 Your Revision Notes (paste in comments)
⭐ What is Insertion Sort

👉 Insertion sort is a simple sorting algorithm
👉 It builds the sorted array one element at a time
👉 Each new element is inserted at correct position
in already sorted left portion.

⭐ Steps of Insertion Sort

1️⃣ Assume first element is already sorted
2️⃣ Pick next element as key
3️⃣ Compare key with elements in sorted part (left side)
4️⃣ Shift larger elements one position to right
5️⃣ Insert key at correct position
6️⃣ Repeat until array becomes sorted

⭐ Time Complexity
Worst Case → O(n²) (reverse sorted)
Average Case → O(n²)
Best Case → O(n) (already sorted)

👉 Because in best case no shifting happens

⭐ Space Complexity

👉 O(1)
It is an in-place sorting algorithm

⭐ Important Characteristics

✅ Stable sorting
✅ Adaptive (fast for nearly sorted arrays)
✅ Online algorithm (can sort as data arrives)
❌ Slow for large datasets

⭐ Very Important Interview Line

👉 Insertion sort is more efficient than bubble and selection
for small or nearly sorted arrays

That’s why internally:

⭐ Used in TimSort (Java, Python sorting) for small partitions.
 */