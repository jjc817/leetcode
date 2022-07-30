package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static leetcode.algorithm.Merge56.Solution.getInts;

public class Insert57 {
    public static void main(String[] args) {
        int[][] insert = MySolution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        IntArraySolution.printIntArrays(insert);
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
