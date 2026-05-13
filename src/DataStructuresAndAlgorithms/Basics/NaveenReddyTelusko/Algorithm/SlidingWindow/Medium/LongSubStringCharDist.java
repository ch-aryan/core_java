package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm.SlidingWindow.Medium;
/*
Longest Substring Without Repeating Characters
Last Updated : 20 Jan, 2026
Given a string s having lowercase characters, find the length of the longest substring without repeating characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef".
 */
public class LongSubStringCharDist {
    public static int bruteForce(String str){
        int n = str.length();
        int maxCount = 1;

        for(int i=0;i<n;i++){
            int count = 0;
            boolean visited[] = new boolean[26];
            for(int j=i; j<n;j++){
               if(visited[str.charAt(j)-'a'] == false){
                   count++;
               }
               visited[str.charAt(j)-'a'] = true;


            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
    public static int slidingWindow(String str){
        int n = str.length();
        int maxCount  = 1;
        int i =0;
        int freq[] = new int[256];
        for(int j=0; j<n;j++){
        char ch = str.charAt(j);
            freq[ch]++;
            while(freq[ch] > 1){
                freq[str.charAt(i)]--;
                i++;
            }
          int currentLen = j-i+1;
            maxCount = Math.max(currentLen, maxCount);

        }
        return maxCount;
    }

    public static int usingLastIndex(String str){
        int n = str.length();
        int []lstIdx = new int[26];
        int res = 0;
        for(int i=0;i< lstIdx.length ; i++){
            lstIdx[i] = -1;
        }

        int start = 0;
        for(int end = 0; end < n ; end++){
            start = Math.max(start, lstIdx[str.charAt(end)-'a']+1);
            res = Math.max(res, end - start +1);
            lstIdx[str.charAt(end)-'a'] = end;
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String s1 = "abcdefabcbb";
        System.out.println( bruteForce(s));
        System.out.println(bruteForce(s1));
        System.out.println(bruteForce("aaa"));

        System.out.println(slidingWindow(s));
        System.out.println(slidingWindow(s1));
        System.out.println(slidingWindow("aaa"));


        System.out.println(usingLastIndex(s));
        System.out.println(usingLastIndex("aaa"));
    }
}
/*
[Naive Approach] Substrings Starting From Every Index - O(n^2) Time and O(1) Space
The idea is to find length of longest substring with distinct characters starting
from every index and maximum of all such lengths will be our answer.
To find the length of the longest substring with distinct characters starting from an index,
 we create a new visited array of size = 26 to keep track of included characters in the substring.
vis[0] checks for 'a', vis[1] checks for 'b', vis[2] checks for 'c' and so on.
class GfG {

    static int longestUniqueSubstr(String s){
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {

            // Initializing all characters as not visited
            boolean[] vis = new boolean[26];

            for (int j = i; j < n; j++) {

                // If current character is visited
                // Break the loop
                if (vis[s.charAt(j) - 'a'] == true)
                    break;

                // Else update the result if this window is
                // larger, and mark current character as
                // visited.
                else {
                    res = Math.max(res, j - i + 1);
                    vis[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}
 */
/*
slidingWindow technique
[Expected Approach 1] Using Sliding Window - O(n) Time and O(1) Space
The idea is to maintain a window of distinct characters. The window is initialized as single character. We keep extending the window on the right side till we see distinct characters. When we see a repeating character, we remove characters from the left side of the window. We keep track of the maximum length window.

Below are the detailed steps:

Initialize two pointers left and right with 0, which define the current window being considered.
The right pointer moves from left to right, extending the current window.
If the character at right pointer is not visited, it's marked as visited.
If the character at right pointer is visited, it means there is a repeating character. The left pointer moves to the right while marking visited characters as false until the repeating character is no longer part of the current window.
The length of the current window (right - left + 1) is calculated and answer is updated accordingly.
class GfG {

    static int longestUniqueSubstr(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();

        int res = 0;
        boolean[] vis = new boolean[26];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating
            // character is no longer part of the current window
            while (vis[s.charAt(right) - 'a'] == true) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}
 */
/*
another appraoch.
[Expected Approach 2] Using Last Index of Each Character - O(n) Time and O(1) Space
The approach stores the last indexes of already visited characters. The idea is to maintain a window of distinct characters. Start from the first character, and keep extending the window on the right side till we see distinct characters. When we see a repeating character, we check for the last index of the repeated character:

If last index of repeated character >= starting index of the current window, then we update the starting index of the current window to last index of repeated character + 1 to remove the repeated character.
If last index of repeated character < starting index of the current window, then it means that the repeated character is already outside the current window so the window size remains unchanged.
After iterating over all the characters, the largest window size will be our answer.
 */