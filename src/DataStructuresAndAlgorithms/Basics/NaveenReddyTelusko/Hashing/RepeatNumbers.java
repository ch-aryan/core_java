package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Hashing;
class Hashing{
    public int hash(int [] arr, int elm){
        if(elm > 100){
            return -1;
        }
        int[] hashArr = new int[101];

        for(int i=0;i<arr.length;i++){
            hashArr[arr[i]]++;
        }

        return hashArr[elm];
    }

}
public class RepeatNumbers {
    public static void main(String[] args) {
        int arr[] = {14,100,100,12,1,23,22,23,22,1};
        Hashing obj = new Hashing();
       int res =  obj.hash(arr, 1);
        System.out.println(res);
    }
}
/* 📒 HASHING — Complete Notes (DSA)
✅ What is Hashing ?

👉 Hashing is a technique to store and retrieve data in constant time O(1) using an index mapping.

Simple meaning:

We convert a value → into an index → store frequency or presence.

Example thinking:

Instead of searching an element again and again
we store how many times each element appears.

✅ Why Hashing is Needed ?

Normal searching:

Linear Search → O(n)
Binary Search → O(log n) (array must be sorted)

But hashing:

⭐ Search → O(1)
⭐ Frequency count → O(n)
⭐ Duplicate detection → very fast

✅ Types of Hashing in DSA
⭐ 1. Frequency Array Hashing (what you are using)

Used when:

Numbers are small
Range is known

Example:

arr = {1,2,1,3}

We create:

hash[1] = 2
hash[2] = 1
hash[3] = 1
⭐ 2. HashMap Hashing (advanced & real interview use)

Used when:

Numbers are large
Negative numbers exist
Range unknown

(Java)

HashMap<Integer,Integer> map = new HashMap<>();
📒 Now Let’s Understand YOUR Code
✅ Your Code Purpose

👉 Count how many times an element repeats in array

✅ Step-by-Step Explanation
⭐ Step 1 — Method
public int hash(int [] arr, int elm)

Meaning:

arr → input array
elm → whose frequency we want
⭐ Step 2 — Range Check
if(elm > 12){
    return -1;
}

Why?

Because:

int[] hashArr = new int[13];

👉 This means index allowed:

0 to 12

So if user asks frequency of 20 → invalid → return -1

⭐ Step 3 — Create Hash Array
int[] hashArr = new int[13];

Initially:

Index : 0 1 2 3 4 5 6 7 8 9 10 11 12
Value : 0 0 0 0 0 0 0 0 0 0  0  0  0
⭐ Step 4 — Frequency Counting Loop
for(int i=0;i<arr.length;i++){
    hashArr[arr[i]]++;
}

Very important line.

Meaning:

👉 If arr[i] = 5
then

hashArr[5]++

So frequency increases.

✅ FULL DRY RUN

Array:

{1,2,1,2,1,2,3,4,5,6,5,5,6,7,9,10}

We track only main indexes.

Stepwise Frequency Building

After processing whole array:

hashArr[1] = 3
hashArr[2] = 3
hashArr[3] = 1
hashArr[4] = 1
hashArr[5] = 3
hashArr[6] = 2
hashArr[7] = 1
hashArr[9] = 1
hashArr[10] = 1
⭐ Final Return
return hashArr[elm];

You called:

obj.hash(arr, 1);

So:

return hashArr[1] → 3

Output:

3

✔ Correct.

📒 Time & Space Complexity
⭐ Time Complexity
O(n)

Because single loop.

⭐ Space Complexity
O(13) → constant → O(1)

Very efficient.

📒 Important Interview Concept Hidden Here

👉 This technique is called:

⭐ Pre-computation

Meaning:

We compute all frequencies first
then answer queries instantly.

Example:

How many 1 ?
How many 5 ?
How many 6 ?

All become O(1).

📒 Real Interview Extension Question

Interviewer may ask:

👉 What if array values are 1000000 or negative ?

Then this solution fails.

Answer:

⭐ Use HashMap

📒 Clean Improved Version of Your Code (Best Practice)
class Hashing {

    public int frequency(int[] arr, int elm) {

        int max = 100; // assumed range

        int[] hash = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        return hash[elm];
    }
} */