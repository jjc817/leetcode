package leetcode.algorithm;

public class _152maxProduct {
    public static void main(String[] args) {
        System.out.println(MySolution.maxProduct(new int[]{-2,-3,0,2,1,-4,5,-6}));
    }
    static class MySolution {
        static public int maxProduct(int[] nums) {
            int dp[] = new int[nums.length];
            int dp2[] = new int[nums.length];
            dp[0] = nums[0];
            dp2[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] * nums[i], Math.max(dp2[i - 1] * nums[i],nums[i]));
                dp2[i] = Math.min(dp[i - 1] * nums[i],Math.min(dp2[i - 1] * nums[i],nums[i]));
                max = Math.max(max,Math.max(dp[i],dp2[i]));
            }
            return max;
        }
    }

    class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] maxF = new int[length];
            int[] minF = new int[length];
            System.arraycopy(nums, 0, maxF, 0, length);
            System.arraycopy(nums, 0, minF, 0, length);
            for (int i = 1; i < length; ++i) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            }
            int ans = maxF[0];
            for (int i = 1; i < length; ++i) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }

    class Solution2 {
        public int maxProduct(int[] nums) {
            int maxF = nums[0], minF = nums[0], ans = nums[0];
            int length = nums.length;
            for (int i = 1; i < length; ++i) {
                int mx = maxF, mn = minF;
                maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
                minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
                ans = Math.max(maxF, ans);
            }
            return ans;
        }
    }

}
