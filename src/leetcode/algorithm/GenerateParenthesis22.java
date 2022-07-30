package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

// 括号生成
public class GenerateParenthesis22 {
    public static void main(String[] args) {
        List<String> strings = MySolution.generateParenthesis(3);
        System.out.println(strings);
    }
    static class MySolution {
        static public List<String> generateParenthesis(int n) {
            List<String> lists = new ArrayList<>();
            backtrack(lists,new StringBuilder(),0,0,n);
            return lists;
        }
        static public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
