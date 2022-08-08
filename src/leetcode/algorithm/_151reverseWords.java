package leetcode.algorithm;

import java.util.*;

public class _151reverseWords {
    public static void main(String[] args) {
        System.out.println(_151reverseWords.MySolution.reverseWords("the sky is blue"));
    }
   static class MySolution {
        public static String reverseWords(String s) {
            StringBuilder sb = new StringBuilder(s);
            if (s.charAt(s.length() - 1) != ' ')
                sb.append(' ');
            int start = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' '){
                    reverse(sb, start, i - 1);
                    start = i + 1;
                }
            }
            return new String(reverse(sb, 0, s.length() - 1));
        }
        public static StringBuilder reverse(StringBuilder s,int start,int end){
            while (start <= end){
                char c = s.charAt(start);
                s.setCharAt(start++, s.charAt(end));
                s.setCharAt(end--, c);
            }
            return s;
        }
       class Solution {
           public String reverseWords(String s) {
               // 除去开头和末尾的空白字符
               s = s.trim();
               // 正则匹配连续的空白字符作为分隔符分割
               List<String> wordList = Arrays.asList(s.split("\\s+"));
               Collections.reverse(wordList);
               return String.join(" ", wordList);
           }
       }
       class Solution2 {
           public String reverseWords(String s) {
               int left = 0, right = s.length() - 1;
               // 去掉字符串开头的空白字符
               while (left <= right && s.charAt(left) == ' ') {
                   ++left;
               }

               // 去掉字符串末尾的空白字符
               while (left <= right && s.charAt(right) == ' ') {
                   --right;
               }

               Deque<String> d = new ArrayDeque<String>();
               StringBuilder word = new StringBuilder();

               while (left <= right) {
                   char c = s.charAt(left);
                   if ((word.length() != 0) && (c == ' ')) {
                       // 将单词 push 到队列的头部
                       d.offerFirst(word.toString());
                       word.setLength(0);
                   } else if (c != ' ') {
                       word.append(c);
                   }
                   ++left;
               }
               d.offerFirst(word.toString());

               return String.join(" ", d);
           }
       }

    }
}
