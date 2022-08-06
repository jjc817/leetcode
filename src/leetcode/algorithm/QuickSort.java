package leetcode.algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{7,4,6,2,3,8,1,9,5};
        InsertionSort.iSort(nums);
        quickSort(0,nums.length - 1,nums);
        quickSort(nums,0,nums.length - 1);
    }
    //單邊
    static public void quickSort(int start,int end,int[] nums){
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
        quickSort(0,start - 1,nums);
        quickSort(start + 1,end,nums);
    }
    //雙邊
    static public void quickSort(int[] nums,int left,int right){
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
        quickSort(nums,start,left - 1);
        quickSort(nums,left + 1,end);
    }
    static public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
