package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class FactorsN {
    public static void recursionFact(int n, int i) {
    if(i>(int)Math.sqrt(n)) return;

    if(n%i ==0){
    if(i != n/i){
        System.out.println(n/i);
    }
        System.out.println(i);
    }
    recursionFact(n, i+1);

    }
    public static void main(String[] args) {
recursionFact(48,1);
    }
}
