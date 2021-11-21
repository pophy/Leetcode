package linkedListRelated;

import org.junit.jupiter.api.Test;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preMid = findMid(head);
        TreeNode root = new TreeNode(preMid.next.val);
        ListNode nextMid = preMid.next.next;
        preMid.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(nextMid);
        root.left = left;
        root.right = right;
        return root;
    }


    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (fast != null && fast.next != null) {
            fast = fast.next.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        TreeNode root = sortedListToBST(node1);
        System.out.println(root);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
