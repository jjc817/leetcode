package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _137singleNumber {
    public static void main(String[] args) {
        System.out.println(MySolution.singleNumber(new int[]{1, 2, 2, 1, 4, 2, 1}));
    }
    static class MySolution {
        public static int singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) == null){
                    map.put(nums[i],1);
                }
                else if(map.get(nums[i]) > 1)
                    map.remove(nums[i]);
                else 
                    map.put(nums[i],map.get(nums[i]) + 1);
            }
            int single = 0;
            for (Integer i : map.keySet()) {
                single = i;
            }
            return single;
        }
    }
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int num = entry.getKey(), occ = entry.getValue();
                if (occ == 1) {
                    ans = num;
                    break;
                }
            }
            return ans;
        }
    }
    class Solution2 {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; ++i) {
                int total = 0;
                for (int num: nums) {
                    total += ((num >> i) & 1);
                }
                if (total % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }

}
