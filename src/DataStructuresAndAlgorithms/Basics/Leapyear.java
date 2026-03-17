package DataStructuresAndAlgorithms.Basics;

import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter year");
        int year = in.nextInt();
        if((year % 4 == 0) && (year % 100 != 0)|| year % 400 ==0){
            System.out.println("leap year");
        }else{
            System.out.println("not a leap year");
        }
    }
}
