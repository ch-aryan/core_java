package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BineaySearch;

public class BinarySearchCode {
    public static int BinaryCode(int arr[] , int tar){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] > tar){
                high = mid -1;
            }else if(arr[mid] == tar){
                return mid;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //array must be sorted
        int arr[] = {3,4,5,6,6,9,21,112};
        int tar = 6;
        int i = BinaryCode(arr, tar);
        System.out.println(i);
    }
}
/*
if binary search take tc of (O(log n)) then what is would take for root n. the for the loop
if i starting from 1 to root n.
why for checking prime we can't go with n/2 but root n. means it depends on the prblm right
Great question—this is exactly the kind of thinking that sharpens your DSA intuition.

You’re right about one thing: **yes, it depends on the problem**, but for *prime checking specifically*, √n isn’t arbitrary—it comes from a solid mathematical reason.

---

## 🧠 Why not check till `n/2`?

You *can* do this:

```java
for (int i = 2; i <= n/2; i++)
```

✔ It works
❌ But it’s inefficient → **O(n)** time

---

## 🔍 Why √n is enough (core logic)

Think about factors of a number.

If `n = a × b`, then:

* one factor is **≤ √n**
* the other is **≥ √n**

👉 They come in pairs.

---

### 📌 Example: n = 36

Factor pairs:

* (1, 36)
* (2, 18)
* (3, 12)
* (4, 9)
* (6, 6)

Notice:

* After √36 = 6, factors start repeating in reverse

---

## 💡 Key Insight

> If a number has a factor greater than √n,
> 👉 it must already have a corresponding factor smaller than √n.

---

### ❗ That means:

If no factor is found till √n,
👉 there will be NO factor after that

So we can safely stop at √n.

---

## ⚡ Complexity Comparison

| Method      | Loop runs till | Time Complexity |
| ----------- | -------------- | --------------- |
| Brute force | n/2            | O(n)            |
| Optimized   | √n             | O(√n)           |

---

## 🧠 Clean Prime Check Code

```java
boolean isPrime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

---

## 🎯 Your statement: “depends on problem?”

✔ YES, but with nuance:

* For **prime / factors problems** → √n works due to factor pairing
* For **other problems** → you might need full `n`, or `log n`, or something else

👉 So it’s not random—it’s based on **math properties of the problem**

---

## 🧩 Final Mental Model

Think like this:

> “Factors always come in pairs around √n”

So:

* Check one side (up to √n)
* You automatically cover the other side

---

If you want, I can next show you:

* 🔥 how to print all divisors in √n
* ⚡ how this idea is used in advanced problems (very useful in interviews)

Just say 👍

 */