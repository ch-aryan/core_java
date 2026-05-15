package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.KMP;

import java.util.ArrayList;

/*
KMP Algorithm
Last Updated : 27 Mar, 2026
Given two strings txt and pat, the task is to return all indices of occurrences of pat within txt.

Examples:

Input: txt = "abcab",  pat = "ab"
Output: [0, 3]
Explanation: The string "ab" occurs twice in txt, first occurrence starts from index 0 and second from index 3.

Input: txt=  "aabaacaadaabaaba", pat =  "aaba"
Output: [0, 9, 12]
Explanation:
 */
public class KMPPattern {

    public static ArrayList<Integer> bruteForce(String txt , String pat){
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        int len = n-m;

        for(int i=0;i<=len ; i++){
            boolean flag = true;
            int j =0;
            int count = i;
            while(j< m){ // we can for loop also here . for(int j =0; j<m ; j++){

                if(txt.charAt(count) == pat.charAt(j)){//if(txt.charAt(i+j)!=pat.charAt(j)){
                                                                            //break and flag = false;
                    count++;
                    j++;
                } else {
                    flag = false;
                    break;
                }

            }
            if(flag){
                res.add(i);
            }

        }
        return  res;
    }

    public static ArrayList<Integer> KMPAlgorithm(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[]  lps = buildLpsArr(pat, m);
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
                if (j == m) { //2 and write this if in the upper if block.
                    res.add(i - j);
                    j = lps[j - 1];// this is to ensure that we don't go forward in the text. se comments.
                }
            else if(i< n && txt.charAt(i) != pat.charAt(j)){ //1 either write like this or remove only if
                    if (j > 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }

                }
        }
        return res;
    }
    public static int[] buildLpsArr(String pat, int m )
    {
        int len =0;
        int []lps = new int[m];
        int i =1;
        while(i<m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len > 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;


    }
    public static void main(String[] args) {
      String txt =   "aabaacaadaabaaba", pat =  "aaba";
       // Output: [0, 9, 12]
        bruteForce(txt, pat).forEach(i-> System.out.print(i+" "));

        System.out.println("************");
        KMPAlgorithm(txt, pat).forEach(i-> System.out.print(i+" "));
    }

}
/*
Exactly right — the array version and string version are 100% the same algorithm.

The only difference is how you access elements:

Arrays	Strings
a[i]	txt.charAt(i)
b[j]	pat.charAt(j)

Everything else is identical.

Why Does One Version Fail When You Separate the if Blocks?

This is a very important KMP subtlety.

Working Version
if (txt.charAt(i) == pat.charAt(j)) {
    i++;
    j++;

    if (j == m) {
        res.add(i - j);
        j = lps[j - 1];
    }
}
else {
    if (j > 0) {
        j = lps[j - 1];
    } else {
        i++;
    }
}

This works because:

If characters match, the else block is skipped.
No unnecessary mismatch check happens.
The "Separated if" Version
if (txt.charAt(i) == pat.charAt(j)) {
    i++;
    j++;
}

if (j == m) {
    res.add(i - j);
    j = lps[j - 1];
}
else if (i < n && txt.charAt(i) != pat.charAt(j)) {
    ...
}

This also works if written exactly like this.

Why Sometimes It Prints Nothing

After the first if, you may have already changed i and j.

Suppose:

Before match:
i = 0, j = 0
txt[0] == pat[0]

After increment:

i = 1, j = 1

Now the second if checks:

txt.charAt(i) != pat.charAt(j)

which compares the next characters, not the ones you just matched.

That is correct KMP behavior.

However, if your control flow is arranged incorrectly, you can accidentally treat a valid match as a mismatch and modify j unexpectedly.

The Key Rule

KMP has three mutually exclusive cases:

Match
Full pattern matched
Mismatch

Only one logical path should be applied at a time.

Safe Structure (Recommended)
while (i < n) {
    if (txt.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
    }

    if (j == m) {
        res.add(i - j);
        j = lps[j - 1];
    }
    else if (i < n && txt.charAt(i) != pat.charAt(j)) {
        if (j > 0) {
            j = lps[j - 1];
        } else {
            i++;
        }
    }
}

This is the canonical Knuth–Morris–Pratt algorithm implementation.

Most Common Mistake

If you write:

if (txt.charAt(i) == pat.charAt(j)) {
    i++;
    j++;
}

if (txt.charAt(i) != pat.charAt(j)) {
    ...
}

without checking:

j == m
i < n

then you may:

Access out of bounds
Undo a valid match
Skip results
Produce no output
Important Example

Suppose the pattern length is 4.

After matching the final character:

j = 4

Then j == m.

If you immediately do:

pat.charAt(j)

you are accessing:

pat.charAt(4)

which is invalid.

So you must always handle j == m before using pat.charAt(j) again.

Why Your Array Version Worked

Your array version uses the correct canonical structure:

Match
Check full match
Else-if mismatch

That structure is safe and correct.

Final Answer

Yes, both the string and integer-array KMP implementations are fundamentally identical.

The reason one version fails when you separate the if blocks is not because strings behave differently. It happens because:

i and j change after the match block,
the next comparison uses updated indices,
and if j == m is not handled before accessing pat[j], the logic breaks.
Golden Rule to Remember

Always structure KMP in this order:

1. Match -> i++, j++
2. If j == m -> pattern found
3. Else if mismatch -> fallback using LPS

If you keep this order, the same KMP code works for:

Strings
Character arrays
Integer arrays
Any sequence of comparable elements

Implementation of KMP Algorithm
We initialize two pointers, one for the text string and another for the pattern. When the characters at both pointers match, we increment both pointers and continue the comparison. If they do not match, we reset the pattern pointer to the last value from the LPS array, because that portion of the pattern has already been matched with the text string. Similarly, if we have traversed the entire pattern string, we add the starting index of occurrence of pattern in text, to the result and continue the search from the lps value of last element of the pattern.

Let’s say we are at position i in the text string and position j in the pattern string when a mismatch occurs:

At this point, we know that pat[0..j-1] has already matched with txt[i-j..i-1].
The value of lps[j-1] represents the length of the longest proper prefix of the substring pat[0..j-1] that is also a suffix of the same substring.
From these two observations, we can conclude that there's no need to recheck the characters in pat[0..lps[j-1]]. Instead, we can directly resume our search from lps[j-1].

 */
/*
This is one of the most important ideas in KMP.
The short answer:

After finding one complete match, we do j = lps[j - 1] so that we can immediately continue searching for overlapping matches without starting from zero.


1. What Does j == m Mean?


j = number of pattern characters matched.


m = pattern length.


So:
j == m
means:

"The entire pattern has been matched."

At this point, we record the starting index:
res.add(i - j);

2. Why Not Just Set j = 0?
You could do that, but you would lose useful information.
KMP is designed to reuse what is already known.

3. Example Where Overlapping Matches Exist
Text    = A A A A APattern = A A A
Pattern length:
m = 3
Expected matches:


Index 0


Index 1


Index 2



4. First Match Found
After matching the first occurrence:
Text[0..2] = A A A
Now:
i = 3j = 3
Since j == m, we found a match at index:
i - j = 3 - 3 = 0

5. Pattern LPS
For:
Pattern = A A A
LPS:
[0, 1, 2]

6. Apply the KMP Trick
Set:
j=lps[j−1]=lps[2]=2j = \mathrm{lps}[j-1] = \mathrm{lps}[2] = 2j=lps[j−1]=lps[2]=2
Now:
j = 2
Meaning:

Two characters (AA) are already matched and can be reused.


7. Continue Searching
Current state:
i = 3j = 2
Compare:
Text[3] = APattern[2] = A
Match.
Now:
i = 4j = 3
Full match again.
Starting index:
4 - 3 = 1

8. Another Overlapping Match
Again:
j = lps[2] = 2
Continue and find the match at index 2.

9. Final Output
[0, 1, 2]

10. What If We Used j = 0?
After finding the first match, we would discard the fact that the suffix "AA" is also a prefix.
KMP would do more work and overlapping matches would be harder to detect efficiently.

11. Meaning of lps[j - 1]
When the whole pattern is matched, the matched string is the pattern itself.
lps[j - 1] tells us:

"How much of the pattern can still be considered matched because its suffix is also a prefix?"


12. Visual Understanding
Pattern:
A A A
Complete match found.
The suffix:
A A
is also the prefix:
A A
So instead of restarting, continue with:
j = 2

13. General Rule
Whenever a full match is found:
res.add(i - j);j = lps[j - 1];
This allows:


Overlapping matches


Reuse of already matched prefix


Optimal O(n + m) performance



14. Example with No Overlap
Pattern = ABCLPS     = [0, 0, 0]
After a full match:
j = lps[2] = 0
So we naturally restart from the beginning.

15. One Sentence to Remember Forever

After finding a match, keep the longest suffix of the matched pattern that is also a prefix, because it may start the next match immediately.


16. Final Summary
When j == m:


The entire pattern is matched.


Store the result.


Set j = lps[j - 1].


Continue searching without losing reusable information.


This is what enables KMP to detect overlapping matches efficiently.
 */