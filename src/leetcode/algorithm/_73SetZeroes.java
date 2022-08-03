package leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

public class _73SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        MySolution.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
    static class MySolution {
       public static void setZeroes(int[][] matrix) {
            Set<Integer> rows = new HashSet();
            Set<Integer> cols = new HashSet();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == 0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            for (Integer row : rows) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[row][i] = 0;
                }
            }
            for (Integer col : cols) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
   }


}
