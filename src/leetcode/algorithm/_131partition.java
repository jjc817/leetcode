package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _131partition {
    public static void main(String[] args) {
        System.out.println(Solution.partition("aabb"));
    }

    static class Solution {
        static boolean[][] f;
        static List<List<String>> ret = new ArrayList<List<String>>();
        static List<String> ans = new ArrayList<String>();
        static int n;

        public static List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public static void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
//    static class MySolution {
//        static List<List<String>> res = new ArrayList<>();
//        static List<String> path = new ArrayList<>();
//        static public List<List<String>> partition(String s) {
//            String s1,s2;
//            for (int i = s.length(); i > 0; i--) {
//                s1 = s.substring(0,i);
//                s2 = s.substring(i,s.length());
//                backtrack(s1,s2,s);
//            }
//            int len = 0;
//            for (int i = 0; i < res.size(); i++) {
//                for (int j = 0; j < res.get(i).size(); j++) {
//                    len+=res.get(i).get(j).length();
//                }
//                if (len < s.length())
//                    res.remove(i);
//                len = 0;
//            }
//            return res;
//        }
//        public static void backtrack(String s1,String s2,String s){
//            if(Objects.equals(s1, "")){
//                res.add(new ArrayList<>(path));
//                path.clear();
//                return;
//            }
//            if (Palindrome.check(s1.toString())){
//                path.add(s1.toString());
//                s1 = s2;
//                s2 = "";
//                backtrack(s1,s2,s);
//            }
//            if (s1.length() + s2.length() < s.length()){
//                s = s1;
//                for (int i = s.length() - 1; i > 0; i--) {
//                    s1 = s.substring(0,i);
//                    s2 = s.substring(i,s.length());
//                    backtrack(s1,s2,s);
//                }
//            }
//        }
//    }
}
