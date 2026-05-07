package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;

import java.util.ArrayList;
//always remember  1 % 2 = 1. because 2 cannot go in once so remainder stays as it as for ex used for 32. 16, all 2 powers.
public class dayVSortBitCount {
    //tc exceed my own logic thinking.
    class Solution {
        public static int countSetBits(int n){
            int count = 0;
            while(n > 0){
                if(n % 2 == 1) count++;
                n = n / 2;
            }
            return count;
        }
        ArrayList<Integer> sortBySetBitCount(int[] arr) {
            // code here
            int n = arr.length;
            int [][] data = new int[n][2];
            //step1 : store number + set bits
            for(int i=0;i<n;i++){
                data[i][0] = arr[i];
                data[i][1] = countSetBits(arr[i]);
            }
            //bubble sort (descending)
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1; j++){
                    if(data[j][1] < data[j+1][1]){
                        int temp = data[j][0];
                        int temp1 = data[j][1];

                        data[j][0] = data[j+1][0];
                        data[j][1] = data[j+1][1];

                        data[j+1][0] = temp;
                        data[j+1][1] = temp1;
                    }
                }
            }
            //but by using  Arrays.sort(data, (a,b)-> b[1] - a[1]); we can solve it easyily.
            //step 3 : copy back
            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0;i<n;i++){
                result.add(data[i][0]);
            }
            return result;

        }
    }

}
/*
🧠 What You’re Doing Right

Your idea is actually correct at a high level:

Count number of 1s in binary
Store that info
Sort based on that count (descending)
Maintain order (stable sort)

That’s exactly the expected logic ✅

🔥 Clean Way to Think About This

Instead of using a HashMap, think like this:

👉 Each number has a property = number of set bits
👉 So we sort based on that property

🧩 Step-by-Step Simple Approach (No Bit Tricks)
Step 1: Count set bits (your logic but clean)
int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        if (n % 2 == 1) count++;
        n = n / 2;
    }
    return count;
}
Step 2: Sort using custom comparator
import java.util.*;

class Solution {
    void sortBySetBitCount(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int countA = countSetBits(a);
            int countB = countSetBits(b);

            if (countB != countA) {
                return countB - countA; // descending
            } else {
                return 0; // maintain order (stable sort)
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n = n / 2;
        }
        return count;
    }
}
⚡ Important Insight

You don’t need HashMap here because:

You are not doing lookup
You are sorting based on a computed property

👉 So comparator is the correct tool

🚀 Once You’re Ready (Next Level)

After you’re comfortable, I’ll show you:

Integer.bitCount(n)

and

n & (n - 1)

These make it 🔥 efficient.

🧭 What You Should Focus On

Right now your learning goal is perfect:

Build intuition ✔️
Understand binary breakdown ✔️
Learn sorting with custom logic ✔️

🧠 Your Idea (Refined Properly)

You said:

count 1s → store → arrange highest to lowest

Perfect. Let’s just fix and complete it cleanly.

✅ Step-by-Step Original Algorithm (Your Style)
🔹 Step 1: Count set bits for each number

Instead of breaking your array, create a 2D structure:

[number, setBitCount]

Example:

5  → 2
2  → 1
3  → 2
9  → 2
🔹 Step 2: Store in 2D array
int[][] data = new int[arr.length][2];

for (int i = 0; i < arr.length; i++) {
    data[i][0] = arr[i];                // original number
    data[i][1] = countSetBits(arr[i]); // count of 1s
}
🔹 Step 3: Sort this manually (Bubble Sort)

No built-in sort. Full control. Pure logic.

for (int i = 0; i < data.length - 1; i++) {
    for (int j = 0; j < data.length - i - 1; j++) {

        // sort in descending order of set bits
        if (data[j][1] < data[j + 1][1]) {

            // swap both number and count
            int temp0 = data[j][0];
            int temp1 = data[j][1];

            data[j][0] = data[j + 1][0];
            data[j][1] = data[j + 1][1];

            data[j + 1][0] = temp0;
            data[j + 1][1] = temp1;
        }
    }
}

👉 Bubble sort is stable, so same-bit elements keep order automatically ✔️

🔹 Step 4: Put back into original array
for (int i = 0; i < arr.length; i++) {
    arr[i] = data[i][0];
}
🔹 Step 5: Your bit counting logic (simple)
int countSetBits(int n) {
    int count = 0;

    while (n > 0) {
        if (n % 2 == 1) count++;
        n = n / 2;
    }

    return count;
}
🔥 Full Code (Your Style, Cleaned)
class Solution {

    void sortBySetBitCount(int[] arr) {
        int n = arr.length;

        int[][] data = new int[n][2];

        // Step 1: store number + set bits
        for (int i = 0; i < n; i++) {
            data[i][0] = arr[i];
            data[i][1] = countSetBits(arr[i]);
        }

        // Step 2: bubble sort (descending)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j][1] < data[j + 1][1]) {

                    int temp0 = data[j][0];
                    int temp1 = data[j][1];

                    data[j][0] = data[j + 1][0];
                    data[j][1] = data[j + 1][1];

                    data[j + 1][0] = temp0;
                    data[j + 1][1] = temp1;
                }
            }
        }

        // Step 3: copy back
        for (int i = 0; i < n; i++) {
            arr[i] = data[i][0];
        }
    }

    int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n = n / 2;
        }
        return count;
    }
}
💡 Why This Is Powerful for You
No advanced methods ✔️
No confusion ✔️
Full control ✔️
Builds real understanding ✔️
⚡ Next Step (Important)

Once you're comfortable with this:

👉 Replace Bubble Sort → with efficient sorting
👉 Replace %2 → with bit manipulation

That’s how you level up naturally, not forcefully.

👉 Every power of 2 has exactly ONE set bit

Number	Binary	Set Bits
1	1	1
2	10	1
4	100	1
8	1000	1
16	10000	1
32	100000	1
🔥 Key Insight (Very Important)

👉 Numbers like 32 are pure powers of 2

Which means:

n = 2^k  → only one '1' in binary
⚡ Quick Trick to Remember

If a number is divisible by 2 repeatedly until it becomes 1:

32 → 16 → 8 → 4 → 2 → 1

👉 then it has exactly one set bit

🧭 Final Answer

❌ Not 0
✅ Count = 1
🧠 What does % mean?
% is the modulus operator
👉 It gives the remainder after division

🔍 Now your question:
1 % 2 = ?
👉 Divide 1 by 2:

2 cannot go inside 1 even once

So quotient = 0

remainder = 1

1 = 0 × 2 + 1
👉 Therefore:

1 % 2 = 1
⚡ Simple intuition
If number is even → remainder = 0

If number is odd → remainder = 1

🔥 Quick Examples
Expression	Result	Why
4 % 2	0	4 is even
5 % 2	1	5 is odd
1 % 2	1	1 is odd
💡 Connection to your problem
When you do:

if (n % 2 == 1)
👉 You’re checking:

➡️ “Is the last binary digit 1?”
➡️ “Is the number odd?”

🧭 Final Answer
1 % 2 = 1
because remainder after dividing 1 by 2 is 1
 */