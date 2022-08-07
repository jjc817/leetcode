package leetcode.algorithm;

public class _122maxProfit {
    public static void main(String[] args) {
        System.out.println(MySolution.maxProfit(new int[]{2,6,4,1,3}));

    }
    static class MySolution {
        static public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            }
            return dp[dp.length - 1][0];
        }
    }
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }
}
