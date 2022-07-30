package leetcode.algorithm;

public class ListNode {

    //  Definition for singly-linked list.
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
    public static String toStringAndRemoveHead(ListNode listNode) {
          listNode=listNode.next;
        return listNode.toString();
    }

    public static ListNode create(int num){
        ListNode head = new ListNode();
        ListNode p = head;
        while (num>0){
            int n = num%10;
            ListNode node = new ListNode(n);
            p.next=node;
            p=node;
            num/=10;
        }
        return head;
    }
    public static ListNode createByList(int[] list){
        ListNode head = new ListNode();
        ListNode h = head;
        for (int i = 0; i < list.length; i++) {
            ListNode listNode =new ListNode(list[i]);
            h.next = listNode;
            h=listNode;
        }
        return head;
    }
    public static int length(ListNode head){
          int len = 0;
          while (head.next!=null){
             head=head.next;
             len++;
          }
        return len;
    }
}
