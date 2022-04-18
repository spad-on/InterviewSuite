package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestITrieNode extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".TrieNodeImpl";

    protected static ITrieNode createTrieNode(char data){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(char.class);
            return (ITrieNode) supplier.newInstance(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSingleNode() {
        ITrieNode node = createTrieNode('a');
        assertEquals('a', node.getData());
        assertEquals("a", node.toString());
        assertFalse(node.isWord());
    }

    @Test
    public void testChildren() {
        ITrieNode h = createTrieNode('h');
        ITrieNode i = h.addChild('i');
        assertNotNull(i);
        assertEquals('i', i.getData());
        assertNotNull(h.getChild('i'));
        // no node named e
        assertNull(h.getChild('e'));
    }
}
