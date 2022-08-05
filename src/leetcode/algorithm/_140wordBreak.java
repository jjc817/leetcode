package leetcode.algorithm;

import java.util.*;

public class _140wordBreak {
    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.add("leet");
        word.add("code");
        System.out.println(MySolution.wordBreak("leetcode", word));
    }
    static class MySolution {
        public static List<String> wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] =true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            List<String> word = new ArrayList<>();
            int start = 0;
            for (int i = 1; i < dp.length; i++) {
                if (dp[i]){
                    word.add(s.substring(start,i));
                    start = i;
                }
            }
            return word;
        }
    }
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
            List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
            List<String> breakList = new LinkedList<String>();
            for (List<String> wordBreak : wordBreaks) {
                breakList.add(String.join(" ", wordBreak));
            }
            return breakList;
        }

        public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
            if (!map.containsKey(index)) {
                List<List<String>> wordBreaks = new LinkedList<List<String>>();
                if (index == length) {
                    wordBreaks.add(new LinkedList<String>());
                }
                for (int i = index + 1; i <= length; i++) {
                    String word = s.substring(index, i);
                    if (wordSet.contains(word)) {
                        List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                        for (List<String> nextWordBreak : nextWordBreaks) {
                            LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                            wordBreak.offerFirst(word);
                            wordBreaks.add(wordBreak);
                        }
                    }
                }
                map.put(index, wordBreaks);
            }
            return map.get(index);
        }
    }

}
