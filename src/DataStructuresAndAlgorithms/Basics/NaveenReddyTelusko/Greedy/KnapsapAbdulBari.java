package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Greedy;

import java.util.Arrays;

/*
Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
Return the maximum value as a double, rounded to 6 decimal places. Examples :
Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg.
 Hence total price will be 60+100+(2/3)(120) = 240
 */
public class KnapsapAbdulBari {
    public static double greedyAlgo(int val[] , int [] wt, double cap){
        double [][] items = new double[val.length][3];
        int n= val.length;
        for(int i=0;i<n;i++){
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = (double) val[i]/wt[i];
        }           //syntAX RATTY OR UNDERSNTAD.
        Arrays.sort(items, (a, b) -> Double.compare(b[2] , a[2]));


        double res =0;
        for(int i=0;i<n;i++){
            if(cap >= items[i][1]){
                res = res + items[i][0];
                cap = cap - items[i][1];
            }else{
                res = res + cap * items[i][2];
                break;
            }

        }
        return res;
    }
    public static void main(String[] args) {
       int val[] = {60, 100, 120};
       int wt[] = {10, 20, 30};
       double capacity = 50;
        double v = greedyAlgo(val, wt, capacity);
        System.out.println(v);
    }
}
/*
🧠 Correct Greedy Idea

Instead of separating arrays, do this:

👉 Keep everything together:

(value, weight, ratio)

Then sort based on ratio descending
🔴 What’s going wrong in your code
❌ 1. Integer division bug
ratio[i] = val[i]/wt[i];

👉 Both are int, so:

5 / 2 = 2   (not 2.5 ❌)
✅ Fix:
ratio[i] = (double) val[i] / wt[i];
🔴 The bug is here
items[i][2] = (double) (val[i]/wt[i]);

👉 This still does integer division first, then converts to double.

Example:
10 / 7 = 1   → then becomes 1.0 ❌

👉 But we actually need:

10 / 7 = 1.428... ✅
✅ Fix (VERY IMPORTANT)

Change this line to:

items[i][2] = (double) val[i] / wt[i];

👉 Now division happens in double, not int

🔥 Why this matters

Greedy depends on correct ordering of ratios

If ratios are wrong:

Sorting becomes wrong
You pick wrong items
Final answer becomes wrong (like your 35 instead of 37)
🧠 What Arrays.sort(..., comparator) really does

When you write:

Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

👉 Java repeatedly asks your comparator:

“Between a and b, who should come first?”

🔍 Understand the comparator (tiny pieces)
1. What are a and b?

If:

double[][] items = {
    {60,10,6.0},
    {100,20,5.0},
    {120,30,4.0}
};

Then during sorting:

a = {60,10,6.0}
b = {100,20,5.0}
2. What does this line mean?
Double.compare(b[2], a[2])

👉 Compare ratio of b vs ratio of a

3. How Double.compare(x, y) works
Case	Meaning
< 0	x < y → x comes first
> 0	x > y → y comes first
0	equal
🧠 Why b[2], a[2] (reverse)?

We want descending order (highest ratio first)

Example:
a = 6.0
b = 5.0
Double.compare(5.0, 6.0) → -1

👉 Negative → a comes before b

✔️ Correct → higher ratio first

🔥 Simple mental model

Comparator decides priority

👉 You are telling Java:

“Put the item with higher ratio first”

🧩 Now your second code (Comparator class)
static class ItemComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        double a1 = (1.0 * a[0]) / a[1];
        double b1 = (1.0 * b[0]) / b[1];
        return Double.compare(b1, a1);
    }
}
🔍 Step-by-step
Input row:
a = [value, weight]
Compute ratio:
double a1 = value / weight;
Compare:
Double.compare(b1, a1);

👉 Same idea:

higher ratio → comes first
⚡ Lambda vs Comparator class
Lambda	Class
Short	Verbose
(a,b) -> ...	implements Comparator
Same logic	Same logic

👉 Just two styles — logic identical

🧠 HOW TO THINK (important)

Whenever you see sorting in DSA:

Ask:

1. What am I sorting?
numbers?
pairs?
objects?
2. Based on what?
finish time?
ratio?
distance?
profit?
3. Ascending or descending?
🔥 3 Golden Patterns (remember this)
✅ Ascending
(a, b) -> a - b
✅ Descending
(a, b) -> b - a
✅ Custom logic
(a, b) -> Double.compare(b.ratio, a.ratio)
🧩 Real-world analogy

Think of sorting like ranking students:

Student	Marks
A	90
B	80

Comparator decides:

👉 “Who ranks higher?”

🔥 Trick to master this forever

Whenever writing comparator:

👉 Say this in your head:

“If I return negative → a comes first”

🧠 One-liner cheat code

“Comparator returns negative → first argument gets priority”

⚠️ Common mistakes (you already faced one)
❌ Integer division
❌ Sorting one array and tracking another
❌ Wrong comparator direction
🚀 Your current level

You now understand:

Greedy ✔️
Sorting pairs ✔️
Comparator ✔️

👉 This is interview-level foundation
 */