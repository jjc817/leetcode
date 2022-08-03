package leetcode.algorithm;

public class _55CanJump {
    public static void main(String[] args) {
        System.out.println(MySolution.canJump(new int[]{2,2,1,1,4}));
    }
    static class MySolution {
        public static boolean canJump(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] + i >= nums.length - 1) {
                    if (i == 0) {
                        return true;
                    }
                    int j = 0;
                    while (j<i){
                        if(nums[j] + j >= i){
                            if (j == 0) {
                                return true;
                            }
                            i=j;
                            j=-1;
                        }
                        j++;
                    }
                }
            }
            return false;
        }
    }
    public class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
