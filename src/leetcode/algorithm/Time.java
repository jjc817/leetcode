package leetcode.algorithm;

import java.time.LocalTime;
import java.util.List;

public class Time {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createByList(new int[]{1,2,5,1,1,1,1,1,1,1});
        ListNode listNode2 = ListNode.createByList(new int[]{4,6,9,23,2,34423,4,2,42,42});
        ListNode listNode3 = ListNode.createByList(new int[]{3,8,7,124124,24,21,12,412,41,124,124,534,533});
        System.out.println(LocalTime.now());
        System.out.println(MergeKLists23.MySolution.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3}));
        System.out.println(LocalTime.now());
    }
}
