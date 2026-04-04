package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

import java.util.Scanner;

public class ValidTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter triangle angles");
        int a1, a2 , a3;
        a1 = in.nextInt();
        a2 = in.nextInt();
        a3 = in.nextInt();
        if(a1 + a2 + a3 == 180 && a1>0 && a2 >0 && a3 > 0){
            System.out.println("traingle is formed");
        }else{
            System.out.println("NOt a traingle");
        }
    }
}
