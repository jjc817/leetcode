package leetcode.algorithm;


import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDup90 {
    public static void main(String[] args) {
        System.out.println(MySolution.subsetsWithDup(new int[]{1, 2, 2}));
    }
    static class MySolution {
        static List<List<Integer>> res = new ArrayList<>();
        static List<Integer> path = new ArrayList<>();
        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            dfs(0,nums);
            return res;
        }
        public static void dfs(int i,int[] nums){
            if(i == nums.length){
                if ( !res.contains(path))
                    res.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[i]);
            dfs(i+1,nums);
            path.remove(path.size()-1);
            dfs(i+1, nums);
        }
    }
}
