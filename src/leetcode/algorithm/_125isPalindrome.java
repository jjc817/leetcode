package leetcode.algorithm;


public class _125isPalindrome {
    public static void main(String[] args) {
        System.out.println(MySolution.isPalindrome(" 123A man, a plan, a canal: Panama"));
    }

    static class MySolution {
        static public boolean isPalindrome(String s) {
            int st = 0;
            while (st < s.length() && !isLetter(s.charAt(st))) {
                st++;
            }
            s = s.substring(st,s.length());
            for (int i = 1; i < s.length(); i++) {
                if (!isLetter(s.charAt(i))) {
                    s = s.substring(0,i).concat(s.substring(i + 1,s.length()));
                    i--;
                }
                if (isUpper(s.charAt(i))){
                    s = s.replace(s.charAt(i), (char) (s.charAt(i) +32));
                }
            }
            int l = 0, r = s.length() - 1;
            while (l < r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
        static public boolean isUpper(char c){
            return c >= 'A' && c <= 'Z';
        }
        static public boolean isLower(char c){
            return c >= 'a' && c <= 'z';
        }
        static public boolean isLetter(char c){
            return isLower(c) || isUpper(c);
        }
    }
    class Solution {
        public boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }

}
