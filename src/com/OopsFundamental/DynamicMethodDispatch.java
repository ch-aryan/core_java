package com.OopsFundamental;
class Anil{
    public void methA(){
        System.out.println("hello from anil");
    }
    public void methB(){
        System.out.println("Namaste from anil");
    }
}
class Aryan extends Anil{
    @Override
    public void methA(){
        System.out.println("Hello from aryan");
    }

}
public class DynamicMethodDispatch {
    public static void main(String[] args) {
    Anil obj = new Aryan();
    obj.methA();//Dynamic method dispatch
    }
}
/*
# 💡 Very Important Concept

When you do:

```
Z obj= new Y();
```

You are saying:

> “Treat this object as parent type.”
>

So JVM allows only parent methods.

But when overridden exists:

> Object type wins over reference type.
>

This is called:

### 🔥 Dynamic Method Dispatch
 */