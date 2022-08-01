package leetcode.algorithm;

public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByList(new int[]{1,2,3,4,5});
        MySolution.removeNthFromEnd(listNode, 5);
    }
    static class MySolution {

        public static ListNode removeNthFromEnd(ListNode head, int n) {
            int length = ListNode.length(head);
            if (n > length)
                return head;
            ListNode cur = head;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }
    }
}
