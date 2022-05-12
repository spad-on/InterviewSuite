package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestIQueue extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".QueueImpl";

    protected static IQueue createQueue(){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor();
            return (IQueue) supplier.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testEmptyOnCreation() {
        IQueue queue = createQueue();
        assertTrue(queue.isEmpty());
    }


    @Test
    public void testOneElementJourney() {
        IQueue queue = createQueue();
        queue.offer(42);
        assertFalse(queue.isEmpty());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekDoesNotChange() {
        IQueue queue = createQueue();
        queue.offer(42);
        assertFalse(queue.isEmpty());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
    }


    @Test
    public void testMultipleElements() {
        IQueue queue = createQueue();
        queue.offer(42);
        queue.offer(32);
        queue.offer(1);
        assertFalse(queue.isEmpty());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.poll());
        assertFalse(queue.isEmpty());
        assertEquals(32, queue.peek());
        assertEquals(32, queue.poll());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

}
