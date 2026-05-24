package com.OopsFundamental.Collections.maps;

import java.net.Inet4Address;
import java.util.*;

class Passport{
    public String name;
    public String country;
    public String lang;

    public Passport(String name, String country, String lang) {
        this.name = name;
        this.country = country;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
public class PassportApplication {
    public static void main(String[] args) {
        Passport pass1 = new Passport("ary", "ind", "tel");
        Passport pass2 = new Passport("anil", "india", "telugu");
        Passport pass3 = new Passport("vani", "inida" , "telugu");
        Passport pass4 = new Passport("Bhav", "india", "telugu");

        Integer id1 = Integer.valueOf(101);
        Integer id2 = Integer.valueOf(102);
        Integer id3 = 19;

        HashMap<Integer, Passport> hsMap = new HashMap<>();
        hsMap.put(id1, pass1);
        hsMap.put(id2, pass2);
        hsMap.put(id3, pass3);
        hsMap.put(4, pass4);

        System.out.println(hsMap);
        System.out.println("************");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number or id to be search");
        int n = in.nextInt();
        Boolean flag = false;
        Set<Map.Entry<Integer, Passport>> entries = hsMap.entrySet();
        Iterator<Map.Entry<Integer, Passport>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Passport> next = iterator.next();
            Integer key = next.getKey();
            if(n==key){
                System.out.println("please find your details below");
                System.out.println(next.getValue());
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("sorry no details availabe");
        }


    }
}
/*
Yes Aryan — both are creating Integer objects, but there’s a small difference in how Java creates them internally.

Your code:

Integer id1 = Integer.valueOf(101);
Integer id2 = Integer.valueOf(102);

Integer id3 = 19;

At the end, all are Integer wrapper objects.

But:

Integer id3 = 19;

is actually converted by Java compiler into:

Integer id3 = Integer.valueOf(19);

This feature is called Autoboxing.

So internally:

Integer id3 = 19;

becomes:

Integer id3 = Integer.valueOf(19);

That means both are almost the same in modern Java.

Then why does Integer.valueOf() exist?

Because before Java introduced autoboxing, developers had to manually create wrapper objects.

Old style:

Integer x = Integer.valueOf(10);

Modern style:

Integer x = 10;

Java automatically boxes primitive int into Integer.

Which one is preferred?

Normally:

Integer x = 10;

is preferred because it is:

cleaner
shorter
more readable
Important Internal Difference

There are 3 ways people create Integer:

1. Preferred — Autoboxing
Integer x = 10;

Internally:

Integer.valueOf(10)

Uses Integer cache.

2. Explicit valueOf()
Integer x = Integer.valueOf(10);

Also uses Integer cache.

Efficient.

3. Avoid — new Integer()
Integer x = new Integer(10);

Always creates a new object.

No caching.

Slower and wasteful.

Deprecated in newer Java versions.

Integer Cache Concept

Java caches integers from:

-128 to 127

So:

Integer a = 100;
Integer b = 100;

System.out.println(a == b);

Output:

true

Because both point to same cached object.

But:

Integer a = 200;
Integer b = 200;

System.out.println(a == b);

Output:

false

Because outside cache range.

Visualization
Cached value
Integer a = 10;
Integer b = 10;

Memory:

Integer Cache
   |
   ---> [10 Object]
           ↑    ↑
           a    b
Non-cached value
Integer a = 200;
Integer b = 200;

Memory:

a ---> [200 Object]
b ---> [200 Object]

Different objects.

Real Interview Point

Whenever comparing wrapper objects:

❌ Wrong:

a == b

✅ Correct:

a.equals(b)

Because:

== checks reference
equals() checks value
Final Conclusion

These two are effectively same:

Integer x = 10;
Integer x = Integer.valueOf(10);

because autoboxing internally calls:

Integer.valueOf()

But this is bad:

new Integer(10)

because it creates unnecessary objects.

So in real projects and modern Java:

✅ Mostly preferred:

Integer x = 10;

or sometimes explicitly:

Integer.valueOf()

when you want to show intent clearly.
 */