package leetcode.algorithm;

public class RotateRight61 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{0,1,2});
        ListNode node = MySolution.rotateRight(listNode, 4);
        System.out.println(ListNode.toStringAndRemoveHead(node));
    }
    static class MySolution {
        public static ListNode rotateRight(ListNode head, int k) {
            int length = ListNode.length(head);
            final int n = k % length;
            ListNode thead = head.next;
            int temp = head.next.val;
            int temp2 = head.next.val;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < length - 1; j++) {
                    if(j%2 == 0){
                        temp2 = thead.next.val;
                        thead.next.val=temp;
                        thead = thead.next;
                    }else {
                        temp = thead.next.val;
                        thead.next.val=temp2;
                        thead = thead.next;
                    }
                }
                if(length%2==1)
                    head.next.val=temp;
                else
                    head.next.val=temp2;
                thead = head.next;
            }
            return head;
        }
        class Solution {
            public ListNode rotateRight(ListNode head, int k) {
                if (k == 0 || head == null || head.next == null) {
                    return head;
                }
                int n = 1;
                ListNode iter = head;
                while (iter.next != null) {
                    iter = iter.next;
                    n++;
                }
                int add = n - k % n;
                if (add == n) {
                    return head;
                }
                iter.next = head;
                while (add-- > 0) {
                    iter = iter.next;
                }
                ListNode ret = iter.next;
                iter.next = null;
                return ret;
            }
        }


    }
}
