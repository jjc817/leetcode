package leetcode.algorithm;

import java.util.Arrays;

public class _16ThreeSumClosest {
    public static void main(String[] args) {
        int[] ints = {1,2,1,-4};
        int target =1;
        int i = MySolution.threeSumClosest(ints, target);
        System.out.println(i);
    }
    static class MySolution {
        static public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int best=Math.abs(target -(nums[0]+nums[1]+nums[2]));
            for (int i = 0; i < nums.length; i++) {
                int right = nums.length - 1;

                int left = i+1;
                while (left<right){
                    int tar = nums[left] + nums[right] + nums[i];
                    int gap = Math.abs(target -tar);
                    if(gap == 0)
                        return target;
                    if(gap<best)
                        best = gap;
                    if(tar>target)
                        right--;
                    else
                        left++;
                }
            }

            return best;
        }
    }
}
