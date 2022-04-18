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
public class TestIGraphNode extends BaseDSTestCase {

    private static final String NODE_PATH =  PACKAGE_PATH + ".GraphNodeImpl";

    protected static IGraphNode createGraphNode(int id){
        Class<?> cls = getImplClass(NODE_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(int.class);
            return (IGraphNode) supplier.newInstance(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSingleNode() {
        IGraphNode node = createGraphNode(456);
        assertEquals(456, node.getId());
        assertEquals("456", node.toString());
    }

    @Test
    public void testEqualAndHashCode() {
        IGraphNode node = createGraphNode(2);
        IGraphNode node2 = createGraphNode(2);
        assertEquals(node.hashCode(), node2.hashCode());
        assertEquals(node, node2);
    }

    @Test
    public void testChildren() {
        IGraphNode node = createGraphNode(0);
        List<IGraphNode> expected = new ArrayList<>(10);
        for (int i = 1; i < 11; i++){
            IGraphNode link = createGraphNode(i);
            node.addNode(link);
            expected.add(link);
        }

        // test getEdges() method
        assertEquals(expected.size(), node.getEdges().size());
        checkEdges(node, expected, node.getEdges().stream());

        // test edges() method
        checkEdges(node, expected, node.edges());
    }

    private void checkEdges(
            IGraphNode node,
            List<IGraphNode> expected,
            Stream<IGraphEdge> edges
    ) {
        // Sort by target
        List<IGraphEdge> actual = edges
                .sorted(Comparator.comparingInt(s -> s.getTarget().getId()))
                .collect(Collectors.toList());
        for (int i = 0; i < expected.size(); i++){
            IGraphEdge edge = actual.get(i);
            assertEquals(node, edge.getSource());
            assertEquals(expected.get(i), edge.getTarget());
        }
    }

}
