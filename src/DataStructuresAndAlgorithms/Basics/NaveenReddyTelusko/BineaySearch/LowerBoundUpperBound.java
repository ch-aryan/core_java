package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

//For Lower Bound:
//Condition → arr[mid] >= target
//Action → store ans & move LEFT
public class LowerBoundUpperBound {
    public static int LowerBound(int arr[] , int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid -1;
            }else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static int upperBound(int arr[] , int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] > x){
                ans = mid;
                high = mid -1;
            }else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,3,5,7};
        int tar = 3;
        int tar1 = 4;
        int i = LowerBound(arr, tar1);
        System.out.println(i);
      int j =   LowerBound(arr, tar);
        System.out.println(j);

        int k = upperBound(arr, tar);
        System.out.println(k);
    }
}
/*
🧠 What is Lower Bound?
👉 Lower Bound = first position where value ≥ target
📌 Example:
arr = [1, 3, 3, 5, 7]
target = 3
👉 Lower Bound = index of first 3
➡️ Answer = 1
Another example:
arr = [1, 3, 3, 5, 7]
target = 4
👉 First element ≥ 4 is 5
➡️ index = 3
💡 Definition (remember this line)
Lower Bound = first index where arr[i] >= target

//upper bound
What is Upper Bound?

👉 Upper Bound = first position where value > target

📌 Example:
arr = [1, 3, 3, 5, 7]
target = 3

👉 First element > 3 is 5

➡️ index = 3

💡 Definition

Upper Bound = first index where arr[i] > target

⚡ Difference (VERY IMPORTANT)
Concept	Condition
Lower Bound	≥ target
Upper Bound	> target
🔍 Why Binary Search?

Because array is sorted.

👉 Instead of checking all elements:

We cut search space in half → O(log n)

🧠 Intuition (THIS IS GOLD)

Think like this:

👉 Lower Bound = “Where can I place target without breaking order?”
👉 Upper Bound = “Where does strictly bigger start?”

🔥 Real Use Cases (Important)

These concepts are used in:

First & Last occurrence
Count occurrences
👉 count = upperBound - lowerBound
Search insert position
Binary search on answers (VERY IMPORTANT 🔥)
🎯 Simple Visualization
arr = [1, 3, 3, 3, 5, 7]

target = 3

Lower Bound → first 3 → index 1
Upper Bound → first >3 → index 4
🧩 Final Mental Model

👉 Lower Bound → start of target zone
👉 Upper Bound → end of target zone + 1

“Why am I learning lower/upper bound? How does this help in Trees / BST?”
That’s a very smart question.

🧠 Short Answer (keep this in mind)

Binary Search on arrays = Binary Search Tree (BST) thinking in structure

If you understand lower/upper bound well,
👉 you already understand how BST searches work internally

🌳 Connection to BST (VERY IMPORTANT)

In a Binary Search Tree (BST):

Left subtree → values smaller
Right subtree → values greater

Now think:

🔍 When you search in BST:
If target < node → go left
If target > node → go right

👉 This is EXACTLY what you do in binary search.

🔗 Now where do Lower & Upper Bound fit?
✅ Lower Bound in BST

First value ≥ target

In BST:

You traverse
Keep track of a potential answer
Move left/right accordingly

👉 This is literally how you find ceil in BST

✅ Upper Bound in BST

First value > target

In BST:

Same traversal logic
Just condition changes slightly
💡 Direct Mapping
Array Concept	BST Equivalent
Lower Bound	Ceil in BST
Upper Bound	Strict successor
Binary Search	Tree traversal decision
🎯 Example

Suppose BST:

        10
       /  \
      5    15
          /  \
         12   20

Target = 13

👉 Lower Bound (≥13) = 15

How do you find it?

13 > 10 → go right
13 < 15 → store 15, go left
13 > 12 → go right
stop

👉 Answer = 15

🧠 What you're actually learning

By doing lower/upper bound, you're training:

🔥 1. Decision making
go left or right
🔥 2. Maintaining candidate answer
store possible result
🔥 3. Narrowing search space
same as tree traversal
⚡ Why this matters for interviews

These problems directly map to:

Ceil in BST
Floor in BST
Inorder successor
Range queries
Balanced BST operations
🧩 Final Insight (VERY IMPORTANT)

Arrays + Binary Search = Simulation of BST without building tree

Later when you study trees,
👉 everything will feel familiar, not new.

💬 Honest truth

If you skip understanding this deeply:

👉 BST problems will feel confusing

But if you understand this now:

👉 BST will feel easy and natural
 */
/*
Correct mapping:
Lower Bound (LB) → first index where arr[i] >= x
👉 gives first occurrence
Upper Bound (UB) → first index where arr[i] > x
👉 so last occurrence = UB - 1
 */