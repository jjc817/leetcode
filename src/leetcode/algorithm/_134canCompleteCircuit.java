package leetcode.algorithm;

public class _134canCompleteCircuit {
    public static void main(String[] args) {
        MySolution.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{1,2,3,4,5});
    }
    static class MySolution {
        public static int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            //考虑从每一个点出发
            for (int i = 0; i < n; i++) {
                int j = i;
                int remain = gas[i];
                //当前剩余的油能否到达下一个点
                while (remain - cost[j] >= 0) {
                    //减去花费的加上新的点的补给
                    remain = remain - cost[j] + gas[(j + 1) % n];
                    j = (j + 1) % n;
                    //j 回到了 i
                    if (j == i) {
                        return i;
                    }
                }
            }
            //任何点都不可以
            return -1;
        }
        static public int canCompleteCircuit(int[] gas, int[] cost,int p) {
            int n = gas.length;
            //记录能到的最远距离
            int[] farIndex = new int[n];
            for (int i = 0; i < farIndex.length; i++) {
                farIndex[i] = -1;
            }
            //记录到达最远距离时候剩余的汽油
            int[] farIndexRemain = new int[n];
            for (int i = 0; i < n; i++) {
                int j = i;
                int remain = gas[i];
                while (remain - cost[j] >= 0) {
                    //到达下个点后的剩余
                    remain = remain - cost[j];
                    j = (j + 1) % n;
                    //判断之前有没有考虑过这个点
                    if (farIndex[j] != -1) {
                        //加上当时剩余的汽油
                        remain = remain + farIndexRemain[j];
                        //j 进行跳跃
                        j = farIndex[j];
                    } else {
                        //加上当前点的补给
                        remain = remain + gas[j];
                    }
                    if (j == i) {
                        return i;
                    }
                }
                //记录当前点最远到达哪里
                farIndex[i] = j;
                //记录当前点的剩余
                farIndexRemain[i] = remain;
            }
            return -1;
        }
        static public int canCompleteCircuit(int[] gas, int[] cost,char c) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                int j = i;
                int remain = gas[i];
                while (remain - cost[j] >= 0) {
                    //减去花费的加上新的点的补给
                    remain = remain - cost[j] + gas[(j + 1) % n];
                    j = (j + 1) % n;
                    //j 回到了 i
                    if (j == i) {
                        return i;
                    }
                }
                //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
                if (j < i) {
                    return -1;
                }
                //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
                i = j;

            }
            return -1;
        }

    }
}
