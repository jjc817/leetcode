package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        int[] ints = {1,2,1,-4,-3,0};
        int target =1;
        System.out.println(MySolution.fourSum(ints, target));

    }
    static class MySolution {
        static public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int right = nums.length - 1;
                    int left = j + 1;
                    while (left<right){
                        int tar =nums[i]+nums[j]+nums[left]+nums[right];
                        if(tar==target){
                            quadruplets.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        }
                        if(tar>target)
                            right--;
                        else
                            left++;
                    }
                }
            }

            return quadruplets;
        }
    }
}
