package leetcode.algorithm.Sort;
import static leetcode.algorithm.Sort.SortTest.swap;

public class SelectionSort {
    /*
        对数组a中的元素进行排序
     */
    public static void sSort(int[] a){
        for(int i=0;i<=a.length-2;i++){
            //定义一个变量，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            for(int j=i+1;j<a.length;j++){
                //需要比较最小索引minIndex处的值和j索引处的值；
                if (a[minIndex] > a[j]){
                    minIndex=j;
                }
            }

            //交换最小元素所在索引minIndex处的值和索引i处的值
            swap(a,i,minIndex);
        }
    }

}
