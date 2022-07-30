package leetcode.algorithm;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create(362);
//        System.out.println(l1);
        ListNode l2 = ListNode.create(456);
        ListNode listNode = MySolution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    static class MySolution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode n1 =l1.next;
            ListNode n2 =l2.next;
            int len = 1;
            int sum = 0;
            int carry = 0;
            while(n1!=null ){
                int i = n1.val + n2.val + carry;
                if(i>=10){
                    carry = 1;
                    i=i-10;
                }
                sum+=i*len;
                len*=10;
//                System.out.println(i);
                n1=n1.next;
                n2=n2.next;
            }
            System.out.println(sum);
            ListNode node = ListNode.create(sum);
            return  node;
        }
    }

    //官方
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }

}
