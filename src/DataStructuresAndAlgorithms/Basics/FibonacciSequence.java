package DataStructuresAndAlgorithms.Basics;

import java.util.ArrayList;

class Fibonacci{
    ArrayList<Integer> arrayList = new ArrayList<>();

    public int  meth(int n ){

        int n1 =0 , n2 = 1;
        arrayList.add(0);
        arrayList.add(1);
        for(int i =2;i<=n;i++){

            int sum = n1 + n2;


          arrayList.add(i,sum);
            n1 = n2 ;
            n2 = sum;
        }
        System.out.println(arrayList);
        return arrayList.get(n);
    }
    public int returnFibNumber(int n){
      int result =   meth(n);
        System.out.println();
      return result;
    }
}// 0 + 1 = 1 -> 2 -> 3 -> 5 -> 8 -> 13
public class FibonacciSequence {
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        System.out.println(  obj.returnFibNumber(10));


    }
}
