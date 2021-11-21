import pojo.ListNode;

public class ReverseKGroupList {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }



//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode begin;
//        if (head==null || head.next ==null || k==1)
//            return head;
//        ListNode dummyhead = new ListNode(-1);
//        dummyhead.next = head;
//        begin = dummyhead;
//        int i=0;
//        while (head != null){
//            i++;
//            if (i%k == 0){
//                begin = reverse(begin, head.next);
//                head = begin.next;
//            } else {
//                head = head.next;
//            }
//        }
//        return dummyhead.next;
//
//    }
//
//    public ListNode reverse(ListNode begin, ListNode end){
//        ListNode curr = begin.next;
//        ListNode next, first;
//        ListNode prev = begin;
//        first = curr;
//        while (curr!=end){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        begin.next = prev;
//        first.next = curr;
//        return first;
//    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ReverseKGroupList reverseKGroupList = new ReverseKGroupList();
        reverseKGroupList.reverseKGroup(n1,2);

    }
}


