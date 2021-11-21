package linkedListRelated;

import org.junit.jupiter.api.Test;
import pojo.ListNode;

public class RevertLinkedList {

    public ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode cur = head;
        ListNode n = null;
        while (cur != null) {
            n = cur.next;
            cur.next = p;
            p = cur;
            cur = n;
        }
        return p;
    }

    @Test
    public void test() {
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

        ListNode head = revert(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}
