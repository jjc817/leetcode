package leetcode.algorithm;

import java.util.*;

public class IntersectionSizeTwo757 {
    public static void main(String[] args) {
        int[][] ints = {{1,10},{3,8},{4,9}};
        final int i = Solution.intersectionSizeTwo(ints);
        System.out.println(i);
    }
//    public static int intersectionSizeTwo(int[][] intervals) {
//        Set set = new HashSet();
//        for (int[] interval : intervals) {
//            if (interval[1]-interval[0]==1) {
//                set.add(interval[0]);
//                set.add(interval[1]);
//            }else{
//                set.stream().forEach();
//            }
//        }
//        return set.size();
//    }
static class Solution {
    public static int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        int m = 2;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<Integer>[] temp = new List[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new ArrayList<Integer>();
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++) {
                res++;
                help(intervals, temp, i - 1, j);
            }
        }
        return res;
    }

    public static void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp[i].add(num);
        }
    }
}

}
