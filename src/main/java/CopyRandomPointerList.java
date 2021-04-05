/**
 * Created by fei on 1/8/18.
 */
public class CopyRandomPointerList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        while (head!= null) {
            RandomListNode cloneNode = new RandomListNode(head.label);
            cloneNode.next = head.next;
            cloneNode.random = head.random;
            head.next = cloneNode;
            head = cloneNode.next;
        }

        head = dummy.next;
        while (head != null) {
            RandomListNode cloneNode = head.next;
            if (cloneNode.random != null) {
                cloneNode.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        RandomListNode newNode = head.next;


        while (head != null) {
            RandomListNode cloneNode = head.next;
            head.next = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            head = head.next;
        }
        return newNode;

    }

    public static void main(String[] args) {
        CopyRandomPointerList copyRandomPointerList = new CopyRandomPointerList();
        RandomListNode node1 = new RandomListNode(1);
//        RandomListNode node2 = new RandomListNode(2);
//        RandomListNode node3 = null;


        copyRandomPointerList.copyRandomList(node1);
    }
}


  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }