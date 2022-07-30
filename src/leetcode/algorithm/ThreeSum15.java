package leetcode.algorithm;

import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] ints = {1,2,-1,0,-2,-1};
        List<List<Integer>> lists = MySolution.threeSum(ints);
        System.out.println(lists);
    }
    static class MySolution {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists =new ArrayList<>();
            //set去重
            Set<Integer> set = new TreeSet();
            for (int num : nums) {
                set.add(num);
            }
            Integer[] temp = set.toArray(new Integer[]{});
            int[] array = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i].intValue();
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    for (int k = j+1; k < array.length; k++) {
                        if(array[i]+array[j]+array[k]==0){
                            List<Integer> num = new ArrayList<>();
                            num.add(array[i]);
                            num.add(array[j]);
                            num.add(array[k]);
                            lists.add(num);
                        }
                    }
                }
            }
            return lists;
        }
        //当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
        //将枚举的时间复杂度从 O(N^2)
        //  减少至 O(N)。为什么是 O(N) 呢？这是因为在枚举的过程每一步中，
        //  「左指针」会向右移动一个位置（也就是题目中的 bb），
        //  而「右指针」会向左移动若干个位置，这个与数组的元素有关，
        //  但我们知道它一共会移动的位置数为 O(N，均摊下来，每次也向左移动一个位置，因此时间复杂度为 O(N)。
        //注意到我们的伪代码中还有第一重循环，时间复杂度为 O(N)因此枚举的总时间复杂度为 O(N^2)
        // )。由于排序的时间复杂度为 O(N \log N)在渐进意义下小于前者，因此算法的总时间复杂度为 O(N^2)
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        public List<List<Integer>> threeSum2(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
}
