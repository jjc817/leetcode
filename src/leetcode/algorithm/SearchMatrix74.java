package leetcode.algorithm;

import java.awt.print.PrinterGraphics;
import java.util.Arrays;

public class SearchMatrix74 {
    public static void main(String[] args) {
        System.out.println(MySolution.searchMatrix(new int[][]{{1, 3, 4, 5}, {10, 11, 13, 14}, {24, 124, 333, 555}}, 124));
    }
    static class MySolution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            int left = 0;
            int right = matrix.length - 1;
            int mid = 0;
            while (left <= right){
                mid = (left + right) >> 1;
                if(matrix[mid][0] == target)
                    return true;
                else if (matrix[mid][0]<target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            int i = Arrays.binarySearch(matrix[mid], target);
            if(i>=0)
                return true;
            return false;
        }
    }
    //一次二分查找
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int x = matrix[mid / n][mid % n];
                if (x < target) {
                    low = mid + 1;
                } else if (x > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
