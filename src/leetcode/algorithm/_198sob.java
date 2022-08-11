package leetcode.algorithm;

public class _198sob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + nums[i];
        }
        return Math.max(dp[0][nums.length - 1],dp[1][nums.length - 1]);
    }
    public static int rob2(int[] nums) {

        int n = 0;//不偷
        int y = nums[0];//偷
        for (int i = 1; i < nums.length; i++) {
            int temp = n;
            n = y;
            y = temp + nums[i];
        }
        return Math.max(n,y);
    }
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
