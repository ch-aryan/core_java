package com.OopsFundamental;
interface Parameters{
    int methPara(int x, int y);
}
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

        Parameters obj3 = (int x, int y) -> {
          return x + y;
        };
       int res =  obj3.methPara(10, 14);
        System.out.println(res);

        Parameters obj4 = ((x, y) -> x * y);
        System.out.println(obj4.methPara(10 , 4));
    }
}//lambda expressions only work with functional interface(means the interface with only one method).
