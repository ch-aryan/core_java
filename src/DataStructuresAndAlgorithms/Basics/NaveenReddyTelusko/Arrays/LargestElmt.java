package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

public class LargestElmt {
    public static int LargestAlgo1(int arr[]){
        int lar = 0;
        for(int i =0;i<arr.length-1;i++){
            if(arr[i] >= arr[i+1]){
                lar = Math.max(lar,arr[i]);
            }else{
                lar = Math.max(lar,arr[i+1]);
            }
        }
        return lar;
    }
    public static int LargestAlgo2(int arr[]) {
        int lar = arr[0];  // important

        for (int i = 1; i < arr.length; i++) {
            lar = Math.max(lar, arr[i]);
        }

        return lar;
    }

    public static void main(String[] args) {
    int [] arr = {3,2,1,5,2,100};
   int res = LargestAlgo1(arr);
        System.out.println(res);

        int res1 = LargestAlgo2(arr);
        System.out.println(res1);
    }
}
/* ❌ Problem in Your Code

Your logic compares only adjacent elements:

if(arr[i] >= arr[i+1]){
    lar = Math.max(lar,arr[i]);
}else{
    lar = Math.max(lar,arr[i+1]);
}
🔴 Issues:
1. Wrong Initialization
int lar = 0;
If array contains all negative numbers, your result will be wrong.
Example:
int[] arr = {-10, -5, -2};

👉 Your output = 0 ❌ (wrong)
👉 Correct output = -2

2. Unnecessary Adjacent Comparison

You are comparing:

arr[i] vs arr[i+1]

But finding max doesn’t require that.

👉 You just need:

compare current element with current max
3. Loop is Slightly Misleading
for(int i = 0; i < arr.length - 1; i++)
You’re skipping clean logic and adding complexity.
✅ Correct & Optimal Approach
🔥 Simple and Clean Code:
public static int LargestAlgo1(int arr[]) {
    int lar = arr[0];  // important

    for (int i = 1; i < arr.length; i++) {
        lar = Math.max(lar, arr[i]);
    }

    return lar;
}
🧠 Why This Works Better
Start with first element as max
Compare every element with current max
No unnecessary conditions
Works for negative values also*/
