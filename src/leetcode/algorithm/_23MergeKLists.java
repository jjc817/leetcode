package leetcode.algorithm;

import java.util.*;

public class _23MergeKLists {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createByList(new int[]{1,2,5});
        ListNode listNode2 = ListNode.createByList(new int[]{4,6,9});
        ListNode listNode3 = ListNode.createByList(new int[]{3,8,7});
        System.out.println(MySolution.mergeKLists(new ListNode[]{listNode1, listNode2, listNode3}));
    }
    static class MySolution {
        public static ListNode mergeKLists(ListNode[] lists) {
            List<Integer> array = new ArrayList<>();
            for (ListNode list : lists) {
                ListNode head = list;
                while (head.next!=null){
                    array.add(head.next.val);
                    head = head.next;
                }
            }
            array.sort(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            int[] ints = new int[array.size()];
            for (int i = 0; i < array.size(); i++) {
                ints[i]=array.get(i);
            }
            ListNode res = ListNode.createByListWithoutHead(ints);
            return res;
        }
    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = null;
            for (int i = 0; i < lists.length; ++i) {
                ans = mergeTwoLists(ans, lists[i]);
            }
            return ans;
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }
    class Solution3 {
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<Status>();

        public ListNode mergeKLists(ListNode[] lists) {
            for (ListNode node: lists) {
                if (node != null) {
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!queue.isEmpty()) {
                Status f = queue.poll();
                tail.next = f.ptr;
                tail = tail.next;
                if (f.ptr.next != null) {
                    queue.offer(new Status(f.ptr.next.val, f.ptr.next));
                }
            }
            return head.next;
        }
    }


}
