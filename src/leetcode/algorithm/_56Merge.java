package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56Merge {
    public static void main(String[] args) {
        int[][] temp =new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = MySolution.merge(temp);
        IntArraySolution.printIntArrays(merge);

    }
    static class MySolution {
        public static int[][] merge(int[][] intervals) {
            int n = intervals.length;
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                for (int j = 0; j < n; j++) {
                    if(i == j)
                        continue;
                    if(intervals[j][0] >= start && intervals[j][0] <= end){
                        int right = Math.max(intervals[i][1],intervals[j][1]);
                        intervals[i][1] = right;
                        int t = j;
                        for (int k = t + 1; k < n; k++) {
                            intervals[t++] = intervals[k];
                        }
                        intervals = Arrays.copyOf(intervals, intervals.length - 1);
                        n--;
                        j--;
                    }
                }
            }

            return intervals;
        }
    }
    static class Solution {
        public static int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });
            return getInts(intervals);
        }

        static public int[][] getInts(int[][] intervals) {
            List<int[]> merged = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; ++i) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }

}
