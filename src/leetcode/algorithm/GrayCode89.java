package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    public static void main(String[] args) {
        MySolution.grayCode(2);
    }
    static class MySolution {
        public static List<Integer> grayCode(int n) {
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < 1 << n; i++) {
                ret.add((i >> 1) ^ i);
            }
            return ret;
        }

    }
}
