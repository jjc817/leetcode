package leetcode.algorithm;

public class _162findPeakElement {
    public static void main(String[] args) {
        System.out.println(MySolution.findPeakElement(new int[]{1,2,3,4,5}));
        System.out.println(Solution.findPeakElement(new int[]{1,2,3,4,5}));
    }
    //On
    static class MySolution {
        public static int findPeakElement(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1])
                    return i;
            }
            return nums.length - 1;
        }
    }
    //O(log n)
    static class Solution {
        public static int findPeakElement(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1, ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                    ans = mid;
                    break;
                }
                if (compare(nums, mid, mid + 1) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
        // 方便处理 nums[-1] 以及 nums[n] 的边界情况
        public static int[] get(int[] nums, int idx) {
            if (idx == -1 || idx == nums.length) {
                return new int[]{0, 0};
            }
            return new int[]{1, nums[idx]};
        }

        public static int compare(int[] nums, int idx1, int idx2) {
            int[] num1 = get(nums, idx1);
            int[] num2 = get(nums, idx2);
            if (num1[0] != num2[0]) {
                return num1[0] > num2[0] ? 1 : -1;
            }
            if (num1[1] == num2[1]) {
                return 0;
            }
            return num1[1] > num2[1] ? 1 : -1;
        }
    }

}
