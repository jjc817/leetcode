package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _139wordBreak {
    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.add("leet");
        word.add("code");
        System.out.println(MySolution.wordBreak("leetcode", word));
    }
    static class MySolution {
        public static boolean wordBreak(String s, List<String> wordDict) {
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
            return dp[dp.length - 1];
        }
    }
}
