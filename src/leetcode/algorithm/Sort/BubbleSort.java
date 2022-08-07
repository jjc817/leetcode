package leetcode.algorithm.Sort;

import static leetcode.algorithm.Sort.SortTest.swap;

public class BubbleSort {
    public static void bSort(int[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                //{6,5,4,3,2,1}
                //比较索引j和索引j+1处的值
                if (a[j] > a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
}
