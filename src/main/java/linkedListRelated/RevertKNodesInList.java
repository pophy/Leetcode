package linkedListRelated;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;


public class RevertKNodesInList {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return swapKPairs(head,2);
    }


    public ListNode swapKPairs(ListNode head, int k) {
        ListNode newHead = null;
        ListNode preNode = null;
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            while (head != null && stack.size() != k) {
                ListNode next = head.next;
                head.next = null;
                stack.push(head);
                head = next;
            }

            while (!stack.isEmpty()) {
                if (newHead == null) {
                    newHead = stack.peek();
                }
                if (preNode == null) {
                    preNode = stack.pop();
                } else {
                    ListNode node = stack.pop();
                    preNode.next = node;
                    preNode = node;
                }
            }
        }
        return newHead;
    }

    private ListNode swapKGroupRecursive(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int counter = 0;

        ListNode node = head;
        while (counter < k) {
            if (head == null) {
                return head;
            }
            node = node.next;
            counter++;
        }
        ListNode pre = swapKGroupRecursive(node,k);



        return pre;
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;



        swapKPairs(node1,2);
    }

}
