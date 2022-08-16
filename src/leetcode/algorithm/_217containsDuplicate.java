package leetcode.algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class _217containsDuplicate {
    public static void main(String[] args) {

        //创建对象
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数据:");
        //多行输入
        int n = sc.nextInt();
        int[] arr = new int[n];
        //int等基本数据类型的数组,用nextInt()，同行或不同都可以
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(containsDuplicate(arr));
        //关闭
        sc.close();

    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i))
                map.put(i,1);
            else
                return true;
        }
        return false;
    }

}
