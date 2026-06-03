package com.OopsFundamental;
enum Result1 {
    PASS, FAIL;
    int marks;
         Result1(){
        System.out.println("enums are created ");
    }
    public void setMarks(int marks){
             this.marks = marks;
    }
    public int getMarks(){
             return marks;
    }
}
public class Enums {
    public static void main(String[] args) {
        Result1 pass = Result1.PASS;
        pass.setMarks(100);
        System.out.println(pass.getMarks());

        Result1.FAIL.setMarks(2);
        int marks = Result1.FAIL.getMarks();
        System.out.println(marks);

        Result1.PASS.setMarks(88);
        int passMarks = Result1.PASS.getMarks();
        System.out.println(passMarks);
    }
}
/*
Great practice, Aryan. Your example is actually exploring something many beginners don't realize: **enums are real Java classes**, not just constants.

Let's build solid notes from your code.

# 1. What is an Enum?

Enum (Enumeration) is a special type in Java used to represent a **fixed set of constants**.

Example:

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}
```

Instead of:

```java
String day = "MONDAY";
```

you write:

```java
Day day = Day.MONDAY;
```

This prevents invalid values like:

```java
day = "MONDA"; // typo
```

because only the defined constants are allowed.

---

# 2. What Happens Internally?

When Java sees:

```java
enum Result1 {
    PASS, FAIL
}
```

it roughly creates something like:

```java
final class Result1 extends Enum<Result1> {
    public static final Result1 PASS = new Result1();
    public static final Result1 FAIL = new Result1();
}
```

So:

```java
Result1.PASS
```

and

```java
Result1.FAIL
```

are actually objects.

That's why your enum can have:

* variables
* constructors
* methods

---

# 3. Constructor in Enum

Your code:

```java
Result1() {
    System.out.println("enums are created");
}
```

Output:

```text
enums are created
enums are created
```

Why only 2 times?

Because:

```java
PASS
FAIL
```

are the only objects ever created.

Java creates them when the enum class loads.

Even if you do:

```java
Result1.PASS
Result1.PASS
Result1.PASS
```

constructor runs only once.

---

# 4. Enum Objects are Singleton

You cannot do:

```java
new Result1(); // Error
```

Java prevents it.

Only these objects exist:

```java
Result1.PASS
Result1.FAIL
```

Nothing else.

---

# 5. Variables Inside Enum

Your code:

```java
int marks;
```

Each enum object gets its own copy.

Think:

```java
PASS -> marks
FAIL -> marks
```

When:

```java
PASS.setMarks(100);
```

it affects only PASS.

When:

```java
FAIL.setMarks(2);
```

it affects only FAIL.

---

# 6. Better Enum Design

Instead of setting values later:

```java
PASS.setMarks(100);
```

we usually initialize them directly.

Example:

```java
enum Result {
    PASS(35),
    FAIL(0);

    private int marks;

    Result(int marks){
        this.marks = marks;
    }

    public int getMarks(){
        return marks;
    }
}
```

Usage:

```java
System.out.println(Result.PASS.getMarks());
```

Output:

```text
35
```

This is the common pattern.

---

# 7. Important Built-in Methods

## values()

Returns all constants.

```java
for(Result1 r : Result1.values()){
    System.out.println(r);
}
```

Output:

```text
PASS
FAIL
```

---

## ordinal()

Returns position.

```java
System.out.println(Result1.PASS.ordinal());
System.out.println(Result1.FAIL.ordinal());
```

Output:

```text
0
1
```

PASS is first.

FAIL is second.

⚠️ Don't use ordinal for business logic because order may change later.

---

## valueOf()

Converts String to Enum.

```java
Result1 r = Result1.valueOf("PASS");
```

Output:

```java
PASS
```

If not found:

```java
Result1.valueOf("ABC");
```

throws exception.

---

## name()

Returns constant name.

```java
System.out.println(Result1.PASS.name());
```

Output:

```text
PASS
```

---

# 8. Enum with Switch

Very common in real projects.

```java
enum Status {
    PENDING,
    APPROVED,
    REJECTED
}
```

```java
Status status = Status.APPROVED;

switch(status){
    case PENDING:
        System.out.println("Waiting");
        break;

    case APPROVED:
        System.out.println("Accepted");
        break;

    case REJECTED:
        System.out.println("Denied");
        break;
}
```

---

# 9. Enum Can Have Methods

```java
enum Operation {
    ADD,
    SUBTRACT;

    public void printInfo(){
        System.out.println("Operation running");
    }
}
```

Usage:

```java
Operation.ADD.printInfo();
```

---

# 10. Enum Can Have Abstract Methods

Advanced feature.

```java
enum Calculator {

    ADD{
        public int apply(int a, int b){
            return a + b;
        }
    },

    SUBTRACT{
        public int apply(int a, int b){
            return a - b;
        }
    };

    public abstract int apply(int a, int b);
}
```

Usage:

```java
System.out.println(Calculator.ADD.apply(5,3));
```

Output:

```text
8
```

---

# 11. Where Are Enums Used in Real Projects?

Your sir is correct.

Most of the time we use predefined enums.

Examples:

### Thread State

```java
Thread.State.NEW
Thread.State.RUNNABLE
Thread.State.TERMINATED
```

---

### Month

```java
java.time.Month.JANUARY
java.time.Month.FEBRUARY
```

---

### Day Of Week

```java
DayOfWeek.MONDAY
```

---

### Spring Boot

```java
public enum UserRole {
    ADMIN,
    USER,
    MODERATOR
}
```

Used in authentication and authorization.

---

### Order Status

```java
public enum OrderStatus {
    PLACED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
```

Very common in backend development.

---

# 12. Relation Between Enums and Annotations

Your sir probably mentioned this because annotations internally use enums a lot.

Example:

```java
@Retention(RetentionPolicy.RUNTIME)
```

Here:

```java
RetentionPolicy
```

is an enum.

Possible values:

```java
SOURCE
CLASS
RUNTIME
```

Java frameworks heavily use enums and annotations together.

---

# Interview Points

If an interviewer asks:

**"Can enum have constructor?"**

✅ Yes.

---

**"Can enum have methods?"**

✅ Yes.

---

**"Can enum extend a class?"**

❌ No.

It already extends `java.lang.Enum`.

---

**"Can enum implement interfaces?"**

✅ Yes.

---

**"Can we create enum objects using new?"**

❌ No.

---

**"Are enums classes?"**

✅ Yes. Special classes.

---

The biggest takeaway from your experiment is this:

> **An enum is not merely a collection of constants. Each enum constant is actually a pre-created object, and those objects can have their own fields, constructors, and methods.**

Once you understand that single statement, enums become much easier to understand and use in Spring Boot, backend development, and enterprise Java applications.

 */