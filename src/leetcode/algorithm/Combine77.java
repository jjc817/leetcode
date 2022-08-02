package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    public static void main(String[] args) {
        System.out.println(MySolution.combine(5, 3));
    }
    static class MySolution {
        public static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(res,new ArrayList<Integer>(),n,k,1);
            return res;
        }
        public static void backtrack(List<List<Integer>> res,List<Integer> path,int n, int k,int i){
            if (path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j <= n; j++) {
                path.add(j);
                backtrack(res, path, n, k, j+1);
                path.remove(path.size()-1);
            }
        }
    }
}
