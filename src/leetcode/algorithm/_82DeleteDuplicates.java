package leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class _82DeleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createByList(new int[]{1,2,3,1,2,4,1,5});
        System.out.println(MySolution.deleteDuplicates(listNode));
    }
    static class MySolution {
        public static ListNode deleteDuplicates(ListNode head) {
            Map<Integer,Integer> map = new HashMap();
            ListNode p = head.next;
            while (p!=null){
                if(map.get(p.val) == null)
                    map.put(p.val,1);
                else
                    map.put(p.val,map.get(p.val)+1);
                p = p.next;
            }
            p = head.next;
            while (p!=null){
                ListNode q = p;
                if(map.get(q.val)>1){
                    ListNode t = ListNode.prev(head,q);
                    t.next=q.next;
                    p = t;
                    q.next=null;
                }
                p=p.next;

            }
            return head;
        }
    }
}
