package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;

import java.util.HashMap;
//bruteforce
// Java Program to count all subarrays having
// XOR of elements as given value K
class GfG {

    // Function to find count of subarrays of arr
    // with XOR value equals to K
    static int subarrayXor(int[] arr, int k) {
        int res = 0;

        // Pick starting point i of subarrays
        for (int i = 0; i < arr.length; i++) {
            int prefXOR = 0;

            // Pick ending point j of subarray for each i
            for (int j = i; j < arr.length; j++) {
                // calculate prefXOR for subarray arr[i ... j]
                prefXOR = prefXOR ^ arr[j];

                // If prefXOR is equal to given value, increase res by 1
                if (prefXOR == k)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarrayXor(arr, k));
    }
}

public class subArrayXOR {
    //using the optimal soltuion prefixXor hasing, map
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n= arr.length;
        int pXor  = 0;
        long result = 0;
        for(int i=0;i<n;i++){
            pXor = pXor ^ arr[i];
            int req = pXor ^ k;
            if(map.containsKey(req)){
                result = result + map.get(req);
            }
            map.put(pXor , map.getOrDefault(pXor,0)+1);
        }
        return result;

    }
}/* This is actually a very important DSA concept (and super useful in interviews). I’ll explain it in a way that really clicks—step by step, with intuition + example.

🔥 Problem Understanding

👉 We want to count subarrays whose XOR = k

Example:

arr = [4, 2, 2, 6, 4], k = 6
🧠 Step 1: Key XOR Property

The whole trick is based on this:

prefixXOR[j] = prefixXOR[i-1] ⊕ subarray(i → j)

Rearranging:

subarray(i → j) = prefixXOR[j] ⊕ prefixXOR[i-1]

Now we want:

subarray XOR = k

So:

prefixXOR[j] ⊕ prefixXOR[i-1] = k

Rearrange:

prefixXOR[i-1] = prefixXOR[j] ⊕ k
💡 Core Idea (MOST IMPORTANT LINE)

👉 If we know:

prefixXOR[j] = current XOR

Then we need:

previous prefix XOR = current XOR ⊕ k
🚀 Why HashMap?

We store:

prefixXOR → how many times it appeared

So when we find:

required = currentXOR ⊕ k

👉 If it exists in map → we found subarrays!

📊 Step-by-Step Example
arr = [4, 2, 2, 6, 4], k = 6
Initial:
prefXOR = 0
map = {}
count = 0
👉 i = 0 → 4
prefXOR = 0 ⊕ 4 = 4
required = 4 ⊕ 6 = 2

map doesn't have 2

map = {4:1}
👉 i = 1 → 2
prefXOR = 4 ⊕ 2 = 6

💥 prefXOR == k → count++

count = 1
required = 6 ⊕ 6 = 0

map doesn't have 0

map = {4:1, 6:1}
👉 i = 2 → 2
prefXOR = 6 ⊕ 2 = 4
required = 4 ⊕ 6 = 2

map doesn't have 2

map = {4:2, 6:1}
👉 i = 3 → 6
prefXOR = 4 ⊕ 6 = 2
required = 2 ⊕ 6 = 4

💥 map has 4 (frequency = 2)

count += 2 → count = 3
map = {4:2, 6:1, 2:1}
👉 i = 4 → 4
prefXOR = 2 ⊕ 4 = 6

💥 prefXOR == k → count++

count = 4
required = 6 ⊕ 6 = 0
✅ Final Answer:
Total subarrays = 4
🎯 Intuition in Simple Words

Instead of checking all subarrays (O(n²)):

👉 We say:

"If I already saw a prefix XOR that can help me make k, then I found a valid subarray!"

🔑 Pattern to Remember

Whenever you see:

"subarray XOR = k"
OR "subarray sum = k"

👉 Think:

prefix + hashmap
*/

/* [Naive Approach] Checking all Subarray - O(n^2) Time and O(1) Space
A Simple Solution is to use two loops to go through all possible
subarrays of arr[] and count the number of subarrays having XOR of their elements as

 */