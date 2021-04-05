import pojo.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Fei on 1/7/2018.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue(new listNodeComparator());
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode lowest = queue.poll();
            tail.next = lowest;
            tail = tail.next;
            if (lowest.next != null) {
                queue.add(lowest.next);
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = null;
        ListNode node3 = new ListNode(2);
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        mergeKSortedList.mergeKLists(list);

    }
}
