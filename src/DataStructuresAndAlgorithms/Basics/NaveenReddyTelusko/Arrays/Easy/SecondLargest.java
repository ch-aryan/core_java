package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class SecondLargest {
    public static void main(String[] args) {
        int [] arr = {5,4,5};
        int largest = Integer.MIN_VALUE;
        int secondLar = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > largest ){
                secondLar = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLar && arr[i] != largest){
                secondLar = arr[i];
            }
        }
        System.out.println(largest);
        System.out.println(secondLar);
    }
}
/*
🧠 Key learning (THIS matters more than code)

When solving this type:

👉 Always think in this order:

If new number > largest
shift largest → second
Else if number fits between largest & second
update second

class Solution {
    public int secondLargestElement(int[] nums) {
        int lar = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > lar) {
                sec = lar;
                lar = num;
            }
            else if (num > sec && num != lar) {
                sec = num;
            }
        }

        return (sec == Integer.MIN_VALUE) ? -1 : sec;
    }
}
 */