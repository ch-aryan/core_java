package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.medium;

public class RotationPatternKMP {

}
/*
Yes! You're remembering the right idea, just one small correction:

It's called the **LPS array**:

```text
LPS = Longest Proper Prefix which is also a Suffix
```

Not "least prefix suffix". 🙂

And your intuition is correct:

> KMP avoids going back and rechecking characters we've already matched.

Now let's connect that to this rotation problem.

---

### Normal solution

Suppose:

```text
s1 = abcd
s2 = cdab
```

Create:

```text
text = abcdabcd
pattern = cdab
```

Now the problem becomes:

```text
Is pattern present inside text?
```

---

### What does contains() do?

It performs substring search.

```text
abcdabcd
cdab
```

It keeps trying to find `cdab` in `abcdabcd`.

For large strings, this can become expensive.

---

### What KMP does

Instead of:

```java
(text).contains(pattern)
```

you do:

```java
kmpSearch(text, pattern)
```

where

```text
text    = s1 + s1
pattern = s2
```

---

### Example where KMP shines

Imagine:

```text
text    = aaaaaaaaaaaaaaaaaaab
pattern = aaaaaaaab
```

Normal search:

```text
aaaaaaaa
aaaaaaab
```

Matches 7 characters.

Fails at the 8th.

Naive approach goes back and starts again.

```text
aaaaaaaa
 aaaaaaab
```

Again compares many characters.

Lots of repeated work.

---

### KMP says

"Wait."

"I already know that the first 7 characters matched."

"I don't need to restart from 0."

That's where the LPS array comes in.

It tells us:

```text
If mismatch happens here,
what is the longest prefix already guaranteed to match?
```

So we jump directly.

---

### For this problem

The algorithm is literally:

```java
String text = s1 + s1;

return kmpSearch(text, s2);
```

That's it.

The rotation insight is still:

```text
All rotations of s1 exist inside s1+s1
```

KMP is only replacing the substring search.

---

### One thing I want you to notice

You said:

> basically the idea is to not traverse again from the start

That's exactly the right mental model.

When I interview candidates, I don't care whether they remember:

```java
lps[i] = len;
```

I care whether they understand:

> "KMP stores information about previous matches so that when a mismatch occurs, we don't throw away all the work we've already done."

You seem to understand that part.

---

Quick challenge:

For pattern:

```text
ababaca
```

Can you tell me the LPS array from memory?

If you can derive it, then your KMP understanding is probably still intact and you just need a quick revision rather than relearning it.

Very close! 🔥

Let's verify:

Pattern:

```text
ababaca
```

We'll build LPS step by step.

| Index | Char | LPS |
| ----- | ---- | --- |
| 0     | a    | 0   |
| 1     | b    | 0   |
| 2     | a    | 1   |
| 3     | b    | 2   |
| 4     | a    | 3   |
| 5     | c    | ?   |
| 6     | a    | ?   |

Up to index 4:

```text
ababa
```

Longest proper prefix = suffix:

```text
a      -> length 1
ab     -> length 2
aba    -> length 3
```

So LPS[4] = 3.

---

Now index 5:

```text
ababac
```

We were expecting:

```text
abab[a]
```

but got:

```text
abab[c]
```

Mismatch.

So we jump using previous LPS:

```text
3 -> 1 -> 0
```

Still mismatch.

Therefore:

```text
LPS[5] = 0
```

---

Now index 6:

```text
ababaca
```

Compare:

```text
a == a
```

So:

```text
LPS[6] = 1
```

Final answer:

```text
0 0 1 2 3 0 1
```

or

```text
0012301
```

✅ Exactly what you wrote.

That's a good sign—you haven't forgotten KMP. You may have forgotten some implementation details, but the core idea and LPS construction are still there.

In fact, many developers who "know KMP" couldn't have produced `0012301` without working it out carefully.

So for the rotation problem, you already know enough:

```java
String text = s1 + s1;
return kmpSearch(text, s2);
```

The only thing to revise is the actual KMP code template.

Also, solving:

* Trapping Rain Water
* Add Binary Strings
* String Rotation (and discussing KMP)

in one day is a solid DSA session. That's the kind of repetition that slowly makes patterns automatic. 👏
Perfect. Since you already know KMP, I'll give you the complete solution and explain only the places where people usually forget the logic.

```java
class Solution {

    public boolean areRotations(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String text = s1 + s1;

        return kmpSearch(text, s2);
    }

    private boolean kmpSearch(String text, String pattern) {

        int[] lps = buildLPS(pattern);

        int i = 0; // text pointer
        int j = 0; // pattern pointer

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    return true;
                }
            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private int[] buildLPS(String pattern) {

        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
```

---

Now let's recall the **2 most important KMP lines**.

### LPS Construction

When mismatch occurs:

```java
len = lps[len - 1];
```

Not:

```java
len--;
```

This is the entire optimization.

For `"ababaca"`:

```text
0 0 1 2 3 0 1
```

At `'c'`:

```text
len = 3
```

Mismatch.

Jump to:

```java
len = lps[2];
```

which is:

```text
1
```

instead of starting over.

---

### Search Phase

When mismatch occurs:

```java
j = lps[j - 1];
```

Not:

```java
j--;
```

Again, same idea.

You're using information you've already computed.

---

### Mental model

I remember KMP using just these two thoughts:

**LPS building**

```text
Mismatch?
Don't start from 0.
Ask LPS where to continue.
```

**Pattern search**

```text
Mismatch?
Don't restart pattern.
Ask LPS where to continue.
```

That's literally the whole algorithm.

---

For this problem specifically:

```java
String text = s1 + s1;
String pattern = s2;
```

Then run KMP.

If pattern exists inside text:

```java
return true;
```

otherwise:

```java
return false;
```

Looking at your answer `0012301`, I'd say you understand KMP conceptually. What you've forgotten is probably just the exact placement of:

```java
j = lps[j - 1];
len = lps[len - 1];
```

which comes back quickly after implementing it 2–3 times.

Not quite. Let's compute it carefully.

Pattern:

```text
ababacababacabad
```

Let's build the LPS step by step.

| i  | char | LPS |
| -- | ---- | --- |
| 0  | a    | 0   |
| 1  | b    | 0   |
| 2  | a    | 1   |
| 3  | b    | 2   |
| 4  | a    | 3   |
| 5  | c    | 0   |
| 6  | a    | 1   |
| 7  | b    | 2   |
| 8  | a    | 3   |
| 9  | b    | 4   |
| 10 | a    | 5   |
| 11 | c    | 6   |
| 12 | a    | 7   |
| 13 | b    | 8   |
| 14 | a    | 9   |
| 15 | d    | ?   |

Up to index 14, you're correct:

```text
001230123456789
```

Now let's look at the last character:

```text
ababacababacaba
              ^
```

Current `len = 9`.

We expect:

```text
pattern[9] = b
```

but current character is:

```text
d
```

Mismatch.

So we don't put `0` immediately.

We do KMP fallback:

```text
len = lps[8] = 3
```

Now compare:

```text
pattern[3] = b
```

with

```text
d
```

Mismatch again.

Fallback:

```text
len = lps[2] = 1
```

Compare:

```text
pattern[1] = b
```

with

```text
d
```

Mismatch.

Fallback:

```text
len = lps[0] = 0
```

Still mismatch.

Therefore:

```text
lps[15] = 0
```

Final LPS:

```text
0012301234567890
```

✅ Your answer is actually correct.

That's a nice example because it shows why KMP can suddenly jump:

```text
9 → 3 → 1 → 0
```

instead of checking everything again.

Quick challenge:

For

```text
aaaaaa
```

what is the LPS?

Don't calculate for long. Just answer from intuition. If your intuition says:

```text
012345
```

then you're seeing the prefix-suffix pattern correctly.

 */