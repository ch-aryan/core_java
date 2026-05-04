package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD;

public class DayIIMaxHeapArray {
    public static boolean algorithmEasy(int []arr){
        int n= arr.length;
        for(int i=0;i<= (n-2)/2;i++){
            if(arr[i] < arr[i*2 +1]) return false;
            if(i*2 + 2 <n && arr[i] < arr[i*2+2]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int [] arr = {90, 15, 10, 7, 12, 2};
        int [] arr1 = {9, 15, 10, 7, 12, 11};

        System.out.println(algorithmEasy(arr));
        System.out.println(algorithmEasy(arr1));
    }
}
/*
Check if an Array is Max Heap
Given an array arr[], determine whether it represents the level-order traversal of a valid max heap. Return true if it does; otherwise, return false.

Examples :

Input: arr[] = [90, 15, 10, 7, 12, 2]
Output: true
Explanation: The given array represents the following tree. Each parent node is greater than or equal to its children, so the max-heap property holds.

Input: arr[] = [9, 15, 10, 7, 12, 11]
Output: false
Explanation: The given array represents the following tree. It does not satisfy the max-heap property, as 9 is smaller than 15 and 10, and 10 is smaller than 11.

❓ Do you need Trees knowledge?
👉 ✅ Yes — but only basic understanding

You don’t need full tree mastery. Just know this:

🧠 Key Concept (Very Important)
A heap stored in an array follows:

For any index i:

Left child  = 2*i + 1
Right child = 2*i + 2
🔥 Max Heap Property
For every node:

arr[i] >= arr[left]
arr[i] >= arr[right]
If this is true for all nodes → it's a Max Heap ✅

💡 Why only till (n-2)/2?

Because:
👉 After that, nodes are leaf nodes
👉 Leaf nodes have no children → nothing to check

🧭 Final Answer
Concept	Needed?
Heap	✅ YES
Tree basics	✅ YES
Queue	❌ NO
Sliding Window	❌ NO
DP / Greedy	❌ NO
🧠 Simple Way to Remember

👉 “Array + parent-child index relation = Heap problem”

 */