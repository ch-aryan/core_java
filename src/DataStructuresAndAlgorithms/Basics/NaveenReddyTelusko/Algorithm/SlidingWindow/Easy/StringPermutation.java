package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Easy;
/*
Check if Permutation of Pattern is Substring
Last Updated : 23 Jul, 2025
Given two strings txt and pat having lowercase letters, the task is to check if any permutation of pat is a substring of txt.

Examples:

Input: txt = "geeks", pat = "eke"
Output: true
Explanation: "eek" is a permutation of "eke" which exists in "geeks".

Input: txt = "programming", pat = "rain"
Output: false
Explanation: No permutation of "rain" exists as a substring in "programming".
 */
public class StringPermutation {
    //bruteForce solution.
    public static boolean isPermutation(String txt, String pat , int Startidx){
        int [] freq = new int[26];
        for(int i=0;i<pat.length();i++){
            freq[txt.charAt(Startidx+i)-'a']++;
            freq[pat.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static boolean subString(String txt, String pat){
        int n = txt.length();
        int m = pat.length();
        for(int i=0;i<n-m+1 ; i++){
           if( isPermutation(txt,pat, i)){
               return true;
           }
        }
        return false;
    }
    public static void main(String[] args) {
        String txt = "geeks";
        String pat = "eke";
       boolean res =  subString(txt, pat);
        System.out.println(res);
    }
}
/*
[Naive Approach] Checking all possible substrings
The idea is to iterate over all possible substrings of txt having the same length as pat.
For each substring of txt, check if pat is a permutation of the substring.
Two strings are said to be permutations of each other if they contain the same characters with the
same frequencies, but possibly in a different order. So, we can match the frequency of each character in
both the strings to check if they are permutations of each other or not.





 */