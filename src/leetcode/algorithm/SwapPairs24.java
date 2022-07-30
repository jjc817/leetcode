package leetcode.algorithm;

import static leetcode.algorithm.ListNode.createByList;

public class SwapPairs24 {
    public static void main(String[] args) {
        ListNode list = createByList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = MySolution.swapPairs(list);
        while (listNode.next!=null){
            System.out.println(listNode.next.val);
            System.out.println("⬇");
            listNode=listNode.next;
        }
    }

    static class MySolution {

        static public ListNode swapPairs(ListNode head) {
            ListNode h = head.next;
            while (h!=null&&h.next!=null){
                int val = h.val;
                h.val=h.next.val;
                h.next.val=val;
                h=h.next.next;
            }
            return head;
        }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }

}
