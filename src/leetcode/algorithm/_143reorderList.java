package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class _143reorderList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByListWithoutHead(new int[]{1,2,3,4,5});
        MySolution.reorderList(listNode);
        System.out.println(listNode);
    }
    static class MySolution {
        public static void reorderList(ListNode head) {
            ListNode mid = ListNode.mid(head);
            ListNode right = mid.next;
            ListNode left = head;
            mid.next = null;
            right = ListNode.reverse(right);
            while (left != null && right != null){
                ListNode p = left.next;
                ListNode q = right.next;
                right.next = left.next;
                left.next = right;
                right = q;
                left = p;
            }
        }
    }
    static class Solution {
        public static void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<ListNode>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }

}
