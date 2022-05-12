package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestILRUCache extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".LRUCacheImpl";

    protected static ILRUCache createLRUCache(int capacity){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(int.class);
            return (ILRUCache) supplier.newInstance(capacity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testBelowCapacityNoDuplicates() {
        List<ILRUCache.Entry> expected = new ArrayList<>();
        expected.add(new ILRUCache.Entry(22, 34));
        expected.add(new ILRUCache.Entry(1, 3));
        expected.add(new ILRUCache.Entry(9, 66));
        expected.add(new ILRUCache.Entry(96, 1));
        expected.add(new ILRUCache.Entry(12, 1));
        ILRUCache map = createLRUCache(6);
        for (ILRUCache.Entry e : expected){
            map.put(e.getKey(), e.getValue());
        }

        checkOrder(expected.iterator(), map.iterator());
    }

    @Test
    public void testBelowCapacityWithDuplicates() {
        List<ILRUCache.Entry> expected = new ArrayList<>();
        expected.add(new ILRUCache.Entry(22, 34));
        expected.add(new ILRUCache.Entry(9, 66));
        expected.add(new ILRUCache.Entry(96, 1));
        expected.add(new ILRUCache.Entry(3, 11));
        expected.add(new ILRUCache.Entry(1, 8));

        List<ILRUCache.Entry> feed = new ArrayList<>();
        feed.add(new ILRUCache.Entry(22, 34));
        feed.add(new ILRUCache.Entry(1, 3));
        feed.add(new ILRUCache.Entry(3, 7));
        feed.add(new ILRUCache.Entry(9, 66));
        feed.add(new ILRUCache.Entry(3, 11));
        feed.add(new ILRUCache.Entry(96, 1));
        feed.add(new ILRUCache.Entry(1, 8));

        ILRUCache map = createLRUCache(6);
        for (ILRUCache.Entry e : feed){
            map.put(e.getKey(), e.getValue());
        }

        checkGet(11, map.get(3));
        checkGet(8, map.get(1));
        checkOrder(expected.iterator(), map.iterator());
    }

    @Test
    public void testAboveCapacityNoGet() {
        List<ILRUCache.Entry> expected = new ArrayList<>();
        expected.add(new ILRUCache.Entry(12, 1));
        expected.add(new ILRUCache.Entry(33, 1));
        expected.add(new ILRUCache.Entry(1024, 1));

        List<ILRUCache.Entry> feed = new ArrayList<>();
        feed.add(new ILRUCache.Entry(96, 1));
        feed.add(new ILRUCache.Entry(12, 1));
        feed.add(new ILRUCache.Entry(33, 1));
        feed.add(new ILRUCache.Entry(1024, 1));
        ILRUCache map = createLRUCache(3);
        for (ILRUCache.Entry e : expected){
            map.put(e.getKey(), e.getValue());
        }

        checkOrder(expected.iterator(), map.iterator());
    }

    @Test
    public void testAboveCapacityWithGets() {

        List<ILRUCache.Entry> feed = new ArrayList<>();
        feed.add(new ILRUCache.Entry(22, 34));
        feed.add(new ILRUCache.Entry(8, 3));
        feed.add(new ILRUCache.Entry(42, 7));
        feed.add(new ILRUCache.Entry(9, 66));

        ILRUCache map = createLRUCache(4);
        for (ILRUCache.Entry e : feed){
            map.put(e.getKey(), e.getValue());
        }
        checkOrder(feed.iterator(), map.iterator());

        checkGet(7, map.get(42));
        checkGet(34, map.get(22));
        // map should be 8 9 42 22
        map.put(12, 239);
        map.put(5, 21);
        // map should be 42 22 12 5
        checkGet(21, map.get(5));
        checkGet(7, map.get(42));
        // map should be  22 12 5 42
        List<ILRUCache.Entry> expected = new ArrayList<>();
        expected.add(new ILRUCache.Entry(22, 34));
        expected.add(new ILRUCache.Entry(12, 239));
        expected.add(new ILRUCache.Entry(5, 21));
        expected.add(new ILRUCache.Entry(42, 7));

        checkOrder(expected.iterator(), map.iterator());


    }

    private void checkGet(Integer expected, Integer actual){
        assertEquals(expected, actual);
    }

    private void checkOrder(
            Iterator<ILRUCache.Entry> expected,
            Iterator<ILRUCache.Entry> actual){
        while (expected.hasNext() && actual.hasNext()){
            checkEntry(expected.next(), actual.next());
        }
        assertFalse("Expected another entry", expected.hasNext());
        assertFalse("Unexpected entry found", actual.hasNext());

    }

    private void checkEntry(ILRUCache.Entry expected,
                            ILRUCache.Entry actual){
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
    }
}
