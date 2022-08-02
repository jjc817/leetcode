package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        System.out.println(MySolution.subsets(new int[]{1, 2, 3,}));
    }
    static class MySolution {
        static List<List<Integer>> res = new ArrayList<>();
        public static List<List<Integer>> subsets(int[] nums) {
            backtrack(new ArrayList<>(),nums, nums.length,0);
            return res;
        }
        public static void backtrack(List<Integer> path,int[] nums,int len,int i) {
            if (i == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[i]);
            backtrack(path, nums, len, i + 1);
            path.remove(path.size() - 1);
            backtrack(path, nums, len, i + 1);
        }
    }
   static class Solution {
        static List<Integer> t = new ArrayList<Integer>();
        static List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public static List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        static public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }
}
