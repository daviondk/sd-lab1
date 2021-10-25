import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> {
    private final HashMap<K, V> map = new HashMap<>();
    private final LinkedList<K> list = new LinkedList<>();

    private final int capacity;

    public LRUCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
    }

    public V get(K key) {
        assert (key != null);
        if (map.containsKey(key)) {
            list.remove(key);
            list.add(key);
            assert (list.getLast() == key);
            return map.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        assert (key != null && value != null);
        if (map.containsKey(key)) {
            list.remove(key);
        } else if (size() == capacity) {
            map.remove(list.removeFirst());
        }
        map.put(key, value);
        list.add(key);
        assert (list.getLast() == key && map.containsKey(key));
    }

    public V remove(K key) {
        assert (key != null);
        V removed = null;
        if (map.containsKey(key)) {
            list.remove(key);
            removed = map.remove(key);
        }
        assert (!map.containsKey(key));
        return removed;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return list.size();
    }
}
