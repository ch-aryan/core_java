package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class UsingBackTrack {
    public static void backTracking(int n){
        if(n<1){
            return;
        }
        backTracking(n-1);
        System.out.print(n+" ");
    }

    public static void backTracking1(int n){
        if(n>10){
            return;
        }
        backTracking1(n+1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        backTracking(10);
        System.out.println("*******");
        backTracking1(1);
    }
}
