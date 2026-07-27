package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

public class TrappingRainWater {
    public static int totalWaterStore(int [] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while(left < right){
            if(arr[left] < arr[right]){
                if(leftMax > arr[left]){
                    total = total + leftMax - arr[left];
                }else{
                    leftMax = arr[left];
                }
                left++;
            }else{
                if(rightMax > arr[right]){
                    total = total + rightMax - arr[right];
                }else{
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return total;
    }


    public static void main(String[] args) {
        int[] arr1 = {10, 8, 3, 2, 12, 4 ,8};
        int i = totalWaterStore(arr1);
        System.out.println(i);
    }
}
/*
Absolutely. I actually want to teach you this in the way I would explain it to a friend sitting beside me. Forget the code for 10 minutes. Once the intuition is crystal clear, you'll never have to memorize this algorithm again.

---

# Step 1: What are we actually trying to calculate?

Let's take the classic example.

```text
Height:

      █
█     █
█ █   █     █
█ █ █ █ █   █
█ █ █ █ █ █ █

4 2 0 3 2 5
```

Imagine this is a city after rain.

Water gets trapped like this:

```text
      █
█~~~~~█
█~█~~~█
█~█~█~█
█~█~█~█
```

Our job is to calculate the total water.

---

# Step 2: Water at one position

Forget the whole array.

Just focus on this one bar.

```text
4 2 0 3 2 5
    ^
```

Height = 0

Ask yourself:

> **How much water can stand on top of this bar?**

Not the whole array.

Only this one position.

---

Water can rise only until a wall stops it.

There are two walls.

Left side

```text
4
```

Right side

```text
5
```

So water level is

```text
min(4,5)
```

because the smaller wall leaks first.

Therefore

```text
Water = min(leftMax,rightMax)-height

= min(4,5)-0

=4
```

This is the entire problem.

Everything else is just finding

```text
leftMax

rightMax
```

efficiently.

---

# Step 3: Brute Force

For every position

find

```text
largest on left

largest on right
```

Then

```text
min(left,right)-height
```

Time

```text
O(n²)
```

You already did this.

---

# Step 4: Prefix/Suffix

Store

```text
leftMax[]
```

and

```text
rightMax[]
```

Now answer becomes

```text
min(prefix[i],suffix[i])-arr[i]
```

Time

```text
O(n)
```

Space

```text
O(n)
```

Good.

---

# Step 5: Can we remove the arrays?

This is where everyone gets stuck.

Let's discover it.

---

Suppose

```text
4 2 0 3 2 5
L           R
```

Pointers

```text
left = 0

right = 5
```

Current bars

```text
4

5
```

Question

Can we calculate water on the left?

---

You may think

> Wait...

> I don't know the tallest building on the right.

Correct.

But...

Do we need to?

---

Right now

```text
Left =4

Right =5
```

The right wall is already taller.

Even if there are even taller buildings later,

does it matter?

Suppose

```text
4 ..........100
```

Water level on the left becomes

```text
min(4,100)

=4
```

Suppose

```text
4........7
```

Still

```text
min(4,7)

=4
```

Suppose

```text
4.......5
```

Still

```text
4
```

See the pattern?

Once the right wall is **at least** as tall as the left wall,

the right side is no longer the limiting factor.

The left wall limits the water.

That is the biggest intuition.

---

# Therefore

When

```text
arr[left] <= arr[right]
```

we know

```text
right boundary exists
```

So

we only care about

```text
leftMax
```

Nothing else.

---

Similarly

If

```text
arr[left] > arr[right]
```

then

```text
left boundary already exists
```

Therefore

calculate using

```text
rightMax
```

---

This explains the famous condition.

```java
if(arr[left] <= arr[right])
```

Not because someone memorized it.

Because

the smaller side determines the water.

---

# Step 6: Why do we maintain leftMax?

Look here.

```text
4 2 0 3 2 5
^

leftMax=4
```

Move

```text
2
```

Can water stay?

Maximum seen on left

```text
4
```

Current height

```text
2
```

Water

```text
4-2

=2
```

Easy.

Move

```text
0
```

Maximum left

```text
4
```

Water

```text
4
```

Move

```text
3
```

Water

```text
1
```

Every time

```text
current water

=

leftMax-currentHeight
```

Only because

we already know

```text
right side is taller
```

---

# Why update leftMax?

Suppose

```text
2 6 1 5
```

Initially

```text
leftMax=2
```

Move

```text
6
```

Question

Can water stay on top of 6?

No.

Instead

```text
leftMax

becomes

6
```

Because this is now the biggest wall.

That's exactly why your sir wrote

```java
if(leftMax > arr[left]){
    total += leftMax-arr[left];
}else{
    leftMax=arr[left];
}
```

Meaning

Either

```text
water gets stored
```

or

```text
wall becomes taller
```

Never both.

---

# Right side works exactly the same.

Imagine reversing the array.

Everything is symmetric.

---

# Now let's execute the entire algorithm

Array

```text
4 2 0 3 2 5
```

Initially

```text
left=0

right=5

leftMax=0

rightMax=0
```

---

### Iteration 1

```text
4<=5

Yes
```

Update

```text
leftMax=4
```

Move

```text
left++
```

---

### Iteration 2

Current

```text
2<=5
```

Water

```text
4-2=2
```

Total

```text
2
```

---

### Iteration 3

```text
0<=5
```

Water

```text
4
```

Total

```text
6
```

---

### Iteration 4

```text
3<=5
```

Water

```text
1
```

Total

```text
7
```

---

### Iteration 5

```text
2<=5
```

Water

```text
2
```

Total

```text
9
```

Done.

Correct answer.

---

# The mental model I want you to remember

Don't think:

> "If left <= right, go left."

Instead, think:

> **Whichever side has the smaller current boundary is the only side whose water level can be determined right now.**

That's the entire algorithm in one sentence.

---

## A pattern you'll see in many two-pointer problems

This is something worth remembering because it shows up again and again:

1. There are **two boundaries** (left and right).
2. The **answer depends on the smaller boundary** (`min(leftBoundary, rightBoundary)`).
3. Since the smaller boundary is the limiting factor, **you process that side first**.
4. While processing, you maintain the best information seen so far (`leftMax` or `rightMax`).

You'll encounter the same style of thinking in problems like:

* Trapping Rain Water
* Container With Most Water (different formula, same "move the limiting side" intuition)
* Some interval and sliding-window problems

---

### One exercise for you (don't code, just think)

Take this array:

```text
3 0 1 0 4
```

Try to fill this table on paper:

| left | right | leftMax | rightMax | Which pointer moves? | Water Added |
| ---- | ----- | ------- | -------- | -------------------- | ----------- |

Complete it row by row until `left == right`.

If you can do that without looking at the code, you'll have internalized the algorithm rather than memorized it. That's the point where these two-pointer problems start feeling natural.

 */