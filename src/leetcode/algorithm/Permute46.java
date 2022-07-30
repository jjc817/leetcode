package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
    public static void main(String[] args) {
        System.out.println(MySolution.permute(new int[]{1, 2, 2}));
    }
    static class MySolution {
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            List<Integer> haveNum = new ArrayList<>();
            dfs(res,path,nums,haveNum);
            return res;
        }
        public static void dfs(List<List<Integer>> res, List<Integer> path, int[] nums,List<Integer> haveNum){
            if(path.size()==nums.length){
                //47题重复不加入
                if(res.contains(path)){
                    return;
                }
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if(haveNum.contains(i)){
                    continue;
                }
                path.add(nums[i]);
                haveNum.add(i);
                dfs(res, path, nums,haveNum);
                path.remove(path.size()-1);
                haveNum.remove(haveNum.size()-1);
            }
        }
    }
}
