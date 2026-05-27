package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;
/*
Wifi Range
Difficulty: EasyAccuracy: 51.63%Submissions: 41K+Points: 2
There are n rooms in a straight line in Geekland State University's hostel. You are given a binary
string s of length n, where s[i] = '1' means there is a WiFi router in the i-th room, and s[i] = '0'
means there is no WiFi in that room.

Each WiFi router has a range of x, meaning it can cover up to x rooms to its left and x rooms to its right.

Given x and s, determine whether all rooms are covered by at least one WiFi router.
Return true if all rooms are covered; otherwise, return false.

Examples:
Input: x = 0, s = "010"
Output: false
Explanation: Since the range is 0, so Wifi is only accessible in second room while 1st & 3rd
 room have no wifi. Therefore answer is false for this test case.
Input: x = 1, s = "10010"
Output: true
Explanation:
Index 0: WiFi is available.
Index 1: Since the range of the 0th index is 1, WiFi is available here.
Index 2: Since the range of the 3rd index is 1, WiFi is also available here.
Index 3: WiFi is available.
Index 4: The range of the 3rd index covers this position.
So, all the rooms have WiFi. Therefore, the answer is true for this test case.
 */
public class traverseLeftTraverseright {
    public static boolean wifiRange(String s, int x){
        int n = s.length();
        boolean[] cov = new boolean[n];
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='1'){
                int left = Math.max(0, i-x);
                int right = Math.min(n-1, x+i);

                for(int j=left ; j<=right;j++){
                    cov[j] = true;
                }
            }
        }
        for(boolean i:cov){
            if(i==false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "100100";
        int x = 2;
        boolean b = wifiRange(s, x);
        System.out.println(b);
        System.out.println(wifiRange("0001001000",2));

    }
}
