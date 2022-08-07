package leetcode.algorithm.Sort;


import static leetcode.algorithm.Sort.SortTest.swap;

public class QuickSort {
    //單邊
    static public void qSort(int start,int end,int[] nums){
        if (end - start < 1){
            return;
        }
        for (int i = start; i < end; i++) {
            if(nums[i] < nums[end]){
                swap(nums,i,start);
                start++;
            }
        }
        swap(nums,start,end);
        qSort(0,start - 1,nums);
        qSort(start + 1,end,nums);
    }
    //雙邊
    static public void qSort(int[] nums,int left,int right){
        if (right - left < 1){
            return;
        }
        int start = left;
        int end = right;
        while (left < right){
            while (nums[right] > nums[start] && left < right){
                right--;
            }
            while (nums[left] <= nums[start] && left < right){
                left++;
            }
            swap(nums,left,right);
        }
        swap(nums,start,left);
        qSort(nums,start,left - 1);
        qSort(nums,left + 1,end);
    }

}
