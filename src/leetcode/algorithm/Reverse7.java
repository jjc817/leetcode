package leetcode.algorithm;

public class Reverse7 {
    public static void main(String[] args) {
        int reverse = MySolution.reverse(-908);
        int reverse1 = Solution.reverse(-908);
        System.out.println(reverse1);
    }
    static class MySolution {
        public static int reverse(int x) {
            String s = "";
            int sign = 1;
            if(x<0){
                sign = -1;
                x=-x;
            }
            while (x>0){
                int i = x % 10;
                s+=i;
                x/=10;
            }
            return Integer.valueOf(s)*sign;
        }
    }
    static class Solution {
        public static int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }

}
