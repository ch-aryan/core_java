package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays;

import java.util.ArrayList;

public class FindIntersection {
    public static void BruteForceIntersection(int a[] , int b[]){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visted = new boolean[b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i] ==  b[j] && !visted[j] ){
                list.add(a[i]);
                    visted[j] = true;
                break;
                }
                if(b[j] > a[i]){
                    break;
                }
            }
        }
        printArr(list);
    }
    public static void OptimizeIntersection(int a[] , int []b){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while(j< b.length && i<a.length){
            if(a[i] == b[j]){
                list.add(a[i]); //if(list.size() == 0 || list.get(list.size()-1) != a[i]){
                                // list.add(a[i]);
                                // }
                i++;
                j++;

            }else if(a[i] < b[j]){
                i++;
            }else{

                j++;
            }

        }
        printArr(list);
    }


    private static void printArr(ArrayList<Integer> list) {
        for(int i:list){
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) {
    int[] a = {1,2,3};
    int[] b = {1,2,3,4,5,6};

  //  BruteForceIntersection(a, b);
    OptimizeIntersection(a,b);
    }
}
/* What You Got Right
✔ Using two loops (i, j) → valid brute force
✔ Thinking about tracking used elements → good
✔ Using sorted property → very good thinking 🔥
🔴 2. Tracking Array (Important Clarification)

You said:

“tracking array to check already taken”

👉 This is correct for brute force 👍

Why needed?
To avoid counting same element multiple times

Example:

a = [1,2,2]
b = [2,2]

👉 Without tracking:

Output = [2,2,2] ❌ wrong

👉 With tracking:

Output = [2,2] ✅ correct
🧠 Correct Brute Force Intuition
💡 Steps:
Loop through a
For each a[i], loop through b
If:
a[i] == b[j] AND not already used

→ add to result
→ mark b[j] as used
→ break

⚠️ Important Observations
❗ Why break after match?
One element should match only once
❗ Why tracking needed?
To avoid reusing same element in b
🧪 Example
a = [1,2,2,3]
b = [2,2,4]
Steps:
i=1 → 2 matches b[0] → mark used
i=2 → 2 matches b[1] → mark used

👉 Result:

[2,2]
⚖️ Complexity
Time: O(n × m) ❌
Space: O(m) (tracking array)
🚀 Final Verdict

👉 Your intuition:

✔ Strong
✔ Thinking about sorted property (very good 🔥)
❌ Small mistake in comparison
❌ Slight confusion in index usage
🎯 Key Correction to Remember
Always compare:
a[i] with b[j]
NOT a[i] with b[i]
🧪 Example
a = [1,2,2,3]
b = [2,2,4]
🧠 Initial Setup
list = []
visited = [false, false, false]

👉 visited corresponds to b:

b = [2,2,4]
      ↑ ↑ ↑
      0 1 2
🔁 Iteration 1 (i = 0)
a[0] = 1
Inner loop:
j = 0 → b[0] = 2
👉 2 > 1 → break ❌

👉 No match

State:
list = []
visited = [F, F, F]
🔁 Iteration 2 (i = 1)
a[1] = 2
Inner loop:
j = 0 → b[0] = 2
👉 Match + not visited ✅
list.add(2)
visited[0] = true
break
State:
list = [2]
visited = [T, F, F]
🔁 Iteration 3 (i = 2)
a[2] = 2
Inner loop:
j = 0 → b[0] = 2
👉 Already visited ❌ skip
j = 1 → b[1] = 2
👉 Match + not visited ✅
list.add(2)
visited[1] = true
break
State:
list = [2,2]
visited = [T, T, F]
🔁 Iteration 4 (i = 3)
a[3] = 3
Inner loop:
j = 0 → b[0] = 2 → skip
j = 1 → b[1] = 2 → skip
j = 2 → b[2] = 4

👉 4 > 3 → break ❌

Final State:
list = [2,2]
visited = [T, T, F]
✅ Final Output
[2,2]
🧠 What You Should Notice
🔥 1. visited[] prevents reuse
First 2 → uses b[0]
Second 2 → uses b[1]

👉 No duplicate misuse ✅

🔥 2. Early Break Optimization
if (b[j] > a[i]) break

👉 Saves unnecessary comparisons

🔥 3. One Match Per Element
break after match

👉 Very important rule

🎯 Final Mental Model
For each element in a:
    find FIRST unused match in b
💬 Simple Analogy

Think:

a = students
b = available seats
visited = seat already occupied

👉 Each student takes one available matching seat.
🧠 What is a boolean[] array?
boolean[] visited = new boolean[b.length];

👉 This creates an array like:

[false, false, false, ...]

👉 By default:

boolean → false
💡 What does visited[j] mean?

It means:

Has this element in b been used already?
🔍 Example
b = [2, 2, 4]
visited = [F, F, F]

👉 Index-wise:

b[0] → visited[0]
b[1] → visited[1]
b[2] → visited[2]
🔥 What does !visited[j] mean?

👉 ! means NOT

So:

visited[j] = false  → !visited[j] = true
visited[j] = true   → !visited[j] = false
💡 Simple Meaning
if (!visited[j])

👉 Means:

"If this element is NOT used yet"
🧪 Step-by-Step Mini Example
b = [2, 2]
visited = [F, F]
First match
a[i] = 2 matches b[0]

Check:

visited[0] = false → !visited[0] = true ✅

👉 Use it:

visited[0] = true

Now:

visited = [T, F]
Second match
a[i] = 2 again

Check:

visited[0] = true → !visited[0] = false ❌ skip

👉 Move to next:

visited[1] = false → !visited[1] = true ✅

👉 Use it:

visited[1] = true
🎯 Why We Need This

Without visited:

a = [2,2]
b = [2]

👉 You would match:

2 → b[0]
2 → b[0] again ❌ (wrong)

With visited:

First 2 → uses b[0]
Second 2 → no unused match ❌

👉 Correct result:

[2]
🧠 Simple Analogy (Very Important)

Think:

b = seats
visited = seat occupied
visited[j] = true → seat taken
visited[j] = false → seat free

👉 !visited[j] → “seat is free”

🔁 One Line Understanding
visited[j] = true  → already used
!visited[j]        → not used yet
🚀 Final Clarity

👉 Your confusion:

❌ Not logic
✔ Just syntax familiarity

👉 Now you know:

boolean array = tracks usage
! = NOT
!visited[j] = “not used yet”
 */