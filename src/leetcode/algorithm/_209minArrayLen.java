package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//不連續
public class _209minArrayLen {
    static int[] nums = new int[]{1,4,4};
    static List<Integer> path = new ArrayList<>();
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        System.out.println(minSubArrayLen(7, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        dfs(target,0);
        return res.size();
    }

    private static void dfs(int target,int i) {
        if (path.stream().mapToInt(Integer::intValue).sum() >= target){
            if (path.size() < res.size()){
                res = new ArrayList<>(path);
            }
            return;
        }
        if (i > nums.length - 1)
            return;
        path.add(nums[i]);
        dfs(target, i + 1);
        path.remove(path.size() - 1);
        dfs(target, i + 1);
    }

}
