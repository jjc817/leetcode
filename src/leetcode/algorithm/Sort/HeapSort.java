package leetcode.algorithm.Sort;

import leetcode.dataStructure.heap.Heap;
import leetcode.dataStructure.heap.SmallHeap;

public class HeapSort {
    public static void hSort(int[] arr){
        //小頂堆
        SmallHeap<Integer> sHeap = new SmallHeap<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            sHeap.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sHeap.delMin();
        }
    }
    public static void ReverseHSort(int[] arr){
        //大頂堆
        Heap<Integer> heap = new Heap<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.delMax();
        }
    }
}
