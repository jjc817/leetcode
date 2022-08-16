package leetcode.algorithm;

import java.util.*;

public class _220containsNearbyAlmostDuplicate {
    public static void main(String[] args) {

        //创建对象
        Scanner sc = new Scanner(System.in);
        System.out.println("输入數組長度:");
        //多行输入
        int n = sc.nextInt();
        int[] arr = new int[n];
        //int等基本数据类型的数组,用nextInt()，同行或不同都可以
        System.out.println("输入元素:");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("输入k:");
        int k = sc.nextInt();
        System.out.println("输入t:");
        int t = sc.nextInt();
        System.out.println(containsDuplicate(arr,t,k));
        //关闭
        sc.close();

    }
    public static boolean containsDuplicate(int[] nums,int t,int k) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Integer ceiling = set.ceiling(nums[i] -  t);
            if (ceiling != null && ceiling <= nums[i] + t) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }


}
