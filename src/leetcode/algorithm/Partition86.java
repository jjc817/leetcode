package leetcode.algorithm;

public class Partition86 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByList(new int[]{1,5,3,4,2});
        System.out.println(MySolution.partition(listNode, 3));
    }
    static class MySolution {
        public static ListNode partition(ListNode head, int x) {
            ListNode small = head;
            ListNode big = head;
            ListNode p = head;
            ListNode q = head;
            while (head.next!=null){
                if (head.next.val<x){
                    small.next=head.next;
                    small=small.next;
                    if (p.val==-99999){
                        p=small;
                    }
                }else {
                    big.next=head.next;
                    big=big.next;
                    if (q.val==-99999){
                        q=big;
                    }
                }
                head=head.next;
            }
            small.next=q;
            big.next=null;
            return p;
        }
    }
}
