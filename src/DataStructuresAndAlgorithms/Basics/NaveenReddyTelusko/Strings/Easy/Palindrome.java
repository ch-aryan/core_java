package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Strings.Easy;

public class Palindrome {
    public static Boolean checkPalindrome(String str){
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) == str.charAt(n-i-1)){
                continue;
            }else{
                return false; /*
                          for(int i = 0; i < n/2; i++){
                             if(str.charAt(i) != str.charAt(n - i - 1)){
                                 return false;
                                   }
                                    }
                                return true;*/
            }
        }
        return true;
    }
    //two pointer appraoch.
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "MADAM";
        String str1 = "abba";
      Boolean res =   checkPalindrome(str);
        System.out.println(res);
    }
}
