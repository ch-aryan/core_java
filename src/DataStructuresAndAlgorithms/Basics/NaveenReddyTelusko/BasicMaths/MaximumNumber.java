package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class MaximumNumber {
    public static void main(String[] args) {
        int n1 = 14, n2 =88 , n3 =100;
        if(n1 > n2 && n1 > n3){
            System.out.println(n1 + "is greater");
        }else if(n2 > n1 && n2 > n3){
            System.out.println("n2 is greater");
        }else {
            System.out.println(n3+ "is greater");
        }
    }
}
