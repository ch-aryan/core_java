package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Hashing;

public class CharacterHasing {
    public static int hashingForAll(String str, char c){

        int[] hash = new int[256];

        for(int i=0; i<str.length();i++){
            hash[str.charAt(i) ]++;
        }
        return hash[c];
    }
    public static int hashing(String str, char c){

        int[] hash = new int[26];

        for(int i=0; i<str.length();i++){
            hash[str.charAt(i) - 'a']++;
        }
    return hash[c - 'a'];
    }


    public static void main(String[] args) {
        String str = "aabcdde";
        char c = 'a';
     int result =    hashing(str, c);
        System.out.println(result);
        System.out.println("**********");

        String str1 = "AAAAvaddaab";
        char C = 'A';
       int rs = hashingForAll(str1,C);
        System.out.println(rs);

    }
}
/* 📒 Dry Run (VERY IMPORTANT)

String:

aabcdde

Initially:

hash[26] → all zeros
Step 1 → 'a'
index = 'a' - 'a' = 0
hash[0]++
a = 1
Step 2 → 'a'
hash[0]++
a = 2
Step 3 → 'b'
'b' - 'a' = 1
hash[1]++
b = 1
Step 4 → 'c'
hash[2]++
c = 1
Step 5 → 'd'
hash[3]++
d = 1
Step 6 → 'd'
hash[3]++
d = 2
Step 7 → 'e'
hash[4]++
e = 1
Final Hash Table
a → 2
b → 1
c → 1
d → 2
e → 1

Now you asked frequency of:

c = 'a'

Return:

hash[0] → 2

Output:

2

✔ Correct.

📒 Time Complexity
O(n)
📒 Space Complexity
O(26) → O(1)

Constant space ⭐

⭐ VERY IMPORTANT INTERVIEW CONCEPT

Character hashing is used in:

✅ Anagram problems
✅ First non-repeating character
✅ Count distinct characters
✅ Sliding window problems
✅ String frequency problems

This topic is super super important.

If you want, next I will teach you a powerful next step:

👉 Character hashing using HashMap (handles uppercase + symbols + large charset)
👉 Then I will give you 3 interview problems to practice

Shall we go step-by-step like that?

this is important why? return hash[c - 'a'];
    }. because we use are taking 0 -25 only so we are storing at the diff format . like wise haa.

Yes 👍 you are thinking in the correct direction.
Let me make it 100% crystal clear in simple words.

⭐ Why we write
return hash[c - 'a'];
✅ Core Idea

We are not storing characters directly.

We are storing their frequencies using index mapping.

Because array index must be a number, not a character.

So we convert:

character  →  number index
✅ How mapping works

In Java internally characters have ASCII values.

'a' = 97
'b' = 98
'c' = 99
...
'z' = 122

But we don't want to create:

int hash[123]

Waste of space ❌

Instead we do smart mapping:

'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
...
'z' - 'a' = 25

So we can use:

int hash[26]

This is called
⭐ Index Compression / Mapping Technique

Very important concept.

✅ So what happens while storing

Example string:

aabcdde

When loop runs:

hash[str.charAt(i) - 'a']++

Means:

Character	Calculation	Index	Stored
a	'a'-'a'	0	hash[0]++
b	'b'-'a'	1	hash[1]++
d	'd'-'a'	3	hash[3]++

So yes 👍
You are right:

we are storing in different format (mapped index format)

✅ Now WHY returning like this ?

When user asks:

frequency of 'c'

We must again convert character → same mapped index

So:

return hash[c - 'a'];

Example:

c = 'd'
'd' - 'a' = 3
return hash[3]

That gives frequency.

⭐ Very Important Golden Rule

👉 Whenever you store using mapping,
you must retrieve using the same mapping.

Otherwise wrong index → wrong answer.

This is a big DSA understanding point.

🧠 Real Interview Thinking

This technique teaches you:

how to reduce memory
how to convert data → index
how hashing internally works
foundation for HashMap understanding*/
/* ⭐ Why in C++ sir wrote
hash[s[i]]++;
✅ Because in C++ (and Java also)

👉 Character itself can behave like an integer (ASCII value).

So when you write:

s[i] = 'a'

Internally it is stored as:

97

So this becomes:

hash[97]++;

That means:

👉 Array index used = ASCII value of character

📒 Example

If sir created array like:

int hash[256] = {0};

Then mapping becomes:

Character	ASCII	Index used
a	97	hash[97]
b	98	hash[98]
A	65	hash[65]
0	48	hash[48]

So this hashing supports:

✅ lowercase
✅ uppercase
✅ digits
✅ symbols

Very powerful ⭐

⭐ Then why WE used
hash[ch - 'a']++

Because we were solving restricted problem:

👉 Only lowercase letters
👉 Want memory optimization
👉 Want index range 0 → 25 only

So we did index compression

⭐ Difference Between Two Approaches
✅ Method 1 — ASCII hashing (your sir method)
int hash[256];
hash[s[i]]++;
✔ Advantages
Works for all characters
Simple to write
Interview safe
❌ Disadvantage
Uses more memory
✅ Method 2 — Mapped hashing (your method)
int hash[26];
hash[ch - 'a']++;
✔ Advantages
Very memory efficient
Shows deeper DSA understanding
Used in competitive programming
❌ Limitation
Works only for lowercase
⭐ Very Important Interview Insight

Interviewer may ask:

Why not use hash[s[i]]++ ?

Best answer:

👉 “Yes we can use that if character range is large.
But when range is known (like lowercase letters),
we compress index to reduce memory.”

This answer gives strong impression ⭐*/