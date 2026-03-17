package com.javabasics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Cricket{
int value() default 22;
String name() default "Aryan";
}
@Cricket()//valid
class Mama{

}
@Cricket(value = 1 ,name = "Aryan")//valid
public class Annotations {
    public static void main(String[] args) {
        System.out.println("Annotations are for what?");
    }
}
