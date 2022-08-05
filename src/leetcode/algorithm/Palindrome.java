package leetcode.algorithm;

public class Palindrome {
    public static boolean check(String s){
        int l = 0,r = s.length() - 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
