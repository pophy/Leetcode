package linkedListRelated;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null,fast = head,slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left,right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }





    @Test
    public void test() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;


        sortList(node1);
    }

}
