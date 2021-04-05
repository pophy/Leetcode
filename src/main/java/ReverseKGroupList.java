import pojo.ListNode;

public class ReverseKGroupList {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (count < k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            count++;
        }

        ListNode pre = reverseKGroup(node,k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count--;
        }
        return pre;
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


