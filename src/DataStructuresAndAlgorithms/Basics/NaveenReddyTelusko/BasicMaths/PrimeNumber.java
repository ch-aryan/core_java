package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;
class SclarPrimeWithRange{
    public static Boolean isPrimeNum(int n ){
        for(int i =2;i * i <= n ; i++){
            if(n % i == 0){
               return false;
            }
        }
        return true;
    }
    public static void PrintRange(int a, int b){
        for(int i = Math.max(2, a); i <= b ; i++){
            if(isPrimeNum(i)){
                System.out.print(i+" ");
            }
        }
    }
}
class ScalerPrime{
    public static Boolean isNumPrime(int n){
        for(int i = 2; i*i <= n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
class isPrime {


  Boolean prime = true;

    public Boolean methPrime(int n ) {
        if (n <= 1) {
        prime = false;
        }
        //prime number is a number which is div by 1 and itself.
        //so we know that if a number is 49 it is not prime because it is having
        //square of 1,7, 49 right. so 3 numbers so we are doing exactly like this
        //if we have 29 suppose the sqrt will be assume 5. then loop will run from two to 5
        //then we will able to find if a number is divisibe by i then it is not prime.
        for(int i =2;i<=Math.sqrt(n) ; i++){
            if(n% i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
}
public class PrimeNumber {
    //the number which is divisible by 1 and itself is called prime number
    public static void main(String[] args) {


        int n = 5;
        isPrime obj = new isPrime();
        System.out.println(  obj.methPrime(n));
        System.out.println("*******");

        int nn = 19;
        if(ScalerPrime.isNumPrime(nn)){
            System.out.println("is a prime number from scaler method");
        }else{
            System.out.println("not a chance to get a prime");
        }

        System.out.println("*******");

        SclarPrimeWithRange.PrintRange(1,100);

//        int count = 0;
////        if ((n % 1 == 0) && (n % n == 0)) {
////            System.out.println("prime number or");no wrong.
////        }
//        for(int i =1;i<=Math.sqrt(n);i++){
//            if(n % i == 0){
//                count ++;
//            }
//        }
//        if(count == 2){
//            System.out.println("prime number");
//        }else {
//            System.out.println("not a prime number");
//        }
    }
}