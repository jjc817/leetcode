package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSum40 {
    public static void main(String[] args) {
    //    List<List<Integer>> lists = MySolution.combinationSum2(new int[]{10, 1, 2, 7, 6, 5}, 8);
        List<List<Integer>> lists2 = Solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 5}, 8);
        System.out.println(lists2);
    }
    static class MySolution {
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            int[] ints =new int[candidates.length];
            for (int i = 0; i < candidates.length; i++) {
                if(candidates[i]>target){
                    ints = Arrays.stream(candidates).limit(i).toArray();
                }
            }

            backtrack(lists,list,ints,target,0);
            return lists;
        }
        static void backtrack(List<List<Integer>> lists,List<Integer> list,int[] candidates, int target,int index){
            int sum = list.stream().mapToInt(num -> num.intValue()).sum();
            if(sum == target){
                lists.add(new ArrayList<>(list));
                list.clear();
            }
            if(sum < target){
                backtrack(lists, list, candidates, target, index+1);
                //list.remove(list.size()-1);
            }
            if(sum > target){
                list.clear();

                backtrack(lists, list, candidates, target, index);
            }

        }
    }
    static class Solution {
        static List<int[]> freq = new ArrayList<int[]>();
        static List<List<Integer>> ans = new ArrayList<List<Integer>>();
        static List<Integer> sequence = new ArrayList<Integer>();
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    ++freq.get(size - 1)[1];
                }
            }
            dfs(0, target);
            return ans;
        }

        public static void dfs(int pos, int rest) {
            if (rest == 0) {
                ans.add(new ArrayList<Integer>(sequence));
                return;
            }
            if (pos == freq.size() || rest < freq.get(pos)[0]) {
                return;
            }

            dfs(pos + 1, rest);

            int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
            for (int i = 1; i <= most; ++i) {
                sequence.add(freq.get(pos)[0]);
                dfs(pos + 1, rest - i * freq.get(pos)[0]);
            }
            for (int i = 1; i <= most; ++i) {
                sequence.remove(sequence.size() - 1);
            }
        }
    }

}
