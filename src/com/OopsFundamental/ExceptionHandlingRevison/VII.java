package com.OopsFundamental.ExceptionHandlingRevison;
class A {



        public void methA () {
        methB();
    }
        public void methB () {
        methA();
        }
    }

public class VII {
    public static void main(String[] args) {
        A obj = new A();
        obj.methA();
    }
}
