package linkedListRelated;

import pojo.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKList(List<ListNode> nodeList) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode node : nodeList) {
            queue.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            current.next = minNode;
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
            current = current.next;
        }
        return dummy.next;
    }

}
