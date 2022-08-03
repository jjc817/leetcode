package leetcode.algorithm;

public class _92ReverseBetween {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByListWithoutHead(new int[]{1,2,3,4,5});
        System.out.println(MySolution.reverseBetween(listNode, 2, 4));
    }
    static class MySolution {
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode hair = new ListNode(0);
            hair.next=head;
            ListNode start = head;
            ListNode pre = hair;
            ListNode end = head;
            for (int i = 1; i < right; i++) {
                if(i<left){
                    pre = pre.next;
                    start = start.next;
                    end = end.next;
                }else
                    end = end.next;
            }
            ListNode p = end.next;
            ListNode q = start;
            while (p!=end){
                ListNode nex = q.next;
                q.next = p;
                p=q;
                q=nex;
            }
            pre.next=end;
            return head;
        }
    }
}
