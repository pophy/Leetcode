import pojo.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Fei on 1/7/2018.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (ListNode node : lists) {
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            pre.next = pq.poll();
            pre = pre.next;
            if (pre.next != null) {
                pq.add(pre.next);
            }
        }
        return dummy.next;
    }
}
