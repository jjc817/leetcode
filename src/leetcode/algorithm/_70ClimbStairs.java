package leetcode.algorithm;

public class _70ClimbStairs {
    public static void main(String[] args) {
        System.out.println(MySolution.climbStairs(9));
    }
    static class MySolution {
        public static int climbStairs(int n) {
            int p = 1;
            int q = 1;
            int r = 0;
            for (int i = 1; i < n; i++) {
                r=q+p;
                p=q;
                q=r;
            }
            return r;
        }
    }
    static class MySolution2 {
        public static int climbStairs(int n) {
            int[] res = new int[1];
            recursion(res,0,n);
            return res[0];
        }
        private static void recursion(int[] res,int n,int m) {
            if (n==m){
                res[0]++;
                return;
            }
            if (n>m)
                return;
            recursion(res,n+1,m);
            recursion(res,n+2,m);
        }
    }
    public class Solution {
        public int climbStairs(int n) {
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n);
            return res[0][0];
        }

        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }

        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
                }
            }
            return c;
        }
    }
    public class Solution2 {
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) Math.round(fibn / sqrt5);
        }
    }
}
