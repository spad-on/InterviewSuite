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
public class TestIStack extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".StackImpl";

    protected static IStack createStack(){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor();
            return (IStack) supplier.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testEmptyOnCreation() {
        IStack stack = createStack();
        assertTrue(stack.isEmpty());
    }


    @Test
    public void testOneElementJourney() {
        IStack stack = createStack();
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(42, stack.peek());
        assertEquals(42, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekDoesNotChange() {
        IStack stack = createStack();
        stack.push(42);
        assertFalse(stack.isEmpty());
        assertEquals(42, stack.peek());
        assertEquals(42, stack.peek());
    }


    @Test
    public void testMultipleElements() {
        IStack stack = createStack();
        stack.push(42);
        stack.push(32);
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals(32, stack.peek());
        assertEquals(32, stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals(42, stack.peek());
        assertEquals(42, stack.pop());
        assertTrue(stack.isEmpty());
    }

}
