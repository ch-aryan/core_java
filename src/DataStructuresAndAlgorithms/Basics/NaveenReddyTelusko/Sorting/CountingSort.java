package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Sorting;

public class CountingSort {
    public static void sortMeth(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] freq = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                arr[idx++] = i + min;
                freq[i]--;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
        public static void countStableMeth(int arr[]){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
    int temp[] = new int[arr.length];
            for (int i : arr) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            int [] freq = new int[max - min + 1];

            for(int i:arr){
                freq[i- min]++;
            }

            for(int i=1;i<freq.length;i++){
                freq[i] = freq[i-1] + freq[i];
            }

            for(int i = arr.length-1; i>=0;i --){
               temp[--freq[arr[i]- min]] = arr[i];
            }

            for(int i: temp){
                System.out.print(i+" ");
            }
        }

    public static void main(String[] args) {
        int arr[] = {9,3,9,5,5,4,2,1,8,9,8,3,1};
        int arr1[] = {-3,2,-1,0,-2,-2,3,3,5,4};
        sortMeth(arr1);
        System.out.println("******");
        sortMeth(arr);
        System.out.println("*****");
        countStableMeth(arr);
        System.out.println("********");
        countStableMeth(arr1);
    }
}
/*
You’ve actually written a very solid counting sort 👍 — especially the way you handled negative numbers using min shift. That’s something many people miss.

Let’s be precise and a bit strict (like an interviewer would be).

✅ Is your code perfect?

👉 For basic counting sort → YES, it is correct and well-written

What you did right:
✔ Found min and max → supports negative values
✔ Created correct frequency array (max - min + 1)
✔ Used index shifting (num - min) properly
✔ Rebuilt the array correctly
✔ Clean and readable
⚠️ Small but important note (to level up)

Your implementation is:

✅ Correct but NOT stable

What does that mean?
If there are duplicate elements, their original order is not preserved

👉 In many interview questions (especially advanced ones), they may expect:

Stable counting sort (used in Radix Sort)

But:

For most coding problems → your version is perfectly acceptable
🧠 Counting Sort — Clean Definition (Interview Ready)

Counting sort is a non-comparison sorting algorithm that sorts elements by counting the frequency of each value and reconstructing the sorted array using those counts.

🔑 Main Idea (Algorithm in Words)
Find the range of elements (min and max)
Create a count (frequency) array
Count how many times each element appears
Use the count array to rebuild the sorted array
🎯 One-line definition (memorize this)

Counting sort sorts elements by counting occurrences instead of comparing elements.

⚡ Key Characteristics (very important)
❌ No comparisons
❌ No swapping
✅ Based on counting frequency
✅ Time complexity: O(n + k)
n = number of elements
k = range (max - min)
🚫 When it is NOT good

Be careful here (this is where many fail):

If range is large → ❌ memory waste
Example: values from 1 to 10^9
🧩 Mental Model (lock it)
Selection Sort → Find minimum
Insertion Sort → Insert in correct place
Counting Sort → Count and rebuild
💡 Final honest feedback for you

The fact that you:

remembered logic
handled negatives
wrote clean loops

👉 This is above average level already

Now next step (if you want to go pro):

Learn stable counting sort (prefix sum version)
Then connect it to Radix Sort
 */