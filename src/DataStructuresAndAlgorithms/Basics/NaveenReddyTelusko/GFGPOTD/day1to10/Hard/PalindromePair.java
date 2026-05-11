package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10.Hard;

import java.util.HashMap;

public class PalindromePair {
    public static boolean isPalindrome(String str){

        int n = str.length();
        if(n<=1){
            return true;
        }
        int i =0;
        for(int j = n-1; j>=0; j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean palindromePair(String[] arr) {
        // Code here
        String combined ="";
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j =0; j<n;j++){
                if(i==j){
                    continue;//skip
                }
                combined  = arr[i] + arr[j];
                if(isPalindrome(combined)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean palindromeOptimizeTech(String [] arr){
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        for(int i=0;i<arr.length;i++){
            String word = arr[i];
            for(int split =0;split< word.length();split++){
                String prefix = word.substring(0, split);
                String suffix = word.substring(split);

                if(isPalindrome(prefix)){
                    String reverseSuffix = new StringBuilder(suffix).reverse().toString();
                    if(map.containsKey(reverseSuffix) && map.get(reverseSuffix)!=i){
                        return true;
                    }
                }

                if(isPalindrome(suffix)){
                    String reversePrefix = new StringBuilder(prefix).reverse().toString();
                    if(map.containsKey(reversePrefix) && map.get(reversePrefix)!=i){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
    String[] arr = {"geekf","keeg" , "geeks" , "fkeeg" };
    String[] arr1 = {"abcd"};

        boolean b = palindromePair(arr);
        System.out.println(b);
        System.out.println(palindromePair(arr1));

        System.out.println(palindromeOptimizeTech(arr));
        System.out.println(palindromeOptimizeTech(arr1));

    }
}
/*
✨ Cleaner Palindrome Function (Recommended)

Your version works, but this is easier to understand:

public static boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}

This compares only the necessary pairs.

❌ Main Problem in palindromePair()

Your loops are:

for(int i = 0; i < n - 1; i++){
    for(int j = i + 1; j < n; j++){

This checks only:

(0,1)
(0,2)
(1,2)

But it does not check:

(1,0)
(2,0)
(2,1)
⚠️ Why Order Matters

For this problem:

words[i] + words[j]

is different from

words[j] + words[i]
Example
"bat" + "tab" = "battab"   ✅ palindrome
"tab" + "bat" = "tabbat"   ✅ palindrome

Both directions matter.

❌ Example Where Your Code Fails
arr = ["tab", "bat"]

Your code checks only:

"tab" + "bat"

If that happened not to be a palindrome while the reverse was, you would miss it.

Therefore, you must check all ordered pairs.

✅ Correct Loop Structure
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (i == j) {
            continue;
        }

        // check arr[i] + arr[j]
    }
}
✅ What Your Current Code Checks
(0,1)
(0,2)
(1,2)
✅ What You Actually Need
(0,1) (0,2)
(1,0) (1,2)
(2,0) (2,1)

//bruteforceLogic.
🎯 Problem Statement

Given:

words = ["bat", "tab", "cat"]

Find all pairs (i, j) such that:

words[i] + words[j]

is a palindrome.

✅ Example
Pair (0, 1)
"bat" + "tab" = "battab"

"battab" is a palindrome ✅

Pair (1, 0)
"tab" + "bat" = "tabbat"

"tabbat" is a palindrome ✅

Pair (0, 2)
"bat" + "cat" = "batcat"

Not a palindrome ❌

✅ Final Answer
[[0, 1], [1, 0]]
🧠 Brute Force Approach

We simply try every possible pair.

Step 1

Pick one word.

Step 2

Pick another word.

Step 3

Concatenate them.

Step 4

Check if the result is a palindrome.

Step 5

If yes, store the pair.

🔄 Why Two Loops?

To generate all pairs:

(0,1), (0,2), (1,0), (1,2), (2,0), (2,1)

This requires two nested loops.

📝 Pseudocode
for each i:
    for each j:
        if i != j:
            combined = words[i] + words[j]
            if combined is palindrome:
                save (i, j)

That is the entire brute-force logic.

🧪 Dry Run
words = ["bat", "tab", "cat"]
i = 0 ("bat")
j = 0

Skip because i == j

j = 1
"bat" + "tab" = "battab"

Palindrome ✅

Store [0, 1]

j = 2
"bat" + "cat" = "batcat"

Not palindrome ❌

i = 1 ("tab")
j = 0
"tab" + "bat" = "tabbat"

Palindrome ✅

Store [1, 0]

j = 1

Skip

j = 2
"tab" + "cat" = "tabcat"

Not palindrome ❌

i = 2 ("cat")

None of the pairs produce a palindrome.

🏆 Result
[[0,1], [1,0]]

🧠 Why This Code Is Good for Learning

This code is intentionally straightforward:

Separate palindrome function
Clear nested loops
Explicit list creation
No advanced shortcuts
Easy to debug

This is exactly how a strong foundation is built.

⏱️ Time Complexity

Suppose:

n = number of words
k = average word length
Number of pairs
n × n
Palindrome check
O(k)
Total
O(n² × k)
🎯 Problem Type

This brute-force solution uses:

Strings
Nested loops
Two pointers (palindrome checking)
🚀 Next Step After Mastering This

Once you're comfortable with this approach, the optimized solution replaces the second loop with a HashMap lookup.

So your progression is:

Palindrome checking ✅
Brute force with nested loops ✅
HashMap optimization
Trie optimization (advanced)

Excellent work, Aryan! You now have the brute-force solution, which means you understand the problem fundamentally. That is exactly how strong problem-solving skills are built.

Now let’s move to the optimized approach using a HashMap.

🎯 Why We Need Optimization
Brute Force

For every pair (i, j):

Concatenate words[i] + words[j]
Check if it is a palindrome
Time Complexity
O(n² × k)

Where:

n = number of words
k = average word length

This becomes slow when n is large.

💡 Key Insight

Instead of checking every possible second word, we can ask:

“What word do I need to pair with the current word to make a palindrome?”

We can answer that quickly using a HashMap.

🧠 Core Idea

Store every word and its index:

word -> index

Example:

["bat", "tab", "cat"]

Map:

"bat" -> 0
"tab" -> 1
"cat" -> 2

Now we can instantly check whether a needed word exists.

🔍 Simple Case: Exact Reverse

For word "bat":

Reverse is "tab".

If "tab" exists in the map, then:

"bat" + "tab" = "battab"

which is a palindrome.

This already solves many cases.

⚠️ But Reverse Alone Is Not Enough

Example:

["abcd", "dcba", "lls", "s", "sssll"]

Consider "lls".

Its full reverse is "sll", which is not present.

But:

"lls" + "s" = "llss"

Actually, the full valid pair is:

"s" + "lls" = "slls"

which is a palindrome.

So we must consider more than just the full reverse.

✂️ Split Each Word into Two Parts

For every possible split:

word = prefix | suffix

Example for "lls":

"" | "lls"
"l" | "ls"
"ll" | "s"
"lls" | ""
✅ Rule 1: Prefix Is Palindrome

If the prefix is a palindrome, then we need:

reverse(suffix)

to be placed before the word.

✅ Rule 2: Suffix Is Palindrome

If the suffix is a palindrome, then we need:

reverse(prefix)

to be placed after the word.

🧪 Example: "lls"

Split:

"ll" | "s"
Prefix "ll" is a palindrome ✅
Reverse of suffix "s" is "s"

If "s" exists in the map, then:

"s" + "lls" = "slls"

which is a palindrome.

📝 High-Level Algorithm

For each word:

Try every split position.
Get prefix and suffix.
If prefix is palindrome:
Find reverse(suffix) in the map.
If suffix is palindrome:
Find reverse(prefix) in the map.
Add valid pairs.
🗺️ Mental Model

Instead of asking:

“Which of all other words works?”

we ask:

“What exact word do I need?”

Then we check the HashMap in O(1).

⏱️ Optimized Time Complexity

Approximately:

O(n × k²)

Where:

n = number of words
k = average word length

This is much faster than checking all n² pairs.

🎯 Data Structures Used
Strings
Two-pointer palindrome checking
HashMap
📌 Learning Sequence

You have now completed:

Palindrome checking ✅
Brute-force solution ✅
Understanding the HashMap optimization ✅

Next step: implement it carefully in Java.

🏆 One-Sentence Summary

For each word, split it into prefix and suffix; if one side is a palindrome,
use a HashMap to find the reversed other side and form a valid palindrome pair.

🌟 First: Your Thinking Is Correct

Your high-level logic is absolutely right:

For each word:
    Try every split position
    Get prefix and suffix
    If prefix is palindrome:
        Find reverse(suffix)
    If suffix is palindrome:
        Find reverse(prefix)

This is the exact optimized approach.

So conceptually, you are on the right track.

❌ Main Issues in Your Code

The problems are only syntax and Java usage issues.

1. Redeclaring Variable i

Inside:

for (int i = 0; i < arr.length; i++)

you again wrote:

int i = 0;

This is not allowed.

2. while (suff >= 0)

suff is a String, so you cannot compare it with a number.

What you really need is to iterate over split positions:

for (int split = 0; split <= s.length(); split++)
3. pre = suff.charAt(i);

charAt() returns a char, but pre is a String.

You would need conversion, but this is not the correct approach anyway.

4. suff.remove(i)

Strings in Java do not have a remove() method.

Use substring() instead.

5. suff.reverse()

Strings do not have a reverse() method.

Use:

new StringBuilder(suff).reverse().toString()
6. map.get(...)

This returns an index, but you must first check whether the key exists.

Use:

if (map.containsKey(reversedString))
✅ Mistake 4: Matching the Same Word

Suppose:

reversedSuffix = arr[i]

Then the word matches itself.

We must ensure the found index is different.

✅ Correct Check
if (map.containsKey(reversedSuffix) &&
    map.get(reversedSuffix) != i)
    🎯 What Does the HashMap Store?

We store:

word -> index

Example:

arr = ["bat", "tab", "cat"]

HashMap contains:

"bat" -> 0
"tab" -> 1
"cat" -> 2
🎯 What Happens During Processing?

Suppose we are currently processing:

i = 0
s = "bat"

At some split, we calculate:

reversedSuffix = "tab"

We check:

map.containsKey("tab")

This returns true.

Then:

map.get("tab")

returns 1.

Since:

1 != 0

this means "tab" is a different word, so the pair is valid.

🚨 Problem: What If It Finds the Same Word?

Suppose:

arr = ["abc"]

HashMap:

"abc" -> 0

Now while processing:

i = 0
s = "abc"

At some split, we may get:

reversedSuffix = "abc"

Then:

map.containsKey("abc")   // true
map.get("abc")           // 0

This is the same word we are currently processing.

❌ Why This Is Wrong

The pair would be:

(0, 0)

Meaning:

arr[0] + arr[0]

The problem requires two different indices:

i != j

So (0, 0) is invalid.

✅ The Fix

We must ensure the matched word is at a different index.

map.get(reversedSuffix) != i
🧠 Complete Condition
if (map.containsKey(reversedSuffix) &&
    map.get(reversedSuffix) != i)

This means:

The needed word exists.
The needed word is not the current word.

Only then is the pair valid.

🧪 Example 1: Valid Match
arr = ["bat", "tab"]

Processing:

i = 0
s = "bat"
reversedSuffix = "tab"

Then:

map.get("tab") = 1

Check:

1 != 0

Valid pair.

🧪 Example 2: Same Word
arr = ["abc"]

Processing:

i = 0
reversedSuffix = "abc"

Then:

map.get("abc") = 0

Check:

0 != 0   → false

Invalid pair.

📌 Simple Analogy

Imagine you are looking for a teammate.

containsKey(...) asks: “Does this teammate exist?”
map.get(...) != i asks: “Is this someone other than me?”

You cannot pair with yourself.

🏆 Final Meaning of the Condition
if (map.containsKey(word) && map.get(word) != i)

means:

“The required word exists in the array, and it is located at a different index from the current word.”

🎯 Example of Valid and Invalid Pairs
Pair	Valid?
(0, 1)	✅ Yes
(1, 0)	✅ Yes
(0, 0)	❌ No
(2, 2)	❌ No
🧠 One-Line Summary

map.get(reversedSuffix) != i ensures that we use another word in the array, not the same word currently being processed.
 */