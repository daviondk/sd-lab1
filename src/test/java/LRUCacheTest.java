import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    private final int CAPACITY = 2;
    private LRUCache<Integer, Integer> lruCache;

    @Before
    public void before() {
        lruCache = new LRUCache<>(CAPACITY);
    }

    @Test
    public void putAndGetTest() {
        lruCache.put(0, 0);
        assertEquals(new Integer(0), lruCache.get(0));
    }

    @Test
    public void getNullTest() {
        lruCache.put(0, 0);
        assertNull(lruCache.get(1));
    }

    @Test
    public void capacityTest() {
        lruCache.put(0, 0);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertNull(lruCache.get(0));
    }

    @Test
    public void capacityAfterGetTest() {
        lruCache.put(0, 0);
        lruCache.put(1, 1);
        lruCache.get(0);
        lruCache.put(2, 2);
        assertNull(lruCache.get(1));
    }

    @Test
    public void testOverwriteKey() {
        lruCache.put(1, 1);
        lruCache.put(1, 2);
        assertEquals(new Integer(2), lruCache.get(1));
    }

    @Test
    public void sizeTest() {
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(2, lruCache.size());
    }

    @Test
    public void sizeMaxCapacityTest() {
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(2, lruCache.size());
    }

    @Test
    public void sizeOverwriteKeyTest() {
        lruCache.put(1, 1);
        lruCache.put(1, 2);
        assertEquals(1, lruCache.size());
    }

    @Test
    public void isEmptyTest() {
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.remove(1);
        lruCache.remove(2);
        assertTrue(lruCache.isEmpty());
    }

    @Test
    public void removeTest() {
        lruCache.put(1, 1);
        assertEquals(new Integer(1), lruCache.remove(1));
        assertTrue(lruCache.isEmpty());
    }

    @Test
    public void isNotEmptyTest() {
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.remove(1);
        assertFalse(lruCache.isEmpty());
    }
}
