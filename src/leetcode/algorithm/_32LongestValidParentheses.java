package leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _32LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(MySolution.longestValidParentheses(")()()))))))))(((((()))))))"));
    }
    static class MySolution {
        public static int longestValidParentheses(String s) {
            int maxans = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }

    static class Solution {
        public static int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }
    static class Solution2 {
        public static int longestValidParentheses(String s) {
            int left = 0, right = 0, maxlength = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * right);
                } else if (right > left) {
                    left = right = 0;
                }
            }
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxlength = Math.max(maxlength, 2 * left);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return maxlength;
        }
    }

}
