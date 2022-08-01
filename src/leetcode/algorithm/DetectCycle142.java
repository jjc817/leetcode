package leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle142 {

    public class MySolution {
        public ListNode detectCycle(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }
    }
}
