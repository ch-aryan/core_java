package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class LeftRotateByKspaces {
    static void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        int countRotate=d;
        if(d >= n){
            countRotate = d % n;
        }
        reverse(arr,0, countRotate);
        reverse(arr,countRotate, n);
        reverse(arr,0,n);

        printArr(arr);

    }
    static void reverse (int[] arr,int start, int end){
        int j = end-1;
        for(int i=start ; i<=j ; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
    static void printArr(int [] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int d = 2;
        rotateArr(arr,2);
    }
}
/* the brute force code i am saying the intution tell me is it perfect or not. first save the elmt of the 0 index of original array save in a temp var. and then take for loop (i =0 ; i< arr.length-1) and then shift the elements arr[i] = arr[i+1] and then we know the last elmt is always arr.length-1 = temp var which is the first index . is it perfect brute force.

Yes — that intuition is perfect ✅

You described it exactly right:

Save arr[0] in temp
Shift everything left
Put temp at last index

👉 That is the correct and standard brute-force approach for left rotate by 1.

🧠 Just one small clarification

This is actually:

Time Complexity = O(n)
Space Complexity = O(1)

So technically:

It’s already optimal for rotation by 1
Not really “brute” in a bad sense — it’s actually efficient
⚠️ Tiny thing to be careful about

Your loop:

i < arr.length - 1

✔ Correct — avoids out of bounds
✔ Ensures last element is handled separately

🚀 Final Verdict

👉 Your thinking:

✔ 100% correct
✔ Clean logic
✔ Interview safe
HINT for “Better” Approach

Think like this:

👉 Instead of shifting one-by-one…

Can you store a small part of the array first?

Clue:

Take first k elements → store somewhere
Shift remaining elements left
Put stored elements at the end

👉 Ask yourself:

How many elements do I really need to save?
Can I avoid shifting repeatedly?
🚀 HINT for “Optimal” Approach (Most Important)

This is the famous trick 🔥

👉 Think in terms of reversing parts of the array

Clue:

If you reverse smartly, shifting happens automatically

Break problem into 3 steps:

Reverse first k elements
Reverse remaining elements
Reverse entire array

👉 Ask yourself:

Why does reversing rearrange positions correctly?
Can reversing simulate rotation?
🧠 Mental Model

Instead of thinking:

“move elements one by one”

Think:

“rearrange blocks of array”
🎯 Final Direction
Better → uses extra space (store k elements)
Optimal → uses reverse trick (no extra space)
 */