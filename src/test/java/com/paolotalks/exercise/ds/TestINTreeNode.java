package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestINTreeNode extends BaseDSTestCase {

    private static final String CLASS_PATH = PACKAGE_PATH + ".NTreeNodeImpl";

    protected static INTreeNode createNTreeNode(int data){
        Class<?> cls = getImplClass(CLASS_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(int.class);
            return (INTreeNode) supplier.newInstance(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSingleNode() {
        INTreeNode node = createNTreeNode(120);
        assertEquals(120, node.getData());
        assertEquals("120", node.toString());
    }

    @Test
    public void testChildren() {
        INTreeNode node = createNTreeNode(0);
        List<INTreeNode> expected = new ArrayList<>(10);
        for (int i = 1; i < 10; i++){
            INTreeNode child = createNTreeNode(i);
            node.addChild(child);
            expected.add(child);
        }
        // Test the getChildren() method
        checkChildren(expected, node.getChildren().stream());
        // Test the children() method
        checkChildren(expected, node.children());
    }

    private void checkChildren(List<INTreeNode> expected, Stream<INTreeNode> children){
        // Order by data
        List<INTreeNode> actual = children
                .sorted(Comparator.comparingInt(INTreeNode::getData))
                .collect(Collectors.toList());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }
}
