package leetcode.algorithm;

public class ReverseKGroup25 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByListWithoutHead(new int[]{1,2,3,4,5});
        System.out.println(Solution.reverseKGroup(listNode, 3));
    }
    static class Solution {
        public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode hair = new ListNode(0);
            hair.next = head;
            ListNode pre = hair;

            while (head != null) {
                ListNode tail = pre;
                // 查看剩余部分长度是否大于等于 k
                for (int i = 0; i < k; ++i) {
                    tail = tail.next;
                    if (tail == null) {
                        return hair.next;
                    }
                }
                ListNode nex = tail.next;
                ListNode[] reverse = ListNode.myReverse(head, tail);
                head = reverse[0];
                tail = reverse[1];
                // 把子链表重新接回原链表
                pre.next = head;
                tail.next = nex;
                pre = tail;
                head = tail.next;
            }

            return hair.next;
        }
        static class MySolution {
            public static ListNode reverseKGroup(ListNode head, int k) {
                ListNode h = head;
                while (ListNode.length(h)>=k){
                    ListNode last = h;
                    ListNode first = h;
                    for (int i = 0; i < k-1; i++) {
                        last=last.next;
                    }
                    for (int i = 0; i < k/2; i++) {
                        int temp = first.val;
                        first.val=last.val;
                        last.val=temp;
                        first=first.next;
                        last=ListNode.prev(head,last);
                    }
                    for (int i = 0; i < k; i++) {
                        h=h.next;
                    }
                }
                return head;
            }
        }


    }

}
