package com.paolotalks.ds;

import com.paolotalks.exception.TestCaseNotImplementedException;
import com.paolotalks.exercise.ds.ITreeNode;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestITreeNode extends BaseDSTestCase {

    private static final String CLASS_PATH = "com.paolotalks.exercise.ds.impl.TreeNodeImpl";

    protected static ITreeNode createTreeNode(int data){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(int.class);
            return (ITreeNode) supplier.newInstance(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSingleNode() {
        ITreeNode node = createTreeNode(12);
        assertEquals(12, node.getData());
        assertEquals("12", node.toString());
    }

    @Test
    public void testLeft() {
        ITreeNode node = createTreeNode(11);
        ITreeNode left = createTreeNode(42);
        node.setLeft(left);
        assertEquals(left, node.getLeft());
    }

    @Test
    public void testRight() {
        ITreeNode node = createTreeNode(34);
        ITreeNode right = createTreeNode(90);
        node.setRight(right);
        assertEquals(right, node.getRight());
    }

    @Test
    public void testBoth() {
        ITreeNode node = createTreeNode(4);
        ITreeNode left = createTreeNode(9);
        ITreeNode right = createTreeNode(2);
        node.setLeft(left);
        node.setRight(right);
        assertEquals(left, node.getLeft());
        assertEquals(right, node.getRight());
    }
}
