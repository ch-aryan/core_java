package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SelectMinimumSubArraySum {
    public static int selectMin(int [] arr){
     int n = arr.length;
        Deque<Integer> stackPre = new ArrayDeque<>();
        Deque<Integer> stackNex = new ArrayDeque<>();
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int total = 0;
        for(int i =0 ; i<arr.length ; i++){
            while(!stackPre.isEmpty() && arr[stackPre.peek() ] >= arr[i]){
                stackPre.pop();
            }
            left[i] = stackPre.isEmpty() ? (i+1) : i- stackPre.peek() ;

            stackPre.push(i);
        }

        for(int i =n-1; i>=0; i--){
            while(!stackNex.isEmpty() && arr[stackNex.peek()] >= arr[i] ){
                stackNex.pop();
            }
            right[i] = stackNex.isEmpty() ? (n-i) : (stackNex.peek() - i);
            stackNex.push(i);
        }

        for(int i =0; i< n ; i++){
            total += arr[i] * left[i] * right[i];
        }
        return total;


    }


    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        for(int i =0; i<arr.length; i++){
            System.out.println("subArrays single" + arr[i]);
            for(int j = i; j<arr.length; j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
            System.out.println("hello");
        }
    }
}
