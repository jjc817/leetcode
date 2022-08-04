package leetcode.algorithm;

public class _59GenerateMatrix {//54相似
    public static void main(String[] args) {
        final int[][] integers = MySolution.spiralOrder(10);
        TwoDimensionalArray.printArrays(integers);
    }
    static class MySolution {
        public static int[][] spiralOrder(int n) {
            int[][] ints = new int[n][n];
            int l =n*n;
            int x = 0;
            int y = 0;
            int z = 0;//圈数，最外第0圈
            for (int i = 0; i < l; i++) {
                ints[x][y] = i+1;
                if(y < n -1 && x==z){
                    y++;
                }else if(x < n -1 && y == n - 1){
                    x++;
                }else if(y > z && x == n - 1){
                    y--;
                }else if(x > z + 1 && y == z){
                    x--;
                }else if(x == z + 1 && y == z){
                    z++;
                    y++;
                    n--;
                }
            }
            return ints;
        }
    }
}
