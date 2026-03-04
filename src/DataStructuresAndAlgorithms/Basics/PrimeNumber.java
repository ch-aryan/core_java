package DataStructuresAndAlgorithms.Basics;

public class PrimeNumber {
    //the number which is divisible by 1 and itself is called prime number
    public static void main(String[] args) {


        int n = 4;
        int count = 0;
//        if ((n % 1 == 0) && (n % n == 0)) {
//            System.out.println("prime number or");no wrong.
//        }
        for(int i =0;i<n;i++){
            if(n % (1+i) == 0){
                count ++;
            }
        }
        if(count == 2){
            System.out.println("prime number");
        }else {
            System.out.println("not a prime number");
        }
    }
}