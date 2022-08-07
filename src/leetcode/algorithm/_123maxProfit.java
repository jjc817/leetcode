package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class _123maxProfit {
    public static void main(String[] args) {
        System.out.println(MySolution.maxProfit(new int[]{1,2,3,5,5,9,1,7,4}));

    }
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int buy1 = -prices[0], sell1 = 0;
            int buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < n; ++i) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }


    static class MySolution {
        static public int maxProfit(int[] prices) {
            int[][] dp = new int[2][prices.length + 1];
            dp[0][0] = 0;
            dp[1][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[0][i] = Math.max(dp[0][i - 1],dp[1][i - 1] + prices[i]);
                dp[1][i] = Math.max(dp[1][i - 1],dp[0][i - 1] - prices[i]);
            }
            int p = 0;
            int profit = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < dp[1].length; i++) {
                if (dp[1][i] != dp[1][p]){
                    profit = dp[0][i - 1] - dp[0][p];
                    list.add(profit);
                    p = i;
                }
            }
            while (list.size() > 2){
                Integer integer = list.stream().min(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }).get();
                list.remove(integer);
            }

            return list.stream().mapToInt(o1->Integer.parseInt(String.valueOf(o1))).sum();
        }
    }
}
