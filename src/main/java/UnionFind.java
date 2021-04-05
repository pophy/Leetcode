import java.util.*;

public class UnionFind<V> {

    public Map<Element<V>, Element<V>> parentMap = new HashMap<>(); //can be array
    public Map<V, Element<V>> elementMap = new HashMap<>();
    public HashMap<Element<V>, Integer> rankMap = new HashMap<>();
    int count = 0;

    public void init() {
        for (Element element : elementMap.values()) {
            parentMap.put(element, element);
            rankMap.put(element, 1);
            count++;
        }
    }

    public Element<V> findHead(Element e1) {

        Stack<Element> path = new Stack<>();
        Element head = parentMap.get(e1);
        while (head != parentMap.get(head)) {
            path.push(head);
            head = parentMap.get(head);
        }
        while (!path.isEmpty()) {
            Element element = path.pop();
            parentMap.put(element, head);
        }
        return head;

    }

    public boolean isSameHead(Element e1, Element e2) {
        return findHead(e1) == findHead(e2);
    }

    public void union(Element e1, Element e2) {
        if (!isSameHead(e1, e2)) {
            Element head1 = findHead(e1);
            Element head2 = findHead(e2);
            parentMap.put(head1, head2);
            count--;
        }
    }


}

class Element<V> {
    public V value;

    public Element(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}