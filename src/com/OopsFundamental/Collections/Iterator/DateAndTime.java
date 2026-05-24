package com.OopsFundamental.Collections.Iterator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {
        Date obj = new Date();
        System.out.println(obj);//this will return both time and date from util package it is.
        //this is depricated and not recommeneded to use. also sql data also not recommended.
        // then the solution is provided by joda api.
        //we cannot create the object of it by new . we should do by 'now' or 'of; //
     LocalDate date =    LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getYear());
        
        //if someone wants to enter there dob and time we have to use of method.
        LocalDate localDate = LocalDate.of(2003, 8, 14);
        System.out.println(localDate);

        //like local date we have local time.
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        LocalTime nowT = LocalTime.now();
        System.out.println(nowT);

    }
}
