package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;
/*
Check if Permutation of Pattern is Substring
Last Updated : 23 Jul, 2025
Given two strings txt and pat having lowercase letters, the task is to check if any permutation of pat is a substring of txt.

Examples:

Input: txt = "geeks", pat = "eke"
Output: true
Explanation: "eek" is a permutation of "eke" which exists in "geeks".

Input: txt = "programming", pat = "rain"
Output: false
Explanation: No permutation of "rain" exists as a substring in "programming".
 */
public class StringPermutation {
    //bruteForce solution.
    public static boolean isPermutation(String txt, String pat , int Startidx){
        int [] freq = new int[26];
        for(int i=0;i<pat.length();i++){
            freq[txt.charAt(Startidx+i)-'a']++;
            freq[pat.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static boolean subString(String txt, String pat){
        int n = txt.length();
        int m = pat.length();
        for(int i=0;i<n-m+1 ; i++){
           if( isPermutation(txt,pat, i)){
               return true;
           }
        }
        return false;
    }
   //sliding window algorithm start.
        public static boolean check(int [] freq){
            for(int i=0;i<freq.length;i++){
                if(freq[i]!=0){
                    return false;
                }
            }
            return true;
        }
        public static boolean slidingAlgo(String txt, String pat){
            int [] freq = new int[26];
            int n = txt.length();
            int m = pat.length();
            for(int i=0;i<m;i++){
                freq[txt.charAt(i)-'a']++;
                freq[pat.charAt(i)-'a']--;
            }
            if(check(freq)){
                return true;
            }

            for(int i=m;i<n;i++){
                freq[txt.charAt(i)-'a']++;
                freq[txt.charAt(i-m)-'a']--;

                if(check(freq)){
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        String txt = "geeks";
        String pat = "eke";

        String txt1 = "programming";
        String pat1 = "rain";

        String txt2 = "aryan";
        String pat2 = "ryan";
       boolean res =  subString(txt, pat);
        boolean res1 =  subString(txt1, pat1);
        boolean res2 =  subString(txt2, pat2);
        System.out.println(res);
        System.out.println(res1 + " " +res2);
        System.out.println(slidingAlgo(txt, pat));
        System.out.println(slidingAlgo(txt1, pat1));
        System.out.println(slidingAlgo(txt2, pat2));
    }
}
/*
[Naive Approach] Checking all possible substrings
The idea is to iterate over all possible substrings of txt having the same length as pat.
For each substring of txt, check if pat is a permutation of the substring.
Two strings are said to be permutations of each other if they contain the same characters with the
same frequencies, but possibly in a different order. So, we can match the frequency of each character in
both the strings to check if they are permutations of each other or not.

Method 2 (GeeksforGeeks Version)
Create one frequency array initialized to 0.
For each character:
Increment for substring character
Decrement for pattern character
If all values become 0, they are permutations.

This is a very elegant trick.

✅ Why This Trick Works

Suppose:

substring = "eek"
pattern   = "eke"

Characters are the same.

For each matching character count:

Add occurrences from substring
Subtract occurrences from pattern

Final result:

e: +2 -2 = 0
k: +1 -1 = 0

All entries are zero → permutation.

✅ Dry Run of GeeksforGeeks Code
txt = "geeks"
pat = "eke"

Length of pattern:

m = 3

The first substring checked is:

txt[0..2] = "gee"
✅ Step-by-Step Through arePermutations(txt, 0, pat)
int[] freq = new int[26];

All values are initialized to 0.

Iteration 1: i = 0
Substring character
txt.charAt(startIdx + i)
= txt.charAt(0)
= 'g'
freq['g' - 'a'] += 1;

freq[6] = 1

Pattern character
pat.charAt(0)
= 'e'
freq['e' - 'a'] -= 1;

freq[4] = -1

Iteration 2: i = 1
Substring character
txt.charAt(1) = 'e'

freq[4] += 1

Previously -1, now becomes 0

Pattern character
pat.charAt(1) = 'k'

freq[10] -= 1

Now freq[10] = -1

Iteration 3: i = 2
Substring character
txt.charAt(2) = 'e'

freq[4] += 1

Now freq[4] = 1

Pattern character
pat.charAt(2) = 'e'

freq[4] -= 1

Now freq[4] = 0

✅ Final Frequency Array

Non-zero entries:

g = +1
k = -1

Since not all values are zero, "gee" is NOT a permutation of "eke".

Return false.

✅ Next Window: i = 1

Substring is:

"eek"

Call:

arePermutations(txt, 1, pat)
Iteration 1

Substring 'e' → freq[e]++
Pattern 'e' → freq[e]--

Net effect: 0

Iteration 2

Substring 'e' → freq[e]++
Pattern 'k' → freq[k]--

Iteration 3

Substring 'k' → freq[k]++
Pattern 'e' → freq[e]--

✅ Final Result

All entries become 0.

Return true.

✅ Line-by-Line Explanation
static final int MAX_CHAR = 26;

We only have lowercase letters 'a' to 'z'.

So we need an array of size 26.

static boolean arePermutations(String txt, int startIdx, String pat)

Checks whether the substring of txt starting at startIdx and having length pat.length() is a permutation of pat.

int[] freq = new int[MAX_CHAR];

Creates a frequency array filled with zeros.

for (int i = 0; i < pat.length(); i++)

Processes each character in both strings.

freq[txt.charAt(startIdx + i) - 'a'] += 1;

Adds the current substring character.

freq[pat.charAt(i) - 'a'] -= 1;

Subtracts the current pattern character.

for (int i = 0; i < MAX_CHAR; i++)

Checks all letters.

if (freq[i] != 0) return false;

Any non-zero value means mismatch.

return true;

All counts balanced perfectly.

✅ search() Function
for (int i = 0; i < n - m + 1; i++)

Tries every possible substring of length m.

if (arePermutations(txt, i, pat)) return true;

If any substring is a permutation, answer is true.

return false;

No matching substring found.

✅ Why This Is Still Brute Force

For every starting index:

Rebuild frequency array from scratch.
Compare counts.

If there are n windows and each takes m work:

O(n × m)
✅ Difference from My Brute Force
My Version
Built two arrays separately.
Compared them with Arrays.equals().
GeeksforGeeks Version
Used one array.
Added and subtracted simultaneously.

Both produce the same result.

🧠 Important Insight

If two strings contain the same characters with the same frequencies, then:

count(substring) - count(pattern) = 0

for every character.

That is the heart of this approach.

🏆 Final Summary

The GeeksforGeeks brute-force method:

Takes each substring of length m.
Adds substring character counts.
Subtracts pattern character counts.
Checks whether every count is zero.

If yes, that substring is a permutation of the pattern.


//sliding Window algorithm.
[Expected Approach] Using Sliding Window
The idea is similar to the previous approach where we check if pat is a permutation
of any substring of txt but instead of comparing each substring from the beginning,
 we can use Sliding Window Technique and slide a window of the same size as pat.
 When a new character is added to the window, we increase its
frequency by 1 and when a character is removed from the window, we decrease its frequency by 1.

🚀 Sliding Window Optimization

Instead of rebuilding the frequency array for every substring:

Build frequency for first window.
Slide one character at a time:
Remove left character.
Add right character.
Compare frequencies.
🪟 Window Visualization
txt = "geeks"
pat = "eke"
m = 3

Windows:

[gee]
 g[eek]
 ge[eks]
✅ Initial Window

First window = "gee"

Frequency:

g = 1
e = 2

Compare with pattern → not equal.

✅ Slide the Window

Remove 'g'
Add 'k'

New window = "eek"

Frequency:

e = 2
k = 1

Matches pattern → return true.

⏱️ Sliding Window Complexity

Each window shift does:

Add one character → O(1)
Remove one character → O(1)
Compare two arrays of size 26 → O(26) = O(1)

Total:

O(n)

This is much faster.

🧠 Why Sliding Window Works

Since every candidate substring must have the same length as pat, we maintain a fixed-size window.

When the window moves:

One character leaves.
One character enters.

So we update counts instead of recomputing everything.

🎯 Interview Pattern to Remember

When you see:

"substring of size k"
"anagram"
"permutation"
"frequency matching"

Think:

Sliding Window + Frequency Array

📌 Real-World Analogy

Suppose pat = "eke".

Required inventory:

2 e
1 k

Move through the text and keep checking whether the current window contains exactly that inventory.

🔥 Dry Run
txt = "geeks"
pat = "eke"

Pattern frequency:

e = 2
k = 1

Window "gee" → no
Window "eek" → yes ✅

Return true.

🏆 Final Takeaway

Two strings are permutations if they contain the same characters with the same counts.

Instead of generating all permutations:

Count pattern frequencies.
Use a sliding window of size pat.length().
Update counts while sliding.
Compare frequencies.
🧠 Mental Model

"I am scanning every substring of size m and checking whether it has exactly the same character counts as the pattern."

 */