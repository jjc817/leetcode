package leetcode.algorithm;

public class _153findMin {
    public static void main(String[] args) {
        System.out.println(MySolution.findMin(new int[]{2,3,4,5,6,7,1}));
    }
    static class MySolution {
        public static int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (true){
                int mid = (left + right) >> 1;
                if (nums[left] <= nums[right])
                    return nums[left];
                if (nums[left] < nums[mid]){
                    left = mid + 1;
                }else
                    left++;
            }
        }
    }
    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else {
                    low = pivot + 1;
                }
            }
            return nums[low];
        }
    }
}
