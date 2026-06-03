package com.OopsFundamental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CricketPlayer{
        String country();//this are attributes.not variable.
   //     Integer jersery();// it can't be used because its an class
    int jersey();

    int avg() default 76;

}
@CricketPlayer(country = "IND", jersey = 18)
class ViratKholi{
    private int innings;

    public void setInnings(int innings){
        this.innings = innings;
    }
    public  int getInnings(){
        return innings;
    }
    public void meth(){
        System.out.println("he is a cricket player");
    }
}
public class Annotations {
    public static void main(String[] args) {
    ViratKholi obj = new ViratKholi();
    obj.setInnings(100);
        System.out.println(obj.getInnings());
        System.out.println("let get infor aabout annotation.s");

        Class<? extends ViratKholi> aClass = obj.getClass();
        CricketPlayer annotation = aClass.getAnnotation(CricketPlayer.class);//rememer Annotation is the parent of all annotations.
        System.out.println( annotation.avg());
        System.out.println( annotation.country());
        System.out.println( annotation.jersey());
        System.out.println(  annotation.annotationType());
    }
}
/*
Good question. What you're running into is a special rule of **annotations**.

Your annotation:

```java
@interface CricketPlayer {
    String country();
    Integer jersery();
}
```

has a problem.

Annotation elements can only be certain types:

* Primitive types (`int`, `double`, `boolean`, etc.)
* `String`
* `Class`
* Enum
* Annotation
* Arrays of the above

They **cannot use wrapper classes** like:

```java
Integer
Long
Double
```

So this is invalid:

```java
Integer jersery();
```

You should write:

```java
@interface CricketPlayer {
    String country();
    int jersery();
}
```

Then use it like:

```java
@CricketPlayer(
    country = "IND",
    jersery = 18
)
class Virat {}
```

---

### Why can't we do this?

```java
@CricketPlayer(
    country = "IND",
    jersery = Integer.valueOf(18)
)
```

Because annotation values must be **compile-time constants**.

Java needs to store annotation values in the `.class` file during compilation.

So it allows:

```java
18
"IND"
true
```

but not:

```java
new Integer(18)
Integer.valueOf(18)
```

because those require code execution.

---

### If you want predefined values

Use an enum.

```java
enum Jersey {
    VIRAT(18),
    ROHIT(45);

    private final int number;

    Jersey(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
```

Annotation:

```java
@interface CricketPlayer {
    String country();
    Jersey jersey();
}
```

Usage:

```java
@CricketPlayer(
    country = "IND",
    jersey = Jersey.VIRAT
)
class Virat {}
```

This is actually a very common pattern in frameworks.

---

One small correction:

```java
Integer jersery();
```

should probably be:

```java
int jersey();
```

(Spelling: **jersey**, not **jersery**.)

Your sir is likely teaching annotations after enums because **annotations frequently use enums internally**, for example:

```java
@Retention(RetentionPolicy.RUNTIME)
```

Here `RetentionPolicy` is an enum, and the annotation accepts one of its constants. This is one of the most common real-world uses of enums.

 */