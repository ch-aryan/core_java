package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.medium;
/*
Add Binary Strings
Difficulty: MediumAccuracy: 23.25%Submissions: 126K+Points: 4
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation:
  100
+  10
  110
 */
public class BinaryStrings {
    // User function Template for Java

    class Solution {
        public String addBinary(String s1, String s2) {
            // code here
            int i = s1.length()-1;
            int j = s2.length()-1;

            int carry = 0;
            StringBuilder ans = new StringBuilder();

            while( i >= 0 || j>=0 || carry > 0){
                int sum = carry;

                if(i >=0){
                    sum = sum + s1.charAt(i) -'0';
                    i--;
                }
                if(j >= 0){
                    sum = sum + s2.charAt(j) - '0';
                    j--;
                }
                ans.append(sum % 2);
                carry = sum /2;
            }

            return removeZeroes(ans.reverse().toString());

        }
        public static String removeZeroes(String s){
            int i = 0;

            while(i< s.length()-1 && s.charAt(i) =='0'){
                i++;

            }
            return s.substring(i);
        }
    }
}
/*
Your binary addition logic is already correct. 👍

The only issue is that you created `removeZeroes()` but you're not using it.

If the problem expects the answer without leading zeroes, do:

```java
class Solution {
    public String addBinary(String s1, String s2) {

        s1 = removeZeroes(s1);
        s2 = removeZeroes(s2);

        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 2);
            carry = sum / 2;
        }

        return removeZeroes(ans.reverse().toString());
    }

    public static String removeZeroes(String s) {
        int i = 0;

        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i);
    }
}
```

### Small improvement in your `removeZeroes()`

You don't need both `i` and `start`.

Your version:

```java
int i = 0;
int start = 0;

while(start < s.length()-1 && s.charAt(i) == '0'){
    i++;
    start++;
}
return s.substring(start);
```

Since `i` and `start` always move together, one variable is enough:

```java
int i = 0;

while(i < s.length()-1 && s.charAt(i) == '0'){
    i++;
}

return s.substring(i);
```

### One more question

What should be returned for:

```java
s1 = "0000"
s2 = "0000"
```

Walk through your code mentally and see whether it returns `"0"` or `"0000"`. That's a common edge case interviewers like to test.

Exactly, Aryan. 👍

When you add binary digits, there are only **three things involved**:

1. Current digit from `s1`
2. Current digit from `s2`
3. `carry` from the previous addition

For every position:

```text
sum = digit1 + digit2 + carry
```

Then:

```text
result digit = sum % 2
carry = sum / 2
```

Let's see all possibilities:

| digit1 | digit2 | carry | sum | result | new carry |
| ------ | ------ | ----- | --- | ------ | --------- |
| 0      | 0      | 0     | 0   | 0      | 0         |
| 0      | 1      | 0     | 1   | 1      | 0         |
| 1      | 0      | 0     | 1   | 1      | 0         |
| 1      | 1      | 0     | 2   | 0      | 1         |
| 1      | 1      | 1     | 3   | 1      | 1         |

Notice something beautiful:

* `sum % 2` always gives the binary digit.
* `sum / 2` always gives the carry.

No need for a bunch of `if-else` cases.

---

Take:

```text
s1 = 1011
s2 = 1101
```

Start from the right:

```text
1 + 1 + 0 = 2
digit = 0
carry = 1
ans = "0"
```

Next:

```text
1 + 0 + 1 = 2
digit = 0
carry = 1
ans = "00"
```

Next:

```text
0 + 1 + 1 = 2
digit = 0
carry = 1
ans = "000"
```

Next:

```text
1 + 1 + 1 = 3
digit = 1
carry = 1
ans = "0001"
```

No digits left:

```text
carry = 1
ans = "00011"
```

Reverse:

```text
11000
```

---

This is a good example of a common DSA pattern:

> Whenever you're processing numbers from the least significant digit (units place), start from the end and maintain a carry.

The same idea is used in:

* Add Binary
* Add Strings
* Multiply Strings
* Linked List Addition problems

Since you've already identified **sum + carry**, you're basically one step away from the full solution. Try coding it yourself without looking at my code and post your version. I'll review it line by line.

 */