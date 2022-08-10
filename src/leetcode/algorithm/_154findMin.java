package leetcode.algorithm;

public class _154findMin {
    public static void main(String[] args) {
        System.out.println(MySolution.findMin(new int[]{2,2,2,2,3}));
        System.out.println(Solution.findMin(new int[]{2,2,2,2,3}));
    }
    static class MySolution {
        public static int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                int mid = (left + right) / 2;
                if (nums[mid] < nums[right]){
                    right = mid;
                }
                else if (nums[mid] > nums[right])
                    left = mid + 1;
                else {
                    if (nums[mid] > nums[left])
                        right = mid;
                    else
                        return nums[mid];
                }
            }
            return nums[left];
        }
    }
    static class Solution {
        public static int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else if (nums[pivot] > nums[high]) {
                    low = pivot + 1;
                } else {
                    high -= 1;
                }
            }
            return nums[low];
        }
    }
}
