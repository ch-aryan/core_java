package com.OopsFundamental;
enum Week{
    MON, TUE, WED, THU, FRI, SAT, SUN;
}
public class EnumsInJava {
    public static void main(String[] args) {
          Week week = Week.MON;
        System.out.println(week);

        System.out.println( Week.SUN.ordinal());

        Week [] weekAr = Week.values();

        for(Week i : weekAr){
            System.out.println(i);
        }
    }
}
