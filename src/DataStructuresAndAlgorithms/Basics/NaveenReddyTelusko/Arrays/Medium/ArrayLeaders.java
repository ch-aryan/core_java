package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
         boolean leader = false;

         for(int i=0;i<n-1 ; i++){
             for(int j=i+1;j<n;j++){
                 if(arr[i] >= arr[j]){
                     leader = true;
                 }else{
                     leader = false;
                     break;

                 }
             }
                 if(leader == true)
                 list.add(arr[i]);
             }


         list.add(arr[n-1]);
         return list;
    }
        public ArrayList<Integer> optimal (int arr[]){

        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
            int lastElement = arr[n - 1];
            list.add(lastElement);

            for (int i = n - 1; i > 0; i--) {
                if (arr[i - 1] >= lastElement) {
                    list.add(arr[i - 1]);
                    lastElement = arr[i - 1];
                }
            }

            Collections.reverse(list);

            return list;
        }
    }



/* Nice work Aryan — your intuition is absolutely correct 👏
You already optimized from O(n²) → O(n) by going from right to left. That’s exactly how this problem is meant to be solved.

Now let’s fix the ordering issue you noticed 👇

🧠 What your current code does
for(int i = n-1; i > 0; i--)

👉 You are traversing right → left
👉 So leaders are added in reverse order

Example:

arr = [16, 17, 4, 3, 5, 2]

Your output:

[2, 5, 17]

But expected:

[17, 5, 2]
🎯 Solution: Reverse the result

Since you collected in reverse, just reverse the list at the end

✅ Fixed Code
import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        int lastElement = arr[n - 1];
        list.add(lastElement); // last element is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= lastElement) {
                list.add(arr[i]);
                lastElement = arr[i];
            }
        }

        // Reverse to maintain original order
        Collections.reverse(list);

        return list;
    }
}
🔥 Key Improvement You Made

You correctly used:

lastElement = max so far from right

👉 This is the core pattern:

“Track maximum from right side”

💡 Even Cleaner Thought Process

Instead of thinking “leader”, think:

“Is this element ≥ max seen on right?”

⚡ Alternative (if reverse not allowed)

If interviewer says:

“Don’t reverse”

Then you can use:

LinkedList<Integer> list = new LinkedList<>();
list.addFirst(arr[i]);

👉 This automatically maintains correct order

🧠 Final Takeaway
Your logic = ✅ correct
Your optimization = ✅ perfect
Only missing piece = order handling */