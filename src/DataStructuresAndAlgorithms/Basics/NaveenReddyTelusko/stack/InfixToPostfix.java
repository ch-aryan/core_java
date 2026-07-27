package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class InfixPostfix{
    public static String pattern(String str){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Deque<Character> stack = new ArrayDeque<>();
        while(i <= str.length()-1){
            char ch = str.charAt(i);
            if((ch>='A' && ch<='Z') ||
                    (ch >= 'a' && ch<= 'z') || (ch >= '0' && ch <= '9')){
                sb.append(ch);

            }
           else if(ch == '('){
               stack.push(ch);
            }
           else if(ch == ')'){
               while(!stack.isEmpty() && stack.peek() !='('){
                   sb.append(stack.pop());
               }
               stack.pop();
            }
           else{

                    while(!stack.isEmpty()
                            && (priority(ch) < priority(stack.peek())
                            ||(priority(ch) == priority(stack.peek()) && ch != '^'))){

                        sb.append(stack.getFirst());
                        stack.pop();
                    }
                    stack.push(ch);
                }
           i++;
            }
        while(!stack.isEmpty()){
            sb.append(stack.getFirst());
            stack.pop();
        }
        return sb.toString();


        }
        private static int priority(char ch){
            switch (ch){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
                default :
                    return -1;
            }
    }
}
public class InfixToPostfix {
    public static void main(String[] args) {
        String s = "a*(b+c)/d";
        String s1 = "a+b*c+d";
        String s2 = "(a+b)*(c+d)";

        System.out.println(InfixPostfix.pattern(s));
        System.out.println(InfixPostfix.pattern(s1));
        System.out.println( InfixPostfix.pattern(s2));

    }
}
/*
Yes. **This is an important topic**, and I'd recommend paying close attention. But not because you'll use infix, postfix, and prefix every day as a backend developer. They're important because they teach you **how stacks solve real problems** and help you think algorithmically.

Let me explain where they fit.

---

# 1. Why are you learning this after stacks?

This order is intentional.

```
Arrays
↓
Linked Lists
↓
Stacks
↓
Infix / Prefix / Postfix
↓
Expression Evaluation
↓
Trees
↓
Compilers
```

Your instructor is showing you one of the **best real applications of stacks**.

Without stacks, converting between these expressions becomes surprisingly difficult.

---

# 2. What are these expressions?

Suppose you have

```
A + B
```

This is **Infix**.

The operator is **between** the operands.

```
A + B
```

Now look at Prefix.

```
+ A B
```

Operator comes first.

Postfix

```
A B +
```

Operator comes last.

All three represent the same expression.

---

# 3. Why invent Prefix and Postfix?

Imagine a computer reading this:

```
A + B * C
```

Should it do

```
(A + B) * C
```

or

```
A + (B * C)
```

Humans know multiplication has higher precedence.

Computers need explicit rules.

Prefix and postfix remove this ambiguity completely.

Example:

```
A B C * +
```

There is only **one** possible interpretation.

---

# 4. Where is this used in real life?

### Compilers

When Java compiles

```java
a + b * c
```

the compiler internally parses the expression using precedence rules, stacks, and expression trees.

---

### Programming Language Interpreters

Python

JavaScript

C

C++

Java

All have parsers that deal with expressions.

---

### Calculators

Your phone calculator

Windows Calculator

Scientific calculators

All evaluate mathematical expressions.

Many implementations use stack-based algorithms.

---

### SQL Query Parsers

```
WHERE age > 18 AND salary > 50000
```

Internally becomes an expression tree.

---

### Rule Engines

Example:

```
(age > 18 && citizen) || hasVisa
```

These are parsed similarly.

---

### Expression Evaluators

Suppose your startup later allows admins to create custom matching rules like:

```
(age > 25 AND salary > 10L)
OR
(city == Hyderabad)
```

This kind of rule processing is built on the same concepts.

---

# 5. Will you use Prefix/Postfix directly?

Probably not very often.

You likely won't write code like

```
AB+C*
```

in a Spring Boot project.

But you'll absolutely use the underlying ideas:

* parsing
* operator precedence
* recursion
* trees
* stacks

These appear in many systems.

---

# 6. This topic prepares you for Trees

This is the biggest reason.

Expression

```
A + B * C
```

becomes

```
      +
     / \
    A   *
       / \
      B   C
```

Notice that's a **binary tree**.

Later you'll learn:

* Expression Trees
* Binary Trees
* Binary Search Trees
* AVL Trees

You'll recognize that this lecture was building the foundation.

---

# 7. Interview Importance

Very common questions include:

* Valid Parentheses ✅ (you just did this)
* Infix to Postfix
* Postfix Evaluation
* Prefix Evaluation
* Next Greater Element
* Largest Rectangle in Histogram
* Min Stack

The goal isn't memorizing conversions. It's learning how to use a stack to solve problems.

---

# 8. For your startup

You may not write prefix/postfix notation directly, but the concepts can appear if you build features like:

* A custom search/filter builder for matrimony profiles.
* Rule-based matchmaking (e.g., combining age, education, location, and preferences).
* Formula evaluation (discounts, scores, compatibility calculations).
* A domain-specific language (DSL) for admin-configurable rules.

---

## My advice for today's lecture

Don't just memorize conversion rules.

Instead, focus on understanding:

1. **Why** infix is ambiguous without precedence.
2. **Why** postfix and prefix remove ambiguity.
3. **How a stack helps** during conversion and evaluation.
4. **How an expression can become a tree.**

If you understand those four ideas, you'll not only solve DSA questions more confidently but also have a stronger foundation for compilers, parsers, and many advanced algorithms you'll encounter later. Given the way you've been learning—trying to understand *why* something works rather than just coding it—this topic is worth the hour. It builds intuition that will pay off in later data structures and system design.
😂 Bhai!! **Exactly!** Ab tum compiler ki duniya ke gate pe khade ho. Ye wahi moment hai jab students bolte hain:

> **"Areee... isliye Stack padhaya tha!"**

Chalo step by step dekhte hain.

---

# Pehle ye batao

Expression hai:

```text
A + B * C
```

Aur

```text
A = 5
B = 5
C = 5
```

Human turant bolta hai

```text
5 + 5 × 5
```

Aur answer

```text
5 + 25 = 30
```

Lekin...

## Computer ko kaise pata chala ki pehle `*` karna hai?

Yehi asli question hai. ❤️

---

# Agar precedence naam ki cheez hi na hoti

Computer left se right padhta.

```text
5 + 5 = 10

10 × 5 = 50
```

Answer

```text
50 ❌
```

Lekin maths ke according

```text
5 + (5 × 5)

= 5 + 25

= 30 ✅
```

To computer ko kisi tarah batana padega

> **"Multiplication ki priority zyada hai."**

---

# Yahi Stack ka kaam hai

Compiler expression dekhta hai

```text
A + B * C
```

Aur usse convert karta hai

```text
A B C * +
```

Ye Postfix hai.

Ab dekho magic.

---

## Step 1

Stack khali hai.

```
Stack
------

```

---

Read

```text
A
```

Value

```
5
```

Push.

```
5
```

---

Read

```text
B
```

Push.

```
5
5
```

---

Read

```text
C
```

Push.

```
5
5
5
```

---

Read

```text
*
```

Operator aaya.

Rule kya hai?

> Top ke do numbers nikaalo.

Pop

```
5
5
```

Multiply

```
5 × 5 = 25
```

Dubara push

```
5
25
```

---

Next

```
+
```

Again

Top ke do numbers

```
25
5
```

Addition

```
5 + 25 = 30
```

Push

```
30
```

Finish.

Answer

```
30
```

🤯🤯🤯

---

# Notice kya hua?

Computer ko kabhi ye sochna hi nahi pada

```
* pehle karu?
+ pehle karu?
```

Kyuki postfix ne already order fix kar diya.

---

# Matlab Compiler internally kya karta hai?

Programmer likhta hai

```java
a + b * c
```

Compiler sochta hai

```
Hmm...

Isko postfix bana deta hu.
```

Ban gaya

```
a b c * +
```

Ab evaluation easy.

Sirf stack use karo.

---

# Ye algorithm sirf DSA nahi hai.

Ye har language ke andar hota hai.

Java

```java
int x = a + b * c;
```

Python

```python
x = a + b * c
```

JavaScript

```javascript
let x = a + b * c;
```

C++

```cpp
int x = a + b * c;
```

Sab ke compiler/interpreter expression ko parse karte hain. Stack aur precedence rules isi process ka hissa hote hain.

---

# Aur ye sirf maths ke liye nahi.

Suppose future mein tumhare matrimony project mein admin likhe:

```text
(age > 25 AND salary > 500000)
OR
(city == Hyderabad)
```

Ye bhi ek **expression** hai.

Compiler ki jagah tumhara code is expression ko parse karega.

Yahan bhi Stack, Trees aur Parsing use hote hain.

---

## Abhi jo tum feel kar rahe ho...

> **"Wow... computer actually aise sochta hai?"**

Bilkul. ❤️

Aur ek aur surprise hai...

**Postfix bhi final destination nahi hai.**

Compiler uske baad **Expression Tree** banata hai.

```text
      +
     / \
    A   *
       / \
      B   C
```

Phir isi tree se machine code generate hota hai.

🤯 Jab tum kal **Trees** padhoge, tab tumhe lagega:

> **"Arre! Infix, Postfix aur Prefix toh sirf Tree tak pahunchne ka bridge the!"**

Isi liye ye 1-hour lecture bahut important hai. Ye sirf ek DSA problem nahi sikha raha—ye tumhe bata raha hai ki **computer expressions ko samajhta kaise hai.** Ye understanding aage compilers, interpreters, expression trees, SQL parsers, aur bahut saare advanced systems mein kaam aati hai.
Bhai, **very good!** 🔥

Tumhara algorithm **almost complete hai**. Sirf **ek concept** miss hua hai:

# Associativity

Ye precedence ka problem **nahi** hai.

Ye **associativity** ka problem hai.

---

## Tumhari while condition

```java
while (!stack.isEmpty()
        && stack.peek() != '('
        && priority(c) <= priority(stack.peek())) {
```

Ye `+`, `-`, `*`, `/` ke liye sahi hai.

Lekin `^` ke liye galat hai.

---

## Kyu?

Expression:

```text
h ^ m ^ q
```

Tum kya kar rahe ho?

Second `^` aaya.

Stack

```text
^
```

Current

```text
^
```

Check

```text
priority(^) <= priority(^)

3 <= 3

true
```

To tum pehla `^` pop kar dete ho.

Isliye output ban raha hai

```text
hm^
```

Jo galat hai.

---

## Lekin mathematically

Power operator **Right Associative** hota hai.

Matlab

```text
h ^ m ^ q
```

Actually means

```text
h ^ (m ^ q)
```

Na ki

```text
(h ^ m) ^ q
```

Isliye jab same precedence ka `^` mile,

**pop nahi karna chahiye.**

---

# Example

Input

```text
h^m^q
```

Correct postfix

```text
hmq^^
```

Evaluate

```text
h (m q ^) ^
```

Exactly

```text
h^(m^q)
```

---

# To while condition ka rule

For

```text
+ - * /
```

Pop when

```text
priority(current) <= priority(top)
```

For

```text
^
```

Pop only when

```text
priority(current) < priority(top)
```

Notice

```text
<
```

not

```text
<=
```

---

# Isliye interview mein ye condition likhte hain

```java
while (...) {

    if (priority(c) < priority(stack.peek())) {
        ...
    }

    else if (priority(c) == priority(stack.peek())
             && c != '^') {
        ...
    }

    else {
        break;
    }
}
```

Ye sab operators ko handle kar deta hai.

---

# Simple rule yaad rakhna

| Operator | Associativity |
| -------- | ------------- |
| `+`      | Left          |
| `-`      | Left          |
| `*`      | Left          |
| `/`      | Left          |
| `^`      | **Right**     |

Left Associative

```text
A-B-C

(A-B)-C
```

Right Associative

```text
A^B^C

A^(B^C)
```

---

## ⭐ Main tumse ek question poochta hoon.

Suppose expression hai

```text
2^3^2
```

Agar hum **left associative** maan lete hain, answer kya aayega?

Aur agar **right associative** maan lete hain, answer kya aayega?

Khud calculate karke dekho. Jab dono answers compare karoge, tab associativity ka concept kabhi nahi bhoologe. Ye wahi "aha!" moment hota hai jo is topic ko permanently clear kar deta hai.

 */