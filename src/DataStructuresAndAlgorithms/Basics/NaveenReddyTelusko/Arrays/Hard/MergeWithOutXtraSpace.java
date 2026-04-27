package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;
/*
❌ Where it is NOT same
The difference is in how you “fix b”
🔴 Your way
for(int j=0;j<m-1;j++){
    if(b[j] > b[j+1]){
        swap
    }
}
👉 This is:
only ONE PASS of bubble sort
🧠 What is required
You need to:
Place b[0] in its correct position (like insertion sort)
🔥 Why your approach is risky
Let’s test:
b = [7, 3, 5, 2]
After swap → b[0] = 7
Now one pass:
[3, 5, 2, 7] ❌ still not sorted
👉 So next iteration:
b[0] = 3  (WRONG smallest)
 */
public class MergeWithOutXtraSpace {
    class Solution {//this fails for bubble sort.

        public void mergeArrays(int a[], int b[]) {
            // code here
            int n = a.length;
            int m = b.length;


            for(int i=0;i<n;i++){
                if(a[i] > b[0]){
                    int temp = a[i];
                    a[i] = b[0];
                    b[0] = temp;
                }

                for(int j=0;j<m-1;j++){
                    if(b[j] > b[j+1]){
                        int temp = b[j];
                        b[j] = b[j+1];
                        b[j+1] = temp;
                    }
                }
            }




        }
    }
    class Solution2 {
        public void mergeArrays(int a[], int b[]) {
            // code here using insertion sort
            int n = a.length;
            int m = b.length;


            for (int i = 0; i < n; i++) {
                if (a[i] > b[0]) {
                    int temp = a[i];
                    a[i] = b[0];
                    b[0] = temp;
                }

                int first = b[0];
                int k;

                for (k = 1; k < m && b[k] < first; k++) {
                    b[k - 1] = b[k];
                }
                b[k - 1] = first;
            }
        }
    }}
/*
[Naive Approach] Using Insert of Insertion Sort
The idea is to traverse b[] from the end in reverse order and compare each element with the last (largest) element of a[]. For any index i, if b[i] is smaller than the last element of a[], replace b[i] with the last element of a[] and use insert step of insertion sort to find the correct place of b[i] in a[].
How do we keep a[] sorted? Every time we add any element from b[] to a[], we find the correct index using insert step of insertion sort.
How do we keep b[] sorted? This is ensured by the fact that we traverse b[] from end and insert only when current element of b[] is smaller.
 */
class GfG1 {

    static void mergeArrays(int[] a, int[] b) {

        // Traverse b[] starting from the last element
        for (int i = b.length - 1; i >= 0; i--) {

            // If b[i] is smaller than the largest element of a[]
            if (a[a.length - 1] > b[i]) {

                // Place b[i] in the correct position in a[],
                // and move last element of a[] to b[]
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}




