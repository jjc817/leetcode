package leetcode.algorithm;

import java.util.*;

//接雨水
public class Trap42 {
    public static void main(String[] args) {
        int trap = MySolution.trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
    static class MySolution {
        public static int trap(int[] height) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < height.length - 1; i++) {
                if(height[i] <= height[i+1])
                    continue;
                for (int j = i + 1; j < height.length; j++) {
                    if(height[j] >= height[i]){
                        List<Integer> list = new ArrayList<>();
                        while (i<=j){
                            list.add(height[i++]);
                        }
                        i-=2;
                        lists.add(list);
                        break;
                    }
                }
            }
            int sum = 0;
            for (List<Integer> list : lists) {
                int min = Math.min(list.get(0),list.get(list.size()-1));
                for (int i = 1; i < list.size() - 1; i++) {
                    sum += min - list.get(i);
                }
            }
            return sum;
        }
    }
    //動態規劃
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
    //單調棧stack
    class Solution2 {
        public int trap(int[] height) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }
    }
    //雙指針
    class Solution3 {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }

}
