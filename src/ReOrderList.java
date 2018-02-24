import pojo.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class ReOrderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //split list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode fastHead = slow.next;
        slow.next = null;

        //reverse 2nd list
        ListNode reversedList = reverseList(fastHead);
        //merge two list
        head = mergeList(head,reversedList);
    }

    private ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }

    private ListNode mergeList(ListNode left,ListNode right) {


        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (left != null && right != null) {
            current.next = left;
            left = left.next;
            current = current.next;
            current.next = right;
            right = right.next;
            current = current.next;
        }
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReOrderList reOrderList = new ReOrderList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        reOrderList.reorderList(node1);

        PriorityQueue<ListNode> queue = new PriorityQueue(new listNodeComparator());



    }




}


class listNodeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ListNode node1 = (ListNode)o1;
        ListNode node2 = (ListNode)o1;
        if (o1 != null && o2 != null) {
            return node1.val - node2.val;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return -1;
    }
}