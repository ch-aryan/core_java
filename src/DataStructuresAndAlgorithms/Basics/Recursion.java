package DataStructuresAndAlgorithms.Basics;
class NaturalNum{
    public static int natNum(int n) {
        if (n >= 1) {
            System.out.println(n);
            return natNum(n - 1);

        }
        return 0;
    }
}
class Factorial{
    public static int fact(int n){
        if(n!=0) {
            return n * fact(n - 1);
        }
        return 1;
    }

}
public class Recursion {
    public static void main(String[] args) {
       int res= Factorial.fact(5);
        System.out.println(res);

        int res1 = NaturalNum.natNum(10);
        System.out.print(res1 + " ");
    }
}
