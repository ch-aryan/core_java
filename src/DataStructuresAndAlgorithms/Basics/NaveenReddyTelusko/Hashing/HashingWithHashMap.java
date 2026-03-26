package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Hashing;

import java.util.HashMap;

class HashingAlgo{
    public int hashWithHashMapOld(int[] arr, int elm){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        if(map.containsKey(elm)){//
            return map.get(elm);
        }
        else{
            return -1;
        }
    }

    public int hashWithHashMapNew(int[] arr, int elm){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.getOrDefault(elm, 0);
    }

}
public class HashingWithHashMap {
    public static void main(String[] args) {
        int[] arr = {10,12,14,21,21,10,14,12,24,24,15};

      int res =   new HashingAlgo().hashWithHashMapNew(arr,14);
        System.out.println(res);

        int res1 = new HashingAlgo().hashWithHashMapOld(arr,12);
        System.out.println(res1);

    }
}
/* ⭐ Dry Run (Important)
Step-1

Element = 10

map does NOT contain 10

So:

map.put(10,1)

Map:

{10=1}
Step-2

Element = 12

Map:

{10=1, 12=1}
Step-3

Element = 14

Map:

{10=1, 12=1, 14=1}
Step-4

Element = 21

Map:

{10=1, 12=1, 14=1, 21=1}
Step-5

Element = 21 again

containsKey → YES

map.get(21) = 1
1+1 = 2
map.put(21,2)

Map:

{10=1, 12=1, 14=1, 21=2}
Step-6

Element = 10 again

Final Map:

{10=2, 12=1, 14=1, 21=2}

✔ Correct.*/

/* method 2
⭐ Meaning of this line
hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);

Let’s break it.

Step-1
hs.getOrDefault(arr[i], 0)

Means:

👉 “Give me frequency of arr[i]
if not present assume frequency = 0”

Step-2
+ 1

Increase frequency.

Step-3
hs.put(arr[i], newFrequency)

Store updated value.

So entire line means:

⭐ Increase frequency of current element

⭐ FULL DRY RUN (Very Important)

Array:

10,12,14,21,21,10

Initially:

HashMap = { }
👉 Iteration-1 (i=0)

Element = 10

hs.getOrDefault(10,0) → 0
0 + 1 = 1

Store:

{10=1}
👉 Iteration-2 (i=1)

Element = 12

getOrDefault(12,0) → 0
0+1=1

Map:

{10=1 , 12=1}
👉 Iteration-3 (i=2)

Element = 14

Map:

{10=1 , 12=1 , 14=1}
👉 Iteration-4 (i=3)

Element = 21

Map:

{10=1 , 12=1 , 14=1 , 21=1}
👉 Iteration-5 (i=4)

Element = 21 again

getOrDefault(21,0) → 1
1+1=2

Map:

{10=1 , 12=1 , 14=1 , 21=2}
👉 Iteration-6 (i=5)

Element = 10

getOrDefault(10,0) → 1
1+1=2

Final Map:

{10=2 , 12=1 , 14=1 , 21=2}

✔ Frequency hashing completed.

⭐ Final Query

If you call:

map.get(10)

Answer:

2
⭐ Golden Line You Must Remember

getOrDefault() helps avoid extra if-else while counting frequency.

Interviewers like this clean coding style ⭐
⭐ One More Interview Level Insight

Senior engineers may even write:

map.merge(arr[i], 1, Integer::sum);

Even more advanced clean style 🙂

But first master getOrDefault.
 */