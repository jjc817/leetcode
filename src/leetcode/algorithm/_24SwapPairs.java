package leetcode.algorithm;

import static leetcode.algorithm.ListNode.createByList;

public class _24SwapPairs {
    public static void main(String[] args) {
        ListNode list = createByList(new int[]{1, 2, 3, 4, 9});
        ListNode listNode = MySolution.swapPairs(list);
        while (listNode.next!=null){
            System.out.println(listNode.next.val);
            System.out.println("⬇");
            listNode=listNode.next;
        }
    }

    static class MySolution {

        static public ListNode swapPairs(ListNode head) {
            ListNode pre = head;
            while (pre.next!=null && pre.next.next!=null){
                ListNode p = pre.next;
                ListNode q = p.next;
                p.next=q.next;
                q.next=p;
                pre.next=q;
                pre=pre.next.next;
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
