package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

import java.util.ArrayList;

public class SpiralTraversal {

        public ArrayList<Integer> spirallyTraverse(int[][] mat) {
            // code here
            ArrayList<Integer> list = new ArrayList<>();
            int n = mat.length;
            int m = mat[0].length;

            int top =0; int left = 0;
            int right = m-1; int bottom = n-1;

            while(top <=bottom && left<=right){
                for(int i=left ; i<=right;i++){
                    list.add(mat[top][i]);
                }
                top++;

                for(int i = top ; i<=bottom ; i++){
                    list.add(mat[i][right]);
                }
                right--;


                if(top <= bottom){

                    for(int i=right; i>=left;i--){
                        list.add(mat[bottom][i]);
                    }
                    bottom--;
                }

                if(left <= right){
                    for(int i= bottom;i>=top; i--){
                        list.add(mat[i][left]);
                    }
                    left++;
                }
            }

            return list;
        }
    }

/*
[Expected Approach] Using Boundary Traversal - O(m*n) Time and O(1) Space
We can print the matrix in a spiral order by dividing it into loops or boundaries. We print the elements of the outer boundary first, then move inward to print the elements of the inner boundaries.

Algorithm:

Define the boundaries of the matrix with variables top, bottom, left, and right.
Print the top row from left to right and increment top.
Print the right column from top to bottom and decrement right.
Check if boundaries have crossed; if not, print the bottom row from right to left and decrement bottom.
Print the left column from bottom to top and increment left.
Repeat until all boundaries are crossed.
🧠 Your doubt:

“We already have while(top <= bottom && left <= right)
then why do we still need:

if(top <= bottom)
if(left <= right)
🔥 Short Answer

Because inside one loop iteration, boundaries change, and after that change, some traversals may become invalid.

👉 The while condition is checked only at the start of the iteration, not in between steps.

🧩 Think of One Iteration Like 4 Steps

Inside one while loop, you do:

Top row ✅
Right column ✅
Bottom row ❓
Left column ❓

Now the problem is:

👉 After step 1 & 2, the matrix boundaries may shrink so much that
step 3 or 4 should NOT run

📉 Example Where It Breaks (Single Row)

Matrix:

1 2 3
Initial:
top = 0, bottom = 0
left = 0, right = 2
Step 1 (Top row):

✔️ Add: 1 2 3
Now → top = 1

Step 2 (Right column):

❌ Should NOT run (because top > bottom now)

But your code will still run it if no if check exists!

💥 Problem:

You will start adding duplicate or invalid values.

🔴 So what happens?

After step 1:

top = 1
bottom = 0

👉 Now:

top > bottom ❌

But since you're still inside the same while iteration,
Java doesn’t re-check the while condition immediately.

✅ That’s why we add:
if(top <= bottom)

👉 “Only traverse bottom row IF it still exists”

🔁 Same logic for left column:

After step 3:

left++ or right--

Matrix might collapse → no columns left

So we check:

if(left <= right)
🧠 Visual Understanding

Think like peeling an onion 🧅:

Each loop removes one “layer”
But sometimes:
only row remains
only column remains

👉 So you must avoid over-traversing

💡 Golden Rule (Remember This in Interviews)

The while loop checks the boundary before the iteration
The if checks are needed inside the iteration after boundary updates

🔥 One-Line Intuition

👉 while = “Can I start another layer?”
👉 if = “Does this side still exist before I traverse it?”

If you want, I can give you:

A step-by-step dry run with diagram
Or a trick to instantly know when these if conditions are needed (super useful in exams 🚀)
can you give me a proper example rathen than just 3 numbers. a great example or test cases for this.

Absolutely Aryan — let’s use a proper, interview-level example where the if conditions actually save you from wrong answers.

🧪 Test Case 1 (Rectangular Matrix — Important)
1   2   3   4
5   6   7   8
9  10  11  12
Expected Spiral:
1 2 3 4 8 12 11 10 9 5 6 7
🔍 Step-by-Step Dry Run
Initial:
top = 0, bottom = 2
left = 0, right = 3
🔹 Step 1: Top Row
1 2 3 4

👉 top = 1

🔹 Step 2: Right Column
8 12

👉 right = 2

🔹 Step 3: Bottom Row
11 10 9

👉 bottom = 1

🔹 Step 4: Left Column
5

👉 left = 1

🔁 Next Iteration:
top = 1, bottom = 1
left = 1, right = 2
🔹 Step 1: Top Row
6 7

👉 top = 2

🔴 NOW IMPORTANT PART
top = 2
bottom = 1

👉 top > bottom ❌

❌ What happens WITHOUT if(top <= bottom)?

Your code will still try:

Step 3 (Bottom Row)

👉 It will wrongly try to access row bottom = 1 again

💥 Result:

Duplicate values OR wrong traversal
✅ With if(top <= bottom)

👉 Step 3 is SKIPPED ✔️

❌ Same for Left Column

Now:

left = 1, right = 2

After Step 3 skip, if you don't check:

if(left <= right)

👉 You may again traverse invalid column

🧪 Test Case 2 (Single Column — VERY IMPORTANT)
1
2
3
4
Expected:
1 2 3 4
What happens WITHOUT if(left <= right)?

After some steps:

left becomes greater than right
But your loop still tries to traverse left column

💥 You’ll add duplicate elements

🧪 Test Case 3 (Odd Square Matrix)
1 2 3
4 5 6
7 8 9
Expected:
1 2 3 6 9 8 7 4 5
Final iteration:

Only one element left:

5

After Step 1:

top becomes > bottom

👉 Without if(top <= bottom):

You’ll try to traverse bottom row again ❌
🧠 FINAL INTUITION (VERY CLEAR)

At some point, the matrix becomes:

Only row left:
[ 6 7 ]

👉 No bottom row anymore → must skip

Only column left:
[5]

👉 No left/right distinction → must skip

🔥 Interview-Level Understanding

These conditions prevent:

❌ Duplicate elements
❌ Invalid traversal
❌ Index errors
💡 Golden Rule (Memorize This)

👉 Whenever you shrink boundaries inside loop,
you must re-check before next traversal
 */
