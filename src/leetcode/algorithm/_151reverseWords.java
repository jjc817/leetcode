package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151reverseWords {
    public static void main(String[] args) {
        System.out.println(MySolution.reverseWords("the sky is blue "));
    }
   static class MySolution {
        public static String reverseWords(String s) {
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' '){
                    s = reverse(s, start, i - 1);
                    start = i + 1;
                }
            }
            return reverse(s, 0, s.length() - 1);
        }
        public static String reverse(String s,int start,int end){
            StringBuilder sb = new StringBuilder(s);
            while (start <= end){
                char c1 = s.charAt(start);
                char c2 = s.charAt(end);
                sb.replace(start,start + 1, String.valueOf(c2));
                sb.replace(end,end + 1, String.valueOf(c1));
                start++;
                end--;
            }
            String s1 = new String(sb);
            return s1;
        }
    }
}
