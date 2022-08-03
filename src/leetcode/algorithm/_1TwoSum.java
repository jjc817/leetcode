package leetcode.algorithm;

import java.util.Arrays;

public class _1TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 4}, 7);
        Arrays.stream(ints).forEach(i->{

            System.out.println(i);
        });
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }
}
