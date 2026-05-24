package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Aryans{
    public Integer id;
    public String name;
    public Integer runs;

    public Aryans(Integer id, String name, Integer runs) {
        this.id = id;
        this.name = name;
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "Aryans{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", runs='" + runs + '\'' +
                '}';
    }
}
class  SortingClass implements Comparator<Aryans>{
    @Override
    public int compare(Aryans o1, Aryans o2) {
        if(o1.runs > o2.runs){
            return 1;
        }else{
            return -1;
        }
    }
}

public class CollectionsSortUtitlity {
    public static void main(String[] args) {
//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(11);
//        al.add(2);
//        al.add(32);
//        al.add(4);
//        System.out.println(al);
//        Collections.sort(al);
//        System.out.println(al);

        //same for strings also sort in lexicographically dictonary order which words is smaller like that.
        //now what aobut our predefined classes.

        ArrayList<Aryans> obj = new ArrayList<>();
        obj.add(new Aryans(1,"c", 67));
        obj.add(new Aryans(2, "zabc", 56));
        Aryans obj1 = new Aryans(1,"css", 12);
        Aryans obj2 = new Aryans(2, "abcz", 55);
        obj.add(obj1);
        obj.add(obj2);
        System.out.println(obj);
        Comparator<Aryans> comparator = new Comparator<Aryans>() {
            @Override
            public int compare(Aryans o1, Aryans o2) {
              if(o1.id < o2.id){
                  return 1;
              }else{
                  return -1;
              }
            }

        };

        Comparator<Aryans> comparatorLambda = (o1, o2) -> {
           return o1.name.compareTo(o2.name);
        };

        SortingClass sa = new SortingClass();

        Collections.sort(obj,comparatorLambda );
        System.out.println(obj);



    }
}
/*
o1.name.compareTo(o2.name)

does not return boolean.
It returns an int.

compareTo() returns:
0 → both strings equal
positive number → first string is bigger
negative number → second string is bigger

So this line is invalid:

if(o1.name.compareTo(o2.name))

because if expects true/false, not an integer.

Correct Lambda Comparator

You can simply do this:

Comparator<Aryans> comparatorLambda = (o1, o2) ->
        o1.name.compareTo(o2.name);

That is the cleanest and most standard way.

Why this works

A Comparator expects:

int compare(T o1, T o2)

And compareTo() already returns the exact integer needed by Comparator.

So no need for extra if-else.

If You Still Want if-else

Then write:

Comparator<Aryans> comparatorLambda = (o1, o2) -> {
    if (o1.name.compareTo(o2.name) > 0) {
        return 1;
    } else if (o1.name.compareTo(o2.name) < 0) {
        return -1;
    } else {
        return 0;
    }
};

But this is unnecessary because compareTo() already does all this internally.

Even Better Modern Style

Java provides helper methods:

Comparator<Aryans> comparatorLambda =
        Comparator.comparing(a -> a.name);

This is considered cleaner and more professional in real projects.

Small Visualization

Suppose:

o1.name = "Aryan"
o2.name = "Ravi"

Then:

"Aryan".compareTo("Ravi")

returns a negative number because "Aryan" comes before "Ravi" alphabetically.

So sorting understands:

Aryan < Ravi

Aryan, this is actually very good practice. You are learning the real foundation behind custom sorting in Java collections. Many beginners only use Collections.sort() without understanding how comparators actually control ordering. You are already experimenting with:

anonymous classes
lambda expressions
custom objects
compareTo()
different fields (id, name, runs)

That is exactly how you become comfortable with Java internals.

First — Your Code Works ✅

This lambda is correct:

Comparator<Aryans> comparatorLambda = (o1, o2) -> {
   return o1.name.compareTo(o2.name);
};

This sorts by name in dictionary order.

But There Is One Important Mistake in Your Comparators

You wrote:

if(o1.id < o2.id){
    return 1;
}else{
    return -1;
}

and similarly:

if(o1.runs > o2.runs){
    return 1;
}else{
    return -1;
}

The problem is:

You never return 0

A comparator must handle 3 cases:

Condition	Return
o1 < o2	negative
o1 > o2	positive
equal	0
Why Returning 0 Matters

Suppose:

o1.id = 5
o2.id = 5

Your code still returns -1.

That means:

5 is smaller than 5

which is logically wrong.

This can create strange sorting behavior.

Correct Version
Sorting by ID Ascending
Comparator<Aryans> comparator = (o1, o2) -> {
    if (o1.id > o2.id) {
        return 1;
    } else if (o1.id < o2.id) {
        return -1;
    } else {
        return 0;
    }
};
Even Better Professional Way

Since Integer already has compareTo():

Comparator<Aryans> comparator =
        (o1, o2) -> o1.id.compareTo(o2.id);

OR

Comparator<Aryans> comparator =
        Comparator.comparing(a -> a.id);

This is the modern Java style.

Your Name Comparator
(o1, o2) -> o1.name.compareTo(o2.name)

works because String already implements:

Comparable<String>

Internally Java already knows how to compare strings alphabetically.

Real Visualization

Suppose list:

zabc
abcz
c
css

When sorting:

o1.name.compareTo(o2.name)

Java compares character by character:

Example
"abcz".compareTo("c")

Compare first letters:

a vs c

Since 'a' < 'c',
Java returns negative.

So "abcz" comes before "c".

One More Super Important Thing

You are currently learning:

Collections.sort(obj, comparator);

But modern Java often uses:

obj.sort(comparator);

Example:

obj.sort((o1, o2) -> o1.name.compareTo(o2.name));

Cleaner.

Complex Sorting (Very Important)

Later you will learn:

Sort by runs
Comparator<Aryans> byRuns =
        (o1, o2) -> o1.runs.compareTo(o2.runs);
Sort by runs descending
Comparator<Aryans> byRunsDesc =
        (o1, o2) -> o2.runs.compareTo(o1.runs);

Notice reversed order.

Multi-Level Sorting (VERY COMMON IN REAL PROJECTS)

Example:

first sort by runs
if runs same, sort by name
Comparator<Aryans> complex =
        (o1, o2) -> {
            int result = o1.runs.compareTo(o2.runs);

            if(result == 0){
                return o1.name.compareTo(o2.name);
            }

            return result;
        };

This is called:

secondary sorting

Used everywhere in industry.

Modern Professional Style
Comparator<Aryans> complex =
        Comparator.comparing((Aryans a) -> a.runs)
                  .thenComparing(a -> a.name);

You’ll slowly appreciate this style once you get comfortable.

One Last Important Advice

Your class fields are:

public Integer id;
public String name;
public Integer runs;

In real projects, usually:

private

with getters/setters.

But for learning collections, your current style is perfectly fine. Focus on understanding sorting logic first.
 */