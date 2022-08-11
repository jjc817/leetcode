package leetcode.algorithm;

public class _172trailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(6));
    }

    public static int trailingZeroes(int n) {

        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;

    }

}
