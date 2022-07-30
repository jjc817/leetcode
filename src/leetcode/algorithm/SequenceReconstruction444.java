package leetcode.algorithm;

import java.util.*;

public class SequenceReconstruction444 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[][] sequences = {{1,2},{3,4}};
        boolean b = Solution.sequenceReconstruction(nums, sequences);
        System.out.println(b);
    }
//    static class MySolution {
//        static public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
//            List<Integer> list = new ArrayList();
//            Set<Integer> set = new HashSet();
//            for (int i = 0; i < nums.length; i++) {
//                list.add(nums[i]);
//            }
//            for (int[] sequence : sequences) {
//                for (int i = 0; i < sequence.length; i++) {
//                    if (!list.contains(sequence[i])) {
//                        return false;
//                    }
//                    set.add(sequence[i]);
//                }
//            }
//            if (list.size()>set.size()) {
//                return false;
//            }
//            return true;
//        }
//    }
    static class Solution {
        public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            int n = nums.length;
            int[] indegrees = new int[n + 1];
            Set<Integer>[] graph = new Set[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new HashSet<Integer>();
            }
            for (int[] sequence : sequences) {
                int size = sequence.length;
                for (int i = 1; i < size; i++) {
                    int prev = sequence[i - 1], next = sequence[i];
                    if (graph[prev].add(next)) {
                        indegrees[next]++;
                    }
                }
            }
            Queue<Integer> queue = new ArrayDeque<Integer>();
            for (int i = 1; i <= n; i++) {
                if (indegrees[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    return false;
                }
                int num = queue.poll();
                Set<Integer> set = graph[num];
                for (int next : set) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            return true;
        }
    }
}

