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
public class TestILinkedHashMap extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".LinkedHashMapImpl";

    protected static ILinkedHashMap createLinkedHashMap(){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor();
            return (ILinkedHashMap) supplier.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testMultipleElements() {
        List<ILinkedHashMap.Entry> expected = new ArrayList<>();
        expected.add(new ILinkedHashMap.Entry(22, 34));
        expected.add(new ILinkedHashMap.Entry(1, 3));
        expected.add(new ILinkedHashMap.Entry(9, 66));
        expected.add(new ILinkedHashMap.Entry(96, 1));
        ILinkedHashMap map = createLinkedHashMap();
        for (ILinkedHashMap.Entry e : expected){
            map.put(e.getKey(), e.getValue());
        }

        checkOrder(expected.iterator(), map.iterator());
    }

    @Test
    public void testMultipleElementsWithRepetition() {
        List<ILinkedHashMap.Entry> expected = new ArrayList<>();
        expected.add(new ILinkedHashMap.Entry(22, 34));
        expected.add(new ILinkedHashMap.Entry(1, 8));
        expected.add(new ILinkedHashMap.Entry(3, 11));
        expected.add(new ILinkedHashMap.Entry(9, 66));
        expected.add(new ILinkedHashMap.Entry(96, 1));

        List<ILinkedHashMap.Entry> feed = new ArrayList<>();
        feed.add(new ILinkedHashMap.Entry(22, 34));
        feed.add(new ILinkedHashMap.Entry(1, 3));
        feed.add(new ILinkedHashMap.Entry(3, 7));
        feed.add(new ILinkedHashMap.Entry(9, 66));
        feed.add(new ILinkedHashMap.Entry(3, 11));
        feed.add(new ILinkedHashMap.Entry(96, 1));
        feed.add(new ILinkedHashMap.Entry(1, 8));

        ILinkedHashMap map = createLinkedHashMap();
        for (ILinkedHashMap.Entry e : feed){
            map.put(e.getKey(), e.getValue());
        }

        checkOrder(expected.iterator(), map.iterator());
    }

    private void checkOrder(
            Iterator<ILinkedHashMap.Entry> expected,
            Iterator<ILinkedHashMap.Entry> actual){
        while (expected.hasNext() && actual.hasNext()){
            checkEntry(expected.next(), actual.next());
        }
        assertFalse("Expected another entry", expected.hasNext());
        assertFalse("Unexpected entry found", actual.hasNext());

    }

    private void checkEntry(ILinkedHashMap.Entry expected,
                            ILinkedHashMap.Entry actual){
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
    }
}
