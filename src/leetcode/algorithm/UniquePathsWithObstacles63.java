package leetcode.algorithm;

public class UniquePathsWithObstacles63 {
    public static void main(String[] args) {
        System.out.println(MySolution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
    static class MySolution {
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[m-1][n-1];
        }
        class Solution {
            public int uniquePathsWithObstacles(int[][] obstacleGrid) {
                int n = obstacleGrid.length, m = obstacleGrid[0].length;
                int[] f = new int[m];

                f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        if (obstacleGrid[i][j] == 1) {
                            f[j] = 0;
                            continue;
                        }
                        if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                            f[j] += f[j - 1];
                        }
                    }
                }

                return f[m - 1];
            }
        }
    }
}
