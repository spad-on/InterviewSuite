package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PartialTestRunner.class)
public class TestEdgePartition {


    @Test
    public void testEdgePartition(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 8);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 4);
        graph.addEdge(5, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 2);

        EdgePartition.EdgeData edges = new EdgePartition().visit(graph);
        // Check tree edges
        Set<Edge> tree = edges.getTree();
        assertEquals("Wrong number of tree edges", 7, tree.size());
        Set<String> strTree = tree.stream()
                .map(s -> s.getSource() + "-" + s.getTarget())
                .collect(Collectors.toSet());
        assertTrue(strTree.contains("1-2"));
        assertTrue(strTree.contains("2-4"));
        assertTrue(strTree.contains("4-6"));
        assertTrue(strTree.contains("1-3"));
        assertTrue(strTree.contains("3-5"));
        assertTrue(strTree.contains("5-7"));
        assertTrue(strTree.contains("5-8"));
        // Check forwards
        Set<Edge> fwd = edges.getForward();
        assertEquals("Wrong number of fwd edges", 1, fwd.size());
        Set<String> strFwd = fwd.stream()
                .map(s -> s.getSource() + "-" + s.getTarget())
                .collect(Collectors.toSet());
        assertTrue(strFwd.contains("1-8"));
        // Check backwards
        Set<Edge> bwd = edges.getBackward();
        assertEquals("Wrong number of bwd edges", 1, bwd.size());
        Set<String> strBwd = fwd.stream()
                .map(s -> s.getSource() + "-" + s.getTarget())
                .collect(Collectors.toSet());
        assertTrue(strBwd.contains("6-2"));
        // Check across
        Set<Edge> across = edges.getBackward();
        assertEquals("Wrong number of across edges", 1, across.size());
        Set<String> strAcross = across.stream()
                .map(s -> s.getSource() + "-" + s.getTarget())
                .collect(Collectors.toSet());
        assertTrue(strAcross.contains("5-4"));
    }

}
