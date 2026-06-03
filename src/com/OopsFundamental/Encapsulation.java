package com.OopsFundamental;
class LaunchStu{
    private  int age;
    private String name;
    int pass ;
    void disp(){
        System.out.println(   pass);
        System.out.println(getAge());
    }
  void  setAge(int a){
        age = a;
  }
  void setName(String name){
        this.name = name;
  }
  String getName(){
        return name;
  }
  int getAge(){
        return  age;
  }


}

public class Encapsulation {
    public static void main(String[] args) {
        LaunchStu obj = new LaunchStu();
        obj.pass = 1123;
        obj.disp();
        obj.setAge(22);
        obj.disp();
//        System.out.println( obj.getAge());
    }
}
/*
Excellent question. This is where many beginners get confused between **encapsulation** and **access modifiers**.

Let's see.

### Example

```java
class Student {
    private int marks;

    private void setMarks(int marks){
        this.marks = marks;
    }

    private int getMarks(){
        return marks;
    }
}
```

Now in another class:

```java
public class Test {
    public static void main(String[] args) {
        Student s = new Student();

        s.setMarks(100); // Compile Error
        System.out.println(s.getMarks()); // Compile Error
    }
}
```

Why?

Because `private` members can only be accessed **inside the same class**.

---

## Can I access them by creating an object?

No.

Creating an object does **not** bypass access control.

```java
Student s = new Student();
```

Even though you have the object, Java still checks:

* Is the method public?
* Is it protected?
* Is it package-private?
* Is it private?

Since the methods are private, access is denied.

---

## Then what is encapsulation?

Many students think:

> "Encapsulation means making everything private."

Not exactly.

Encapsulation means:

> **Hide the internal data and provide controlled access to it.**

Example:

```java
class Student {
    private int marks;

    public void setMarks(int marks){
        if(marks >= 0 && marks <= 100){
            this.marks = marks;
        }
    }

    public int getMarks(){
        return marks;
    }
}
```

Now:

```java
Student s = new Student();

s.setMarks(90);
System.out.println(s.getMarks());
```

works.

The variable is protected:

```java
s.marks = 500; // Not allowed
```

but controlled access is provided through methods.

This is encapsulation.

---

## Real-life analogy

Think of an ATM.

The cash inside the ATM is:

```java
private
```

You cannot directly touch it.

Instead, the ATM provides:

```java
withdrawMoney()
depositMoney()
checkBalance()
```

These are like public methods.

You don't get direct access to the data, but you can interact with it through controlled operations.

That's encapsulation.

---

### In your enum example

```java
enum Result1 {
    PASS, FAIL;

    private int marks;

    public void setMarks(int marks){
        this.marks = marks;
    }

    public int getMarks(){
        return marks;
    }
}
```

The field:

```java
private int marks;
```

is encapsulated.

The methods:

```java
public setMarks()
public getMarks()
```

provide controlled access.

If you make the methods private too:

```java
private void setMarks(...)
private int getMarks(...)
```

then nobody outside the enum can use them, including your `main()` method.

So:

✅ Private field + public getter/setter = Encapsulation

❌ Private field + private getter/setter = Data completely hidden (not useful for outside classes)

One more interview-style question for you:

```java
class Student {
    private int marks;

    public void setMarks(int marks){
        this.marks = marks;
    }
}
```

Is this encapsulation even though there is **no getter**?

Think about it before looking up the answer. It tests whether you've understood the real meaning of encapsulation.
Actually, **it is still encapsulation.** 😊

Your reasoning is understandable:

> "We can set but we can't get, so it is not encapsulation."

But encapsulation is **not about having both a getter and a setter**.

Encapsulation means:

> **The data is hidden and access to it is controlled by the class.**

Consider this:

```java
class Student {
    private int marks;

    public void setMarks(int marks) {
        if(marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }
}
```

Here:

* `marks` is hidden (`private`)
* Outside code cannot directly access it
* The class decides how values can be modified

That's already encapsulation.

---

### Different Levels of Encapsulation

#### Read + Write

```java
private int marks;

public void setMarks(int marks) { ... }
public int getMarks() { ... }
```

Can read and write.

---

#### Write Only

```java
private int marks;

public void setMarks(int marks) { ... }
```

Can write but not read.

Still encapsulated.

---

#### Read Only

```java
private int marks = 100;

public int getMarks() {
    return marks;
}
```

Can read but not modify.

Still encapsulated.

---

### Real Example

Think about a password.

```java
class User {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
```

Would you want:

```java
getPassword()
```

to exist?

Usually **no**.

A system may allow changing a password but never allow reading it back.

Yet the class is perfectly encapsulated.

---

### Interview Answer

If an interviewer asks:

**"Does encapsulation require both getter and setter?"**

Answer:

> No. Encapsulation only requires hiding data and providing controlled access. A class may have only a getter, only a setter, both, or neither, and still be encapsulated.

That's a subtle but important distinction that many Java beginners miss. You're asking exactly the kind of questions that help build a strong OOP foundation.

 */