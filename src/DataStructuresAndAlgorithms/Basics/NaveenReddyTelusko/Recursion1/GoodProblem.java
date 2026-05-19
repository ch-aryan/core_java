package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Recursion1;

public class GoodProblem {
    public static int maxSum(int n ){
        if(n==0){
            return 0;
        }

        int totatSum = maxSum(n/2) + maxSum(n/3) + maxSum(n/4);
        return Math.max(totatSum,n);
    }

    public static void main(String[] args) {
        System.out.println(maxSum(12));
    }

}
/*
Maximum Sum Problem
Difficulty: EasyAccuracy: 57.09%Submissions: 60K+Points: 2
Given a number n, find its maximum sum value with 3 recursive breaks described below.

Break into three parts n/2, n/3, and n/4 (consider only the integer part or floor value).
Each number obtained in this process can be divided further recursively.
At every step,  we can take the max of current value of n or the max value obtained with recursive process.
It is possible that we don't divide the number at all and choose it as final answer.
Examples:

Input: n = 12
Output: 13
Explanation: Break n = 12 in three parts [12/2, 12/3, 12/4] = [6, 4, 3], now current sum is = (6 + 4 + 3) = 13. Further breaking 6, 4 and 3 into parts will produce sum less than or equal to 6, 4 and 3 respectively.
Input: n = 24
Output: 27
Explanation: Break n = 24 in three parts [24/2, 24/3, 24/4] = [12, 8, 6],
 now current sum is = (12 + 8 + 6) = 26 . But recursively breaking 12 would produce value 13.
 So our maximum sum is 13 + 8 + 6 = 27.
 Recursion Tree for maxSum(12)

Each call does:

maxSum(n) = max(n, maxSum(n/2) + maxSum(n/3) + maxSum(n/4))

So:

maxSum(12)
= max(12, maxSum(6) + maxSum(4) + maxSum(3))
Full Recursion Tree
maxSum(12)
├── maxSum(6)
│   ├── maxSum(3)
│   │   ├── maxSum(1)
│   │   │   ├── maxSum(0)
│   │   │   ├── maxSum(0)
│   │   │   └── maxSum(0)
│   │   │   => max(1, 0+0+0) = 1
│   │   ├── maxSum(1) = 1
│   │   └── maxSum(0) = 0
│   │   => max(3, 1+1+0) = 3
│   ├── maxSum(2)
│   │   ├── maxSum(1) = 1
│   │   ├── maxSum(0) = 0
│   │   └── maxSum(0) = 0
│   │   => max(2, 1+0+0) = 2
│   └── maxSum(1) = 1
│   => max(6, 3+2+1) = 6
│
├── maxSum(4)
│   ├── maxSum(2) = 2
│   ├── maxSum(1) = 1
│   └── maxSum(1) = 1
│   => max(4, 2+1+1) = 4
│
└── maxSum(3) = 3

=> max(12, 6 + 4 + 3)
=> max(12, 13)
=> 13
 */