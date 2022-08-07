package leetcode.algorithm;

public class _121maxProfit {
    public static void main(String[] args) {
        System.out.println(MySolution.maxProfit(new int[]{2,6,4,1,3}));
        System.out.println(Solution.maxProfit(new int[]{2,6,4,1,3}));
    }
    static class MySolution {
        static public int maxProfit(int[] prices) {
            int i;
            int profit = 0;
            for (i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1])
                    break;
            }
            for (int j = i; j < prices.length - 1; j++) {
                for (int k = j + 1; k < prices.length; k++) {
                    profit = Math.max(prices[k] - prices[j],profit);
                }
            }
            return profit;
        }
    }
    static public class Solution {
        static public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }

}
