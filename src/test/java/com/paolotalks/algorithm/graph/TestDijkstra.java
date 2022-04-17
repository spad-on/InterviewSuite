package com.paolotalks.algorithm.graph;

import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedWeightedGraph;
import com.paolotalks.exercise.algorithm.graph.Dijkstra;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(PartialTestRunner.class)
public class TestDijkstra {

    @Test
    public void testDistance(){
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph();
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 6, 14);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 15);
        graph.addEdge(3, 4, 11);
        graph.addEdge(3, 6, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 9);

        Map<Node, Integer> distance = new Dijkstra().visit(graph, graph.getNode(1));
        checkNodeDistance(1, 0, graph, distance);
        checkNodeDistance(2, 7, graph, distance);
        checkNodeDistance(3, 9, graph, distance);
        checkNodeDistance(4, 20, graph, distance);
        checkNodeDistance(5, 20, graph, distance);
        checkNodeDistance(6, 11, graph, distance);
    }

    private void checkNodeDistance(int nodeId, int expected, UndirectedWeightedGraph graph, Map<Node, Integer> distance){
        Node node = graph.getNode(nodeId);
        assertNotNull("Null node with id " + nodeId, node);
        assertNotNull(graph.getNode(2));
        Integer actual = distance.get(node);
        assertNotNull(actual);
        // check distances match
        assertEquals(expected, actual.intValue());
    }

}
