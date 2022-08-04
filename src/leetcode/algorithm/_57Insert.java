package leetcode.algorithm;

import java.util.Arrays;

import static leetcode.algorithm._56Merge.Solution.getInts;

public class _57Insert {
    public static void main(String[] args) {
        int[][] insert = MySolution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        TwoDimensionalArray.printArrays(insert);
    }
    static class MySolution {
        public static int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length == 0) {
                int[][] ints = new int[][]{newInterval};
                return ints;
            }
            intervals = Arrays.copyOf(intervals,intervals.length+1);
            intervals[intervals.length-1] = newInterval;
            Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
            return getInts(intervals);
        }
    }
}
