package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.HashMap;

public class MajorityElement {
    //bruteforce but time limti got exceeded in gfg 1120/1131 test cases passed but time is greater.
        int majorityElement(int arr[]) {
            // code here
            int n = arr.length;
            if(n==1){
                return arr[0];
            }

            for(int i=0;i<n-1;i++){
                int count =1;
                for(int j = i+1;j<n; j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
                if(count > n/2){
                    return arr[i];
                }
            }
            return -1;
        }
    int majorityElementUsingHashMap(int arr[]) {
        // code here
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
//tc O(n) + n = O(n) only. and sc O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            if( map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        for(int i=0;i<n;i++){
            if(map.get(arr[i]) > n/2){//get(key)
                return arr[i];//key;
            }
        }
        return -1;
    }
    }

/* we can't use the hashing here. like this it will only work for few test cases.
 int[] hash = new int[10000000];
      for(int i =0;i<n;i++){
          hash[arr[i]]++;
      }
      for(int i = 0;i<n; i++){
          if(hash[arr[i]] > n/2){
              return arr[i];
          }
      }
        return -1;
    }

    always remember in hashmap.
    ✅ What you actually want

If key exists → increment count
Else → put it with count = 1

✅ Correct pattern (very important 🔥)
HashMap<Integer, Integer> map = new HashMap<>();

for(int i = 0; i < n; i++){
    if(map.containsKey(arr[i])){
        map.put(arr[i], map.get(arr[i]) + 1);
    } else {
        map.put(arr[i], 1);
    }
} map.get(arr[i]) will return the value means how many times it appeared right.
Exactly right ✅
You understood it perfectly.
map.get(arr[i]) → gives the current count (how many times it appeared so far)
+ 1 → means we saw it one more time
So this line:
map.put(arr[i], map.get(arr[i]) + 1);
means:
👉 “Update the frequency of this element by increasing it”
🧠 One small thing to remember
map.get(arr[i]) will work only if the key already exists
That’s why we do:
if(map.containsKey(arr[i])) {
    map.put(arr[i], map.get(arr[i]) + 1);
} else {
    map.put(arr[i], 1);
}
OR the shortcut:
map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
🧠 How this works (simple thinking)

Let’s say:

arr = [1, 2, 1, 1]

Step-by-step:

1 → not present → put(1,1)
2 → not present → put(2,1)
1 → present → update → put(1,2)
1 → present → update → put(1,3)

Final map:

1 → 3
2 → 1
⚡ Shortcut (interview bonus)

Once you’re comfortable, you can write it in one line:

map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
 */
//hashmap algo and method details.
/*
Yes 👍 — this is a correct “better solution” using hashing.

        ✅ What you did right
Count frequencies using HashMap ✔️
Then check if any element has count > n/2 ✔️
Time complexity: O(n) + O(n) = O(n) ✔️
Space complexity: O(n) ✔️
        🟡 Small improvement (interviewer-level polish)

Your second loop:

        for(int i=0;i<n;i++){
        if(map.get(arr[i]) > n/2){
        return arr[i];
        }
        }

        👉 This works, but you're checking duplicates again.

        ✅ Slightly better version

Iterate over map directly:

        for(int key : map.keySet()){
        if(map.get(key) > n/2){
        return key;
    }
            }

            👉 This avoids redundant checks and looks cleaner in interviews.

🔥 Even cleaner (your level next step)
map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        💬 Honest feedback

You’ve done:

        ✅ Brute force
✅ Better (hashing)
✅ Understood logic deeply

This is exactly how top candidates build problem-solving skills.*/