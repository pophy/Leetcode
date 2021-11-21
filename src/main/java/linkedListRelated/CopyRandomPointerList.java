package linkedListRelated;

import org.junit.jupiter.api.Test;

public class CopyRandomPointerList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node curCopy = new Node(cur.val);
            Node next = cur.next;
            cur.next = curCopy;
            curCopy.next = next;
            cur = curCopy.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node copyHead = head.next;
        cur = head;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = cur.next.next;
            cur = next;
        }
        return copyHead;
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);
    }



    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
