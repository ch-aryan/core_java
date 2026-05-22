package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;


    class Alpha2 {
        public void meth1()  {
            try {
                System.out.println("Alpha connection Established");
                Scanner in = new Scanner(System.in);
                System.out.println("Enter numerator");
                int n = in.nextInt();
                System.out.println("enter denominator");
                int d = in.nextInt();
                int res = n / d;
                System.out.println(res);



            } catch (Exception e) {
                System.out.println("handled the exception in the alpha class only now way the exception" +
                        "will propagate to down the hierarchy except when i rethrow it ");
                throw  e;
            }
            finally {
                System.out.println("Alpha connection Terminated");
            }

        }
    }

        class Beta2 {
            public void dispBeta()  {
                System.out.println("Beta connection estabhished");
                Alpha2 a = new Alpha2();
                try {
                    a.meth1();
                }
             catch (Exception e) {
                System.out.println("exception occured is come when i got from alpha class " +
                        "while rethrowing it.");
            }
                System.out.println("Beta connection terminated");
            }


        }


        public class ClassVI {
            public static void main(String[] args) {
                System.out.println("Main connection established");
                Beta2 obj = new Beta2();

                    obj.dispBeta();

                System.out.println("main connected terminated");
            }
        }
