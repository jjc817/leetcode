package leetcode.algorithm;

public class InsertionSort {
    public static void iSort(int [] arr){
        for (int i = 1;i < arr.length;i++)
        {
            int tmp = arr[i];
            int j;
            for (j = i - 1;j >= 0 && arr[j] > tmp;j--)
            {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }
}
