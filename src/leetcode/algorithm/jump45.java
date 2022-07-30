package leetcode.algorithm;

public class jump45 {
    public static void main(String[] args) {
        System.out.println(MySolution.jump(new int[]{2,3,0,1,4}));
    }
    static class MySolution {
        public static int jump(int[] nums) {
            int i = 0;
            int step = 0;
            while (i<nums.length){
                int max = 0;
                for (int j = 1; j <= nums[i]; j++) {
                    if(i+j>=nums.length-1){
                        return step+1;
                    }
                    max = Math.max(max,nums[i + j] + j);
                }
                i+=max;
                step++;
            }
            return step;
        }
    }
}
