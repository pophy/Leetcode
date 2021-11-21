package linkedListRelated;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> map = new HashMap();
    Map<Integer, Node> nodeMap = new HashMap();
    MyLinkedList queue = new MyLinkedList();
    int cap;
    int size = 0;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            queue.moveToLast(node);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            queue.moveToLast(node);
        } else {
            Node node = new Node(key);
            queue.addLast(node);
            nodeMap.put(key, node);
            size++;
        }
        map.put(key, value);
        if (size > cap) {
            Node node = queue.removeHead();
            nodeMap.remove(node.val);
            map.remove(node.val);
            size--;
        }
    }


    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private static class MyLinkedList {

        Node head = new Node(-1);
        Node tail = new Node(-1);
        int size;

        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addLast(Node node) {
            Node pre = tail.prev;
            pre.next = node;
            node.prev = pre;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        public void moveToLast(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addLast(node);
        }

        public Node removeHead() {
            Node returnV = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            size--;
            return returnV;
        }

    }


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();


        LRUCache cache = new LRUCache(10);

        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);
        cache.get(2);
        cache.get(3);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6, 14);
        cache.put(3, 1);
        cache.get(3);
        cache.put(10, 11);
        cache.get(8);
        cache.put(2, 14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3, 27);
        cache.put(2, 12);
        cache.get(5);
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);
        cache.put(9, 29);
        cache.put(8, 21);
        cache.get(5);
        cache.put(6, 30);
        cache.put(1, 12);
        cache.get(10);
        cache.put(4, 15);
        cache.put(7, 22);
        cache.put(11, 26);
        cache.put(8, 17);
        cache.put(9, 29);
        cache.get(5);
        cache.put(3, 4);
        cache.put(11, 30);
        cache.get(12);
        cache.put(4, 29);
        cache.get(3);
        cache.get(9);
        cache.get(6);
        cache.put(3, 4);
        cache.get(1);
        cache.get(10);
        cache.put(3, 29);
        cache.put(10, 28);
        cache.put(1, 20);
        cache.put(11, 13);
        cache.get(3);
        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);
        cache.get(8);
        cache.get(7);
        cache.get(5);
        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);
        cache.get(12);
        cache.put(9, 19);
        cache.put(2, 15);
        cache.put(3, 16);
        cache.get(1);
        cache.put(12, 17);
        cache.put(9, 1);
        cache.put(6, 19);
        cache.get(4);
        cache.get(5);
        cache.get(5);
        cache.put(8, 1);
        cache.put(11, 7);
        cache.put(5, 2);
        cache.put(9, 28);
        cache.get(1);
        cache.put(2, 2);
        cache.put(7, 4);
        cache.put(4, 22);
        cache.put(7, 24);
        cache.put(9, 26);
        cache.put(13, 28);
        cache.put(11, 26);


    }

}
