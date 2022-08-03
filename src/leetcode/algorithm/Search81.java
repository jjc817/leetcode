package leetcode.algorithm;

public class Search81 {
    public static void main(String[] args) {
        System.out.println(MySolution.search(new int[]{4, 5, 6, 1, 2, 3}, 5));
    }
    static class MySolution {
        public static boolean search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return nums[0] == target;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                    ++l;
                    --r;
                } else if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
