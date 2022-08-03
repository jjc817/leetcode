package leetcode.algorithm;

import java.util.Arrays;

public class _48Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,1,9,11,1,1},{2,4,8,10,2,2},{13,3,6,7,3,3},{15,14,12,16,4,4},{1,2,3,4,5,5},{11,10,9,8,7,6}};
        int[][] matrix2 = new int[][]{
                {5,1,9,11,1,1},{2,4,8,10,2,2},{13,3,6,7,3,3},{15,14,12,16,4,4},{1,2,3,4,5,5},{11,10,9,8,7,6}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("==========");
        MySolution.rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("==========");
        Solution.rotate(matrix2);
        for (int[] ints : matrix2) {
            System.out.println(Arrays.toString(ints));
        }
    }
    static class MySolution {
        public static void rotate(int[][] matrix) {
            int n = matrix.length;
            int m = 0;
            while (n>1) {
                for (int i = 0; i < matrix.length - 1 - 2 * m; i++) {
                    int temp = matrix[m][i+m];//matrix[0][i]第一排左上
                    matrix[m][i+m] = matrix[matrix.length - 1 - i - m][m];//matrix[matrix.length - 1 - i][0]第一列左下
                    int temp2 = matrix[i+m][matrix.length - 1 - m];//matrix[i][matrix.length - 1]最后一列右上
                    matrix[i+m][matrix.length - 1 - m] = temp;
                    matrix[matrix.length - 1 - i - m][m] = matrix[matrix.length - 1 - m][matrix.length - 1 - i - m];
                    //matrix[matrix.length - 1][matrix.length - 1 - i]最后一排右下
                    matrix[matrix.length - 1 - m][matrix.length - 1 - i - m] = temp2;
                }
                m++;
                n-=2;
            }
        }
    }
    static class Solution {
        static public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < (n + 1) / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
    class Solution2 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 水平翻转
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - i - 1][j];
                    matrix[n - i - 1][j] = temp;
                }
            }
            // 主对角线翻转
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

}
