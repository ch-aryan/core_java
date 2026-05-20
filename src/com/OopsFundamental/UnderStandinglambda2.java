package com.OopsFundamental;
interface hello{
    void method();
}
class world implements  hello{
    @Override
    public void method() {
        System.out.println("this is world class");
    }
}
public class UnderStandinglambda2 {
    public static void main(String[] args) {
        hello obj= new world();
        obj.method();

        hello obj1 = new hello() {
            @Override
            public void method() {
                System.out.println("this is annonoums inner class");
            }
        };
        obj1.method();

        hello obj2 = () -> {
            System.out.println("this is lambda expression");
        };
        obj2.method();
    }
}
