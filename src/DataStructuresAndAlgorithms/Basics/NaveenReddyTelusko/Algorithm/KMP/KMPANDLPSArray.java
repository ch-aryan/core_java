package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.KMP;
/*
Longest prefix which is also suffix
Last Updated : 25 Jul, 2025
Given a string s, find the length of the longest proper prefix which is also a suffix. A proper prefix is a prefix that doesn’t include whole string. For example, prefixes of "abc" are "", "a", "ab" and "abc" but proper prefixes are "", "a" and "ab" only.

Examples:

Input: s = "aabcdaabc"
Output: 4
Explanation: The string "aabc" is the longest proper prefix which is also the suffix.

Input: s = "ababab"
Output: 4
Explanation: The string "abab" is the longest proper prefix which is also the suffix.

Input: s = "aaaa"
Output: 3
Explanation: The string "aaa" is the longest proper prefix which is also the suffix.
 */
public class KMPANDLPSArray {
    public static int[] buildLpsBrute(String str){
        int n = str.length();

        int lps[] = new int[n];
        for(int i =1; i<n;i++){
            int suff = n-i;
            for(int k=0;k<i;k++){
                if(str.charAt(k) == str.charAt(suff+k)){
                    lps[suff+k] = k+1;
                }else {
                    lps[suff+k] = 0;
                    break;
                }
            }
        }
        return lps;
    }
    public static int[] buildLPSKMP(String str){
        int n = str.length();
        int [] lps = new int[n];
        int i = 0;
        int j = 1;
        while(j< n){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                lps[j] = i;
                j++;
            }else {
                if(i> 0){
                    i = lps[i-1];
                }else{
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String str = "aaabcdef";
        int [] temp = buildLpsBrute(str);
        for (int i : buildLPSKMP(str)) {
            System.out.print(i+" ");
        }
        System.out.println("************");
        for(int i : temp){
            System.out.print(i+" ");
        }
    }
}
/*
[Expected approach] Using LPS of KMP Algorithm
The idea is to use the preprocessing step of the KMP (Knuth-Morris-Pratt) algorithm.
In this step, we construct an LPS (Longest Prefix Suffix) array, where each index i stores the length of
 the longest proper prefix of the substring str[0...i] that is also a suffix of the same substring.
 The value at the last index of the LPS array
represents the length of the longest proper prefix which is also a suffix for the entire string.
 */