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
        ListNode head = new ListNode(-99999);
        ListNode h = head;
        for (int i = 0; i < list.length; i++) {
            ListNode listNode =new ListNode(list[i]);
            h.next = listNode;
            h=listNode;
        }
        return head;
    }
    public static ListNode createByListWithoutHead(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode h = head;
        for (int i = 1; i < list.length; i++) {
            ListNode listNode =new ListNode(list[i]);
            h.next = listNode;
            h=listNode;
        }
        return head;
    }
    public static int length(ListNode head){
          if(head == null){
              return 0;
          }
          int len = 0;
          if(head.val != -99999)
              len++;
          while (head.next!=null){
             head=head.next;
             len++;
          }
        return len;
    }

    public static ListNode reverse(ListNode head) {
        ListNode first = head;
        ListNode last = ListNode.last(head);
        while (first!=last){
            ListNode p = first;
            first = first.next;
            p.next = last.next;
            last.next=p;
        }
        return first;
    }
    public static ListNode mid(ListNode head) {
        ListNode mid = head;
        while (head.next !=null && head.next.next != null){
            head = head.next.next;
            mid=mid.next;
        }
        return mid;
    }

    public static ListNode last(ListNode head){
          if (head == null)
              return null;
          while (head.next != null){
              head = head.next;
          }
          return head;
    }
}
