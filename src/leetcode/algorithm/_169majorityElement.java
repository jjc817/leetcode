package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _169majorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
    public static int majorityElement(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault((arr[i]),0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > arr.length / 2)
                return i;
        }
        return -1;
    }
    //分治
    class Solution {
        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        private int majorityElementRec(int[] nums, int lo, int hi) {
            // base case; the only element in an array of size 1 is the majority
            // element.
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi - lo) / 2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid + 1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length - 1);
        }
    }
    class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }


}
