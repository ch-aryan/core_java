package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;
import java.util.*;
/* important 🧠 1. What you said
“we can have same i, j, k but we can't have the 3 sum pair once again right”
👉 This is partly correct but needs correction
⚠️ 2. Important Rule (Very Clear)
❌ You CANNOT use the same index
i, j, k must be different indices
✅ You CAN use same values (duplicates)
Example:[0, 0, 0]
Indices:
i = 0, j = 1, k = 2
👉 All values same, but indices different → ✅ VALID
🔥 3. What is NOT allowed
👉 Duplicate triplets in output ❌
Example:
[-1, 0, 1]
[-1, 0, 1] ❌ duplicate
👉 You should return it only once
🧠 4. So the Correct Understanding
✅ Allowed:
Same values ✔️
Different indices ✔️
❌ Not Allowed:
Same index reused ❌
Same triplet repeated in answer ❌
🔍 5. Example Breakdown
arr = [0, 0, 0, 0]
Possible combinations:
(0,1,2) → [0,0,0] ✅
(0,1,3) → [0,0,0] ❌ duplicate
(1,2,3) → [0,0,0] ❌ duplicate
👉 Different indices are required, but duplicate values are allowed — only unique triplets should be returned.
*/


public class IIISum {
    //bruteforce return indexing and if want values as well.
    // User function Template for Java
    class Solution {
        public List<List<Integer>> findTriplets(int[] arr) {
            // Your code here
            HashSet<String> set = new HashSet<>();
            List<List<Integer>> res = new ArrayList<>();

            int n = arr.length;

            for(int i =0;i<n-2;i++){
                for(int j=i+1;j<n-1;j++){
                    for(int k = j+1;k<n;k++){
                        if(arr[i] + arr[j] + arr[k] == 0){
                            // create triplet
                            List<Integer> temp = new ArrayList<>();
                            // temp.add(arr[i]);
                            // temp.add(arr[j]);
                            // temp.add(arr[k]);
                            temp.add(i);
                            temp.add(j);
                            temp.add(k);

                            // sort it (CRITICAL 🔥)
                            // Collections.sort(temp);

                            //convert to string for set
                            String key = temp.toString();

                            // check duplicate
                            if(!set.contains(key)){
                                set.add(key);
                                res.add(temp);
                            }


                        }
                    }
                }
            }
            return res;

        }
    }
}
// User function Template for Java
//better solution using hashing concept .
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here

        List<List<Integer>> res = new ArrayList<>();

        int n = arr.length;

        for(int i=0;i<n-1;i++){
            HashSet<Integer> set = new HashSet<>();

            for(int j = i+1;j<n ; j++){

                //how to add elements in the set from range i To j.

                int third = -(arr[i] + arr[j]);
                if(set.contains(third)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    // ⚠️ important
                    if(!res.contains(temp)){ // avoid duplicates
                        res.add(temp);
                    }

                }
                set.add(arr[j]);
            }

        }

        return res;

    }
}
//bruteforce
/* 🔥 4. Solution (IMPORTANT)

👉 Before storing triplet:

Sort the triplet
Store in Set
🔥 7. Flow (Your Thinking Style)

👉 For every (i, j, k):

Check sum == 0
Make triplet
Sort it
Convert to string
Check in set
Add if new
🧠 6. Why We Use String in Set?

Because:

HashSet<List<Integer>> ❌ (can be tricky with equality)

So we do:

String key = temp.toString();

👉 Example:

[-1, 0, 1] → "[-1, 0, 1]"
That’s a really good doubt, Aryan 👍 — this is exactly where many people get confused.

Let’s clear it properly.

🧠 1. Your Question

👉 “Why HashSet<String> and not HashSet<Integer> or HashSet<List<Integer>>?”

❌ 2. Why NOT HashSet<Integer>

Because:

👉 You are storing triplets, not single numbers

Example:

[-1, 0, 1]

This is:

3 numbers together → one group

So:

HashSet<Integer> ❌

👉 Can only store ONE number at a time

⚠️ 3. Why HashSet<List<Integer>> Feels Risky

Actually, this is IMPORTANT:

👉 It is NOT wrong ❌
👉 But beginners avoid it because of confusion

🔍 Problem: Equality + Order

HashSet checks:

.equals()
.hashCode()

Now:

List<Integer> a = Arrays.asList(-1, 0, 1);
List<Integer> b = Arrays.asList(0, -1, 1);

👉 These are NOT equal ❌
Even though logically same

🔥 4. REAL ISSUE = ORDER

👉 Set does NOT understand:

“these numbers are same combination”

It only sees:

[-1, 0, 1] ≠ [0, -1, 1]
✅ 5. Why We Sort First
Collections.sort(temp);

Now:

[-1, 0, 1]
[0, -1, 1] → [-1, 0, 1]

👉 Both become SAME ✅

🧠 6. Then Why Use String?
String key = temp.toString();

👉 Because:

Easy to store
Easy to compare
No confusion about equals/hashCode

Example:

[-1, 0, 1] → "[-1, 0, 1]"

👉 Strings compare perfectly in HashSet

🔥 7. Can We Use HashSet<List<Integer>>?

👉 YES — if you sort properly

HashSet<List<Integer>> set = new HashSet<>();

Collections.sort(temp);
set.add(temp);

👉 This works because:

Order is same
List equality works
⚖️ 8. So Which One Should YOU Use?
For learning / clarity:

👉 Use String approach ✅ (simple)

For interviews:

👉 Use List directly ✅ (cleaner)

🚀 9. Interview-Level Clean Version
HashSet<List<Integer>> set = new HashSet<>();

Collections.sort(temp);

if(!set.contains(temp)){
    set.add(new ArrayList<>(temp)); // important copy
    res.add(temp);
}
⚠️ 10. VERY IMPORTANT DETAIL
set.add(new ArrayList<>(temp));

👉 Why?

Because:

List is mutable
If modified later → set breaks
 */
//better solution.
/* Perfect, Aryan — this is the right next step 👍
You’re moving from brute force → hashing (O(n²)), which is exactly how this problem is learned.

I’ll keep your structure and just guide/fix it.

🧠 1. Your Idea (Correct Direction ✅)

You’re thinking:

👉 Fix i
👉 For every j, check:

𝑎
arr[i]+arr[j]+x=0⇒x=−(arr[i]+arr[j])

👉 Now check if x already exists → using HashSet

🔥 This is correct!

⚠️ 2. Your Doubt

“how to add elements in the set from range i to j?”

👉 Important concept:

You don’t pre-fill the set
👉 You build it on the fly inside the loop

🔥 3. Correct Pattern (VERY IMPORTANT)

For every i:

Create a new set
Then iterate j
Check if required element exists
Then add current element to set
For each i:

Step-by-step:
Start empty set
Move j
Compute third

Check:

if(set.contains(third))

Then:

set.add(arr[j]);
⚠️ 6. CRITICAL POINTS (Don’t Miss)
🔴 1. New Set for Every i
HashSet<Integer> set = new HashSet<>();

👉 If you reuse → wrong answer ❌

🔴 2. Add AFTER checking
if(set.contains(third)) // check first
set.add(arr[j])         // then add

👉 Order matters!

🔴 3. Sorting triplet
Collections.sort(temp);

👉 Needed for duplicate handling

🔴 4. Duplicate issue still exists
if(!res.contains(temp))

👉 This makes it slightly slower
(but fine for now)

⚡ 7. Time Complexity
Step	Complexity
Outer loop	n
Inner loop	n
Set operations	O(1)

👉 Total = O(n²) ✅

🚀 8. Improvement (Next Level)

Instead of:

res.contains(temp)

👉 Use:

HashSet<List<Integer>>

OR go to:
👉 Two pointer approach (best solution)

🎯 9. One-Line Revision

👉 Fix one element, use HashSet to find the third element in O(1).
 */