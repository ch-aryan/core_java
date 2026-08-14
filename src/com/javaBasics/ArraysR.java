package com.javabasics;

import java.util.ArrayList;
import java.util.HashSet;

public class ArraysR {
    public static void main(String[] args) {
        int [] arr = {12,3};
        ArrayList<Integer> al = new ArrayList<>();
        String s= "AAaa";
  // remove duplicates included capital and small letters. also.
        class Solution {
            String removeDuplicates(String s) {
                HashSet<Character> seen = new HashSet<>();
                StringBuilder lower = new StringBuilder();


                for(char i : s.toCharArray()){
                    char ch = Character.toLowerCase(i);
                    if(!seen.contains(ch)){
                        seen.add(ch);
                        lower.append(i);
                    }
                }
                return lower.toString();
            }
        }


    }
}
/*
If you want to remove duplicate characters **ignoring case** (so `'A'` and `'a'` are considered the same), there are a few ways.

### Method 1: `ArrayList` (closest to your code)

```java
class Solution {
    String removeDuplicates(String s) {
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            boolean found = false;
            for (char c : list) {
                if (Character.toLowerCase(c) == Character.toLowerCase(ch)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                list.add(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : list) {
            ans.append(c);
        }

        return ans.toString();
    }
}
```

### Why `equalsIgnoreCase()` doesn't work?

`equalsIgnoreCase()` is a method of **String**, not **char**.

This is **invalid**:

```java
'a'.equalsIgnoreCase('A');   // ❌
```

You would have to do:

```java
String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2));
```

But that's inefficient.

Instead, compare after converting both characters to the same case:

```java
Character.toLowerCase(c1) == Character.toLowerCase(c2)
```

or

```java
Character.toUpperCase(c1) == Character.toUpperCase(c2)
```

---

### Better approach (using `HashSet`) - O(n)

```java
class Solution {
    String removeDuplicates(String s) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            char lower = Character.toLowerCase(ch);

            if (!seen.contains(lower)) {
                seen.add(lower);
                ans.append(ch); // keeps the original case of the first occurrence
            }
        }

        return ans.toString();
    }
}
```

**Example**

```text
Input : "aAbBcCdDa"
Output: "abcd"
```

or

```text
Input : "AaBbCc"
Output: "ABC"
```

The output preserves the **first occurrence's original case**, while treating uppercase and lowercase versions of the same letter as duplicates.

 */