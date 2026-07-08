package com.javabasics;

public class ValidationRules {
    public static void main(String[] args) {
        String userName = "Aryan_1408";

        if (userName.length() >= 5 && userName.length() <= 20) {
            for (char ch : userName.toCharArray()) {
                if (!(Character.isLetter(ch) || Character.isDigit(ch) || ch == '_')) {
                    System.out.println("invalid");
                }
            }
        } else {
            System.out.println("length is exceeded");
        }

//understanding the regix. part 1.
        String regex = "abc"; //means match the exact "abc"
        System.out.println("abc".matches(regex));
        System.out.println("abcd".matches(regex));
        System.out.println("ab".matches(regex));
        System.out.println("*****************");
        //part 2.
        String regex1 = "a.c"; //means match any one character.
        System.out.println("abc".matches(regex1));
        System.out.println("a%c".matches("a.c"));
        System.out.println("ab".matches(regex1));
        System.out.println(regex1.matches("abcdef"));
    }
}
//using regex.
/*
About String.matches()
You found this:
username.matches(...)
This is a good thing to learn.
But here's a question.
Do you know what a regular expression (Regex) is?
If not, don't jump into writing complex patterns yet.
Start with simple validation first.
For example, ask yourself:
Is the username empty?
Does it contain spaces?
Is it too short?
Is it too long?

Once you're comfortable with those checks, then learn regex as a more compact way to express multiple rules.
 */