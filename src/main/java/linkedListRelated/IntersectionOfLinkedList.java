package linkedListRelated;

import org.junit.jupiter.api.Test;

public class IntersectionOfLinkedList {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                fast = head;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        int lengthA = 0, lengthB = 0;
        while (curA.next != null) {
            curA = curA.next;
            lengthA++;
        }
        ListNode curB = headB;
        while (curB.next != null) {
            curB = curB.next;
            lengthB++;
        }
        if (curA != curB) {
            return null;
        }
        curA = headA;
        curB = headB;
        int k = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < k; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < k; i++) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node2;

        detectCycle(node1);
    }
}
