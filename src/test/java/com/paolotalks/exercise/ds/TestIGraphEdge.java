package com.paolotalks.exercise.ds;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;
import static com.paolotalks.exercise.ds.TestIGraphNode.createGraphNode;

@RunWith(PartialTestRunner.class)
public class TestIGraphEdge extends BaseDSTestCase {

    private static final String EDGE_PATH = PACKAGE_PATH + ".GraphEdgeImpl";

    protected static IGraphEdge createEdge(IGraphNode src, IGraphNode tgt){
        Class<?> cls = getImplClass(EDGE_PATH);
        try {
            Constructor<?> supplier = cls.getConstructor(IGraphNode.class, IGraphNode.class);
            return (IGraphEdge) supplier.newInstance(src, tgt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGraphEdge() {
        IGraphNode src = createGraphNode(4);
        IGraphNode tgt = createGraphNode(6);
        IGraphEdge edge = createEdge(src, tgt);

        assertEquals(src, edge.getSource());
        assertEquals(tgt, edge.getTarget());
        assertEquals("(4, 6)", edge.toString());
    }

    @Test
    public void testGraphEdgeEqualAndHashCode() {
        IGraphNode src = createGraphNode(1);
        IGraphNode tgt = createGraphNode(2);
        IGraphEdge edge = createEdge(src, tgt);
        IGraphEdge edge2 = createEdge(src, tgt);

        assertEquals(edge.hashCode(), edge2.hashCode());
        assertEquals(edge, edge2);
    }

}
