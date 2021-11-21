package linkedListRelated;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        Queue<ListNode> queue = new LinkedList();
        int length = 0;
        ListNode current = head;
        while (current != null) {
            queue.add(current);
            current = current.next;
            length++;
        }
        int moveSteps = length - k % length;
        for (int i = 0; i < moveSteps; i++) {
            queue.add(queue.poll());
        }

        ListNode newHead = queue.poll();
        ListNode pre = newHead;
        while (!queue.isEmpty()) {
            current = queue.poll();
            pre.next = current;
            pre = current;
        }
        pre.next = null;
        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //get length of list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        //fast move ksteps, then slow move
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newTail = slow;
        ListNode tail = fast;
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }


    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> counterMap = new HashMap();
        ListNode cur = head;
        while (cur != null) {
            counterMap.put(cur.val, counterMap.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = slow.next;

        while (fast != null) {
            while (fast != null && counterMap.get(fast.val) > 1) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
            if (fast != null) {
                fast = fast.next;
            }
        }


        return dummy.next;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5


        /**
         *  A B C D E  p = 0
         *  B A C D E  p = 1
         *  C B A D E  p = 2
         *  D C B A E  p = 4
         *  E D C B A  p = 5
         */
        for (int i = 0; i < right - left; i++) {    //头插法
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyMore = new ListNode(-1);

        ListNode less = dummyLess;
        ListNode more = dummyMore;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                more.next = cur;
                more = more.next;
            }
            cur = cur.next;
        }
        less.next = dummyMore.next;
        more.next = null;
        return dummyLess.next;

    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        partition(node1,2);


    }
}
