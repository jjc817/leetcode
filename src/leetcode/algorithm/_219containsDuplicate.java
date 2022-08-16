package leetcode.algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class _219containsDuplicate {
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
        System.out.println(containsDuplicate(arr,k));
        //关闭
        sc.close();

    }
    public static boolean containsDuplicate(int[] nums,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else if (i - map.get(nums[i]) > k)
                map.put(nums[i], i);
            else
                return true;
        }
        return false;
    }
}
