package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.medium;

public class ATOI {
}
/*
Sure. Based on **your length + boundary comparison approach**, here's a complete implementation:

```java
class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle empty string after spaces
        if (i == n) {
            return 0;
        }

        // Handle sign
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Collect digits
        StringBuilder digits = new StringBuilder();

        while (i < n && Character.isDigit(s.charAt(i))) {
            digits.append(s.charAt(i));
            i++;
        }

        // No digits found
        if (digits.length() == 0) {
            return 0;
        }

        // Remove leading zeros
        int start = 0;

        while (start < digits.length() - 1 &&
               digits.charAt(start) == '0') {
            start++;
        }

        String num = digits.substring(start);

        // Overflow check
        String limit =
                (sign == 1)
                        ? "2147483647"
                        : "2147483648";

        if (num.length() > 10) {
            return sign == 1
                    ? Integer.MAX_VALUE
                    : Integer.MIN_VALUE;
        }

        if (num.length() == 10) {

            for (int j = 0; j < 10; j++) {

                if (num.charAt(j) > limit.charAt(j)) {
                    return sign == 1
                            ? Integer.MAX_VALUE
                            : Integer.MIN_VALUE;
                }

                if (num.charAt(j) < limit.charAt(j)) {
                    break;
                }
            }
        }

        // Build number
        int result = 0;

        for (int j = 0; j < num.length(); j++) {
            result = result * 10 + (num.charAt(j) - '0');
        }

        return sign * result;
    }
}
```

A few test cases:

```java
"42"                  -> 42
"   -42"              -> -42
"4193 with words"     -> 4193
"words and 987"       -> 0
"2147483647"          -> 2147483647
"2147483648"          -> 2147483647
"-2147483648"         -> -2147483648
"-2147483649"         -> -2147483648
"00000002147"         -> 2147
"+1"                  -> 1
```

One thing I like here is that you arrived at a valid solution using your own reasoning instead of memorizing the standard overflow-check formula. That's a good habit when you're practicing DSA.

Very close. The overall logic is correct, but I can spot **2 bugs**.

### Bug 1: Possible StringIndexOutOfBoundsException

Consider:

```java
s = ""
```

or

```java
s = "      "
```

After:

```java
while (i < s.length() && s.charAt(i) == ' ') {
    i++;
}
```

`i` becomes `s.length()`.

Then you do:

```java
if (s.charAt(i) == '-')
```

Boom 💥

`StringIndexOutOfBoundsException`.

Add:

```java
if (i == s.length()) {
    return 0;
}
```

before checking the sign.

---

### Bug 2: Wrong result construction

You wrote:

```java
result *= 10 + (num.charAt(k) - '0');
```

This is not the same as:

```java
result = result * 10 + digit;
```

Let's dry run:

```java
num = "123"
```

#### Your code

Initially:

```java
result = 0
```

Digit = 1

```java
result *= 10 + 1
result = 0 * 11
result = 0
```

Digit = 2

```java
result *= 12
result = 0
```

Digit = 3

```java
result *= 13
result = 0
```

Final:

```java
0
```

Wrong.

---

It should be:

```java
result = result * 10 + (num.charAt(k) - '0');
```

or

```java
result *= 10;
result += (num.charAt(k) - '0');
```

---

### Corrected part

```java
if (i == s.length()) {
    return 0;
}

...

int result = 0;

for (int k = 0; k < num.length(); k++) {
    result = result * 10 + (num.charAt(k) - '0');
}

return sign * result;
```

After fixing these two issues, your solution should work correctly for the standard ATOI test cases.

One thing I like is that you independently came up with the "length + boundary string comparison" strategy. It's not the most common interview solution, but it's a perfectly valid O(n) approach and shows you're thinking about overflow rather than memorizing a pattern.

 */