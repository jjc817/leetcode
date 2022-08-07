package leetcode.algorithm.Sort;

public class SortTest {
    public static void main(String[] args) {
        int[] m = new int[]{7,4,6,2,3,8,1,9,5};
        int[] m2 = new int[]{7,4,6,2,3,8,1,9,5};
        int[] b = new int[]{7,4,6,2,3,8,1,9,5};
        int[] i = new int[]{7,4,6,2,3,8,1,9,5};
        int[] q1 = new int[]{7,4,6,2,3,8,1,9,5};
        int[] q2 = new int[]{7,4,6,2,3,8,1,9,5};
        int[] s = new int[]{7,4,6,2,3,8,1,9,5};
        int[] shell = new int[]{7,4,6,2,3,8,1,9,5};
        int[] h = new int[]{7,4,6,2,3,8,1,9,5};
        InsertionSort.iSort(i);
        MergeSort.mSort(m);
        MergeSort.mSortRecursive(m2);
        BubbleSort.bSort(b);
        QuickSort.qSort(0,q1.length - 1,q1);
        QuickSort.qSort(q2,0,q2.length - 1);
        SelectionSort.sSort(s);
        ShellSort.shellSort(shell);
        HeapSort.hSort(h);
    }
    //数组元素i和j交换位置
    public static void swap(int[] a, int i, int j){
        int temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
