package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _82DeleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByList(new int[]{1,2,3,1,2,4,1,5});
        System.out.println(Solution.deleteDuplicates(listNode));
    }
    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
}
