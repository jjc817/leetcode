package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _78Subsets {
    public static void main(String[] args) {
         System.out.println(MySolution.subsets(new int[]{1, 2, 3,}));
    }
    static class MySolution {
        static List<List<Integer>> res = new ArrayList<>();
        static List<Integer> path = new ArrayList<>();
        public static List<List<Integer>> subsets(int[] nums) {
            dfs(nums,0);
            return res;
        }
        public static void dfs(int[] nums,int i) {
            if (i == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
            dfs(nums, i + 1);
        }
    }

}
