package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestIDeque extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".DequeImpl";

    protected static IDeque createQueue(){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor();
            return (IDeque) supplier.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testEmptyOnCreation() {
        IDeque deque = createQueue();
        assertTrue(deque.isEmpty());
    }


    @Test
    public void testOneElementFirst() {
        IDeque deque = createQueue();
        deque.offerFirst(42);
        assertFalse(deque.isEmpty());
        assertEquals(42, deque.peekFirst());
        assertEquals(42, deque.peekFirst());
        assertEquals(42, deque.pollFirst());
        assertTrue(deque.isEmpty());
    }


    @Test
    public void testOneElementLast() {
        IDeque deque = createQueue();
        deque.offerLast(42);
        assertFalse(deque.isEmpty());
        assertEquals(42, deque.peekLast());
        assertEquals(42, deque.peekLast());
        assertEquals(42, deque.pollLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testThreeElements() {
        IDeque deque = createQueue();
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerFirst(1);
        assertEquals(1, deque.peekFirst());
        assertEquals(3, deque.peekLast());
        int expected = 1;
        while (!deque.isEmpty()){
            assertEquals(expected, deque.peekFirst());
            assertEquals(expected++, deque.pollFirst());
        }
    }


    @Test
    public void testPollingEnds() {
        IDeque deque = createQueue();
        deque.offerLast(3);
        deque.offerFirst(2);
        deque.offerFirst(1);
        assertEquals(1, deque.pollFirst());
        assertEquals(3, deque.pollLast());
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.peekFirst());
        assertEquals(2, deque.peekLast());
        assertEquals(2, deque.pollLast());
        assertTrue(deque.isEmpty());
    }

}
