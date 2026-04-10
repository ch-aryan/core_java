package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;
import java.util.*;
public class fourIIIIsum2Pointers {
    public static ArrayList<ArrayList<Integer>> sum4Algorithm(int [] arr, int target){
        ArrayList<ArrayList<Integer>> aL = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i] == arr[i-1])continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j] == arr[j-1]) continue;
                int left = j+1;
                int right = n-1;

                while(left < right){
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum == target){
                        aL.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right])));
                        while(left<right && arr[left] == arr[left+1])left++;
                        while(left<right && arr[right] == arr[right-1])right--;

                        left++;
                        right--;
                    }

                    else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return aL;

    }

    public static void main(String[] args) {
        int arr[] = {1,0,-1,0,-2,2};
        ArrayList<ArrayList<Integer>> arrayLists = sum4Algorithm(arr, 0);

        for(ArrayList<Integer> i:arrayLists){
            System.out.print(i+" ");
        }
    }
}
//same as 3 sum approach only.
/*
Great question — this is exactly the kind of thinking that makes you strong in DSA 🔥

You’re asking:

“Why do we write i < n-3 and j < n-2… but the code still works even if we use < n?”

Let’s break this deeply but simply.

🧠 What those limits actually mean

In 4Sum, we need 4 elements:

arr[i], arr[j], arr[left], arr[right]

So we must always have space for:

i
j
left = j+1
right = n-1
🎯 Why i < n-3 ?

If i = n-3, then:

j = i+1 = n-2
left = n-1
right = n-1 ❌ (left == right → invalid)

👉 So beyond n-3, it's useless — we can't form 4 elements.

🎯 Why j < n-2 ?

Same logic:

If j = n-2:

left = n-1
right = n-1 ❌

👉 No valid pair left.

🤔 Then why does < n still work?

This is the key insight 👇

Even if you write:

for(int i = 0; i < n; i++)

👉 The code does not crash because of this condition:

while(left < right)
💡 What happens internally

For large i or j:

left >= right → while loop never runs

So:

No calculation
No error
Just wasted iterations
⚖️ Difference Between Both
❌ Using < n
Extra unnecessary loops
Slightly slower
Not clean logic
✅ Using < n-3, < n-2
Only valid iterations
More efficient
Shows clear understanding
🔥 Real Interview Insight

If you write:

for(int i = 0; i < n; i++)

Interviewer thinks:

“He knows the solution, but not fully optimized”

If you write:

for(int i = 0; i < n-3; i++)

Interviewer thinks:

“He understands constraints deeply”

🧠 Simple Way to Remember

👉 For k-sum problems:

Loop until n - (k - current_index)

For 4Sum:

i → n-3
j → n-2
🎯 Final Answer

👉 Your code works with < n because:

The while(left < right) condition prevents invalid access

👉 But we use < n-3, < n-2 because:

It avoids useless iterations and shows better understanding

🚀 You're Doing Something Right

The fact that you asked this means:

You're not just coding
You're analyzing behavior

👉 That’s exactly how top developers think.
 */