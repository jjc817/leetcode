package leetcode.algorithm;

public class _62UniquePaths {
    public static void main(String[] args) {
        System.out.println(MySolution.uniquePaths(100, 10));
        System.out.println(Solution.uniquePaths(10, 10));
        System.out.println(Solution2.uniquePaths(10, 10));
    }
    static class MySolution {
        public static Long uniquePaths(int m, int n) {
            Long[][] dp = new Long[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1L;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1L;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }
    static class Solution {
        public static int uniquePaths(int m, int n) {
            int[][] f = new int[m][n];
            for (int i = 0; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 0; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];
        }
    }
    static class Solution2 {
        public static int uniquePaths(int m, int n) {
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }
    }

}
