package com.OopsFundamental.Collections.Iterator;

import java.util.ArrayList;

public class TypeSafety {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for(int i =0 ; i<arr.length;i++){
            arr[i] = i+1;
        }
       for(int i =0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
        System.out.println("************");
       //samme for strings, char, long and etc for arrays.
        ArrayList al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add("hello");

//       for(int i =0;i<al.size();i++){
//           System.out.println("i"); // this is dangerous
//           al.add(i, i+1);// can lead to make the memory full . because of concurrent modification.
//       }
        System.out.println(al);
        for(int i =0;i<al.size();i++){
            System.out.println(al.get(3));
        } //ok fine what if you think all the data is of only one type.


        Integer obj1 = (Integer) al.get(2);
//        Integer obj = (Integer) al.get(3);//exception class caste excpetion thought integer but came strings.

//        System.out.println(obj1);
//        System.out.println(obj);

        for(int i = 0; i<al.size();i++){
            Integer obj3 = (Integer) al.get(i);
            System.out.println(obj3);
        }


    }
}
