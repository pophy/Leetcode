package linkedListRelated;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

public class MergeSortedList {

    public ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current =dummyHead;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                current.next = n1;
                n1 = n1.next;
                current = current.next;
            } else {
                current.next = n2;
                n2 = n2.next;
                current = current.next;
            }
        }
        if (n1 != null) {
            current.next = n1;
        }
        if (n2 != null) {
            current.next = n2;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        n1.next = node3;
        n2.next = node4;

        node3.next = node5;
        node4.next = node6;
        node5.next = node7;

        ListNode node = merge(n1,n2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

}
