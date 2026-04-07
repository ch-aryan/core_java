package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class Factorial {
    public static int Factorials(int n){
        if(n==1){
            return 1;
        }
       int res =  n * Factorials(n-1);
        return res;
    }
    public static void main(String[] args) {
        System.out.println( Factorials(5));
    }
}
