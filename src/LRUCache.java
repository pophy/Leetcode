import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Fei on 2/7/2018.
 */
public class LRUCache {

    private int capacity = 0;
    PriorityQueue<LRUCache> pqueue;
    Map<Integer,LRUCacheItem> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        pqueue = new PriorityQueue(capacity);
        cache = new HashMap<Integer, LRUCacheItem>(capacity);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        LRUCacheItem item = cache.get(key);
        if (item != null) {
            //udpate queue
            return item.value;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
    }

    private class LRUCacheItem implements Comparable<LRUCacheItem> {
        int key;
        int value;
        Date lastVisitTime;

        @Override
        public int compareTo(LRUCacheItem o) {
            return this.lastVisitTime.compareTo(o.lastVisitTime);
        }
    }

}
