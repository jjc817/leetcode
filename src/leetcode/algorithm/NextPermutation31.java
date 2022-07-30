package leetcode.algorithm;
//方法一：两遍扫描
//思路及解法
//
//注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。
// 我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
//
//我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
//
//同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。
// 当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

public class NextPermutation31 {
    public static void main(String[] args) {
        int[] ints = new int[]{4,5,2,3,6,1};
        MySolution.nextPermutation(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }
    static class MySolution {
        static public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}
