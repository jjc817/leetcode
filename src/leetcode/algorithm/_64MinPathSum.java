package leetcode.algorithm;

public class _64MinPathSum {
    public static void main(String[] args) {
        System.out.println(MySolution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
    static class MySolution {
        public static int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i==0 && j==0)
                        continue;
                    if (i == 0){
                        dp[i][j] = dp[i][j-1]+grid[i][j];
                        continue;
                    }
                    if (j == 0){
                        dp[i][j] = dp[i-1][j]+grid[i][j];
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }
        class Solution {
            public int minPathSum(int[][] grid) {
                if (grid == null || grid.length == 0 || grid[0].length == 0) {
                    return 0;
                }
                int rows = grid.length, columns = grid[0].length;
                int[][] dp = new int[rows][columns];
                dp[0][0] = grid[0][0];
                for (int i = 1; i < rows; i++) {
                    dp[i][0] = dp[i - 1][0] + grid[i][0];
                }
                for (int j = 1; j < columns; j++) {
                    dp[0][j] = dp[0][j - 1] + grid[0][j];
                }
                for (int i = 1; i < rows; i++) {
                    for (int j = 1; j < columns; j++) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    }
                }
                return dp[rows - 1][columns - 1];
            }
        }

    }
}
