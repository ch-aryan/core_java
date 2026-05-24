package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;
import java.util.Collections;

class Cricketer implements Comparable<Cricketer> {
    public Integer id;
    public String name;
    public Integer avgR;

    public Cricketer(Integer id, String name, Integer avgR) {
        this.id = id;
        this.name = name;
        this.avgR = avgR;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgR=" + avgR +
                '}';
    }

    @Override
    public int compareTo(Cricketer o) {//this is only getting one parameter why so. because we are implementing in the
        //same class right so we can use this.avg = o.avg right.
        if (this.avgR > o.avgR) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class CollectionscomplexSorting2 {
    public static void main(String[] args) {
        ArrayList<Cricketer> list = new ArrayList<>();
        list.add(new Cricketer(1,"virat kholi", 86));
        list.add(new Cricketer(2,"shreyas iyer" , 65));
        list.add(new Cricketer(3,"rohith sharma", 76));
        list.add(new Cricketer(4,"surya ky", 55));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
/*
Comparator vs Comparable

This is the MOST IMPORTANT PART.

Comparable	Comparator
Inside class	Outside class
Default sorting	Custom sorting
One sorting possible	Multiple sortings possible
compareTo()	compare()
Collections.sort(list)	Collections.sort(list, comp)

SUPER IMPORTANT Hidden Concept

When sorting:

Collections.sort(list)

Java does NOT care:

Bubble sort
Merge sort
Quick sort

Internally Java uses a highly optimized algorithm called:

TimSort

Used in:

Java
Python

Very optimized for real-world data.

Final Deep Understanding

When you implement:

Comparable<Cricketer>

you are essentially giving Java:

a rule to decide:
who is smaller,
who is bigger,
who is equal

Sorting algorithm repeatedly asks:

"Which object should come first?"

And your compareTo() answers that question. (⌐■_■)


Excellent progress, Aryan.
Now you are entering one of the most important concepts in Java Collections:

# `Comparable` vs `Comparator`

And your doubt is actually very intelligent:

> Why does `compareTo()` take only ONE parameter?

That question shows you are trying to understand the internal mechanism instead of just memorizing syntax.

---

# First Understand the Big Idea

When you use:

```java id="ccrlpo"
Collections.sort(list);
```

Java must compare two objects somehow.

For integers:

```java id="2pw9sz"
2 < 5
```

Easy.

For strings:

```java id="g3m0vv"
"abc".compareTo("xyz")
```

Java already knows.

But for your custom class:

```java id="6ah7lu"
Cricketer
```

Java has NO IDEA:

* Should it sort by id?
* by name?
* by avgR?

So Java asks your class:

```text id="w2e9lz"
"Hey Cricketer class...
YOU tell me how to compare two Cricketer objects."
```

That is why we implement:

```java id="b2i00o"
Comparable<Cricketer>
```

---

# Now Your Main Doubt

You wrote:

```java id="wxn6mr"
public int compareTo(Cricketer o)
```

and asked:

> why only one parameter?

---

# The Secret

Inside the method:

```java id="4t4o9q"
this
```

already represents ONE object.

And:

```java id="nq7t7n"
o
```

represents the SECOND object.

So actually:

```java id="2fjlwm"
this  vs  o
```

means:

```text id="xutgt8"
current object vs incoming object
```

---

# Visualization

Suppose Java is comparing:

```java id="mvsm6u"
Virat (86)
Rohit (76)
```

Internally Java does something like:

```java id="0w8hph"
virat.compareTo(rohit)
```

Now inside compareTo:

```java id="kkp7v9"
this -> virat
o    -> rohit
```

So:

```java id="24w95f"
this.avgR -> 86
o.avgR    -> 76
```

Then:

```java id="k8f7zt"
86 > 76
```

return `1`.

Meaning:

```text id="3g4e6u"
Virat should come AFTER Rohit
```

because ascending sorting.

---

# Internals of `Collections.sort()`

Very simplified internal logic:

```java id="5avtt8"
for(i){
   for(j){

      if(list.get(i).compareTo(list.get(j)) > 0){
            swap();
      }

   }
}
```

Not exact implementation, but conceptually similar.

---

# Actual Flow in Your Program

You wrote:

```java id="m0jlf1"
Collections.sort(list);
```

Since no Comparator is given,
Java checks:

```text id="6iwywp"
Does Cricketer implement Comparable?
```

YES.

Then Java uses:

```java id="vpd1a1"
compareTo()
```

again and again during sorting.

---

# VERY IMPORTANT DIFFERENCE

## Comparable

```java id="gr6uxr"
class Cricketer implements Comparable<Cricketer>
```

Means:

```text id="8m3z1v"
"default sorting logic"
```

Inside the class itself.

Example:

* Student → sort by roll number
* Employee → sort by id

---

## Comparator

External sorting logic.

Example:

* sort by name today
* sort by salary tomorrow
* sort by age later

WITHOUT changing class.

---

# One Important Mistake in Your compareTo

You again forgot `0`.

Your code:

```java id="8d16rt"
if (this.avgR > o.avgR) {
    return 1;
} else {
    return -1;
}
```

If averages are equal:

```text id="l1ddzz"
76 vs 76
```

you still return `-1`.

Wrong logically.

---

# Correct Version

```java id="k36e61"
@Override
public int compareTo(Cricketer o) {

    if(this.avgR > o.avgR){
        return 1;
    }
    else if(this.avgR < o.avgR){
        return -1;
    }
    else{
        return 0;
    }
}
```

---

# Best Professional Version

Since Integer already implements Comparable:

```java id="icv7vf"
@Override
public int compareTo(Cricketer o) {
    return this.avgR.compareTo(o.avgR);
}
```

VERY clean.

---

# SUPER IMPORTANT CONCEPT

## Comparator → 2 objects

```java id="r5bgsc"
compare(o1, o2)
```

Because Comparator is external.

It needs BOTH objects.

---

## Comparable → 1 object parameter

```java id="s4s98q"
this.compareTo(o)
```

Because current object already exists as `this`.

So only second object is needed.

---

# Real Industry Understanding

When Java developers see:

```java id="tx7v5u"
Collections.sort(list);
```

they immediately know:

```text id="x4pl0s"
"This class must implement Comparable."
```

And when they see:

```java id="1k4mb6"
Collections.sort(list, comparator);
```

they know:

```text id="pq9dbd"
"Custom external sorting logic."
```

You are now learning the exact foundations used everywhere in:

* TreeSet
* TreeMap
* PriorityQueue
* Streams sorted()
* TimSort internally
* Database result ordering
* Ranking systems
* Leaderboards

This is genuinely important Java knowledge.

 */