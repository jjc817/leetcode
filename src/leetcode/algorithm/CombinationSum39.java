package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        System.out.println(MySolution.combinationSum(new int[]{1,2, 3, 6, 7}, 7));
    }
    static class MySolution {
        static public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists =new ArrayList<>();
            backtrack(lists,candidates,target,0,new ArrayList<Integer>());
            return lists;
        }
        static void backtrack(List<List<Integer>> lists,int[] candidates,int target,int index,List<Integer> list){
//            list.add(candidates[index]);
////            index++;
////            int sum = list.stream().mapToInt(num->num.intValue()).sum();
////            if(target%sum==0){
////                lists.add(list);
////            }
////            backtrack(lists, candidates, target, index, list);
            if(index==candidates.length){
                return;
            }
            if (target == 0){
                lists.add(new ArrayList<Integer>(list));
                return;
            }
            backtrack(lists, candidates, target, index+1, list);
            if(target-candidates[index]>=0){
                list.add(candidates[index]);
                backtrack(lists, candidates, target-candidates[index], index, list);
                list.remove(list.size()-1);
            }
        }
    }
    class Solution {
        List<List<Integer>> res;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            res = new ArrayList<>();
            Arrays.sort(candidates);

            backtrack(candidates, target, new ArrayList<>(), 0);

            return res;
        }

        private void backtrack(int[] candidates, int remains, List<Integer> path, int start){
            if(remains == 0){
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i = start; i < candidates.length; i++){
                if(candidates[i] > remains)
                    return;

                if(i > 0 && candidates[i] == candidates[i-1])   continue;
                //[2,2,3,5]

                path.add(candidates[i]);

                backtrack(candidates, remains - candidates[i], path, i);

                path.remove(path.size() - 1);
            }
        }
    }
}
