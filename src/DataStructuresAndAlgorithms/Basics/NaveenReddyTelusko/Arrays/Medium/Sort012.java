package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class Sort012 {
//own logic & implementation.
        public void sort012(int[] arr) {
            // code here
            //bruteforce.
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;

            for(int i=0;i<arr.length;i++){
                if(arr[i] == 0){
                    count0++;
                }else if(arr[i] == 1){
                    count1++;
                }else{
                    count2++;
                }
            }
            int i=0;
            while(count0 >0){
                arr[i] = 0;
                i++;
                count0--;
            }
            while(count1 >0){
                arr[i] = 1;
                i++;
                count1--;
            }
            while(count2 >0){
                arr[i] = 2;
                i++;
                count2--;
            }
        }
        public void sort012DutchNationalFlag(int[] arr){

        }
    }


/* ✅ Your Approach — Is it correct?

👉 Yes, completely correct ✅

You:

Counted 0s, 1s, 2s ✔️
Rewrote the array ✔️

This is a valid and accepted solution

🧠 What you did (intuition)

You basically said:

“I don’t care about order, I’ll just count and rebuild”

That’s a frequency-based sorting idea — very strong thinking 👍

⏱️ Complexity
Time → O(n) ✅
Space → O(1) ✅

👉 So this is already optimal in complexity

⚠️ But why is it called “brute force”?

Not because it’s slow — but because:

You are doing 2 passes
Count
Rewrite

👉 There exists a one-pass solution */