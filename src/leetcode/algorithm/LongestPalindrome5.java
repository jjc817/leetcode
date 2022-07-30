package leetcode.algorithm;

public class LongestPalindrome5 {
    public static void main(String[] args) {
        String s = Solution.longestPalindrome("dasabcdcbafas");
        System.out.println(s);
    }

    static class MySolution {
        public static String longestPalindrome(String s) {
            int max = 0;
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                int left = i;
                int right = i;
                int len = 0;
                while(s.charAt(left) == s.charAt(right) && left>0 && right < s.length()-1){
                    left--;
                    right++;
                    len ++;
                }
                if(len>max){
                    max = len;
                    index = i;
                }
            }
           String substring = s.substring(index - max,index + max +1);
           return substring;
        }
    }
    static class Solution {
        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public static int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }

}
