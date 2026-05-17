package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

public class DefinationsClearCut {
}
/*
📘 Sorting Algorithms One-Page Notes
🔵 Bubble Sort
✅ Definition

Repeatedly compares adjacent elements and swaps them if they are in the wrong order. After each pass, the largest unsorted element bubbles to the end.

✅ Steps Involved
Start from index 0.
Compare arr[j] and arr[j+1].
If arr[j] > arr[j+1], swap them.
Continue until the end of the unsorted part.
Repeat for n-1 passes.
✅ Key Idea

Largest element moves to the end in each pass.

✅ Example
[5, 3, 4, 1]
Pass 1 → [3, 4, 1, 5]
Pass 2 → [3, 1, 4, 5]
Pass 3 → [1, 3, 4, 5]
✅ Time Complexity
Best: O(n) (with optimization)
Average: O(n²)
Worst: O(n²)
✅ Space Complexity
O(1)
🟢 Selection Sort
✅ Definition

Repeatedly finds the smallest element from the unsorted part and places it at the correct position.

✅ Steps Involved
Assume the current index i contains the minimum.
Search the rest of the array for a smaller element.
Update the minimum index if found.
Swap the minimum element with arr[i].
Repeat for all positions.
✅ Key Idea

Select the smallest element and place it in the correct position.

✅ Example
[5, 3, 4, 1]
Pass 1 → [1, 3, 4, 5]
Pass 2 → [1, 3, 4, 5]
Pass 3 → [1, 3, 4, 5]
✅ Time Complexity
Best: O(n²)
Average: O(n²)
Worst: O(n²)
✅ Space Complexity
O(1)
🟠 Insertion Sort
✅ Definition

Builds the sorted array one element at a time by inserting each element into its correct position among already sorted elements.

✅ Steps Involved
Assume the first element is sorted.
Pick the next element (key).
Compare it with previous elements.
Shift larger elements one position to the right.
Insert the key into its correct position.
Repeat until all elements are processed.
✅ Key Idea

Insert each element into the correct position in the sorted portion.

✅ Example
[5, 3, 4, 1]
Pass 1 → [3, 5, 4, 1]
Pass 2 → [3, 4, 5, 1]
Pass 3 → [1, 3, 4, 5]
✅ Time Complexity
Best: O(n)
Average: O(n²)
Worst: O(n²)
✅ Space Complexity
O(1)
📊 Quick Comparison Table
Algorithm	Main Idea	Best Case	Average	Worst	Stable
Bubble Sort	Swap adjacent elements	O(n)	O(n²)	O(n²)	Yes
Selection Sort	Select minimum element	O(n²)	O(n²)	O(n²)	No
Insertion Sort	Insert into sorted part	O(n)	O(n²)	O(n²)	Yes
🧠 Memory Tricks
Bubble Sort → Largest element bubbles up to the end.
Selection Sort → Select the smallest element.
Insertion Sort → Insert each element into the sorted part.
 */