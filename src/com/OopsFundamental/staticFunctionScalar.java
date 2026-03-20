package com.OopsFundamental;

public class staticFunctionScalar {
    public static int methStatic(int n){
        n = n + 100;
        System.out.println("methStatic "+ n);
        return n;
    }

    public static void main(String[] args) {
        int n = 100;
        int i = methStatic(100);
        System.out.println(i);
        System.out.println(n);
    }
}
