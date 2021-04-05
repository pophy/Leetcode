import pojo.ListNode;

/**
 * Created by Fei on 1/6/2018.
 */
public class ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;

        // tail1 is the (m-1)th node
        ListNode tail1 = newhead;
        int i = 1;
        while (i < m) {
            head = head.next;
            tail1 = tail1.next;
            i++;
        }

        // tail2 is the mth node
        ListNode tail2 = head;
        head = head.next;
        i++;

        while (i <= n) {
            tail2.next = head.next;

            // insert head after tail1
            head.next = tail1.next;
            tail1.next = head;

            head = tail2.next;
            i++;
        }

        return newhead.next;

    }

    public static void main(String[] args) {
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

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        reverseLinkedListII.reverseBetween(node1,2,6);
    }
}
