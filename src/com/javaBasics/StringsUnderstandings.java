package com.javabasics;

public class StringsUnderstandings {
    public static void main(String[] args) {
        String s1 = "Aryan";
        String s2 = "Aryan";
        String s3 = new String("Aryan");
        String s4 = new String("Aryan");
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.compareTo(s2));
//        System.out.println(s1.equalsIgnoreCase(s2));
//        System.out.printf("***********");
//        System.out.println(s3==s4);
//        System.out.println(s3.equals(s4));
//        System.out.println(s3.compareTo(s4));
//        System.out.println(s3.equalsIgnoreCase(s4));
//        System.out.println("************8");
//        System.out.println(s1.equals(s3)+ "one is literal and another is string new object");
//        System.out.println(s1==s3 + " with == sign");
//        System.out.println(s1.compareTo(s3)+" compare to");


        String a = "java";
        String b = a;
        a = "python";
        System.out.println(a);
        System.out.println(b);


        String a1 = new String("hello");
        String b1 = a1;
        a1 = "world";
        System.out.println(a1);
        System.out.println(b1);


        int [] arr = {1};
        int [] barr = arr;
        arr[0] = 2;
        System.out.println(arr[0]);
        System.out.println(barr[0]);

        int z = 1;
        int y = z;
        z = 2;
        System.out.println(z);
        System.out.println(y);

    }
}
