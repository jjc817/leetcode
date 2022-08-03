package leetcode.algorithm;
//中等难度 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//返回容器可以储存的最大水量。
//双指针
public class _11MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = MySolution.maxArea(height);
        System.out.println(i);
    }
    static class MySolution {
        static public int maxArea(int[] height) {
            int left = 0;
            int right = height.length-1;
            int area = 0;
            int max = 0;
            while (left<right){
                area = Math.min(height[left],height[right])*(right-left);
                max = Math.max(max,area);
                if (height[left]<height[right])
                    left++;
                else
                    right--;
            }
            return max;
        }
    }
    public class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;
        }
    }

}
