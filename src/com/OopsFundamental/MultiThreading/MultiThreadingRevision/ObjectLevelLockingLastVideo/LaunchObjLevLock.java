package com.OopsFundamental.MultiThreading.MultiThreadingRevision.ObjectLevelLockingLastVideo;

public class LaunchObjLevLock {
    public static void main(String[] args) {
        HSBC bank = new HSBC(6000);

        ATM atm = new ATM(bank);
        Thread t1 = new Thread(atm);
        t1.setName("Atm thread");

        GooglePay gpay= new GooglePay(bank);
        Thread t2 = new Thread(gpay);
        t2.setName("Gpay thread");

        Paytm paytm = new Paytm(bank);
        Thread t3 = new Thread(paytm);
        t3.setName("Paytm thread");

        t1.start();
        t2.start();
        t3.start();


    }
}
/*
Aryan, this is actually one of the **most important concepts in Java multithreading**. Almost every interview, backend system, banking app, payment system, ticket booking app, etc., uses this idea somewhere.

And your sir taught it using a **bank example** because that is the perfect real-world use case.

Your uploaded code is actually a very good beginner example.

Let’s build the understanding slowly from zero.

---

# First Understand the Problem

Imagine this:

A bank account has ₹6000.

At the same time:

* ATM withdraws ₹2000
* Google Pay deposits ₹4000
* Paytm checks balance

All these are happening using **different threads**.

Your code:

* ATM thread → withdraw
* GPay thread → deposit
* Paytm thread → view balance

All are using the SAME bank object.

---

# Why Locking Is Needed?

Suppose two threads access the same data together.

Without locking:

```java
accountBal = accountBal - withdraw;
```

and

```java
accountBal = accountBal + deposit;
```

may execute simultaneously.

Then:

* data may become corrupted
* wrong balance may come
* race condition happens

Example:

Initial balance = 6000

Thread 1 reads → 6000
Thread 2 reads → 6000

Thread 1 updates → 4000
Thread 2 updates → 10000

Final result = 10000 ❌
Correct result should be = 8000

This problem is called:

# Race Condition

Multiple threads racing to modify same data.

---

# So What Is Locking?

Locking means:

> “Only one thread can enter the critical section at a time.”

Critical section means:

* shared resource
* shared data
* sensitive code

In your example:

* accountBal is shared data

---

# Object Level Locking

Now comes the main topic.

When you write:

```java
synchronized public void withdrawMeth(int withdraw)
```

Java internally does:

```java
lock this object
```

That means:

# The lock belongs to the OBJECT

NOT the method.

NOT the thread.

NOT the class.

The lock belongs to:

```java
HSBC bank = new HSBC(6000);
```

THIS object.

---

# Visualization

You created:

```java
HSBC bank = new HSBC(6000);
```

Only ONE object exists.

Now all threads share this:

```java
ATM(bank)
GooglePay(bank)
Paytm(bank)
```

All use SAME object.

---

# Internal Visualization

Think like this:

```text
                [ HSBC Object ]
             ---------------------
             | accountBal = 6000 |
             |   LOCK 🔒         |
             ---------------------
```

Now:

```text
ATM Thread  ---> wants lock
GPay Thread ---> wants lock
Paytm Thread --> wants lock
```

Only ONE gets lock.

Others wait.

---

# Flow Example

Suppose ATM thread enters first.

```java
withdrawMeth()
```

It acquires lock.

Now:

```text
ATM Thread       -> RUNNING
GPay Thread      -> WAITING
Paytm Thread     -> WAITING
```

After ATM finishes:

```text
lock released 🔓
```

Then another thread enters.

This is:

# Object Level Locking

Because lock is associated with ONE OBJECT.

---

# Important Principle

## synchronized instance method

```java
synchronized public void method()
```

locks:

```java
this
```

which means:

```java
current object
```

---

# What If There Are 2 Objects?

Example:

```java
HSBC b1 = new HSBC(5000);
HSBC b2 = new HSBC(7000);
```

Now:

```text
b1 has separate lock
b2 has separate lock
```

So:

* Thread using b1 can run
* Thread using b2 can also run

simultaneously.

Because:

* locks are DIFFERENT

---

# This Is The Biggest Principle

# One Object → One Lock

Different objects:

* different locks
* parallel execution possible

Same object:

* same lock
* one thread at a time

---

# Class Level Locking

Now another important concept.

Suppose you write:

```java
synchronized static void method()
```

Now lock is NOT on object.

Now lock is on:

# CLASS

Meaning:

```java
HSBC.class
```

gets locked.

---

# Visualization

```text
              [ HSBC.class ]
             ----------------
             | CLASS LOCK 🔒 |
             ----------------
```

Now ALL objects share same class lock.

---

# Difference

## Object Level Lock

```java
synchronized void method()
```

Lock:

```text
this object
```

---

## Class Level Lock

```java
synchronized static void method()
```

Lock:

```text
Class object
```

---

# Real-Life Analogy

## Object Level Lock

Imagine:

* every bank account has its own locker

Account A lock ≠ Account B lock

Operations on different accounts can happen simultaneously.

---

## Class Level Lock

Imagine:

* entire bank branch has one master lock

If one operation is running:

* whole branch locked

---

# When To Use Object Level Locking?

Use when:

* object data is shared
* instance variables are modified

Examples:

* bank account
* shopping cart
* seat booking
* user wallet
* inventory item

Your example is perfect.

---

# When To Use Class Level Locking?

Use when:

* static data shared by all objects

Examples:

* total users count
* global configuration
* singleton resources
* static counters

---

# How To Achieve Object Level Locking?

## Method Level

```java
synchronized void method()
```

---

## Block Level

```java
synchronized(this){

}
```

Example:

```java
public void withdraw(int amount){
    synchronized(this){
        balance -= amount;
    }
}
```

This also locks current object.

---

# Why Synchronized Block Is Better Sometimes?

Because:

```java
synchronized method
```

locks whole method.

But:

```java
synchronized block
```

locks only important part.

Better performance.

---

# Very Important Interview Question

# Does synchronized lock method or object?

Answer:

> synchronized locks the OBJECT, not the method.

Very important.

---

# In Your Code

This line:

```java
HSBC bank = new HSBC(6000);
```

creates ONE shared object.

And these methods:

```java
synchronized public void withdrawMeth()
synchronized public void depositMeth()
synchronized public void balanceView()
```

all use SAME object lock.

Therefore:

* only one thread enters at a time.

---

# One More Advanced Point

Suppose:

```java
public void normalMethod(){

}
```

This method is NOT synchronized.

Threads can enter it anytime.

Only synchronized parts require lock.

---

# Easy Memory Trick

# Object Lock

```text
synchronized non-static method
```

→ locks object

---

# Class Lock

```text
synchronized static method
```

→ locks class

---

# Final Core Understanding

## Object Level Locking

* lock belongs to object
* same object → one thread at a time
* different objects → parallel possible
* used for protecting instance data

---

## Class Level Locking

* lock belongs to class
* shared by all objects
* used for protecting static data

---

# Your Current Level

Honestly, your sir has introduced you to a very foundational and important topic at the correct time. And the fact that you uploaded the code and are trying to deeply understand “WHY the lock exists” instead of memorizing syntax means your thinking is moving in the right software engineer direction.

Most students only memorize:

```java
synchronized
```
But real understanding is:
* who owns lock?
* why lock?
* what data is protected?
* what happens if multiple objects exist?
That is the actual multithreading understanding.
And you are asking exactly those questions now.

 */